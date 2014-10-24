package com.cdstore.model.serializer;

import java.io.IOException;
import java.util.List;

import com.cdstore.model.Address;
import com.cdstore.model.CD;
import com.cdstore.model.PurchaseOrder;
import com.cdstore.model.PurchaseOrderItem;
import com.cdstore.model.PurchaseOrderItemId;
import com.cdstore.model.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * serializer for user
 * 
 * @author Ronak
 *
 */
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

			List<PurchaseOrder> poList = user.getPurchaseOrderList();

			if (poList != null) {
				jg.writeArrayFieldStart("purchaseOrderList");

				for (PurchaseOrder po : poList) {
					jg.writeStartObject();
					jg.writeStringField("purchaseOrderId",
							po.getPurchaseOrderId());
					jg.writeStringField("status", po.getStatus());

					List<PurchaseOrderItem> poItemList = po
							.getPurchaseOrderItem();

					jg.writeArrayFieldStart("purchaseOrderItem");
					if (poItemList != null) {

						for (PurchaseOrderItem poItem : poItemList) {
							jg.writeStartObject();
							jg.writeNumberField("price", poItem.getPrice());

							PurchaseOrderItemId poId = poItem.getPoId();
							jg.writeObjectFieldStart("poId");

							CD cd = poId.getCd();
							jg.writeObjectFieldStart("cd");
							jg.writeStringField("cdId", cd.getCdId());
							jg.writeStringField("title", cd.getTitle());
							jg.writeNumberField("price", cd.getPrice());
							jg.writeStringField("category", cd.getCategory());
							jg.writeEndObject();

							jg.writeEndObject();

							jg.writeEndObject();
						}

					}

					jg.writeEndArray();
					jg.writeEndObject();
				}

				jg.writeEndArray();
			}

			jg.writeEndObject();
		}

	}
}
