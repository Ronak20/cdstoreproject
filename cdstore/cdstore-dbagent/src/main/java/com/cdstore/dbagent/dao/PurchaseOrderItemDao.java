package com.cdstore.dbagent.dao;

import org.hibernate.Session;

import com.cdstore.dbagent.dao.def.IPurchaseOrderItemDao;
import com.cdstore.model.PurchaseOrderItem;

public class PurchaseOrderItemDao implements IPurchaseOrderItemDao {

	private Session session;

	public PurchaseOrderItemDao(Session session) {
		this.session = session;
	}

	public void save(PurchaseOrderItem purchaseOrderItem) {
		session.save(purchaseOrderItem);
	}

}
