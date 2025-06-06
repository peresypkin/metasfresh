/*
 * #%L
 * de.metas.printing.base
 * %%
 * Copyright (C) 2020 metas GmbH
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

package de.metas.printing;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.metas.audit.data.ExternalSystemParentConfigId;
import de.metas.printing.model.I_AD_PrinterHW;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;
import org.adempiere.exceptions.AdempiereException;
import org.adempiere.exceptions.FillMandatoryException;

import javax.annotation.Nullable;
import java.net.URI;

@Value
public class HardwarePrinter
{
	@NonNull HardwarePrinterId id;
	@NonNull String name;
	@NonNull OutputType outputType;
	@Nullable ExternalSystemParentConfigId externalSystemParentConfigId;
	@Nullable URI ippUrl;
	@NonNull ImmutableMap<HardwareTrayId, HardwareTray> trays;

	@Builder
	private HardwarePrinter(
			@NonNull final HardwarePrinterId id,
			@NonNull final String name,
			@NonNull final OutputType outputType,
			@Nullable final ExternalSystemParentConfigId externalSystemParentConfigId,
			@Nullable final URI ippUrl,
			@Singular final ImmutableList<HardwareTray> trays)
	{
		if (outputType == OutputType.Frontend && ippUrl == null)
		{
			throw new FillMandatoryException(I_AD_PrinterHW.COLUMNNAME_IPP_URL);
		}
		
		this.id = id;
		this.name = name;
		this.outputType = outputType;
		this.externalSystemParentConfigId = externalSystemParentConfigId;
		this.ippUrl = ippUrl;
		this.trays = Maps.uniqueIndex(trays, HardwareTray::getId);
	}

	@NonNull
	public HardwareTray getTray(@NonNull final HardwareTrayId trayId)
	{
		final HardwareTray hardwareTray = trays.get(trayId);
		if (hardwareTray == null)
		{
			throw new AdempiereException("This hardwarePrinter does not have a tray with AD_PrinterHW_MediaTray=" + trayId.getRepoId())
					.setParameter("this", this);
		}

		return hardwareTray;
	}

	public boolean isFrontendPrinter() {return getOutputType().isFrontend();}

	public URI getPrinterURI()
	{
		return getIppUrl();
	}
}
