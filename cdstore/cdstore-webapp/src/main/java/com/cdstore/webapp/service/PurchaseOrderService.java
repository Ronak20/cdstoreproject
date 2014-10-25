package com.cdstore.webapp.service;

import com.cdstore.model.PurchaseOrder;
import com.cdstore.webapp.restclient.PurchaseOrderRestClient;
import com.cdstore.webapp.restclient.def.IPurchaseOrderRestClient;
import com.cdstore.webapp.service.def.IPurchaseOrderService;

/**
 * Implementation of IPurchaseOrderService
 * 
 * @author Ronak
 *
 */
public class PurchaseOrderService implements IPurchaseOrderService {

	private IPurchaseOrderRestClient purchaseOrderRestClient;
	
	public PurchaseOrderService() {
		setPurchaseOrderClient(new PurchaseOrderRestClient());
	}

	public IPurchaseOrderRestClient getUserRestClient() {
		return purchaseOrderRestClient;
	}

	public void setPurchaseOrderClient(IPurchaseOrderRestClient purchaseOrderRestClient) {
		this.purchaseOrderRestClient = purchaseOrderRestClient;
	}
	
	public String purchase(PurchaseOrder purchaseOrder) {
		
		String responseString= purchaseOrderRestClient.purchase(purchaseOrder);
		return responseString;
	}

}
