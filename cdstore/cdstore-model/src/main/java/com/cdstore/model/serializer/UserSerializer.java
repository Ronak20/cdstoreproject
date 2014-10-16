package com.cdstore.model.serializer;

import java.io.IOException;

import com.cdstore.model.Address;
import com.cdstore.model.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class UserSerializer extends JsonSerializer<User> {

	@Override
	public void serialize(User user, JsonGenerator jg, SerializerProvider sp)
			throws IOException, JsonProcessingException {
		if (user != null) {
			jg.writeStartObject();

			jg.writeStringField("userId", user.getUserId());
			jg.writeStringField("firstName", user.getFirstName());
			jg.writeStringField("lastName", user.getLastName());
			jg.writeStringField("username", user.getUsername());
			jg.writeStringField("password", user.getPassword());

			Address address = user.getAddress();

			if (address != null) {
				jg.writeObjectFieldStart("address");
				jg.writeStringField("addressId", address.getAddressId());
				jg.writeStringField("street", address.getStreet());
				jg.writeStringField("province", address.getProvince());
				jg.writeStringField("country", address.getCountry());
				jg.writeStringField("zip", address.getZip());
				jg.writeStringField("phone", address.getPhone());

				jg.writeEndObject();
			}

			jg.writeEndObject();
		}

	}
}
