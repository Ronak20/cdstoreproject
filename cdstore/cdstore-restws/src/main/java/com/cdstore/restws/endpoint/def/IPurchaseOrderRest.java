package com.cdstore.restws.endpoint.def;

import com.cdstore.model.PurchaseOrder;

/**
 * rest endpoint definition for Purchase order
 * 
 * @author Ronak
 *
 */
public interface IPurchaseOrderRest {
	/**
	 * purchasing product
	 * 
	 * @param purchaseOrder
	 * @return
	 */
	String purchase(PurchaseOrder purchaseOrder);
}
