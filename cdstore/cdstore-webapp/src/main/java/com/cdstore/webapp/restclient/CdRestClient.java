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

	/*
	 * @author Sandarbh
	 * Method to get the existing CD categories from web service
	 */
	public List<String> getAllCDCategories() {
		WebTarget webTarget = this.webTarget.path("cddrive").path("cdCategories");
		Invocation.Builder invocationBuilder = webTarget
				.request(MediaType.APPLICATION_JSON);
		List<String> response = invocationBuilder.get(new GenericType<List<String>>() {
		});
		return response;
	}

	/*
	 * @author Sandarbh
	 * 
	 * @see
	 * com.cdstore.webapp.restclient.def.ICdRestClient#getAllCDsForCategories
	 * (java.util.List) Method to fetch CDs belonging to a particular category
	 */
	public List<CD> getAllCDsForCategory(String categoryString) {
		WebTarget webTarget = this.webTarget.path("cddrive").path(
				"cdsForCategories");
		WebTarget webTargetWithQueryParam = webTarget.queryParam("category",
				categoryString);
		Invocation.Builder invocationBuilder = webTargetWithQueryParam
				.request(MediaType.APPLICATION_JSON);
		List<CD> response = invocationBuilder.get(new GenericType<List<CD>>() {
		});
		return response;
	}

	public List<CD> getCds(List<String> cdIds) {
		WebTarget webTarget = this.webTarget.path("cddrive").path(
				"cdIds");
		WebTarget webTargetWithQueryParam = webTarget.queryParam("cdIds",
				cdIds);
		Invocation.Builder invocationBuilder = webTargetWithQueryParam
				.request(MediaType.APPLICATION_JSON);
		List<CD> response = invocationBuilder.get(new GenericType<List<CD>>() {
		});
		return response;
		
	}
}
