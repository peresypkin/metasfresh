package de.metas.notification;

import de.metas.document.engine.IDocumentBL;
import de.metas.event.EventMessageFormatTemplate;
import de.metas.logging.LogManager;
import de.metas.util.Services;
import lombok.NonNull;
import org.adempiere.model.PlainContextAware;
import org.adempiere.util.lang.IContextAware;
import org.adempiere.util.lang.ITableRecordReference;
import org.slf4j.Logger;

/*
 * #%L
 * de.metas.adempiere.adempiere.base
 * %%
 * Copyright (C) 2018 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

/**
 * {@link UserNotification}'s message formatter.
 *
 * @author metas-dev <dev@metasfresh.com>
 */
final class UserNotificationDetailMessageFormat extends EventMessageFormatTemplate
{
	public static UserNotificationDetailMessageFormat newInstance()
	{
		return new UserNotificationDetailMessageFormat();
	}

	private static final Logger logger = LogManager.getLogger(UserNotificationDetailMessageFormat.class);

	private UserNotificationDetailMessageFormat()
	{
		super();
	}

	@Override
	protected String formatTableRecordReference(@NonNull final ITableRecordReference recordRef)
	{
		// Retrieve the record
		final Object record;
		try
		{
			final IContextAware context = PlainContextAware.createUsingOutOfTransaction();
			record = recordRef.getModel(context);
		}
		catch (final Exception e)
		{
			logger.info("Failed retrieving record for " + recordRef, e);
			return "<" + recordRef.getRecord_ID() + ">";
		}

		if (record == null)
		{
			logger.info("Failed retrieving record for " + recordRef);
			return "<" + recordRef.getRecord_ID() + ">";
		}

		final String documentNo = Services.get(IDocumentBL.class).getDocumentNo(record);
		return documentNo;
	}

	@Override
	protected String formatText(final String text)
	{
		return text == null ? "" : text;
	}
}
