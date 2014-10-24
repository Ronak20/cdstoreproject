package com.cdstore.dbagent.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdstore.dbagent.dao.def.IUserDao;
import com.cdstore.model.User;

@Repository
public class UserDao implements IUserDao {

	@Autowired
	SessionFactory sessionFactory;
	private static Logger logger = LogManager.getLogger(UserDao.class);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(User user) {
		logger.info(LogConstant.ENTERED + "save");
		logger.info(LogConstant.PARAMETER + "user :" + user);
		sessionFactory.getCurrentSession().save(user);
		logger.info(LogConstant.EXITED + "save");
	}

	@Transactional
	public List<User> getUser(String userName, String password) {
		logger.info(LogConstant.ENTERED + "getUser");
		logger.info(LogConstant.PARAMETER + "userName :" + userName);
		logger.info(LogConstant.PARAMETER + "password :" + password);
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				User.class);
		criteria.add(Restrictions.eq("username", userName));
		criteria.add(Restrictions.eq("password", password));

		List<User> userList = criteria.list();
		logger.debug(LogConstant.RETURN + "userList :" + userList);
		logger.info(LogConstant.EXITED + "getUser");
		return userList;
	}

	@Transactional
	public User getUser(String userId) {
		logger.info(LogConstant.ENTERED + "getUser");
		logger.info(LogConstant.PARAMETER + "userId :" + userId);
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				User.class);
		criteria.add(Restrictions.eq("userId", userId));

		User userList = (User) criteria.list().get(0);
		logger.debug(LogConstant.RETURN + "userList :" + userList);
		logger.info(LogConstant.EXITED + "getUser");
		return userList;
	}
}
