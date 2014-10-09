package com.cdstore.restws;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.cdstore.restws.endpoint.CdDriveRest;

/**
 * 
 * 
 * @author Ronak Chaudhari
 */
public class CdStoreResourceConfig extends ResourceConfig {

	/**
	 * Register JAX-RS application components.
	 */
	public CdStoreResourceConfig() {
		this.register(RequestContextFilter.class);
		this.register(TestResource.class);
		this.register(JAXBContextResolver.class);
		//this.register(JacksonFeature.class);
		this.register(CdDriveRest.class);
	}
}
