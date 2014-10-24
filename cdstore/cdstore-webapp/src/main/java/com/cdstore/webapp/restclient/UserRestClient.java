package com.cdstore.webapp.restclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cdstore.model.User;
import com.cdstore.webapp.AppConstant;
import com.cdstore.webapp.CdStoreRestClientConfig;
import com.cdstore.webapp.LogConstant;
import com.cdstore.webapp.restclient.def.IUserRestClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * implementation of IUserRestClient
 * 
 * @author Ronak Chaudhari
 *
 */
public class UserRestClient implements IUserRestClient {

	private Client restClient;
	private WebTarget webTarget;
	private static Logger logger = LogManager.getLogger(UserRestClient.class);

	public UserRestClient() {
		setRestClient(CdStoreRestClientConfig.getRestClient());
		webTarget = restClient.target(AppConstant.REST_URL);
	}

	public Client getRestClient() {
		return restClient;
	}

	public void setRestClient(Client restClient) {
		this.restClient = restClient;
	}

	public void save(User user) {
		logger.info(LogConstant.ENTERED + "save");
		logger.info(LogConstant.PARAMETER + "user :" + user);
		WebTarget webTarget = this.webTarget.path("user");
		Invocation.Builder invocationBuilder = webTarget
				.request(MediaType.APPLICATION_JSON);

		ObjectMapper objectMapper = new ObjectMapper();
		String userJson;

		try {
			userJson = objectMapper.writeValueAsString(user);
			logger.debug("userJson :" + userJson);
			Response response = webTarget.request().post(
					Entity.entity(userJson, MediaType.APPLICATION_JSON));
			logger.info(LogConstant.EXITED + "save");
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage(), e);
			logger.info(LogConstant.EXITED + "save");
		}
	}

	public User authenticate(User user) {
		logger.info(LogConstant.ENTERED + "authenticate");
		logger.info(LogConstant.PARAMETER + "user :" + user);
		WebTarget webTarget = this.webTarget.path("user").path("/authenticate");
		Invocation.Builder invocationBuilder = webTarget
				.request(MediaType.APPLICATION_JSON);

		ObjectMapper objectMapper = new ObjectMapper();
		String userJson;

		try {
			userJson = objectMapper.writeValueAsString(user);
			logger.debug("userJson :" + userJson);
			Response response = webTarget.request().post(
					Entity.entity(userJson, MediaType.APPLICATION_JSON));

			User authenticatedUser = response.readEntity(User.class);
			logger.debug(LogConstant.RETURN + "authenticatedUser :"
					+ authenticatedUser);
			logger.info(LogConstant.EXITED + "authenticate");
			return authenticatedUser;
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage(), e);
			logger.info(LogConstant.EXITED + "authenticate");
		}
		logger.info(LogConstant.EXITED + "authenticate");
		return null;

	}

	public User getUser(String userId) {
		logger.info(LogConstant.ENTERED + "getUser");
		logger.info(LogConstant.PARAMETER + "userId :" + userId);
		WebTarget webTarget = this.webTarget.path("user").path("details");
		WebTarget webTargetWithQueryParam = webTarget.queryParam("userId",
				userId);
		Invocation.Builder invocationBuilder = webTargetWithQueryParam
				.request();
		Response response = invocationBuilder.get();
		User authenticatedUser = response.readEntity(User.class);
		logger.debug(LogConstant.RETURN + "authenticatedUser :"
				+ authenticatedUser);
		logger.info(LogConstant.EXITED + "getUser");
		return authenticatedUser;
	}

}
