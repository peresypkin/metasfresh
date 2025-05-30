package de.metas.common.ordercandidates.v1.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.metas.common.rest_api.v1.attachment.JsonAttachmentType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import javax.annotation.Nullable;

/*
 * #%L
 * de.metas.business
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@Value
@Schema(description = "Describes a data attachment that exists within metasfresh")
public class JsonAttachment
{
	@Schema(minLength = 1,
			description = "Reference in terms of the external system. Can reference multiple records (e.g. multiple order line candidates)\n"
					+ "To be used in conjunktion with <code>dataSourceName</code>")
	String externalReference;

	@Schema(minLength = 1,
			description = "Internal name of the <code>AD_InputDataSource</code> record that tells where this attachment came from.\n"
					+ "To be used in conjunktion with <code>externalReference</code>")
	String dataSourceName;

	@Schema(minLength = 1,
			description = "ID assigned to the attachment data by metasfresh")
	String attachmentId;

	JsonAttachmentType type;

	String filename;

	@Schema(minLength = 1, //
			description = "MIME type of the binary data; `null` if the attachment's type is `URL`")
	String mimeType;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	String url;

	@JsonCreator
	@Builder(toBuilder = true)
	private JsonAttachment(
			@JsonProperty("externalReference") @NonNull final String externalReference,
			@JsonProperty("dataSourceName") @NonNull final String dataSourceName,
			@JsonProperty("attachmentId") @NonNull final String attachmentId,
			@JsonProperty("type") final @NonNull JsonAttachmentType type,
			@JsonProperty("filename") @NonNull final String filename,
			@JsonProperty("mimeType") @Nullable final String mimeType,
			@JsonProperty("url") final String url)
	{
		this.externalReference = externalReference;
		this.dataSourceName = dataSourceName;
		this.attachmentId = attachmentId;
		this.type = type;
		this.filename = filename;
		this.mimeType = mimeType;
		this.url = url;
	}
}
