package com.cdstore.restws.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	@Produces(MediaType.TEXT_PLAIN)
	public String purchase(PurchaseOrder purchaseOrder) {
		try {
			if (PURCHASE_COUNT != 5) {
				iPurchaseOrderService.save(purchaseOrder);
				PURCHASE_COUNT++;
				return "creditcarderror";
			} else {
				PURCHASE_COUNT = 0;
				return "creditcarderror";
			}
		} catch (Exception e) {
			// if exception occurs while saving a purchase order
			// relay a message accordingly so that shopping cart is not emptied
			// and
			// user will be redirected to main page again,
			// which should request user to check out again
			return "tryagain";
		}

	}

}
