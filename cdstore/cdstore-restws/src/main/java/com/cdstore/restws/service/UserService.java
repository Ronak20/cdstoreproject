package com.cdstore.restws.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdstore.dbagent.dao.def.IUserDao;
import com.cdstore.model.User;
import com.cdstore.restws.service.def.IUserService;

public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void save(User user) {
		userDao.save(user);
	}

}
