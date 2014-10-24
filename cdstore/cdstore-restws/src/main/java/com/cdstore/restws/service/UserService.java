package com.cdstore.restws.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdstore.dbagent.LogConstant;
import com.cdstore.dbagent.dao.def.IUserDao;
import com.cdstore.model.User;
import com.cdstore.restws.service.def.IUserService;

/**
 * Implementation of IUserService
 * 
 * @author Ronak
 *
 */
public class UserService implements IUserService {

	private static Logger logger = LogManager.getLogger(UserService.class);
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

	public User authenticate(User user) {
		logger.info(LogConstant.ENTERED + "authenticate");
		logger.info(LogConstant.PARAMETER + "user :" + user);

		String userName = user.getUsername();
		String password = user.getPassword();

		User userList = null;
		if (userName != null && !userName.isEmpty() && password != null
				&& !password.isEmpty()) {
			userList = userDao.getUser(userName, password);
			return userList;
		}
		logger.debug(LogConstant.RETURN + "user :" + null);
		logger.info(LogConstant.EXITED + "authenticate");
		return null;
	}

	public User getUser(String userId) {
		return userDao.getUser(userId);
	}

}
