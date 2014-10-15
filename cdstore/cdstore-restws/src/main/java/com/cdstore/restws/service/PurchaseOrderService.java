package com.cdstore.restws.service;

import java.util.List;

import org.hibernate.SessionFactory;

import com.cdstore.dbagent.dao.PurchaseOrderDao;
import com.cdstore.dbagent.dao.PurchaseOrderItemDao;
import com.cdstore.dbagent.dao.def.IPurchaseOrderDao;
import com.cdstore.dbagent.dao.def.IPurchaseOrderItemDao;
import com.cdstore.dbagent.util.HibernateUtil;
import com.cdstore.model.PurchaseOrder;
import com.cdstore.model.PurchaseOrderItem;
import com.cdstore.model.PurchaseOrderItemId;
import com.cdstore.restws.service.def.IPurchaseOrderService;

public class PurchaseOrderService implements IPurchaseOrderService {

	private IPurchaseOrderDao purchaseOrderDao;
	private IPurchaseOrderItemDao purchaseOrderItemDao;

	public PurchaseOrderService() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		purchaseOrderDao = new PurchaseOrderDao(sessionFactory.openSession());
		purchaseOrderItemDao = new PurchaseOrderItemDao(sessionFactory.openSession());
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
