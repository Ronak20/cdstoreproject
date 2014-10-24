package com.cdstore.restws.endpoint;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdstore.model.CD;
import com.cdstore.restws.MessageConstant;
import com.cdstore.restws.endpoint.def.ICdRest;
import com.cdstore.restws.service.def.ICdService;

/**
 * rest endpoint for cd
 * 
 * @author Ronak
 *
 */
@Component
@Path("/cddrive")
public class CdRest implements ICdRest {

	@Autowired
	private ICdService cdService;

	public ICdService getCdService() {
		return cdService;
	}

	public void setCdService(ICdService cdService) {
		this.cdService = cdService;
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCD() {
		List<CD> cdDriveList = null;
		try {
			cdDriveList = cdService.getAllCD();

			if (cdDriveList == null || (cdDriveList.size() == 0)) {
				return Response.status(Response.Status.NOT_FOUND)
						.entity(MessageConstant.CD_NOT_FOUND).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
		return Response.ok(cdDriveList).build();
	}

	@GET
	@Path("/cdCategories")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCDCategories() {
		List<String> cdCategoryList = null;
		try {
			cdCategoryList = cdService.getAllCDCategories();

			if (cdCategoryList == null || (cdCategoryList.size() == 0)) {
				return Response.status(Response.Status.NOT_FOUND)
						.entity(MessageConstant.CATEGORY_NOT_FOUND).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
		return Response.ok(cdCategoryList).build();
	}

	@GET
	@Path("/cdsForCategories")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCDsForCategory(
			@QueryParam("category") String categorieString) {

		if (categorieString == null || categorieString.isEmpty()) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		List<CD> cdList = null;
		try {
			cdList = cdService.getAllCDForCategory(categorieString);
			if (cdList == null || (cdList.size() == 0)) {
				return Response.status(Response.Status.NOT_FOUND)
						.entity(MessageConstant.CATEGORY_NOT_FOUND).build();
			}
			return Response.ok(cdList).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
	}

	@GET
	@Path("/cdIds")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCds(@QueryParam("cdIds") List<String> cdIds) {
		if (cdIds == null || cdIds.isEmpty()) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		List<CD> cdList = null;
		try {
			cdList = cdService.getCds(cdIds);
			if (cdList == null || (cdList.size() == 0)) {
				return Response.status(Response.Status.NOT_FOUND)
						.entity(MessageConstant.CD_NOT_FOUND).build();
			}
			return Response.ok(cdList).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
	}

}
