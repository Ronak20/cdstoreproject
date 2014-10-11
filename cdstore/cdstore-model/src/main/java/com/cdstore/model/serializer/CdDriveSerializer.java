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

			jg.writeStringField("cdId", cd.getCdId());
			jg.writeStringField("title", cd.getTitle());
			jg.writeNumberField("price", cd.getPrice());
			jg.writeStringField("category", cd.getCategory());

			jg.writeEndObject();
		}
	}

}
