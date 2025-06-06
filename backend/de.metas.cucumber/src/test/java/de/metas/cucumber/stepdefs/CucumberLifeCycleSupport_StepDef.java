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

package de.metas.cucumber.stepdefs;

import de.metas.cucumber.CucumberLifeCycleSupport;
import io.cucumber.java.en.Given;

public class CucumberLifeCycleSupport_StepDef
{
	@Given("infrastructure and metasfresh are running")
	public void infrastructure()
	{
		CucumberLifeCycleSupport.beforeEach();
		
		// note: we can't use something like CucumberLifeCycleSupport_StepDefData,
		// because the state needs to be shared not between StepDefs of the same scenario, but between different Scenarios.
		CucumberLifeCycleSupport.beforeAll();
	}
}
