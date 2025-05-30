package de.metas.document.archive.api;

/*
 * #%L
 * de.metas.document.archive.base
 * %%
 * Copyright (C) 2015 metas GmbH
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

import de.metas.document.archive.DocOutboundLogId;
import de.metas.document.archive.model.I_C_Doc_Outbound_Log;
import de.metas.document.archive.model.I_C_Doc_Outbound_Log_Line;
import de.metas.document.archive.postfinance.PostFinanceStatus;
import de.metas.util.ISingletonService;
import lombok.NonNull;
import org.adempiere.ad.dao.IQueryBuilder;
import org.adempiere.util.lang.IContextAware;
import org.adempiere.util.lang.impl.TableRecordReference;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Stream;

public interface IDocOutboundDAO extends ISingletonService
{
	List<I_C_Doc_Outbound_Log> retrieveLog(TableRecordReference tableRecordReference);

	I_C_Doc_Outbound_Log getById(@NonNull DocOutboundLogId docOutboundLogId);

	Stream<I_C_Doc_Outbound_Log> streamByIdsInOrder(@NonNull List<DocOutboundLogId> ids);

	@Nullable
	I_C_Doc_Outbound_Log_Line retrieveCurrentPDFArchiveLogLineOrNull(@NonNull DocOutboundLogId docOutboundLogId);

	void setPostFinanceExportStatus(@NonNull DocOutboundLogId docOutboundLogId, @NonNull PostFinanceStatus exportStatus);

	/**
	 * Find among the given <code>log</code>'s {@link I_C_Doc_Outbound_Log_Line}s the latest one with action <code>PDF</code> (i.e highest ID)
	 *
	 * @return log line
	 */
	@Nullable
	I_C_Doc_Outbound_Log_Line retrieveCurrentPDFArchiveLogLineOrNull(I_C_Doc_Outbound_Log log);

	/**
	 * Decorate query builder with PDF archive log line filters
	 */
	void addPDFArchiveLogLineFilters(IQueryBuilder<I_C_Doc_Outbound_Log_Line> queryBuilder);

	/**
	 * Retrieves last created {@link I_C_Doc_Outbound_Log} for given bpartner and table
	 */
	I_C_Doc_Outbound_Log retrieveLog(final IContextAware contextProvider, int bpartnerId, int AD_Table_ID);
	
	void updatePOReferenceIfExists(@NonNull TableRecordReference recordReference, @Nullable String poReference);
}
