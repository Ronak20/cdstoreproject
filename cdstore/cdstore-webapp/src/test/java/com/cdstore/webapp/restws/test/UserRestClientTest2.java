package com.cdstore.webapp.restws.test;



import junit.framework.TestCase;

import com.cdstore.model.Address;
import com.cdstore.model.User;
import com.cdstore.webapp.restclient.UserRestClient;
import com.cdstore.webapp.restclient.def.IUserRestClient;


public class UserRestClientTest2 extends TestCase {

	Constant_Values cv = new Constant_Values();
	
	public void testAuthenticateUser()

	{
		IUserRestClient userRestClient = new UserRestClient();

		User user = new User();
		Address adr = new Address();
		adr.setCountry(cv.country);
		adr.setPhone(cv.Phone);
		adr.setProvince(cv.Province);
		adr.setStreet(cv.Street);
		adr.setZip(cv.Zip);
		user.setFirstName(cv.firstname);
		user.setLastName(cv.lastname);
		user.setUsername(cv.username);
		user.setPassword(cv.password);
		user.setAddress(adr);
		userRestClient.save(user);

		// userRestClient.authenticate(user);
		String id = userRestClient.authenticate(user).getUserId();

		assertNotNull(id);

	}
}
