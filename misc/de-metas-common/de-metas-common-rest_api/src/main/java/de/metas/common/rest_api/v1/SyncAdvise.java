/*
 * #%L
 * de-metas-common-rest_api
 * %%
 * Copyright (C) 2021 metas GmbH
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

package de.metas.common.rest_api.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.metas.common.util.CoalesceUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import javax.annotation.Nullable;

@Value
public class SyncAdvise
{
	public static final SyncAdvise READ_ONLY = SyncAdvise
			.builder()
			.ifNotExists(IfNotExists.FAIL)
			.ifExists(IfExists.DONT_UPDATE)
			.build();
	public static final SyncAdvise READ_ONLY_UNCHANGED = SyncAdvise
			.builder()
			.ifNotExists(IfNotExists.FAIL)
			.ifExists(IfExists.ASSERT_UNCHANGED)
			.build();

	public static final SyncAdvise CREATE_OR_MERGE = SyncAdvise
			.builder()
			.ifNotExists(IfNotExists.CREATE)
			.ifExists(IfExists.UPDATE_MERGE)
			.build();

	public static final SyncAdvise JUST_CREATE_IF_NOT_EXISTS = SyncAdvise
			.builder()
			.ifNotExists(IfNotExists.CREATE)
			.ifExists(IfExists.DONT_UPDATE)
			.build();

	@Getter
	public enum IfNotExists
	{
		CREATE(false/* fail */, true/* create */),

		FAIL(true/* fail */, false/* create */);

		private final boolean fail;

		private final boolean create;

		IfNotExists(final boolean fail, final boolean create)
		{
			this.fail = fail;
			this.create = create;
		}
	}

	@Schema(enumAsRef = true, description = "IfExists: \n" +
			"* `UPDATE_MERGE` - Insert/update data that is specified in this request entity, but leave *other* pre-existing data untouched\n" +
			"* `UPDATE_REMOVE` - Insert/update data that is specified in this request entity, *and* unset or remove * other* pre-existing data\n" +
			"* `ASSERT_UNCHANGED` - Verify the data specified in this request entity is equal to the pre-existing data\n" +
			"* `DONT_UPDATE`\n" +
			"")

	@Getter
	public enum IfExists
	{
		UPDATE_MERGE(true/* updateMerge */, false/* updateRemove */, false /* assertUnchanged */),

		UPDATE_REMOVE(false/* updateMerge */, true/* updateRemove */, false /* assertUnchanged */),

		ASSERT_UNCHANGED(false/* updateMerge */, false/* updateRemove */, true /* assertUnchanged */),

		DONT_UPDATE(false/* updateMerge */, false/* updateRemove */, false /* assertUnchanged */);

		private final boolean updateMerge;

		private final boolean updateRemove;

		private final boolean assertUnchanged;

		IfExists(final boolean updateMerge, final boolean updateRemove, final boolean assertUnchanged)
		{
			this.updateMerge = updateMerge;
			this.updateRemove = updateRemove;
			this.assertUnchanged = assertUnchanged;
		}

		public boolean isUpdate()
		{
			return updateMerge || updateRemove;
		}

		public boolean isAttemptUpdate()
		{
			return updateMerge || updateRemove || assertUnchanged;
		}
	}

	@JsonInclude(Include.NON_NULL)
	IfNotExists ifNotExists;

	@JsonInclude(Include.NON_NULL)
	IfExists ifExists;

	@Builder
	@JsonCreator
	private SyncAdvise(
			@JsonProperty("ifNotExists") @Nullable final IfNotExists ifNotExists,
			@JsonProperty("ifExists") @Nullable final IfExists ifExists)
	{
		this.ifNotExists = CoalesceUtil.coalesce(ifNotExists, IfNotExists.FAIL);
		this.ifExists = CoalesceUtil.coalesce(ifExists, IfExists.DONT_UPDATE);
	}

	@JsonIgnore
	public boolean isFailIfNotExists()
	{
		return IfNotExists.FAIL.equals(ifNotExists);
	}

	/**
	 * If {@code true} then the sync code can attempt to lookup readonlydata. Maybe this info helps with caching.
	 */
	@JsonIgnore
	public boolean isLoadReadOnly()
	{
		return READ_ONLY.equals(this) || READ_ONLY_UNCHANGED.equals(this);
	}
}
