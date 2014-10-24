package com.cdstore.restws.endpoint.def;

import com.cdstore.model.User;

public interface IUserRest {
	void save(User user);

	User authenticate(User user);

	User getUser(String userId);
}
