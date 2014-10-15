package com.cdstore.restws.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdstore.model.User;
import com.cdstore.restws.endpoint.def.IUserRest;
import com.cdstore.restws.service.def.IUserService;

@Component
@Path("/user")
public class UserRest implements IUserRest {

	@Autowired
	private IUserService userservice;

	public IUserService getUserservice() {
		return userservice;
	}

	public void setUserservice(IUserService userservice) {
		this.userservice = userservice;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void save(User user) {
		userservice.save(user);
	}

}
