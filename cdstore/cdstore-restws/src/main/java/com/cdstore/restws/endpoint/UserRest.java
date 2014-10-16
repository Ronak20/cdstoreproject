package com.cdstore.restws.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdstore.model.Address;
import com.cdstore.model.User;
import com.cdstore.restws.endpoint.def.IUserRest;
import com.cdstore.restws.service.def.IAddressService;
import com.cdstore.restws.service.def.IUserService;

@Component
@Path("/user")
public class UserRest implements IUserRest {

	@Autowired
	private IUserService userservice;

	@Autowired
	private IAddressService addressService;

	public IUserService getUserservice() {
		return userservice;
	}

	public void setUserservice(IUserService userservice) {
		this.userservice = userservice;
	}

	public IAddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(IAddressService addressService) {
		this.addressService = addressService;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void save(User user) {
		Address address = user.getAddress();
		if (address != null) {
			addressService.save(address);
		}
		userservice.save(user);
	}

	@POST
	@Path("/authenticate")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public User authenticate(User user) {
		User dbUser = userservice.authenticate(user);
		return dbUser;
	}

}
