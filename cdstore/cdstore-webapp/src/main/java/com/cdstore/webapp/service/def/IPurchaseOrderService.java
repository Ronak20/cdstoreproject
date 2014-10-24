package com.cdstore.webapp.service.def;

import com.cdstore.model.PurchaseOrder;

public interface IPurchaseOrderService {

	/*
	 * void purchase(List<PurchaseOrderItem> puchaseOrderItemList, User user,
	 * List<CD> cdList);
	 */
	String purchase(PurchaseOrder purchaseOrder);

}
