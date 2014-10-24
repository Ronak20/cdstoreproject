package com.cdstore.dbagent.dao.def;

import java.util.List;

import com.cdstore.model.PurchaseOrder;

/**
 * definition of dao for purchase order
 * 
 * @author Ronak
 *
 */
public interface IPurchaseOrderDao {

	/**
	 * Saves purchase order
	 * 
	 * @param purchaseOrder
	 */
	void save(PurchaseOrder purchaseOrder);

	/**
	 * Retrived purchase order of user
	 * 
	 * @param userId
	 *            id of user
	 * @return list of purchase order
	 */
	List<PurchaseOrder> getPurchaseOrder(String userId);
}
