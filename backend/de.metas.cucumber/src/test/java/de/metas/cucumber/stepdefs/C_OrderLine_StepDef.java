/*
 * #%L
 * de.metas.cucumber
 * %%
 * Copyright (C) 2023 metas GmbH
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

package de.metas.cucumber.stepdefs;

import de.metas.common.util.Check;
import de.metas.common.util.StringUtils;
import de.metas.contracts.model.I_C_Flatrate_Conditions;
import de.metas.contracts.model.I_C_Flatrate_Term;
import de.metas.cucumber.stepdefs.activity.C_Activity_StepDefData;
import de.metas.cucumber.stepdefs.attribute.M_AttributeSetInstance_StepDefData;
import de.metas.cucumber.stepdefs.attribute.M_Attribute_StepDefData;
import de.metas.cucumber.stepdefs.contract.C_Flatrate_Conditions_StepDefData;
import de.metas.cucumber.stepdefs.contract.C_Flatrate_Term_StepDefData;
import de.metas.cucumber.stepdefs.hu.M_HU_PI_Item_Product_StepDefData;
import de.metas.cucumber.stepdefs.message.AD_Message_StepDefData;
import de.metas.cucumber.stepdefs.pricing.C_TaxCategory_StepDefData;
import de.metas.cucumber.stepdefs.project.C_Project_StepDefData;
import de.metas.cucumber.stepdefs.shipper.M_Shipper_StepDefData;
import de.metas.cucumber.stepdefs.warehouse.M_Warehouse_StepDefData;
import de.metas.currency.Currency;
import de.metas.currency.CurrencyCode;
import de.metas.currency.ICurrencyDAO;
import de.metas.handlingunits.HUPIItemProductId;
import de.metas.handlingunits.model.I_M_HU_PI_Item_Product;
import de.metas.i18n.AdMessageKey;
import de.metas.i18n.IMsgBL;
import de.metas.material.event.commons.AttributesKey;
import de.metas.order.OrderId;
import de.metas.ordercandidate.model.I_C_OLCand;
import de.metas.product.ProductId;
import de.metas.tax.api.TaxId;
import de.metas.uom.IUOMDAO;
import de.metas.uom.UomId;
import de.metas.uom.X12DE355;
import de.metas.util.Services;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.NonNull;
import org.adempiere.ad.dao.IQueryBL;
import org.adempiere.exceptions.AdempiereException;
import org.adempiere.mm.attributes.AttributeSetInstanceId;
import org.adempiere.mm.attributes.keys.AttributesKeys;
import org.adempiere.model.InterfaceWrapperHelper;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.compiere.model.I_AD_Message;
import org.compiere.model.I_C_Activity;
import org.compiere.model.I_C_BPartner_Location;
import org.compiere.model.I_C_Currency;
import org.compiere.model.I_C_DocType;
import org.compiere.model.I_C_Order;
import org.compiere.model.I_C_OrderLine;
import org.compiere.model.I_C_Project;
import org.compiere.model.I_C_Tax;
import org.compiere.model.I_C_TaxCategory;
import org.compiere.model.I_C_UOM;
import org.compiere.model.I_M_Attribute;
import org.compiere.model.I_M_AttributeInstance;
import org.compiere.model.I_M_AttributeSetInstance;
import org.compiere.model.I_M_Product;
import org.compiere.model.I_M_Shipper;
import org.compiere.model.I_M_Warehouse;
import org.compiere.util.Env;
import org.compiere.util.TimeUtil;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static de.metas.cucumber.stepdefs.StepDefConstants.TABLECOLUMN_IDENTIFIER;
import static org.adempiere.model.InterfaceWrapperHelper.newInstance;
import static org.adempiere.model.InterfaceWrapperHelper.saveRecord;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.compiere.model.I_AD_Message.COLUMNNAME_AD_Message_ID;
import static org.compiere.model.I_C_OrderLine.COLUMNNAME_M_AttributeSetInstance_ID;
import static org.compiere.model.I_C_OrderLine.COLUMNNAME_M_Product_ID;
import static org.compiere.model.I_C_TaxCategory.COLUMNNAME_C_TaxCategory_ID;

public class C_OrderLine_StepDef
{
	private final IQueryBL queryBL = Services.get(IQueryBL.class);
	private final ICurrencyDAO currencyDAO = Services.get(ICurrencyDAO.class);
	private final IUOMDAO uomDAO = Services.get(IUOMDAO.class);
	private final IMsgBL msgBL = Services.get(IMsgBL.class);

	private final M_Product_StepDefData productTable;
	private final C_BPartner_StepDefData partnerTable;
	private final C_Order_StepDefData orderTable;
	private final C_OrderLine_StepDefData orderLineTable;
	private final C_Project_StepDefData projectTable;
	private final M_AttributeSetInstance_StepDefData attributeSetInstanceTable;
	private final C_Flatrate_Conditions_StepDefData flatrateConditionsTable;
	private final C_Flatrate_Term_StepDefData contractTable;
	private final C_TaxCategory_StepDefData taxCategoryTable;
	private final M_HU_PI_Item_Product_StepDefData huPiItemProductTable;
	private final C_Activity_StepDefData activityTable;
	private final M_Attribute_StepDefData attributeTable;
	private final M_Warehouse_StepDefData warehouseTable;
	private final IdentifierIds_StepDefData identifierIdsTable;
	private final C_Tax_StepDefData taxTable;
	private final M_Shipper_StepDefData shipperTable;
	private final C_BPartner_Location_StepDefData bPartnerLocationTable;
	private final C_Currency_StepDefData currencyTable;
	private final AD_Message_StepDefData messageTable;

	public C_OrderLine_StepDef(
			@NonNull final M_Product_StepDefData productTable,
			@NonNull final C_BPartner_StepDefData partnerTable,
			@NonNull final C_Order_StepDefData orderTable,
			@NonNull final C_OrderLine_StepDefData orderLineTable,
			@NonNull final C_Project_StepDefData projectTable,
			@NonNull final M_AttributeSetInstance_StepDefData attributeSetInstanceTable,
			@NonNull final C_Flatrate_Conditions_StepDefData flatrateConditionsTable,
			@NonNull final C_Flatrate_Term_StepDefData contractTable,
			@NonNull final C_TaxCategory_StepDefData taxCategoryTable,
			@NonNull final M_HU_PI_Item_Product_StepDefData huPiItemProductTable,
			@NonNull final C_Activity_StepDefData activityTable,
			@NonNull final M_Attribute_StepDefData attributeTable,
			@NonNull final M_Warehouse_StepDefData warehouseTable,
			@NonNull final IdentifierIds_StepDefData identifierIdsTable,
			@NonNull final C_Tax_StepDefData taxTable,
			@NonNull final M_Shipper_StepDefData shipperTable,
			@NonNull final C_BPartner_Location_StepDefData bPartnerLocationTable,
			@NonNull final C_Currency_StepDefData currencyTable,
			@NonNull final AD_Message_StepDefData messageTable)
	{
		this.productTable = productTable;
		this.partnerTable = partnerTable;
		this.orderTable = orderTable;
		this.orderLineTable = orderLineTable;
		this.projectTable = projectTable;
		this.attributeSetInstanceTable = attributeSetInstanceTable;
		this.flatrateConditionsTable = flatrateConditionsTable;
		this.contractTable = contractTable;
		this.taxCategoryTable = taxCategoryTable;
		this.huPiItemProductTable = huPiItemProductTable;
		this.activityTable = activityTable;
		this.attributeTable = attributeTable;
		this.warehouseTable = warehouseTable;
		this.identifierIdsTable = identifierIdsTable;
		this.taxTable = taxTable;
		this.shipperTable = shipperTable;
		this.bPartnerLocationTable = bPartnerLocationTable;
		this.currencyTable = currencyTable;
		this.messageTable = messageTable;
	}

	@Given("metasfresh contains C_OrderLines:")
	public void metasfresh_contains_c_order_lines(@NonNull final DataTable dataTable)
	{
		DataTableRows.of(dataTable)
				.setAdditionalRowIdentifierColumnName(I_C_OrderLine.COLUMNNAME_C_OrderLine_ID)
				.forEach(tableRow -> {
					final de.metas.handlingunits.model.I_C_OrderLine orderLine = newInstance(de.metas.handlingunits.model.I_C_OrderLine.class);
					orderLine.setAD_Org_ID(StepDefConstants.ORG_ID.getRepoId());

					final StepDefDataIdentifier productIdentifier = tableRow.getAsIdentifier(COLUMNNAME_M_Product_ID);
					final ProductId productId = productTable.getIdOptional(productIdentifier)
							.orElseGet(() -> productIdentifier.getAsId(ProductId.class));

					orderLine.setM_Product_ID(productId.getRepoId());
					orderLine.setQtyEntered(tableRow.getAsBigDecimal(I_C_OrderLine.COLUMNNAME_QtyEntered));

					tableRow.getAsOptionalIdentifier(I_C_OrderLine.COLUMNNAME_M_AttributeSetInstance_ID)
							.map(attributeSetInstanceTable::getId)
							.ifPresent(asiId -> orderLine.setM_AttributeSetInstance_ID(asiId.getRepoId()));

					final OrderId orderId = tableRow.getAsIdentifier(I_C_OrderLine.COLUMNNAME_C_Order_ID).lookupIdIn(orderTable);
					orderLine.setC_Order_ID(orderId.getRepoId());

					tableRow.getAsOptionalIdentifier(I_C_OrderLine.COLUMNNAME_C_BPartner_ID)
							.map(partnerTable::getId)
							.ifPresent(bpartnerId -> orderLine.setC_BPartner_ID(bpartnerId.getRepoId()));

					final String flatrateConditionsIdentifier = DataTableUtil.extractStringOrNullForColumnName(tableRow, "OPT." + I_C_OrderLine.COLUMNNAME_C_Flatrate_Conditions_ID + "." + TABLECOLUMN_IDENTIFIER);
					if (Check.isNotBlank(flatrateConditionsIdentifier))
					{
						final I_C_Flatrate_Conditions flatrateConditions = flatrateConditionsTable.get(flatrateConditionsIdentifier);
						orderLine.setC_Flatrate_Conditions_ID(flatrateConditions.getC_Flatrate_Conditions_ID());
					}

					tableRow.getAsOptionalIdentifier(de.metas.handlingunits.model.I_C_OrderLine.COLUMNNAME_M_HU_PI_Item_Product_ID)
							.ifPresent(itemProductIdentifier -> {
								if (itemProductIdentifier.isNullPlaceholder())
								{
									orderLine.setM_HU_PI_Item_Product_ID(-1);
								}
								else
								{
									final HUPIItemProductId huPiItemProductId = huPiItemProductTable.getIdOptional(itemProductIdentifier)
											.orElseGet(() -> itemProductIdentifier.getAsId(HUPIItemProductId.class));

									orderLine.setM_HU_PI_Item_Product_ID(huPiItemProductId.getRepoId());
								}
							});

					final BigDecimal qtyEnteredTU = DataTableUtil.extractBigDecimalOrNullForColumnName(tableRow, de.metas.handlingunits.model.I_C_OrderLine.COLUMNNAME_QtyEnteredTU);
					if (qtyEnteredTU != null)
					{
						orderLine.setQtyEnteredTU(qtyEnteredTU);
					}

					final BigDecimal qtyItemCapacity = DataTableUtil.extractBigDecimalOrNullForColumnName(tableRow, "OPT." + I_C_OrderLine.COLUMNNAME_QtyItemCapacity);
					if (qtyItemCapacity != null)
					{
						orderLine.setQtyItemCapacity(qtyItemCapacity);
					}

					final String warehouseIdentifier = DataTableUtil.extractStringOrNullForColumnName(tableRow, "OPT." + I_C_OrderLine.COLUMNNAME_M_Warehouse_ID + "." + TABLECOLUMN_IDENTIFIER);
					if (Check.isNotBlank(warehouseIdentifier))
					{
						final I_M_Warehouse warehouse = warehouseTable.get(warehouseIdentifier);
						assertThat(warehouse).isNotNull();

						orderLine.setM_Warehouse_ID(warehouse.getM_Warehouse_ID());
					}

					final String shipperIdentifier = DataTableUtil.extractStringOrNullForColumnName(tableRow, "OPT." + I_C_OrderLine.COLUMNNAME_M_Shipper_ID + "." + TABLECOLUMN_IDENTIFIER);
					if (Check.isNotBlank(shipperIdentifier))
					{
						final I_M_Shipper shipper = shipperTable.get(shipperIdentifier);
						assertThat(shipper).isNotNull();

						orderLine.setM_Shipper_ID(shipper.getM_Shipper_ID());
					}

					final ZonedDateTime datePromised = DataTableUtil.extractZonedDateTimeOrNullForColumnName(tableRow, "OPT." + I_C_OrderLine.COLUMNNAME_DatePromised);
					if (datePromised != null)
					{
						orderLine.setDatePromised(TimeUtil.asTimestamp(datePromised));
					}

					final String bpLocationIdentifier = DataTableUtil.extractStringOrNullForColumnName(tableRow, "OPT." + I_C_OrderLine.COLUMNNAME_C_BPartner_Location_ID + "." + TABLECOLUMN_IDENTIFIER);
					if (Check.isNotBlank(bpLocationIdentifier))
					{
						final I_C_BPartner_Location bPartnerLocation = bPartnerLocationTable.get(bpLocationIdentifier);
						assertThat(bPartnerLocation).isNotNull();
						orderLine.setC_BPartner_Location_ID(bPartnerLocation.getC_BPartner_Location_ID());
					}

					final String currencyIdentifier = DataTableUtil.extractStringOrNullForColumnName(tableRow, "OPT." + I_C_OrderLine.COLUMNNAME_C_Currency_ID + "." + TABLECOLUMN_IDENTIFIER);
					if (Check.isNotBlank(currencyIdentifier))
					{
						final I_C_Currency currency = currencyTable.get(currencyIdentifier);
						assertThat(currency).isNotNull();

						orderLine.setC_Currency_ID(currency.getC_Currency_ID());
					}

					final Timestamp dateOrdered = DataTableUtil.extractDateTimestampForColumnNameOrNull(tableRow, "OPT." + I_C_OrderLine.COLUMNNAME_DateOrdered);
					if (dateOrdered != null)
					{
						orderLine.setDateOrdered(dateOrdered);
					}

					final String uomX12DE355 = DataTableUtil.extractStringOrNullForColumnName(tableRow, "OPT." + I_C_OrderLine.COLUMNNAME_C_UOM_ID + "." + I_C_UOM.COLUMNNAME_X12DE355);
					if (Check.isNotBlank(uomX12DE355))
					{
						final UomId uomId = queryBL.createQueryBuilder(I_C_UOM.class)
								.addEqualsFilter(I_C_UOM.COLUMNNAME_X12DE355, uomX12DE355)
								.addOnlyActiveRecordsFilter()
								.create()
								.firstIdOnly(UomId::ofRepoIdOrNull);
						assertThat(uomId).as("Found no C_UOM with X12DE355=%s", uomX12DE355).isNotNull();
						orderLine.setC_UOM_ID(UomId.toRepoId(uomId));
					}

					tableRow.getAsOptionalBigDecimal("Price")
							.ifPresent(price -> {
								orderLine.setIsManualPrice(true);
								orderLine.setPriceEntered(price);
								orderLine.setPriceActual(price);
							});

					tableRow.getAsOptionalString(I_C_OrderLine.COLUMNNAME_Description)
							.ifPresent(orderLine::setDescription);

					saveRecord(orderLine);

					orderLineTable.putOrReplace(tableRow.getAsIdentifier(), orderLine);
				});
	}

	@Then("the purchase order {string} with document subtype {string} linked to order {string} has lines:")
	public void thePurchaseOrderLinkedToOrderO_HasLines(
			@NonNull final String orderIdentifier,
			@Nullable final String docSubType,
			@NonNull final String linkedOrderIdentifier,
			@NonNull final DataTable dataTable)
	{
		final SoftAssertions softly = new SoftAssertions();

		final I_C_Order purchaseOrder = queryBL
				.createQueryBuilder(I_C_Order.class)
				.addOnlyActiveRecordsFilter()
				.addEqualsFilter(I_C_Order.COLUMNNAME_Link_Order_ID, orderTable.get(linkedOrderIdentifier).getC_Order_ID())
				.create().firstOnly(I_C_Order.class);

		softly.assertThat(purchaseOrder).isNotNull();
		orderTable.putOrReplace(orderIdentifier, purchaseOrder);

		final I_C_DocType docType = queryBL
				.createQueryBuilder(I_C_DocType.class)
				.addOnlyActiveRecordsFilter()
				.addEqualsFilter(I_C_DocType.COLUMN_C_DocType_ID, purchaseOrder.getC_DocTypeTarget_ID())
				.create().firstOnly(I_C_DocType.class);

		softly.assertThat(docType).isNotNull();

		if (Check.isNotBlank(docSubType))
		{
			softly.assertThat(docType.getDocSubType()).as(I_C_DocType.COLUMNNAME_DocSubType).isEqualTo(docSubType);
		}

		final List<I_C_OrderLine> purchaseOrderLines = queryBL
				.createQueryBuilder(I_C_OrderLine.class)
				.addOnlyActiveRecordsFilter()
				.addEqualsFilter(I_C_OrderLine.COLUMNNAME_C_Order_ID, purchaseOrder.getC_Order_ID())
				.create()
				.list(I_C_OrderLine.class);

		final List<Map<String, String>> tableRows = dataTable.asMaps(String.class, String.class);
		for (final Map<String, String> tableRow : tableRows)
		{
			final BigDecimal qtyOrdered = DataTableUtil.extractBigDecimalForColumnName(tableRow, I_C_OrderLine.COLUMNNAME_QtyOrdered);
			final BigDecimal netAmt = DataTableUtil.extractBigDecimalForColumnName(tableRow, I_C_OrderLine.COLUMNNAME_LineNetAmt);
			final String productIdentifier = DataTableUtil.extractStringForColumnName(tableRow, COLUMNNAME_M_Product_ID + ".Identifier");
			final String partnerIdentifier = DataTableUtil.extractStringOrNullForColumnName(tableRow, "OPT." + I_C_OrderLine.COLUMNNAME_C_BPartner_ID + ".Identifier");
			final int partnerId = Check.isBlank(partnerIdentifier) ? 0 : partnerTable.get(partnerIdentifier).getC_BPartner_ID();
			final String warehouseIdentifier = DataTableUtil.extractStringOrNullForColumnName(tableRow, "OPT." + I_C_OrderLine.COLUMNNAME_M_Warehouse_ID + "." + TABLECOLUMN_IDENTIFIER);
			final ZonedDateTime datePromised = DataTableUtil.extractZonedDateTimeOrNullForColumnName(tableRow, "OPT." + I_C_OrderLine.COLUMNNAME_DatePromised);

			boolean linePresent = false;

			for (final I_C_OrderLine orderLine : purchaseOrderLines)
			{
				linePresent = orderLine.getLineNetAmt().compareTo(netAmt) == 0
						&& orderLine.getQtyOrdered().compareTo(qtyOrdered) == 0
						&& orderLine.getM_Product_ID() == productTable.get(productIdentifier).getM_Product_ID();
				if (partnerId > 0)
				{
					linePresent = linePresent && orderLine.getC_BPartner_ID() == partnerId;
				}

				if (Check.isNotBlank(warehouseIdentifier))
				{
					final I_M_Warehouse warehouse = warehouseTable.get(warehouseIdentifier);
					softly.assertThat(warehouse).isNotNull();

					linePresent = linePresent && (orderLine.getM_Warehouse_ID() == warehouse.getM_Warehouse_ID());
				}

				if (datePromised != null)
				{
					softly.assertThat(orderLine.getDatePromised()).as(I_C_OrderLine.COLUMNNAME_DatePromised).isNotNull();
					linePresent = linePresent && (orderLine.getDatePromised().equals(TimeUtil.asTimestamp(datePromised)));
				}

				if (linePresent)
				{
					final String orderLineIdentifier = DataTableUtil.extractStringOrNullForColumnName(tableRow, "OPT." + I_C_OrderLine.COLUMNNAME_C_OrderLine_ID + "." + TABLECOLUMN_IDENTIFIER);
					if (Check.isNotBlank(orderLineIdentifier))
					{
						orderLineTable.putOrReplace(orderLineIdentifier, orderLine);
					}

					break;
				}
			}

			softly.assertThat(linePresent).isTrue();
		}

		softly.assertAll();
	}

	@And("validate the created order lines")
	public void validate_created_order_lines(@NonNull final DataTable table)
	{
		final List<Map<String, String>> dataTable = table.asMaps();
		for (final Map<String, String> row : dataTable)
		{
			final String orderIdentifier = DataTableUtil.extractStringForColumnName(row, "C_Order_ID.Identifier");

			final I_C_Order orderRecord = orderTable.get(orderIdentifier);

			final String productIdentifier = DataTableUtil.extractStringForColumnName(row, I_C_OLCand.COLUMNNAME_M_Product_ID + "." + StepDefConstants.TABLECOLUMN_IDENTIFIER);
			final Integer expectedProductId = productTable.getOptional(productIdentifier)
					.map(I_M_Product::getM_Product_ID)
					.orElseGet(() -> Integer.parseInt(productIdentifier));

			final BigDecimal qtyOrdered = DataTableUtil.extractBigDecimalForColumnName(row, I_C_OrderLine.COLUMNNAME_QtyOrdered);

			//dev-note: we assume the tests are not using the same product on different lines
			final I_C_OrderLine orderLineRecord = queryBL.createQueryBuilder(I_C_OrderLine.class)
					.addEqualsFilter(I_C_OrderLine.COLUMNNAME_C_Order_ID, orderRecord.getC_Order_ID())
					.addEqualsFilter(I_C_OrderLine.COLUMNNAME_M_Product_ID, expectedProductId)
					.addEqualsFilter(I_C_OrderLine.COLUMNNAME_QtyOrdered, qtyOrdered)
					.create()
					.firstOnlyNotNull(I_C_OrderLine.class);

			validateOrderLine(orderLineRecord, row);
		}
	}

	@And("validate C_OrderLine:")
	public void validate_C_OrderLine(@NonNull final DataTable dataTable)
	{
		final List<Map<String, String>> table = dataTable.asMaps();
		for (final Map<String, String> row : table)
		{
			final String orderLineIdentifier = DataTableUtil.extractStringForColumnName(row, I_C_OrderLine.COLUMNNAME_C_OrderLine_ID + "." + TABLECOLUMN_IDENTIFIER);
			final I_C_OrderLine orderLine = orderLineTable.get(orderLineIdentifier);
			assertThat(orderLine).isNotNull();

			InterfaceWrapperHelper.refresh(orderLine);

			validateOrderLine(orderLine, row);
		}
	}

	@And("update C_OrderLine:")
	public void update_C_OrderLine(@NonNull final DataTable dataTable)
	{
		final List<Map<String, String>> table = dataTable.asMaps();
		for (final Map<String, String> row : table)
		{
			final String olIdentifier = DataTableUtil.extractStringForColumnName(row, I_C_OrderLine.COLUMNNAME_C_OrderLine_ID + "." + TABLECOLUMN_IDENTIFIER);
			final de.metas.handlingunits.model.I_C_OrderLine orderLine = InterfaceWrapperHelper.create(orderLineTable.get(olIdentifier), de.metas.handlingunits.model.I_C_OrderLine.class);

			final String contractIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_OrderLine.COLUMNNAME_C_Flatrate_Term_ID + "." + TABLECOLUMN_IDENTIFIER);

			if (Check.isNotBlank(contractIdentifier))
			{
				final I_C_Flatrate_Term contract = contractTable.get(contractIdentifier);

				orderLine.setC_Flatrate_Term_ID(contract.getC_Flatrate_Term_ID());
			}

			final BigDecimal updatedQtyEntered = DataTableUtil.extractBigDecimalOrNullForColumnName(row, "OPT." + I_C_OrderLine.COLUMNNAME_QtyEntered);
			if (updatedQtyEntered != null)
			{
				orderLine.setQtyEntered(updatedQtyEntered);
			}

			final String piItemProductIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + de.metas.handlingunits.model.I_C_OrderLine.COLUMNNAME_M_HU_PI_Item_Product_ID);
			if (Check.isNotBlank(piItemProductIdentifier))
			{
				final Integer piItemProductId = huPiItemProductTable.getOptional(piItemProductIdentifier)
						.map(I_M_HU_PI_Item_Product::getM_HU_PI_Item_Product_ID)
						.orElseGet(() -> Integer.parseInt(piItemProductIdentifier));

				orderLine.setM_HU_PI_Item_Product_ID(piItemProductId);
			}

			final String attributeSetInstanceIdentifier = DataTableUtil.extractNullableStringForColumnName(row, "OPT." + COLUMNNAME_M_AttributeSetInstance_ID + "." + StepDefConstants.TABLECOLUMN_IDENTIFIER);
			if (de.metas.util.Check.isNotBlank(attributeSetInstanceIdentifier))
			{
				final String asiIdentifierValue = DataTableUtil.nullToken2Null(attributeSetInstanceIdentifier);
				if (asiIdentifierValue == null)
				{
					orderLine.setM_AttributeSetInstance_ID(-1);
				}
				else
				{
					final I_M_AttributeSetInstance attributeSetInstance = attributeSetInstanceTable.get(attributeSetInstanceIdentifier);
					assertThat(attributeSetInstance).isNotNull();

					orderLine.setM_AttributeSetInstance_ID(attributeSetInstance.getM_AttributeSetInstance_ID());
				}
			}

			final BigDecimal updatedQtyOrdered = DataTableUtil.extractBigDecimalOrNullForColumnName(row, "OPT." + I_C_OrderLine.COLUMNNAME_QtyOrdered);
			if (updatedQtyOrdered != null)
			{
				orderLine.setQtyOrdered(updatedQtyOrdered);
			}

			saveRecord(orderLine);

			orderLineTable.putOrReplace(olIdentifier, orderLine);
		}
	}

	@And("^delete C_OrderLine identified by (.*), but keep its id into identifierIds table$")
	public void delete_orderLine(@NonNull final String orderLineIdentifier)
	{
		final I_C_OrderLine orderLine = orderLineTable.get(orderLineIdentifier);
		identifierIdsTable.put(orderLineIdentifier, orderLine.getC_OrderLine_ID());
		InterfaceWrapperHelper.delete(orderLine);
	}

	@And("load C_Order from C_OrderLine")
	public void loadC_Order(@NonNull final DataTable dataTable)
	{
		final List<Map<String, String>> table = dataTable.asMaps();
		for (final Map<String, String> row : table)
		{
			loadC_Order(row);
		}
	}

	private void loadC_Order(@NonNull final Map<String, String> row)
	{
		final String olIdentifier = DataTableUtil.extractStringForColumnName(row, I_C_OrderLine.COLUMNNAME_C_OrderLine_ID + "." + TABLECOLUMN_IDENTIFIER);
		final I_C_OrderLine orderLine = orderLineTable.get(olIdentifier);
		assertThat(orderLine).isNotNull();

		final I_C_Order orderRecord = InterfaceWrapperHelper.load(orderLine.getC_Order_ID(), I_C_Order.class);
		assertThat(orderRecord).isNotNull();

		final String orderIdentifier = DataTableUtil.extractStringForColumnName(row, I_C_OrderLine.COLUMNNAME_C_Order_ID + "." + TABLECOLUMN_IDENTIFIER);
		orderTable.putOrReplace(orderIdentifier, orderRecord);
	}

	@Given("metasfresh contains C_OrderLine expecting error:")
	public void metasfresh_contains_c_order_lines_expecting_error(@NonNull final DataTable dataTable)
	{
		final List<Map<String, String>> tableRows = dataTable.asMaps(String.class, String.class);
		if (tableRows.size() > 1)
		{
			throw new IllegalArgumentException("Multiple rows are not supported!");
		}

		try
		{
			metasfresh_contains_c_order_lines(dataTable);

			Assertions.fail("An Exception should have been thrown !");
		}
		catch (final AdempiereException exception)
		{
			final String errorCode = DataTableUtil.extractStringOrNullForColumnName(tableRows.get(0), "ErrorCode");

			assertThat(exception.getErrorCode()).isEqualTo(errorCode);
		}
	}

	private void validateOrderLine(@NonNull final I_C_OrderLine orderLine, @NonNull final Map<String, String> row)
	{
		final String orderIdentifier = Optional.ofNullable(DataTableUtil.extractStringOrNullForColumnName(row, "C_Order_ID.Identifier"))
				.orElseGet(() -> DataTableUtil.extractStringOrNullForColumnName(row, "Order.Identifier"));

		Check.assumeNotNull(orderIdentifier, "orderIdentifier is missing, looked for C_Order_ID.Identifier || Order.Identifier");

		final Timestamp dateOrdered = DataTableUtil.extractDateTimestampForColumnNameOrNull(row, "OPT." + I_C_OrderLine.COLUMNNAME_DateOrdered);
		final String productIdentifier = DataTableUtil.extractStringForColumnName(row, I_C_OrderLine.COLUMNNAME_M_Product_ID + ".Identifier");
		final BigDecimal qtyDelivered = DataTableUtil.extractBigDecimalForColumnName(row, "qtydelivered");
		final BigDecimal qtyordered = DataTableUtil.extractBigDecimalForColumnName(row, I_C_OrderLine.COLUMNNAME_QtyOrdered);
		final BigDecimal qtyinvoiced = DataTableUtil.extractBigDecimalForColumnName(row, "qtyinvoiced");
		final BigDecimal price = DataTableUtil.extractBigDecimalWithScaleForColumnName(row, "price");
		final BigDecimal discount = DataTableUtil.extractBigDecimalForColumnName(row, "discount");
		final String currencyCode = DataTableUtil.extractStringForColumnName(row, "currencyCode");
		final boolean processed = DataTableUtil.extractBooleanForColumnName(row, "processed");
		final String taxCategoryIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + COLUMNNAME_C_TaxCategory_ID + "." + TABLECOLUMN_IDENTIFIER);

		final Integer expectedProductId = productTable.getOptional(productIdentifier)
				.map(I_M_Product::getM_Product_ID)
				.orElseGet(() -> Integer.parseInt(productIdentifier));

		final String uomBPartner355Code = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_OrderLine.COLUMNNAME_C_UOM_BPartner_ID + "." + X12DE355.class.getSimpleName());

		if (Check.isNotBlank(uomBPartner355Code))
		{
			final UomId bPartnerUOMId = uomDAO.getUomIdByX12DE355(X12DE355.ofCode(uomBPartner355Code));
			assertThat(orderLine.getC_UOM_BPartner_ID()).isEqualTo(bPartnerUOMId.getRepoId());
		}

		final String isManualPriceStr = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_OrderLine.COLUMNNAME_IsManualPrice);

		if (Check.isNotBlank(isManualPriceStr))
		{
			final boolean isManualPrice = StringUtils.toBoolean(isManualPriceStr);
			assertThat(orderLine.isManualPrice()).isEqualTo(isManualPrice);
		}

		final String bPartnerQtyItemCapacity = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_OrderLine.COLUMNNAME_BPartner_QtyItemCapacity);

		if (Check.isNotBlank(bPartnerQtyItemCapacity))
		{
			assertThat(orderLine.getBPartner_QtyItemCapacity()).isEqualByComparingTo(bPartnerQtyItemCapacity);
		}

		final BigDecimal qtyEnteredInBPartnerUOM = DataTableUtil.extractBigDecimalOrNullForColumnName(row, "OPT." + I_C_OrderLine.COLUMNNAME_QtyEnteredInBPartnerUOM);
		if (qtyEnteredInBPartnerUOM != null)
		{
			assertThat(orderLine.getQtyEnteredInBPartnerUOM()).isEqualByComparingTo(qtyEnteredInBPartnerUOM);
		}

		final BigDecimal qtyEntered = DataTableUtil.extractBigDecimalOrNullForColumnName(row, "OPT." + I_C_OrderLine.COLUMNNAME_QtyEntered);
		if (qtyEntered != null)
		{
			assertThat(orderLine.getQtyEntered()).isEqualByComparingTo(qtyEntered);
		}

		final String uomCode = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_OrderLine.COLUMNNAME_C_UOM_ID + "." + X12DE355.class.getSimpleName());

		if (Check.isNotBlank(uomCode))
		{
			final UomId uomId = uomDAO.getUomIdByX12DE355(X12DE355.ofCode(uomCode));
			assertThat(orderLine.getC_UOM_ID()).isEqualTo(uomId.getRepoId());
		}

		final BigDecimal qtyItemCapacity = DataTableUtil.extractBigDecimalOrNullForColumnName(row, "OPT." + I_C_OrderLine.COLUMNNAME_QtyItemCapacity);

		if (qtyItemCapacity != null)
		{
			assertThat(orderLine.getQtyItemCapacity()).isEqualByComparingTo(qtyItemCapacity);
		}

		if (dateOrdered != null)
		{
			assertThat(orderLine.getDateOrdered()).as("DateOrdered").isEqualTo(dateOrdered);
		}

		if (Check.isNotBlank(taxCategoryIdentifier))
		{
			final Integer taxCategoryId = taxCategoryTable.getOptional(taxCategoryIdentifier)
					.map(I_C_TaxCategory::getC_TaxCategory_ID)
					.orElseGet(() -> Integer.parseInt(taxCategoryIdentifier));

			assertThat(orderLine.getC_TaxCategory_ID()).as("C_TaxCategory_ID").isEqualTo(taxCategoryId);
		}

		assertThat(orderLine.getC_Order_ID()).as("C_Order_ID").isEqualTo(orderTable.get(orderIdentifier).getC_Order_ID());
		assertThat(orderLine.getQtyDelivered()).as("QtyDelivered").isEqualTo(qtyDelivered);
		assertThat(orderLine.getPriceEntered()).as("PriceEntered").isEqualTo(price);
		assertThat(orderLine.getDiscount()).as("Discount").isEqualTo(discount);
		assertThat(orderLine.isProcessed()).as("Processed").isEqualTo(processed);
		assertThat(orderLine.getM_Product_ID()).as("M_Product_ID").isEqualTo(expectedProductId);
		assertThat(orderLine.getQtyOrdered()).as("QtyOrdered").isEqualByComparingTo(qtyordered);
		assertThat(orderLine.getQtyInvoiced()).as("QtyInvoiced").isEqualByComparingTo(qtyinvoiced);

		final Currency currency = currencyDAO.getByCurrencyCode(CurrencyCode.ofThreeLetterCode(currencyCode));
		assertThat(orderLine.getC_Currency_ID()).isEqualTo(currency.getId().getRepoId());

		final String flatrateConditionsIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_OrderLine.COLUMNNAME_C_Flatrate_Conditions_ID + "." + TABLECOLUMN_IDENTIFIER);
		if (Check.isNotBlank(flatrateConditionsIdentifier))
		{
			final I_C_Flatrate_Conditions flatrateConditions = flatrateConditionsTable.get(flatrateConditionsIdentifier);
			assertThat(orderLine.getC_Flatrate_Conditions_ID()).isEqualTo(flatrateConditions.getC_Flatrate_Conditions_ID());
		}

		final String x12de355StockCode = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_OrderLine.COLUMNNAME_C_UOM_ID + "." + X12DE355.class.getSimpleName());
		if (Check.isNotBlank(x12de355StockCode))
		{
			final UomId stockUomId = uomDAO.getUomIdByX12DE355(X12DE355.ofCode(x12de355StockCode));
			assertThat(orderLine.getC_UOM_ID()).isEqualTo(stockUomId.getRepoId());
		}

		final String x12de355PriceCode = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_OrderLine.COLUMNNAME_Price_UOM_ID + "." + X12DE355.class.getSimpleName());
		if (Check.isNotBlank(x12de355PriceCode))
		{
			final UomId productPriceUomId = uomDAO.getUomIdByX12DE355(X12DE355.ofCode(x12de355PriceCode));
			assertThat(orderLine.getPrice_UOM_ID()).isEqualTo(productPriceUomId.getRepoId());
		}

		final String productDescription = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_OLCand.COLUMNNAME_ProductDescription);
		if (de.metas.util.Check.isNotBlank(productDescription))
		{
			assertThat(orderLine.getProductDescription()).isEqualTo(productDescription);
		}

		final String activityIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_Activity.COLUMNNAME_C_Activity_ID + "." + StepDefConstants.TABLECOLUMN_IDENTIFIER);
		if (de.metas.util.Check.isNotBlank(activityIdentifier))
		{
			final I_C_Activity activity = activityTable.get(activityIdentifier);
			assertThat(orderLine.getC_Activity_ID()).isEqualTo(activity.getC_Activity_ID());
		}

		final String projectIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_OrderLine.COLUMNNAME_C_Project_ID + "." + StepDefConstants.TABLECOLUMN_IDENTIFIER);

		if (Check.isNotBlank(projectIdentifier))
		{
			final Integer projectId = projectTable.getOptional(projectIdentifier)
					.map(I_C_Project::getC_Project_ID)
					.orElseGet(() -> Integer.parseInt(projectIdentifier));

			assertThat(orderLine.getC_Project_ID()).isEqualTo(projectId);
		}

		final String attributeSetInstanceIdentifier = DataTableUtil.extractNullableStringForColumnName(row, "OPT." + COLUMNNAME_M_AttributeSetInstance_ID + "." + StepDefConstants.TABLECOLUMN_IDENTIFIER);
		if (Check.isNotBlank(attributeSetInstanceIdentifier))
		{
			final I_M_AttributeSetInstance expectedASI = attributeSetInstanceTable.get(attributeSetInstanceIdentifier);
			assertThat(expectedASI).isNotNull();

			final AttributesKey expectedASIKey = AttributesKeys
					.createAttributesKeyFromASIStorageAttributes(AttributeSetInstanceId.ofRepoId(expectedASI.getM_AttributeSetInstance_ID()))
					.orElse(AttributesKey.NONE);

			final AttributesKey orderLineAttributesKeys = AttributesKeys
					.createAttributesKeyFromASIStorageAttributes(AttributeSetInstanceId.ofRepoId(orderLine.getM_AttributeSetInstance_ID()))
					.orElse(AttributesKey.NONE);

			assertThat(orderLineAttributesKeys).isEqualTo(expectedASIKey);
		}

		final String huPiItemProductIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + de.metas.handlingunits.model.I_C_OrderLine.COLUMNNAME_M_HU_PI_Item_Product_ID + "." + TABLECOLUMN_IDENTIFIER);
		if (Check.isNotBlank(huPiItemProductIdentifier))
		{
			final I_M_HU_PI_Item_Product huPiItemProduct = huPiItemProductTable.get(huPiItemProductIdentifier);
			final de.metas.handlingunits.model.I_C_OrderLine orderLineHU = InterfaceWrapperHelper.load(orderLine.getC_OrderLine_ID(), de.metas.handlingunits.model.I_C_OrderLine.class);
			assertThat(huPiItemProduct.getM_HU_PI_Item_Product_ID()).isEqualTo(orderLineHU.getM_HU_PI_Item_Product_ID());
		}

		final String asiValues = DataTableUtil.extractNullableStringForColumnName(row, "OPT." + I_M_AttributeInstance.COLUMNNAME_M_Attribute_ID + ":" + I_M_AttributeInstance.Table_Name + "." + I_M_AttributeInstance.COLUMNNAME_Value);
		if (Check.isNotBlank(asiValues))
		{
			StepDefUtil.splitIdentifiers(asiValues)
					.forEach(value -> validateAttributeValue(orderLine, value));
		}

		final BigDecimal qtyReserved = DataTableUtil.extractBigDecimalOrNullForColumnName(row, "OPT." + I_C_OrderLine.COLUMNNAME_QtyReserved);
		if (qtyReserved != null)
		{
			assertThat(orderLine.getQtyReserved()).isEqualTo(qtyReserved);
		}

		final String taxIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_OrderLine.COLUMNNAME_C_Tax_ID + "." + TABLECOLUMN_IDENTIFIER);
		if (Check.isNotBlank(taxIdentifier))
		{
			final TaxId taxId = taxTable.getId(taxIdentifier);
			assertThat(orderLine.getC_Tax_ID()).isEqualTo(taxId.getRepoId());
		}

		final String orderLineIdentifier = DataTableUtil.extractStringForColumnName(row, I_C_OrderLine.COLUMNNAME_C_OrderLine_ID + "." + TABLECOLUMN_IDENTIFIER);

		orderLineTable.putOrReplace(orderLineIdentifier, orderLine);
	}

	private void validateAttributeValue(@NonNull final I_C_OrderLine orderLine, @NonNull final String value)
	{
		final List<String> expectedAttrValuePair = StepDefUtil.splitByColon(value);
		if (expectedAttrValuePair.size() != 2)
		{
			throw new RuntimeException("AttributeValue argument in wrong format! value=" + value);
		}

		final String attributeIdentifier = expectedAttrValuePair.get(0);
		final String expectedAttrValue = DataTableUtil.nullToken2Null(expectedAttrValuePair.get(1));

		final I_M_Attribute attribute = attributeTable.get(attributeIdentifier);
		assertThat(attribute).isNotNull();

		final int attributeSetInstanceId = orderLine.getM_AttributeSetInstance_ID();
		if (attributeSetInstanceId <= 0)
		{
			throw new AdempiereException("No ASI set on C_OrderLine")
					.appendParametersToMessage()
					.setParameter("C_OrderLine_ID", orderLine.getC_OrderLine_ID());
		}

		final I_M_AttributeInstance attributeInstance = queryBL.createQueryBuilder(I_M_AttributeInstance.class)
				.addEqualsFilter(I_M_AttributeInstance.COLUMNNAME_M_AttributeSetInstance_ID, attributeSetInstanceId)
				.addEqualsFilter(I_M_AttributeInstance.COLUMNNAME_M_Attribute_ID, attribute.getM_Attribute_ID())
				.create()
				.firstOnlyOptional(I_M_AttributeInstance.class)
				.orElseThrow(() -> new AdempiereException("No M_AttributeInstance found for M_Attribute_ID and ASI")
						.appendParametersToMessage()
						.setParameter("M_Attribute_ID", attribute.getM_Attribute_ID())
						.setParameter("M_AttributeSetInstance_ID", attributeSetInstanceId));

		if (expectedAttrValue == null)
		{
			assertThat(attributeInstance.getValue()).isNull();
		}
		else
		{
			assertThat(attributeInstance.getValue()).isEqualTo(expectedAttrValue);
		}
	}

	@Given("^the order line identified by (.*) is (deleted) expecting error$")
	public void order_action_expecting_error(@NonNull final String orderLineIdentifier, @NonNull final String action, @NonNull final DataTable dataTable)
	{
		final Map<String, String> row = dataTable.asMaps().get(0);

		boolean errorThrown = false;

		try
		{
			orderLineAction(orderLineIdentifier, action);
		}
		catch (final Exception e)
		{
			errorThrown = true;

			final String errorMessageIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + COLUMNNAME_AD_Message_ID + "." + TABLECOLUMN_IDENTIFIER);

			if (errorMessageIdentifier != null)
			{
				final I_AD_Message errorMessage = messageTable.get(errorMessageIdentifier);
				assertThat(e.getMessage()).contains(msgBL.getMsg(Env.getCtx(), AdMessageKey.of(errorMessage.getValue())));
			}
		}

		assertThat(errorThrown).isTrue();
	}

	private void orderLineAction(@NonNull final String orderLineIdentifier, @NonNull final String action)
	{
		final I_C_OrderLine orderLine = orderLineTable.get(orderLineIdentifier);

		switch (StepDefAction.valueOf(action))
		{
			case deleted ->
			{
				queryBL.createQueryBuilder(I_C_OrderLine.class)
						.addEqualsFilter(I_C_OrderLine.COLUMNNAME_C_OrderLine_ID, orderLine.getC_OrderLine_ID())
						.create()
						.delete();
			}
			default -> throw new AdempiereException("Unhandled C_OrderLine action")
					.appendParametersToMessage()
					.setParameter("action:", action);
		}
	}

}
