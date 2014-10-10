package com.cdstore.webapp.restclient;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.cdstore.model.CD;
import com.cdstore.webapp.CdStoreRestClientConfig;
import com.cdstore.webapp.restclient.def.ICdRestClient;

public class CdRestClient implements ICdRestClient {

	private Client restClient;
	private WebTarget webTarget;

	public CdRestClient() {
		setRestClient(CdStoreRestClientConfig.getRestClient());
		webTarget = restClient.target("http://localhost:9090/");
	}

	public Client getRestClient() {
		return restClient;
	}

	public void setRestClient(Client restClient) {
		this.restClient = restClient;
	}

	public List<CD> getAll() {
		WebTarget webTarget = this.webTarget.path("cddrive").path("all");

		Invocation.Builder invocationBuilder = webTarget
				.request(MediaType.APPLICATION_JSON);
		List<CD> response = invocationBuilder.get(new GenericType<List<CD>>() {
		});
		return response;
	}
}
