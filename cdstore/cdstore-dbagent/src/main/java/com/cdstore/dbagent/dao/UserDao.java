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

	@Transactional
	public List<User> getUser(String userName, String password) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				User.class);
		criteria.add(Restrictions.eq("username", userName));
		criteria.add(Restrictions.eq("password", password));

		List<User> userList = criteria.list();
		return userList;
	}

	@Transactional
	public User getUser(String userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				User.class);
		criteria.add(Restrictions.eq("userId", userId));

		User userList = (User) criteria.list().get(0);
		return userList;
	}
}
