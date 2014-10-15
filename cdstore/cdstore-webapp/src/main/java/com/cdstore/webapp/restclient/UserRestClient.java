package com.cdstore.webapp.restclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cdstore.model.User;
import com.cdstore.webapp.CdStoreRestClientConfig;
import com.cdstore.webapp.restclient.def.IUserRestClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserRestClient implements IUserRestClient {

	private Client restClient;
	private WebTarget webTarget;

	public UserRestClient() {
		setRestClient(CdStoreRestClientConfig.getRestClient());
		webTarget = restClient.target("http://localhost:9090/");
	}

	public Client getRestClient() {
		return restClient;
	}

	public void setRestClient(Client restClient) {
		this.restClient = restClient;
	}

	public void save(User user) {
		WebTarget webTarget = this.webTarget.path("user");
		Invocation.Builder invocationBuilder = webTarget
				.request(MediaType.APPLICATION_JSON);

		ObjectMapper objectMapper = new ObjectMapper();
		String userJson;

		try {
			userJson = objectMapper.writeValueAsString(user);
			Response response = webTarget.request().post(
					Entity.entity(userJson, MediaType.APPLICATION_JSON));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
