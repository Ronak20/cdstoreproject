package com.cdstore.webapp.restws.test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import junit.framework.TestCase;

import com.cdstore.model.Address;
import com.cdstore.model.User;
import com.cdstore.webapp.restclient.UserRestClient;
import com.cdstore.webapp.restclient.def.IUserRestClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.fabric.Response;

public class UserAuthenticateRestClientTest extends TestCase {
	
	Constant_Values cv = new Constant_Values();

	public void testAuthenticateUser() {
		IUserRestClient userRestClient = new UserRestClient();
		
		User user = new User();
		user.setUsername(cv.username);
		user.setPassword(cv.password);
		String id = userRestClient.authenticate(user).getUserId();
		
		assertNotNull(id);
		
		
			}
}
