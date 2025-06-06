/*
 * #%L
 * de.metas.cucumber
 * %%
 * Copyright (C) 2025 metas GmbH
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

package de.metas.cucumber.stepdefs.forecast;

import de.metas.cucumber.stepdefs.StepDefData;
import de.metas.cucumber.stepdefs.StepDefDataGetIdAware;
import de.metas.mforecast.impl.ForecastId;
import org.compiere.model.I_M_Forecast;

/**
 * Having a dedicated class to help the IOC-framework injecting the right instances, if a step-def needs more than one.
 */
public class M_Forecast_StepDefData extends StepDefData<I_M_Forecast>
		implements StepDefDataGetIdAware<ForecastId, I_M_Forecast>
{
	public M_Forecast_StepDefData()
	{
		super(I_M_Forecast.class);
	}

	@Override
	public ForecastId extractIdFromRecord(final I_M_Forecast record)
	{
		return ForecastId.ofRepoId(record.getM_Forecast_ID());
	}
}
