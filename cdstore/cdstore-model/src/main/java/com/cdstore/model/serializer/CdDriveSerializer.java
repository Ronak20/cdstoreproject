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
	public void serialize(CD cdDrive, JsonGenerator jg, SerializerProvider sp)
			throws IOException, JsonProcessingException {
		if (cdDrive != null) {
			jg.writeStartObject();

			jg.writeStringField("cdId", cdDrive.getCdId());
			jg.writeStringField("title", cdDrive.getTitle());
			jg.writeNumberField("price", cdDrive.getPrice());
			jg.writeStringField("category", cdDrive.getCategory());

			jg.writeEndObject();
		}
	}

}
