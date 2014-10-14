package com.cdstore.restws.service;




import org.hibernate.SessionFactory;

import com.cdstore.dbagent.dao.UserDao;
import com.cdstore.model.User;
import com.cdstore.dbagent.util.HibernateUtil;
import com.cdstore.restws.service.def.IUserService;

public class UserService implements IUserService {
	
	public UserDao userDao ;
	
	public UserService(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		userDao = new UserDao(sessionFactory.openSession());
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	

	

}
