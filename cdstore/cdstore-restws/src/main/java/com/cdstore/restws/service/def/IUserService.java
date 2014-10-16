package com.cdstore.restws.service.def;

import com.cdstore.model.User;

public interface IUserService {
	void save(User user);

	User authenticate(User user);
}
