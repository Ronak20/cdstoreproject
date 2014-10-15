package com.cdstore.restws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdstore.dbagent.dao.def.IPurchaseOrderDao;
import com.cdstore.dbagent.dao.def.IPurchaseOrderItemDao;
import com.cdstore.model.PurchaseOrder;
import com.cdstore.model.PurchaseOrderItem;
import com.cdstore.model.PurchaseOrderItemId;
import com.cdstore.restws.service.def.IPurchaseOrderService;

public class PurchaseOrderService implements IPurchaseOrderService {

	@Autowired
	private IPurchaseOrderDao purchaseOrderDao;
	@Autowired
	private IPurchaseOrderItemDao purchaseOrderItemDao;

	public IPurchaseOrderDao getPurchaseOrderDao() {
		return purchaseOrderDao;
	}

	public void setPurchaseOrderDao(IPurchaseOrderDao purchaseOrderDao) {
		this.purchaseOrderDao = purchaseOrderDao;
	}

	public IPurchaseOrderItemDao getPurchaseOrderItemDao() {
		return purchaseOrderItemDao;
	}

	public void setPurchaseOrderItemDao(
			IPurchaseOrderItemDao purchaseOrderItemDao) {
		this.purchaseOrderItemDao = purchaseOrderItemDao;
	}

	public void save(PurchaseOrder purchaseOrder) {
		purchaseOrderDao.save(purchaseOrder);

		List<PurchaseOrderItem> purchaseOrderItemList = purchaseOrder
				.getPurchaseOrderItem();

		if (purchaseOrderItemList != null) {

			for (PurchaseOrderItem purchaseOrderItem : purchaseOrderItemList) {
				PurchaseOrderItemId poId = purchaseOrderItem.getPoId();
				poId.setPurchaseOrder(purchaseOrder);
				purchaseOrderItem.setPoId(poId);

				purchaseOrderItemDao.save(purchaseOrderItem);
			}

		}
	}

}
