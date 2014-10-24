package com.cdstore.webapp.restws.test;

import junit.framework.TestCase;

import com.cdstore.webapp.restclient.PurchaseOrderRestClient;
import com.cdstore.webapp.restclient.def.IPurchaseOrderRestClient;

public class PurchaseOrderRestClientTest extends TestCase{

	private IPurchaseOrderRestClient purchaseOrderRestClient;
	
	public void setUp() throws Exception {
		purchaseOrderRestClient = new PurchaseOrderRestClient();
	}
	
	public void testPurchase()
	{
		
	}
	
}
