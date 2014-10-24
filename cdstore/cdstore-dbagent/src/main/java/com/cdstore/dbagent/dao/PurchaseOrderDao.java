package com.cdstore.dbagent.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdstore.dbagent.LogConstant;
import com.cdstore.dbagent.dao.def.IPurchaseOrderDao;
import com.cdstore.model.PurchaseOrder;

/**
 * Implementation of IPurchaseOrderDao
 * 
 * @author Ronak
 *
 */
@Repository
public class PurchaseOrderDao implements IPurchaseOrderDao {

	@Autowired
	SessionFactory sessionFactory;
	private static Logger logger = LogManager.getLogger(PurchaseOrderDao.class);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(PurchaseOrder purchaseOrder) {
		logger.info(LogConstant.ENTERED + "save");
		logger.info(LogConstant.PARAMETER + "purchaseOrder :" + purchaseOrder);
		sessionFactory.getCurrentSession().save(purchaseOrder);
		logger.info(LogConstant.EXITED + "save");

	}

	@Transactional
	public List<PurchaseOrder> getPurchaseOrder(String userId) {
		logger.info(LogConstant.ENTERED + "getPurchaseOrder");
		logger.info(LogConstant.PARAMETER + "userId :" + userId);

		String purchaseOrderQuery = "FROM PurchaseOrder P WHERE P.user.userId = "
				+ userId;
		Query query = sessionFactory.getCurrentSession().createQuery(
				purchaseOrderQuery);
		List<PurchaseOrder> poList = query.list();
		logger.debug(LogConstant.RETURN + "poList :" + poList);
		logger.info(LogConstant.EXITED + "getPurchaseOrder");
		return poList;
	}

}
