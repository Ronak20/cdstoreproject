package com.cdstore.dbagent.dao.def;

import com.cdstore.model.PurchaseOrderItem;

/**
 * definition of dao for purchase order item
 * 
 * @author Ronak
 *
 */
public interface IPurchaseOrderItemDao {

	/**
	 * Saves purchase order item
	 * 
	 * @param purchaseOrderItem
	 */
	void save(PurchaseOrderItem purchaseOrderItem);
}
