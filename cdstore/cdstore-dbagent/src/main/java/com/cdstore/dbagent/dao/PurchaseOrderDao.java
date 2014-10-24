package com.cdstore.dbagent.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdstore.dbagent.dao.def.IPurchaseOrderDao;
import com.cdstore.model.PurchaseOrder;
import com.cdstore.model.User;

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
	}

	@Transactional
	public List<PurchaseOrder> getPurchaseOrder(String userId) {
		/*
		 * Criteria criteria =
		 * sessionFactory.getCurrentSession().createCriteria(
		 * PurchaseOrder.class);
		 * 
		 * User user = new User(); user.setUserId(userId);
		 * 
		 * criteria.add(Restrictions.eq("user", user));
		 * 
		 * List<PurchaseOrder> poList = criteria.list();
		 */

		String purchaseOrderQuery = "FROM PurchaseOrder P WHERE P.user.userId = "
				+ userId;
		Query query = sessionFactory.getCurrentSession().createQuery(
				purchaseOrderQuery);
		List<PurchaseOrder> poList = query.list();

		return poList;
	}

}
