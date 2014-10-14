package com.cdstore.dbagent.dao;

import javax.security.auth.login.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cdstore.dbagent.dao.def.IUserDao;
import com.cdstore.model.User;

public class UserDao implements IUserDao {
	
	private Session session;

	public UserDao(Session session) {
		this.session = session;
	}


	public void save(User user) {
		session.save(user);
	}

}
