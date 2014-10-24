package com.cdstore.dbagent.dao.def;

import com.cdstore.model.User;

/**
 * Data access layer for user
 * 
 * @author Ronak
 */
public interface IUserDao {

	/**
	 * Saves user
	 * 
	 * @param user
	 */
	void save(User user);

	/**
	 * Retrives user using username and hashed password
	 * 
	 * @param userName
	 *            user name
	 * @param password
	 *            password
	 * @return user
	 */
	User getUser(String userName, String password);

	/**
	 * Retrieves user using user id
	 * 
	 * @param userId
	 *            id of user
	 * @return user
	 */
	User getUser(String userId);
}
