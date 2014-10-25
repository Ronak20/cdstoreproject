package com.cdstore.model.serializer;

import java.io.IOException;

import com.cdstore.model.CD;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Serializer for cd drive
 * 
 * @author Ronak
 */
public class CdDriveSerializer extends JsonSerializer<CD> {

	@Override
	public void serialize(CD cd, JsonGenerator jg, SerializerProvider sp)
			throws IOException, JsonProcessingException {
		if (cd != null) {
			jg.writeStartObject();

			String cdId = cd.getCdId();

			if (cdId != null) {
				jg.writeStringField("cdId", cd.getCdId());
			}

			String title = cd.getTitle();
			if (title != null) {
				jg.writeStringField("title", cd.getTitle());
			}

			Integer price = cd.getPrice();

			if (price != null) {
				jg.writeNumberField("price", cd.getPrice());
			}

			String category = cd.getCategory();
			if (category != null) {
				jg.writeStringField("category", cd.getCategory());
			}

			jg.writeEndObject();
		}
	}

}
