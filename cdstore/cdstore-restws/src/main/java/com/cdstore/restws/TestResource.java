package com.cdstore.restws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

/**
 * TestResource
 * 
 * @author Janus Dam Nielsen
 */
@Component
@Path("/")
public class TestResource {

	@GET
	@Produces("text/html")
	public String getIt() {
		return "uups";
	}

	@GET
	@Path("/test")
	@Produces("text/html")
	public String test() {
		return "test";
	}

}