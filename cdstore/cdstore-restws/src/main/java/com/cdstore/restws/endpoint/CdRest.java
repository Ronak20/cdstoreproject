package com.cdstore.restws.endpoint;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
	
	@GET
	@Path("/cdCategories")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getAllCDCategories() {
		List<String> cdCategoryList = cdService.getAllCDCategories();
		return cdCategoryList;
	}
	
	@GET
	@Path("/cdsForCategories")
	@Produces(MediaType.APPLICATION_JSON)	
	public List<CD> getAllCDsForCategories(@QueryParam("categories") List<String> categorieStrings) {
		List<CD> cdList = cdService.getAllCDForCategories(categorieStrings);
		return cdList;
	}
	
	@GET
	@Path("/cdMap")
	@Produces(MediaType.APPLICATION_JSON)	
	public Map<String, List<CD>> getCDMap() {
		return cdService.getCDMap();
	}

}
