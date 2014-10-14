package com.cdstore.restws.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.cdstore.dbagent.dao.UserDao;
import com.cdstore.dbagent.dao.def.IUserDao;
import com.cdstore.model.User;
import com.cdstore.restws.endpoint.def.IUserRest;
import com.cdstore.restws.service.CdService;
import com.cdstore.restws.service.UserService;
import com.cdstore.restws.service.def.IUserService;

@Component
@Path("/user")
public class UserRest implements IUserRest {

	private IUserService userservice;
	
	public UserRest() {
		userservice = new UserService(); }
			
			

	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	//@Produces({MediaType.TEXT_HTML})    
	public void save(User user) {
		// TODO Auto-generated method stub
				 userservice.save(user);
	}

}
