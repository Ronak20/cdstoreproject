package com.cdstore.dbagent.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdstore.dbagent.dao.def.IUserDao;
import com.cdstore.model.User;

public class UserDao implements IUserDao {

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

}
