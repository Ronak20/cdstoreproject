package com.cdstore.restws.service.def;

import com.cdstore.model.User;

/**
 * user rest service definition
 * 
 * @author Ronak
 *
 */
public interface IUserService {

	/**
	 * saves user
	 * 
	 * @param user
	 *            to be saved
	 */
	void save(User user);

	/**
	 * authenticated user
	 * 
	 * @param user
	 *            for authenticate
	 * @return authenticated user
	 */
	User authenticate(User user);

	/**
	 * get details of user
	 * 
	 * @param userId
	 *            to get details
	 * @return user with details
	 */
	User getUser(String userId);
}
