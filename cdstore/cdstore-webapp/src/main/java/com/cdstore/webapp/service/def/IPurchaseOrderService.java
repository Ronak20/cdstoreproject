package com.cdstore.webapp.service.def;

import com.cdstore.model.PurchaseOrder;

/**
 * Contains definition of purchase order service
 * 
 * @author Ronak Chaudhari
 *
 */
public interface IPurchaseOrderService {

	/**
	 * purchases cds
	 * 
	 * @param purchaseOrder
	 * @return status of order
	 */
	String purchase(PurchaseOrder purchaseOrder);

}
