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

package de.metas.cucumber.stepdefs.payment;

import de.metas.cucumber.stepdefs.StepDefData;
import de.metas.cucumber.stepdefs.StepDefDataGetIdAware;
import de.metas.payment.PaymentId;
import org.compiere.model.I_C_Payment;

public class C_Payment_StepDefData extends StepDefData<I_C_Payment> implements StepDefDataGetIdAware<PaymentId, I_C_Payment>
{
	public C_Payment_StepDefData()
	{
		super(I_C_Payment.class);
	}

	@Override
	public PaymentId extractIdFromRecord(final I_C_Payment record)
	{
		return PaymentId.ofRepoId(record.getC_Payment_ID());
	}
}
