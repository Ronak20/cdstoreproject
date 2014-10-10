package com.cdstore.webapp;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class CdStoreRestClientConfig {

	public static Client getRestClient() {
		Client client = ClientBuilder.newClient();
		return client;
	}

}
