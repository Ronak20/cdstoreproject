package com.cdstore.dbagent.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdstore.dbagent.dao.def.IAddressDao;
import com.cdstore.model.Address;

@Repository
public class AddressDao implements IAddressDao {

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(Address address) {
		sessionFactory.getCurrentSession().save(address);
		String addressId = address.getAddressId();
	}

}
