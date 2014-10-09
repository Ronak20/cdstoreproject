package com.cdstore.restws.endpoint;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import com.cdstore.dbagent.dao.def.IUserDao;
import com.cdstore.dbagent.model.User;

@Component
@Path("/user")
public class UserRest implements IUserDao{

	@POST
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

}
