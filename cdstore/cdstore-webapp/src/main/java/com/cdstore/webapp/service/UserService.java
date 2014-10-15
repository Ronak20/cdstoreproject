package com.cdstore.webapp.service;

import com.cdstore.model.User;
import com.cdstore.webapp.restclient.UserRestClient;
import com.cdstore.webapp.restclient.def.IUserRestClient;
import com.cdstore.webapp.service.def.IUserService;

public class UserService implements IUserService {
	
	private IUserRestClient userRestClient;
	
	public UserService()
	{
		setUserRestClient(new UserRestClient());
	}

	public IUserRestClient getUserRestClient() {
		return userRestClient;
	}

	public void setUserRestClient(IUserRestClient userRestClient) {
		this.userRestClient = userRestClient;
	}

	public void save(User user) {
		
	}

}
