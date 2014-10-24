package com.cdstore.restws.service.def;

import java.util.List;

import com.cdstore.model.PurchaseOrder;

public interface IPurchaseOrderService {
	void save(PurchaseOrder purchaseOrder);

	List<PurchaseOrder> getPurchaseOrder(String userId);
}
