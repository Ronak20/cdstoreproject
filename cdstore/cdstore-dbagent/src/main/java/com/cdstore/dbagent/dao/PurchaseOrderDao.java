package com.cdstore.dbagent.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdstore.dbagent.dao.def.IPurchaseOrderDao;
import com.cdstore.model.PurchaseOrder;

@Repository
public class PurchaseOrderDao implements IPurchaseOrderDao {

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(PurchaseOrder purchaseOrder) {
		sessionFactory.getCurrentSession().save(purchaseOrder);
		System.out.println("Poid is: "+purchaseOrder.getPurchaseOrderId());
	}

}
