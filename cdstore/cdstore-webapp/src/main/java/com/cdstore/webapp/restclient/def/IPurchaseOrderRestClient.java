package com.cdstore.webapp.restclient.def;

import com.cdstore.model.PurchaseOrder;

public interface IPurchaseOrderRestClient {

	public String purchase(PurchaseOrder purchaseOrder);
}
