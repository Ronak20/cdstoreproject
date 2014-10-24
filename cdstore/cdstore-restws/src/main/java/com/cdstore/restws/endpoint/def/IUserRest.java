package com.cdstore.restws.endpoint.def;

import com.cdstore.model.User;

/**
 * rest definition for user endpoint
 * 
 * @author Ronak
 *
 */
public interface IUserRest {

	/**
	 * Saves user
	 * 
	 * @param user
	 *            to be saved
	 */
	void save(User user);

	/**
	 * authenticated user
	 * 
	 * @param user
	 *            to be authenticated
	 * @return authenticated user
	 */
	User authenticate(User user);

	/**
	 * Provides user details
	 * 
	 * @param userId
	 *            of user
	 * @return details of user
	 */
	User getUser(String userId);
}
