/*package com.cdstore.restws.serializer;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import com.cdstore.dbagent.model.CdDrive;

*//**
 * Serialiazer for cd drive
 * 
 * @author Ronak
 *
 *//*
public class CdDriveSerializer extends JsonSerializer<CdDrive> {

	@Override
	public void serialize(CdDrive cdDrive, JsonGenerator jg,
			SerializerProvider sp) throws IOException, JsonProcessingException {
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
*/