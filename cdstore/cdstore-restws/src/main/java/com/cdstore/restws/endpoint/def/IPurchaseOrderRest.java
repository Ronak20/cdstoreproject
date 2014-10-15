package com.cdstore.restws.endpoint.def;

import java.util.List;

import com.cdstore.model.CD;
import com.cdstore.model.PurchaseOrder;
import com.cdstore.model.PurchaseOrderItem;
import com.cdstore.model.User;

public interface IPurchaseOrderRest {
	/*
	 * void purchase(List<PurchaseOrderItem> puchaseOrderItemList, User user,
	 * List<CD> cdList);
	 */
	void purchase(PurchaseOrder purchaseOrder);
}
