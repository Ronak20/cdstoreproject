package com.cdstore.webapp.restws.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.cdstore.model.Address;
import com.cdstore.model.CD;
import com.cdstore.model.PurchaseOrder;
import com.cdstore.model.PurchaseOrderItem;
import com.cdstore.model.PurchaseOrderItemId;
import com.cdstore.model.User;
import com.cdstore.webapp.restclient.PurchaseOrderRestClient;
import com.cdstore.webapp.restclient.def.IPurchaseOrderRestClient;

public class PurchaseOrderRestClientTest extends TestCase {

	private IPurchaseOrderRestClient purchaseOrderRestClient;

	public void setUp() throws Exception {
		purchaseOrderRestClient = new PurchaseOrderRestClient();
	}

	public void testPurchase() {
		User user = new User();
		user.setUserId("9");
		/*
		 * user.setFirstName("Ronak"); user.setLastName("Chaudhari");
		 * user.setPassword("abcd"); user.setUsername("Ronak");
		 */
		user.setPurchaseOrderList(null);

		Address address = new Address();
		address.setAddressId("1");
		address.setCountry("Canada");
		address.setPhone("613-123-4567");
		address.setProvince("ON");
		address.setStreet("123 King adward");
		address.setUserList(null);
		address.setZip("K1E 6T5");
		user.setAddress(address);

		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setUser(user);
		purchaseOrder.setStatus("ORDERED");

		List<PurchaseOrderItem> poItemList = new ArrayList<PurchaseOrderItem>();

		PurchaseOrderItem poItem1 = new PurchaseOrderItem();
		poItem1.setPrice(100);

		// single poItem
		PurchaseOrderItemId poItemId1 = new PurchaseOrderItemId();

		poItemId1.setPurchaseOrder(null);

		CD cd1 = new CD();
		cd1.setCdId("cd001");
		cd1.setPurchaseOrderItem(null);
		cd1.setVisitEventList(null);

		poItemId1.setCd(cd1);

		poItem1.setPoId(poItemId1);

		// second poItem
		PurchaseOrderItem poItem2 = new PurchaseOrderItem();
		poItem2.setPrice(200);

		PurchaseOrderItemId poItemId2 = new PurchaseOrderItemId();
		poItemId2.setPurchaseOrder(null);
		CD cd2 = new CD();
		cd2.setCdId("cd002");
		cd2.setPurchaseOrderItem(null);
		cd2.setVisitEventList(null);

		poItemId2.setCd(cd2);

		poItem2.setPoId(poItemId2);

		poItemList.add(poItem1);
		poItemList.add(poItem2);

		purchaseOrder.setPurchaseOrderItem(poItemList);

		String purchaseStatus = purchaseOrderRestClient.purchase(purchaseOrder);
		Assert.assertEquals("success", purchaseStatus);
	}
}
