package com.cdstore.restws.endpoint;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.cdstore.dbagent.model.CdDrive;
import com.cdstore.restws.endpoint.def.ICdDriveRest;
import com.cdstore.restws.service.CdService;
import com.cdstore.restws.service.def.ICdService;

@Component
@Path("/cddrive")
public class CdDriveRest implements ICdDriveRest {

	private ICdService cdService;

	public CdDriveRest() {
		cdService = new CdService();
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CdDrive> getAllCD() {
		List<CdDrive> cdDriveList = cdService.getAllCD();
		return cdDriveList;
	}

}
