package com.cdstore.webapp;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * Configures rest client
 * 
 * @author Ronak
 *
 */
public class CdStoreRestClientConfig {

	/**
	 * Provides rest client
	 * 
	 * @return rest client
	 */
	public static Client getRestClient() {
		Client client = ClientBuilder.newClient();
		return client;
	}

}
