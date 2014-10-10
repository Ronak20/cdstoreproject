package com.cdstore.restws.endpoint;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.cdstore.model.CD;
import com.cdstore.restws.endpoint.def.ICdRest;
import com.cdstore.restws.service.CdService;
import com.cdstore.restws.service.def.ICdService;

@Component
@Path("/cddrive")
public class CdRest implements ICdRest {

	private ICdService cdService;

	public CdRest() {
		cdService = new CdService();
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CD> getAllCD() {
		List<CD> cdDriveList = cdService.getAllCD();
		return cdDriveList;
	}

}
