package com.cdstore.restws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdstore.dbagent.dao.def.IUserDao;
import com.cdstore.model.User;
import com.cdstore.restws.service.def.IUserService;

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

		if (userName != null && !userName.isEmpty() && password != null
				&& !password.isEmpty()) {
			List<User> userList = userDao.getUser(userName, password);
			if (userList != null) {
				User dbUser = userList.get(0);
				return dbUser;
			}
		}
		logger.debug(LogConstant.RETURN + "user :" + null);
		logger.info(LogConstant.EXITED + "authenticate");
		return null;
	}

	public User getUser(String userId) {
		return userDao.getUser(userId);
	}

}
