DROP FUNCTION IF EXISTS AccountSheetReport(p_dateFrom date, p_dateTo date, p_c_acctschema_id NUMERIC, p_ad_org_id numeric, p_account_id NUMERIC, p_c_activity_id numeric, p_c_project_id numeric)
;

DROP FUNCTION IF EXISTS AccountSheetReport(p_dateFrom date, p_dateTo date, p_c_acctschema_id NUMERIC, p_ad_org_id numeric, p_account_id NUMERIC, p_c_activity_id numeric, p_c_project_id numeric, p_ad_language text)
;

CREATE OR REPLACE FUNCTION AccountSheetReport(p_dateFrom        date,
                                              p_dateTo          date,
                                              p_c_acctschema_id NUMERIC,
                                              p_ad_org_id       numeric,
                                              p_account_id      NUMERIC=NULL,
                                              p_c_activity_id   numeric=NULL,
                                              p_c_project_id    numeric=NULL,
                                              p_ad_language     text = 'en_US')
    RETURNS table
            (
                AccountValue     text,
                AccountName      text,
                dateacct         timestamp WITHOUT TIME ZONE,
                beginningBalance numeric,
                amtacctdr        numeric,
                amtacctcr        numeric,
                endingBalance    numeric,
                taxRate          text,
                taxCategory      text,
                amtsourcedr      numeric,
				amtsourcecr      numeric, 
				currency         text, 
				currencyrate     numeric,
                docTypeName      text,
                documentno       text,
                description      text,
                fact_acct_id     integer
            )
AS
$BODY$
DECLARE
    v_time                              timestamp;
    LINE_TYPE_BEGINNINGBALANCE CONSTANT text = 'B';
    LINE_TYPE_TRANSACTION      CONSTANT text = 'T';
    v_temp                              numeric;
BEGIN
    v_time := logDebug('start');

    --
    -- create temporary table for everything we're working on; it has no rows, only the needed columns
    DROP TABLE IF EXISTS TMP_AccountSheetReport;
    CREATE TEMPORARY TABLE TMP_AccountSheetReport
    (
        fact_acct_id     numeric(10),
        documentno       text,
        account_id       numeric(10),
        AccountValue     text,
        AccountName      text,
        dateacct         timestamp,
        amtacctdr        numeric,
        amtacctcr        numeric,
        amtsourcedr      numeric,
		amtsourcecr      numeric,
		currency        text, 
		currencyrate     numeric,
        description      text,
        c_doctype_id     numeric(10),
        c_tax_id         numeric(10),
        c_taxcategory_id numeric(10),
        beginningBalance numeric,
        endingBalance    numeric,
        lineType         text,
        taxName          text,
        taxCategoryName  text,
        docTypeName      text
    );
    v_time := logDebug('created empty temporary table', v_time);


    --
    -- insert into the temp table the beginningBalance for all the available accounts which have the balance != 0
    -- noinspection SqlInsertValues
    WITH filteredElementValues AS
             (
                 SELECT ev.c_elementvalue_id,
                        ev.name  AccountName,
                        ev.value AccountValue
                 FROM c_elementvalue ev
                 WHERE TRUE
                   AND (p_account_id IS NULL OR ev.c_elementvalue_id = p_account_id)
                 ORDER BY ev.c_elementvalue_id
             ),
         previousBalances AS
             (
                 SELECT (de_metas_acct.acctBalanceToDate(ev.c_elementvalue_id, p_c_acctschema_id, (p_dateFrom - INTERVAL '1 day')::date, p_ad_org_id)::de_metas_acct.BalanceAmt).Balance previousDayBalance,
                        ev.c_elementvalue_id,
                        ev.AccountName,
                        ev.AccountValue
                 FROM filteredElementValues ev
             ),
         nonZeroPreviousBalances AS
             (
                 SELECT pv.previousDayBalance,
                        pv.c_elementvalue_id,
                        pv.AccountName,
                        pv.AccountValue
                 FROM previousBalances pv
                 WHERE previousDayBalance != 0
             )
    INSERT
    INTO TMP_AccountSheetReport (beginningBalance, endingBalance, lineType, account_id, AccountName, AccountValue)
    SELECT nonZero.previousDayBalance,
           nonZero.previousDayBalance,
           LINE_TYPE_BEGINNINGBALANCE,
           nonZero.c_elementvalue_id,
           nonZero.AccountName,
           nonZero.AccountValue
    FROM nonZeroPreviousBalances nonZero;

    GET DIAGNOSTICS v_temp = ROW_COUNT;
    v_time := logDebug('inserted beginningBalance: ' || v_temp || ' records', v_time);


    --
    -- insert the fact_acct rows into the table
    WITH filteredFactAcct AS
             (
                 SELECT fa.fact_acct_id,
                        fa.documentno,
                        fa.account_id,
                        ev.value                                      AccountValue,
                        ev.name                                       AccountName,
                        fa.dateacct,
                        fa.c_tax_id,
                        coalesce(taxTrl.name, t.name)                 taxName,
                        fa.amtacctdr,
                        fa.amtacctcr,
						fa.amtsourcecr, 
		                fa.amtsourcedr,
		                c.iso_code as currency, 
		                fa.currencyrate,
                        fa.description,
                        fa.c_doctype_id,
                        coalesce(dtTrl.name, dt.name)                 docTypeName,
                        tc.c_taxcategory_id,
                        coalesce(tcTrl.name, tc.name)                 taxCategoryName,
                        coalesce(tmp_fa.beginningBalance::numeric, 0) beginningBalance,
                        coalesce(tmp_fa.endingBalance::numeric, 0)    endingBalance,
                        LINE_TYPE_TRANSACTION                         lineType
                 FROM fact_acct fa
                          INNER JOIN c_elementvalue ev ON fa.account_id = ev.c_elementvalue_id
                          LEFT JOIN TMP_AccountSheetReport tmp_fa ON tmp_fa.account_id = fa.account_id
                          LEFT JOIN c_tax t ON fa.c_tax_id = t.c_tax_id
                          LEFT JOIN c_tax_trl taxTrl ON t.c_tax_id = taxTrl.c_tax_id AND taxTrl.ad_language = p_ad_language
                          LEFT JOIN c_taxcategory tc ON t.c_taxcategory_id = tc.c_taxcategory_id
                          LEFT JOIN c_taxcategory_trl tcTrl ON tc.c_taxcategory_id = tcTrl.c_taxcategory_id AND tcTrl.ad_language = p_ad_language
                          LEFT JOIN c_doctype dt ON fa.c_doctype_id = dt.c_doctype_id AND dt.c_doctype_id != 0
                          LEFT JOIN c_doctype_trl dtTrl ON dt.c_doctype_id = dtTrl.c_doctype_id AND dtTrl.ad_language = p_ad_language
						  LEFT JOIN c_currency c on c.c_currency_id = fa.c_currency_id
						  
                 WHERE TRUE
                   AND (fa.amtacctdr != 0 OR fa.amtacctcr != 0)
                   AND fa.postingtype = 'A' -- posting type = 'Actual'
                   AND fa.c_acctschema_id = p_c_acctschema_id
                   AND (fa.dateacct >= p_dateFrom AND fa.dateacct <= p_dateTo)
                   AND (p_account_id IS NULL OR fa.account_id = p_account_id)
                   AND (p_c_activity_id IS NULL OR fa.c_activity_id = p_c_activity_id)
                   AND (p_c_project_id IS NULL OR fa.c_project_id = p_c_project_id)
                   AND (p_ad_org_id IS NULL or fa.ad_org_id = p_ad_org_id)
             )
    INSERT
    INTO TMP_AccountSheetReport(fact_acct_id,
                                documentno,
                                account_id,
                                AccountValue,
                                AccountName,
                                dateacct,
                                amtacctdr,
                                amtacctcr,
								amtsourcecr, 
								amtsourcedr,
								currency, 
								currencyrate,
                                description,
                                c_doctype_id,
                                c_tax_id,
                                c_taxcategory_id,
                                beginningBalance,
                                endingBalance,
                                lineType,
                                taxName,
                                taxCategoryName,
                                docTypeName)
    SELECT ffa.fact_acct_id,
           ffa.documentno,
           ffa.account_id,
           ffa.AccountValue,
           ffa.AccountName,
           ffa.dateacct,
           ffa.amtacctdr,
           ffa.amtacctcr,
		   ffa.amtsourcecr, 
		   ffa.amtsourcedr,
		   ffa.currency, 
		   ffa.currencyrate,
           ffa.description,
           ffa.c_doctype_id,
           ffa.c_tax_id,
           ffa.c_taxcategory_id,
           ffa.beginningBalance,
           ffa.endingBalance,
           ffa.lineType,
           ffa.taxName,
           ffa.taxCategoryName,
           ffa.docTypeName
    FROM filteredFactAcct ffa;

    GET DIAGNOSTICS v_temp = ROW_COUNT;
    v_time := logDebug('inserted:' || v_temp || ' fact_acct', v_time);


    --
    -- Update the current balance for each row.
    -- This implementation uses a rolling sum over the previous rows
    WITH beginningBalance_fa AS
             (
                 SELECT tmp_fa.fact_acct_id,
                        (
                                tmp_fa.endingBalance
                                + sum(tmp_fa.amtacctdr - tmp_fa.amtacctcr)
                                  OVER
                                      (
                                      PARTITION BY tmp_fa.account_id
                                      ORDER BY tmp_fa.dateacct, tmp_fa.fact_acct_id ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW
                                      )
                            ) AS                              beginningBalance,
                        (tmp_fa.amtacctdr - tmp_fa.amtacctcr) transactionBalance
                 FROM TMP_AccountSheetReport tmp_fa
             ),
         final_fa AS
             (
                 SELECT fa.*,
                        fa.beginningBalance - fa.transactionBalance endingBalance
                 FROM beginningBalance_fa fa
             )
    UPDATE TMP_AccountSheetReport tmp_fa
    SET beginningBalance = ffa.endingBalance,
        endingBalance    = ffa.beginningBalance
    FROM final_fa ffa
    WHERE tmp_fa.fact_acct_id = ffa.fact_acct_id;

    v_time := logDebug('finished calculating rolling sum', v_time);

    RETURN QUERY
        SELECT --
               t.AccountValue,
               t.AccountName,
               t.dateacct,
               t.beginningBalance,
               t.amtacctdr,
               t.amtacctcr,
               t.endingBalance,
               t.taxName         taxRate,
               t.taxCategoryName taxCategory,
			   t.amtsourcecr, 
		       t.amtsourcedr,
		       t.currency, 
		       t.currencyrate,
               t.docTypeName,
               t.documentno::text,
               t.description::text,
               t.fact_acct_id::integer
        FROM TMP_AccountSheetReport t
        ORDER BY t.dateacct NULLS FIRST, t.fact_acct_id NULLS FIRST;
END;
$BODY$
    LANGUAGE plpgsql
    VOLATILE
;
