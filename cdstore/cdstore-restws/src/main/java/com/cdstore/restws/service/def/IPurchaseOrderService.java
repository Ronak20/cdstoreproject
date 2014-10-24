package com.cdstore.restws.service.def;

import java.util.List;

import com.cdstore.model.PurchaseOrder;

/**
 * service definition of Purchase order
 * 
 * @author Ronak
 *
 */
public interface IPurchaseOrderService {

	/**
	 * saves purchase order
	 * 
	 * @param purchaseOrder
	 */
	void save(PurchaseOrder purchaseOrder);

	/**
	 * retrives purchase order of user
	 * 
	 * @param userId
	 *            user id of user
	 * @return list of purchase order
	 */
	List<PurchaseOrder> getPurchaseOrder(String userId);
}
