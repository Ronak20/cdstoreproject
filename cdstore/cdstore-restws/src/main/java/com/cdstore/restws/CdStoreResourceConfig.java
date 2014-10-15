package com.cdstore.restws;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.cdstore.restws.endpoint.CdRest;
import com.cdstore.restws.endpoint.PurchaseOrderRest;
import com.cdstore.restws.endpoint.UserRest;

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
		this.register(JacksonFeature.class);
		this.register(CdRest.class);
		this.register(UserRest.class);
		this.register(PurchaseOrderRest.class);
	}
}
