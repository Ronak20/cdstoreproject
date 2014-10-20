package com.cdstore.dbagent.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdstore.dbagent.dao.def.IPurchaseOrderItemDao;
import com.cdstore.model.PurchaseOrderItem;

@Repository
public class PurchaseOrderItemDao implements IPurchaseOrderItemDao {

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(PurchaseOrderItem purchaseOrderItem) {
		sessionFactory.getCurrentSession().save(purchaseOrderItem);
	}

}
