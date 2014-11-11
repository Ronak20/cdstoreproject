package com.cdstore.webapp.service;

import com.cdstore.model.User;
import com.cdstore.webapp.restclient.UserRestClient;
import com.cdstore.webapp.restclient.def.IUserRestClient;
import com.cdstore.webapp.service.def.IUserService;

/**
 * Implementation of IUserService
 * 
 * @author Ronak
 *
 */
public class UserService implements IUserService {

	private IUserRestClient userRestClient;

	public UserService() {
		setUserRestClient(new UserRestClient());
	}

	public UserService(String username, String password) {
		setUserRestClient(new UserRestClient(username, password));
	}

	public IUserRestClient getUserRestClient() {
		return userRestClient;
	}

	public void setUserRestClient(IUserRestClient userRestClient) {
		this.userRestClient = userRestClient;
	}

	public void save(User user) {
		userRestClient.save(user);
	}

	public User authenticate(User user) {
		return userRestClient.authenticate(user);
	}

	public User getUser(String userId) {
		return userRestClient.getUser(userId);
	}

}
