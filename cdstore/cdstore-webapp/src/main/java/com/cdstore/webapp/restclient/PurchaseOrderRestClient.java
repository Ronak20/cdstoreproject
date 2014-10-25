package com.cdstore.webapp.restclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cdstore.model.PurchaseOrder;
import com.cdstore.webapp.AppConstant;
import com.cdstore.webapp.CdStoreRestClientConfig;
import com.cdstore.webapp.LogConstant;
import com.cdstore.webapp.restclient.def.IPurchaseOrderRestClient;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * implementation of IPurchaseOrderRestClient
 * 
 * @author Ronak Chaudhari
 *
 */
public class PurchaseOrderRestClient implements IPurchaseOrderRestClient {

	private Client restClient;
	private WebTarget webTarget;
	private static Logger logger = LogManager
			.getLogger(PurchaseOrderRestClient.class);

	public PurchaseOrderRestClient() {
		setRestClient(CdStoreRestClientConfig.getRestClient());
		webTarget = restClient.target(AppConstant.REST_URL);
	}

	public Client getRestClient() {
		return restClient;
	}

	public void setRestClient(Client restClient) {
		this.restClient = restClient;
	}

	public String purchase(PurchaseOrder purchaseOrder) {
		logger.info(LogConstant.ENTERED + "purchase");
		logger.info(LogConstant.PARAMETER + "purchaseOrder :" + purchaseOrder);
		Invocation.Builder invocationBuilder = webTarget.path("purchase")
				.request(MediaType.TEXT_PLAIN);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		String poJson;

		try {
			poJson = objectMapper.writeValueAsString(purchaseOrder);
			logger.debug("poJson :" + poJson);
			Response response = invocationBuilder.post(Entity.entity(poJson,
					MediaType.APPLICATION_JSON));
			String purchaseStatus = response.readEntity(String.class);
			logger.debug(" po saved:  " + purchaseOrder.getPurchaseOrderId());
			logger.debug(LogConstant.RETURN + "cdList :" + purchaseStatus);
			logger.info(LogConstant.EXITED + "getAllCDsForCategory");
			return purchaseStatus;
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage(), e);
			logger.info(LogConstant.EXITED + "getAllCDsForCategory");
			return "WebClientException";
		}
	}
}
