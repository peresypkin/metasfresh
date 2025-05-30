package de.metas.acct.accounts;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.metas.acct.Account;
import de.metas.acct.api.AccountId;
import de.metas.acct.api.AcctSchemaId;
import de.metas.cache.CCache;
import de.metas.costing.CostingLevel;
import de.metas.costing.CostingMethod;
import de.metas.product.ProductCategoryId;
import de.metas.util.Loggables;
import de.metas.util.Services;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;
import org.adempiere.ad.dao.IQueryBL;
import org.adempiere.ad.trx.api.ITrx;
import org.compiere.model.I_M_Product_Category_Acct;
import org.compiere.util.DB;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductCategoryAccountsRepository
{
	private final IQueryBL queryBL = Services.get(IQueryBL.class);

	private final CCache<Integer, ProductCategoryAccountsCollection> cache = CCache.<Integer, ProductCategoryAccountsCollection>builder()
			.initialCapacity(1)
			.expireMinutes(CCache.EXPIREMINUTES_Never)
			.additionalTableNameToResetFor(I_M_Product_Category_Acct.Table_Name)
			.build();

	public Optional<ProductCategoryAccounts> getAccounts(
			@NonNull final ProductCategoryId productCategoryId,
			@NonNull final AcctSchemaId acctSchemaId)
	{
		return getAll().getBy(productCategoryId, acctSchemaId);
	}

	private ProductCategoryAccountsCollection getAll()
	{
		return this.cache.getOrLoad(0, this::retrieveAll);
	}

	private ProductCategoryAccountsCollection retrieveAll()
	{
		final ImmutableList<ProductCategoryAccounts> list = queryBL.createQueryBuilder(I_M_Product_Category_Acct.class)
				.addOnlyActiveRecordsFilter()
				.create()
				.stream()
				.map(ProductCategoryAccountsRepository::fromRecord)
				.collect(ImmutableList.toImmutableList());

		return new ProductCategoryAccountsCollection(list);
	}

	private static ProductCategoryAccounts fromRecord(@NonNull final I_M_Product_Category_Acct record)
	{
		return ProductCategoryAccounts.builder()
				.productCategoryId(ProductCategoryId.ofRepoId(record.getM_Product_Category_ID()))
				.acctSchemaId(AcctSchemaId.ofRepoId(record.getC_AcctSchema_ID()))
				.costingLevel(CostingLevel.ofNullableCode(record.getCostingLevel()))
				.costingMethod(CostingMethod.ofNullableCode(record.getCostingMethod()))
				.P_Revenue_Acct(Account.of(AccountId.ofRepoId(record.getP_Revenue_Acct()), ProductAcctType.P_Revenue_Acct))
				.P_Expense_Acct(Account.of(AccountId.ofRepoId(record.getP_Expense_Acct()), ProductAcctType.P_Expense_Acct))
				.P_Asset_Acct(Account.of(AccountId.ofRepoId(record.getP_Asset_Acct()), ProductAcctType.P_Asset_Acct))
				.P_COGS_Acct(Account.of(AccountId.ofRepoId(record.getP_COGS_Acct()), ProductAcctType.P_COGS_Acct))
				.P_PurchasePriceVariance_Acct(Account.of(AccountId.ofRepoId(record.getP_PurchasePriceVariance_Acct()), ProductAcctType.P_PurchasePriceVariance_Acct))
				.P_InvoicePriceVariance_Acct(Account.of(AccountId.ofRepoId(record.getP_InvoicePriceVariance_Acct()), ProductAcctType.P_InvoicePriceVariance_Acct))
				.P_TradeDiscountRec_Acct(Account.of(AccountId.ofRepoId(record.getP_TradeDiscountRec_Acct()), ProductAcctType.P_TradeDiscountRec_Acct))
				.P_TradeDiscountGrant_Acct(Account.of(AccountId.ofRepoId(record.getP_TradeDiscountGrant_Acct()), ProductAcctType.P_TradeDiscountGrant_Acct))
				.P_CostAdjustment_Acct(Account.of(AccountId.ofRepoId(record.getP_CostAdjustment_Acct()), ProductAcctType.P_CostAdjustment_Acct))
				.P_InventoryClearing_Acct(Account.of(AccountId.ofRepoId(record.getP_InventoryClearing_Acct()), ProductAcctType.P_InventoryClearing_Acct))
				.P_WIP_Acct(Account.of(AccountId.ofRepoId(record.getP_WIP_Acct()), ProductAcctType.P_WIP_Acct))
				.P_MethodChangeVariance_Acct(Account.of(AccountId.ofRepoId(record.getP_MethodChangeVariance_Acct()), ProductAcctType.P_MethodChangeVariance_Acct))
				.P_UsageVariance_Acct(Account.of(AccountId.ofRepoId(record.getP_UsageVariance_Acct()), ProductAcctType.P_UsageVariance_Acct))
				.P_RateVariance_Acct(Account.of(AccountId.ofRepoId(record.getP_RateVariance_Acct()), ProductAcctType.P_RateVariance_Acct))
				.P_MixVariance_Acct(Account.of(AccountId.ofRepoId(record.getP_MixVariance_Acct()), ProductAcctType.P_MixVariance_Acct))
				.P_FloorStock_Acct(Account.of(AccountId.ofRepoId(record.getP_FloorStock_Acct()), ProductAcctType.P_FloorStock_Acct))
				.P_CostOfProduction_Acct(Account.of(AccountId.ofRepoId(record.getP_CostOfProduction_Acct()), ProductAcctType.P_CostOfProduction_Acct))
				.P_Labor_Acct(Account.of(AccountId.ofRepoId(record.getP_Labor_Acct()), ProductAcctType.P_Labor_Acct))
				.P_Burden_Acct(Account.of(AccountId.ofRepoId(record.getP_Burden_Acct()), ProductAcctType.P_Burden_Acct))
				.P_OutsideProcessing_Acct(Account.of(AccountId.ofRepoId(record.getP_OutsideProcessing_Acct()), ProductAcctType.P_OutsideProcessing_Acct))
				.P_Overhead_Acct(Account.of(AccountId.ofRepoId(record.getP_Overhead_Acct()), ProductAcctType.P_Overhead_Acct))
				.P_Scrap_Acct(Account.of(AccountId.ofRepoId(record.getP_Scrap_Acct()), ProductAcctType.P_Scrap_Acct))
				.P_ExternallyOwnedStock_Acct(Account.of(AccountId.ofRepoId(record.getP_ExternallyOwnedStock_Acct()), ProductAcctType.P_ExternallyOwnedStock_Acct))
				.build();
	}
	
	public void addMissingAcctRecords()
	{
		// NOTE: a step forward would be to use POAccountingInfo and do something similar to PO.insert_Accounting
		DB.executeFunctionCallEx(ITrx.TRXNAME_None, "select createM_Product_Category_Acct()", null);
		Loggables.addLog("Added missing M_Product_Category_Acct records");
	}

	@Value(staticConstructor = "of")
	private static class ProductCategoryIdAndAcctSchemaId
	{
		@NonNull ProductCategoryId productCategoryId;
		@NonNull AcctSchemaId acctSchemaId;
	}

	@EqualsAndHashCode
	@ToString
	private static final class ProductCategoryAccountsCollection
	{
		private final ImmutableMap<ProductCategoryIdAndAcctSchemaId, ProductCategoryAccounts> map;

		public ProductCategoryAccountsCollection(final List<ProductCategoryAccounts> list)
		{
			this.map = Maps.uniqueIndex(
					list,
					productCategoryAcct -> ProductCategoryIdAndAcctSchemaId.of(productCategoryAcct.getProductCategoryId(), productCategoryAcct.getAcctSchemaId()));
		}

		public Optional<ProductCategoryAccounts> getBy(
				@NonNull final ProductCategoryId productCategoryId,
				@NonNull final AcctSchemaId acctSchemaId)
		{
			final ProductCategoryIdAndAcctSchemaId key = ProductCategoryIdAndAcctSchemaId.of(productCategoryId, acctSchemaId);
			return Optional.ofNullable(map.get(key));
		}
	}

}
