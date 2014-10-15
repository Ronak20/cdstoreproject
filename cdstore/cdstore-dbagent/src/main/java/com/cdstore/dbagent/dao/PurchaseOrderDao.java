package com.cdstore.dbagent.dao;

import org.hibernate.Session;

import com.cdstore.dbagent.dao.def.IPurchaseOrderDao;
import com.cdstore.model.PurchaseOrder;

public class PurchaseOrderDao implements IPurchaseOrderDao {

	private Session session;

	public PurchaseOrderDao(Session session) {
		this.session = session;
	}

	public void save(PurchaseOrder purchaseOrder) {
		session.save(purchaseOrder);
	}

}
