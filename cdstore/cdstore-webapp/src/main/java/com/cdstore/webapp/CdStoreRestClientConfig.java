package com.cdstore.webapp;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.filter.LoggingFilter;

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
	public Client getRestClient(String username, String password) {
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFilter());

		HttpAuthenticationFeature feature = HttpAuthenticationFeature
				.universalBuilder().credentialsForDigest(username, password)
				.build();

		Client client = ClientBuilder.newClient(config);
		client.register(feature);
		return client;
	}

	public Client getRestClient() {
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFilter());
		Client client = ClientBuilder.newClient(config);
		return client;
	}
}
