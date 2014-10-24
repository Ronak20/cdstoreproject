package com.cdstore.dbagent.dao;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdstore.dbagent.LogConstant;
import com.cdstore.dbagent.dao.def.IAddressDao;
import com.cdstore.model.Address;

/**
 * Implementation of IAddressDao
 * 
 * @author Ronak
 *
 */
@Repository
public class AddressDao implements IAddressDao {

	@Autowired
	SessionFactory sessionFactory;
	private static Logger logger = LogManager.getLogger(AddressDao.class);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(Address address) {
		logger.info(LogConstant.ENTERED + "save");
		logger.info(LogConstant.PARAMETER + "address :" + address);
		sessionFactory.getCurrentSession().save(address);
		String addressId = address.getAddressId();
		logger.info(LogConstant.EXITED + "save");

	}

}
