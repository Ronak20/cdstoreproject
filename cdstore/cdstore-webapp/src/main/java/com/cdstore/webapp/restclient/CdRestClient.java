package com.cdstore.webapp.restclient;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cdstore.model.CD;
import com.cdstore.webapp.AppConstant;
import com.cdstore.webapp.CdStoreRestClientConfig;
import com.cdstore.webapp.LogConstant;
import com.cdstore.webapp.exception.InternalServerException;
import com.cdstore.webapp.exception.InvalidParameterException;
import com.cdstore.webapp.exception.NotFoundException;
import com.cdstore.webapp.restclient.def.ICdRestClient;

/**
 * implementation of ICdRestClient
 * 
 * @author Ronak Chaudhari
 *
 */
public class CdRestClient implements ICdRestClient {

	private Client restClient;
	private WebTarget webTarget;
	private static Logger logger = LogManager.getLogger(CdRestClient.class);

	public CdRestClient() {
		setRestClient(CdStoreRestClientConfig.getRestClient());
		webTarget = restClient.target(AppConstant.REST_URL);
	}

	public Client getRestClient() {
		return restClient;
	}

	public void setRestClient(Client restClient) {
		this.restClient = restClient;
	}

	public List<CD> getAll() throws InternalServerException, NotFoundException {
		logger.info(LogConstant.ENTERED + "getAll");
		WebTarget webTarget = this.webTarget.path("cddrive").path("all");

		Invocation.Builder invocationBuilder = webTarget
				.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		List<CD> cdList = null;
		switch (response.getStatus()) {
		case 500:
			throw new InternalServerException("Internal server error");
		case 404:
			throw new NotFoundException("CD not found");
		case 200:
			cdList = response.readEntity(new GenericType<List<CD>>() {
			});
		default:
			cdList = response.readEntity(new GenericType<List<CD>>() {
			});
		}

		logger.debug(LogConstant.RETURN + "cdList :" + cdList);
		logger.info(LogConstant.EXITED + "getAll");
		return cdList;
	}

	public List<String> getAllCDCategories() throws InternalServerException,
			NotFoundException {
		logger.info(LogConstant.ENTERED + "getAllCDCategories");
		WebTarget webTarget = this.webTarget.path("cddrive").path(
				"cdCategories");
		Invocation.Builder invocationBuilder = webTarget
				.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		List<String> categoryList = null;
		switch (response.getStatus()) {
		case 500:
			throw new InternalServerException("Internal server error");
		case 404:
			throw new NotFoundException("CD not found");
		case 200:
			categoryList = response.readEntity(new GenericType<List<String>>() {
			});
		default:
			categoryList = response.readEntity(new GenericType<List<String>>() {
			});
		}

		logger.debug(LogConstant.RETURN + "categoryList :" + categoryList);
		logger.info(LogConstant.EXITED + "getAllCDCategories");
		return categoryList;
	}

	public List<CD> getAllCDsForCategory(String categoryString)
			throws InternalServerException, NotFoundException,
			InvalidParameterException {
		logger.info(LogConstant.ENTERED + "getAllCDsForCategory");
		logger.info(LogConstant.PARAMETER + "categoryString :" + categoryString);
		WebTarget webTarget = this.webTarget.path("cddrive").path(
				"cdsForCategories");
		WebTarget webTargetWithQueryParam = webTarget.queryParam("category",
				categoryString);
		Invocation.Builder invocationBuilder = webTargetWithQueryParam
				.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.get();

		List<CD> cdList = null;
		switch (response.getStatus()) {
		case 500:
			throw new InternalServerException("Internal server error");
		case 404:
			throw new NotFoundException("CD not found");
		case 400:
			throw new InvalidParameterException("Invalid parameters");
		case 200:
			cdList = response.readEntity(new GenericType<List<CD>>() {
			});
		default:
			cdList = response.readEntity(new GenericType<List<CD>>() {
			});
		}

		logger.debug(LogConstant.RETURN + "cdList :" + cdList);
		logger.info(LogConstant.EXITED + "getAllCDsForCategory");
		return cdList;
	}

	public List<CD> getCds(List<String> cdIds) throws InternalServerException,
			NotFoundException, InvalidParameterException {
		logger.info(LogConstant.ENTERED + "getCds");
		logger.info(LogConstant.PARAMETER + "cdIds :" + cdIds);
		WebTarget webTarget = this.webTarget.path("cddrive").path("cdIds");
		WebTarget webTargetWithQueryParam = webTarget
				.queryParam("cdIds", cdIds);
		Invocation.Builder invocationBuilder = webTargetWithQueryParam
				.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		List<CD> cdList = null;
		switch (response.getStatus()) {
		case 500:
			throw new InternalServerException("Internal server error");
		case 400:
			throw new InvalidParameterException("Invalid parameters");
		case 404:
			throw new NotFoundException("CD not found");
		case 200:
			cdList = response.readEntity(new GenericType<List<CD>>() {
			});
		default:
			cdList = response.readEntity(new GenericType<List<CD>>() {
			});
		}
		logger.debug(LogConstant.RETURN + "cdList :" + cdList);
		logger.info(LogConstant.EXITED + "getCds");
		return cdList;
	}
}
