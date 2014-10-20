package com.cdstore.restws.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdstore.model.PurchaseOrder;
import com.cdstore.restws.endpoint.def.IPurchaseOrderRest;
import com.cdstore.restws.service.def.IPurchaseOrderService;

@Component
@Path("/purchase")
public class PurchaseOrderRest implements IPurchaseOrderRest {

	@Autowired
	private IPurchaseOrderService iPurchaseOrderService;
	
	public IPurchaseOrderService getiPurchaseOrderService() {
		return iPurchaseOrderService;
	}

	public void setiPurchaseOrderService(IPurchaseOrderService iPurchaseOrderService) {
		this.iPurchaseOrderService = iPurchaseOrderService;
	}

	private static int PURCHASE_COUNT = 0;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void purchase(PurchaseOrder purchaseOrder) {

		if (PURCHASE_COUNT != 5) {
			iPurchaseOrderService.save(purchaseOrder);
			PURCHASE_COUNT++;
		} else {
			PURCHASE_COUNT = 0;
		}

	}

}
