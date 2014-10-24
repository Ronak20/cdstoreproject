package com.cdstore.webapp.restclient.def;

import com.cdstore.model.User;

public interface IUserRestClient {
	void save(User user);

	User authenticate(User user);
	
	User getUser(String userId);
}
