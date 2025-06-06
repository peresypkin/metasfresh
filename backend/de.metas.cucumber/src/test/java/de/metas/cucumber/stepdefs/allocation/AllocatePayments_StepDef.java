/*
 * #%L
 * de.metas.cucumber
 * %%
 * Copyright (C) 2022 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

package de.metas.cucumber.stepdefs.allocation;

import de.metas.allocation.api.IAllocationBL;
import de.metas.banking.payment.paymentallocation.InvoiceToAllocate;
import de.metas.banking.payment.paymentallocation.InvoiceToAllocateQuery;
import de.metas.banking.payment.paymentallocation.PaymentAllocationRepository;
import de.metas.banking.payment.paymentallocation.PaymentToAllocate;
import de.metas.banking.payment.paymentallocation.PaymentToAllocateQuery;
import de.metas.banking.payment.paymentallocation.service.AllocationAmounts;
import de.metas.banking.payment.paymentallocation.service.PayableDocument;
import de.metas.banking.payment.paymentallocation.service.PaymentAllocationBuilder;
import de.metas.banking.payment.paymentallocation.service.PaymentDocument;
import de.metas.cucumber.stepdefs.DataTableRows;
import de.metas.cucumber.stepdefs.StepDefDataIdentifier;
import de.metas.cucumber.stepdefs.invoice.C_Invoice_StepDefData;
import de.metas.cucumber.stepdefs.payment.C_Payment_StepDefData;
import de.metas.invoice.InvoiceAmtMultiplier;
import de.metas.invoice.InvoiceId;
import de.metas.invoice.invoiceProcessingServiceCompany.InvoiceProcessingServiceCompanyService;
import de.metas.money.Money;
import de.metas.money.MoneyService;
import de.metas.organization.IOrgDAO;
import de.metas.organization.OrgId;
import de.metas.payment.PaymentAmtMultiplier;
import de.metas.payment.PaymentId;
import de.metas.util.Services;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import lombok.NonNull;
import org.adempiere.ad.trx.api.ITrxManager;
import org.compiere.SpringContextHolder;
import org.compiere.model.I_C_Invoice;
import org.compiere.model.I_C_Payment;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_C_Invoice_ID;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_C_Payment_ID;

public class AllocatePayments_StepDef
{
	private static final String WRITE_OFF_PROCESS = "WRITEOFF";
	private static final String DISCOUNT_PROCESS = "DISCOUNT";

	private final PaymentAllocationRepository paymentAllocationRepository = SpringContextHolder.instance.getBean(PaymentAllocationRepository.class);
	private final InvoiceProcessingServiceCompanyService invoiceProcessingServiceCompanyService = SpringContextHolder.instance.getBean(InvoiceProcessingServiceCompanyService.class);
	private final MoneyService moneyService = SpringContextHolder.instance.getBean(MoneyService.class);

	private final IAllocationBL allocationBL = Services.get(IAllocationBL.class);
	private final ITrxManager trxManager = Services.get(ITrxManager.class);
	private final IOrgDAO orgDAO = Services.get(IOrgDAO.class);

	private final C_Payment_StepDefData paymentTable;
	private final C_Invoice_StepDefData invoiceTable;

	public AllocatePayments_StepDef(
			final C_Payment_StepDefData paymentTable,
			final C_Invoice_StepDefData invoiceTable)
	{
		this.paymentTable = paymentTable;
		this.invoiceTable = invoiceTable;

	}

	@And("^apply (.*) to invoices$")
	public void apply_write_off_or_discount_to_invoice(final String processToApply, @NonNull final DataTable table)
	{
		DataTableRows.of(table).forEach(row -> {
			final I_C_Invoice invoice = row.getAsIdentifier(COLUMNNAME_C_Invoice_ID).lookupNotNullIn(invoiceTable);

			final InvoiceToAllocate invoiceToAllocate = getInvoiceToAllocate(invoice);

			final InvoiceAmtMultiplier amtMultiplier = invoiceToAllocate.getMultiplier();
			final Money amountToDiscountOrWriteOff = amtMultiplier.convertToRealValue(invoiceToAllocate.getOpenAmountConverted())
					.toMoney(moneyService::getCurrencyIdByCurrencyCode);

			trxManager.runInThreadInheritedTrx(() -> allocationBL.invoiceDiscountAndWriteOff(
					IAllocationBL.InvoiceDiscountAndWriteOffRequest.builder()
							.invoice(invoice)
							.dateTrx(Instant.now())
							.discountAmt(processToApply.equals(DISCOUNT_PROCESS) ? amountToDiscountOrWriteOff : null)
							.writeOffAmt(processToApply.equals(WRITE_OFF_PROCESS) ? amountToDiscountOrWriteOff : null)
							.build()));
		});
	}

	@And("allocate payments to invoices")
	public void allocate_payment_to_invoice(@NonNull final DataTable table)
	{
		final ArrayList<PayableDocument> payableDocuments = new ArrayList<>();
		final ArrayList<PaymentDocument> paymentDocuments = new ArrayList<>();

		DataTableRows.of(table).forEach(row -> {
			row.getAsOptionalIdentifier(COLUMNNAME_C_Invoice_ID)
					.map(this::buildPayableDocument)
					.ifPresent(payableDocuments::add);

			row.getAsOptionalIdentifier(COLUMNNAME_C_Payment_ID)
					.map(this::buildPaymentDocument)
					.ifPresent(paymentDocuments::add);
		});

		PaymentAllocationBuilder.newBuilder()
				.invoiceProcessingServiceCompanyService(invoiceProcessingServiceCompanyService)
				.defaultDateTrx(LocalDate.now())
				.paymentDocuments(paymentDocuments)
				.payableDocuments(payableDocuments)
				.allowPartialAllocations(true)
				.payableRemainingOpenAmtPolicy(PaymentAllocationBuilder.PayableRemainingOpenAmtPolicy.DO_NOTHING)
				.allowPurchaseSalesInvoiceCompensation(paymentDocuments.isEmpty() && payableDocuments.size() > 1)
				.build();
	}

	@And("^allocate invoices \\(credit memo/purchase\\) to invoices$")
	public void allocate_credit_memo_to_invoice(@NonNull final DataTable table)
	{
		final ArrayList<PayableDocument> payableDocuments = new ArrayList<>();

		DataTableRows.of(table).forEach(row -> {
			row.getAsOptionalIdentifier("C_Invoice_ID")
					.map(this::buildPayableDocument)
					.ifPresent(payableDocuments::add);
			row.getAsOptionalIdentifier("CreditMemo.C_Invoice_ID")
					.map(this::buildPayableDocument)
					.ifPresent(payableDocuments::add);
			row.getAsOptionalIdentifier("Purchase.C_Invoice_ID")
					.map(this::buildPayableDocument)
					.ifPresent(payableDocuments::add);
		});

		PaymentAllocationBuilder.newBuilder()
				.invoiceProcessingServiceCompanyService(invoiceProcessingServiceCompanyService)
				.defaultDateTrx(LocalDate.now())
				.payableDocuments(payableDocuments)
				.allowPartialAllocations(true)
				.allowPurchaseSalesInvoiceCompensation(true)
				.payableRemainingOpenAmtPolicy(PaymentAllocationBuilder.PayableRemainingOpenAmtPolicy.DO_NOTHING)
				.build();
	}

	@NonNull
	private PayableDocument buildPayableDocument(@NonNull final StepDefDataIdentifier invoiceIdentifier)
	{
		final I_C_Invoice invoice = invoiceTable.get(invoiceIdentifier);

		assertThat(invoice).isNotNull();

		final InvoiceToAllocate invoiceToAllocate = getInvoiceToAllocate(invoice);
		final Money invoiceOpenMoneyAmt = moneyService.toMoney(invoiceToAllocate.getOpenAmountConverted());
		final Money discountAmt = moneyService.toMoney(invoiceToAllocate.getDiscountAmountConverted());
		final Money payAmt = discountAmt != null ? invoiceOpenMoneyAmt.subtract(discountAmt) : invoiceOpenMoneyAmt;

		return PayableDocument.builder()
				.invoiceId(invoiceToAllocate.getInvoiceId())
				.bpartnerId(invoiceToAllocate.getBpartnerId())
				.documentNo(invoiceToAllocate.getDocumentNo())
				.soTrx(invoiceToAllocate.getDocBaseType().getSoTrx())
				.creditMemo(invoiceToAllocate.getDocBaseType().isCreditMemo())
				.openAmt(invoiceOpenMoneyAmt.negateIf(!invoice.isSOTrx()))
				.date(invoiceToAllocate.getDateInvoiced())
				.clientAndOrgId(invoiceToAllocate.getClientAndOrgId())
				.currencyConversionTypeId(invoiceToAllocate.getCurrencyConversionTypeId())
				.amountsToAllocate(AllocationAmounts.builder()
						.payAmt(payAmt)
						.discountAmt(discountAmt)
						.build()
						.convertToRealAmounts(invoiceToAllocate.getMultiplier()))
				.build();
	}

	@NonNull
	private InvoiceToAllocate getInvoiceToAllocate(@NonNull final I_C_Invoice invoice)
	{
		final ZoneId timeZone = orgDAO.getTimeZone(OrgId.ofRepoId(invoice.getAD_Org_ID()));
		final InvoiceId invoiceId = InvoiceId.ofRepoId(invoice.getC_Invoice_ID());
		final List<InvoiceToAllocate> invoiceToAllocateList = paymentAllocationRepository.retrieveInvoicesToAllocate(
				InvoiceToAllocateQuery.builder()
						.evaluationDate(invoice.getDateInvoiced().toLocalDateTime().atZone(timeZone))
						.onlyInvoiceId(invoiceId)
						.build()
		);

		assertThat(invoiceToAllocateList)
				.as("There should be just one 'InvoiceToAllocate' for a given C_Invoice_ID")
				.hasSize(1);

		return invoiceToAllocateList.get(0);
	}

	@NonNull
	private PaymentDocument buildPaymentDocument(@NonNull final StepDefDataIdentifier paymentIdentifier)
	{
		final I_C_Payment payment = paymentTable.get(paymentIdentifier);

		assertThat(payment).isNotNull();

		final PaymentToAllocate paymentToAllocate = getPaymentToAllocate(payment);

		final PaymentAmtMultiplier amtMultiplier = paymentToAllocate.getPaymentAmtMultiplier();

		final Money openAmt = amtMultiplier.convertToRealValue(paymentToAllocate.getOpenAmt())
				.toMoney(moneyService::getCurrencyIdByCurrencyCode);

		return PaymentDocument.builder()
				.paymentId(paymentToAllocate.getPaymentId())
				.bpartnerId(paymentToAllocate.getBpartnerId())
				.documentNo(paymentToAllocate.getDocumentNo())
				.paymentDirection(paymentToAllocate.getPaymentDirection())
				.openAmt(openAmt)
				.amountToAllocate(openAmt)
				.dateTrx(paymentToAllocate.getDateTrx())
				.clientAndOrgId(paymentToAllocate.getClientAndOrgId())
				.paymentCurrencyContext(paymentToAllocate.getPaymentCurrencyContext())
				.build();
	}

	@NonNull
	private PaymentToAllocate getPaymentToAllocate(@NonNull final I_C_Payment payment)
	{
		final PaymentToAllocateQuery query = PaymentToAllocateQuery.builder()
				.evaluationDate(ZonedDateTime.now())
				.additionalPaymentIdToInclude(PaymentId.ofRepoId(payment.getC_Payment_ID()))
				.build();

		final List<PaymentToAllocate> paymentToAllocateList = paymentAllocationRepository.retrievePaymentsToAllocate(query);

		assertThat(paymentToAllocateList)
				.as("There should be just one 'PaymentToAllocate' for a given C_Payment_ID")
				.hasSize(1);

		return paymentToAllocateList.get(0);
	}
}
