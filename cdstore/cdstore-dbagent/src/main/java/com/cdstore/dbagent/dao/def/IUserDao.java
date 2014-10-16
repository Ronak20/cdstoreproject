package com.cdstore.dbagent.dao.def;

import java.util.List;

import com.cdstore.model.User;

/**
 * Data access layer for user
 * 
 * @author Ronak
 */
public interface IUserDao {
	void save(User user);

	List<User> getUser(String userName, String password);
}
