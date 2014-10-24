package com.cdstore.dbagent.dao.def;

import java.util.List;

import com.cdstore.model.PurchaseOrder;

public interface IPurchaseOrderDao {
	void save(PurchaseOrder purchaseOrder);

	List<PurchaseOrder> getPurchaseOrder(String userId);
}
