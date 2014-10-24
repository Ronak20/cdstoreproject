package com.cdstore.webapp.restclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cdstore.model.PurchaseOrder;
import com.cdstore.webapp.CdStoreRestClientConfig;
import com.cdstore.webapp.restclient.def.IPurchaseOrderRestClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PurchaseOrderRestClient implements IPurchaseOrderRestClient {

	private Client restClient;
	private WebTarget webTarget;
	
	public PurchaseOrderRestClient(){
		setRestClient(CdStoreRestClientConfig.getRestClient());
		webTarget = restClient.target("http://localhost:9090/");
	}
	
	public Client getRestClient() {
		return restClient;
	}

	public void setRestClient(Client restClient) {
		this.restClient = restClient;
	}
	
	
	public void purchase(PurchaseOrder purchaseOrder) {
		System.out.println(" saving purchase order: "+purchaseOrder.getPurchaseOrderId());
		WebTarget webTarget = this.webTarget.path("purchase");
		Invocation.Builder invocationBuilder = webTarget
				.request(MediaType.APPLICATION_JSON);
		ObjectMapper objectMapper = new ObjectMapper();
		String poJson;

		try {
			poJson = objectMapper.writeValueAsString(purchaseOrder);
			System.out.println(" poJson :  " + poJson);
			Response response = webTarget.request().post(
					Entity.entity(poJson, MediaType.APPLICATION_JSON));
			System.out.println(" po saved:  "+ purchaseOrder.getPurchaseOrderId());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
