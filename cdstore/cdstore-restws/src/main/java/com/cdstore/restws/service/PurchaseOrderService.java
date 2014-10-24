package com.cdstore.restws.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdstore.dbagent.LogConstant;
import com.cdstore.dbagent.dao.def.IPurchaseOrderDao;
import com.cdstore.dbagent.dao.def.IPurchaseOrderItemDao;
import com.cdstore.model.PurchaseOrder;
import com.cdstore.model.PurchaseOrderItem;
import com.cdstore.model.PurchaseOrderItemId;
import com.cdstore.restws.service.def.IPurchaseOrderService;

/**
 * Implementation of IPurchaseOrderService
 * 
 * @author Ronak
 *
 */
public class PurchaseOrderService implements IPurchaseOrderService {
	private static Logger logger = LogManager
			.getLogger(PurchaseOrderService.class);

	@Autowired
	private IPurchaseOrderDao purchaseOrderDao;
	@Autowired
	private IPurchaseOrderItemDao purchaseOrderItemDao;

	public IPurchaseOrderDao getPurchaseOrderDao() {
		return purchaseOrderDao;
	}

	public void setPurchaseOrderDao(IPurchaseOrderDao purchaseOrderDao) {
		this.purchaseOrderDao = purchaseOrderDao;
	}

	public IPurchaseOrderItemDao getPurchaseOrderItemDao() {
		return purchaseOrderItemDao;
	}

	public void setPurchaseOrderItemDao(
			IPurchaseOrderItemDao purchaseOrderItemDao) {
		this.purchaseOrderItemDao = purchaseOrderItemDao;
	}

	public void save(PurchaseOrder purchaseOrder) {
		logger.info(LogConstant.ENTERED + "save");
		logger.info(LogConstant.PARAMETER + "purchaseOrder :" + purchaseOrder);
		List<PurchaseOrderItem> purchaseOrderItemList = purchaseOrder
				.getPurchaseOrderItem();

		purchaseOrder.setPurchaseOrderItem(null);
		purchaseOrderDao.save(purchaseOrder);

		if (purchaseOrderItemList != null) {

			for (PurchaseOrderItem purchaseOrderItem : purchaseOrderItemList) {
				PurchaseOrderItemId poId = purchaseOrderItem.getPoId();
				poId.setPurchaseOrder(purchaseOrder);
				purchaseOrderItem.setPoId(poId);
				purchaseOrderItemDao.save(purchaseOrderItem);
			}

		}
		logger.info(LogConstant.EXITED + "save");
	}

	public List<PurchaseOrder> getPurchaseOrder(String userId) {
		List<PurchaseOrder> purchaseOrderList = purchaseOrderDao
				.getPurchaseOrder(userId);
		return purchaseOrderList;
	}

}
