package com.cdstore.webapp.restws.test;

import junit.framework.TestCase;

import com.cdstore.model.User;
import com.cdstore.webapp.restclient.UserRestClient;
import com.cdstore.webapp.restclient.def.IUserRestClient;

public class UserRestClientTest extends TestCase {
	public void testAuthenticateUser() {
		IUserRestClient userRestClient = new UserRestClient();

		User user = new User();
		user.setUsername("a");
		user.setPassword("a");

		userRestClient.authenticate(user);

		User aUser = userRestClient.authenticate(user);

		System.out.println(aUser.toString());
	}

	public void testGetUserDetails() {
		IUserRestClient userRestClient = new UserRestClient();

		User user = userRestClient.getUser("1");

		System.out.println(user.toString());
	}
}
