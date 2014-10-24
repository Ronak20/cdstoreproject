/*package com.cdstore.webapp.restws.test;

import junit.framework.TestCase;

import com.cdstore.webapp.restclient.PurchaseOrderRestClient;
import com.cdstore.webapp.restclient.def.IPurchaseOrderRestClient;

public class PurchaseOrderRestClientTest extends TestCase {

	private IPurchaseOrderRestClient purchaseOrderRestClient;

	public void setUp() throws Exception {
		purchaseOrderRestClient = new PurchaseOrderRestClient();
	}

	public void testPurchase() {
		IPurchaseOrderRestClient purchaseOrderRestClient = new PurchaseOrderRestClient();
		Constant_Values cv = new Constant_Values();
		User user = new User();
		user.setFirstName(cv.firstname);
		user.setLastName(cv.lastname);
		user.setUsername(cv.username);
		user.setPassword(cv.password);
		// user.setUserId(userRestClient.authenticate(user).getUserId());
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setUser(user);
		purchaseOrder.setStatus("order");
		// purchaseOrder.setPurchaseOrderItem("one");
		// PurchaseOrderService p=new PurchaseOrderService();
		purchaseOrderRestClient.purchase(purchaseOrder);
		// p.purchase(purchaseOrder);
	}

}
*/