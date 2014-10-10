package com.cdstore.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PurchaseOrderItemId implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private PurchaseOrder purchaseOrder;

	@ManyToOne
	private CD cdDrive;

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public CD getCdDrive() {
		return cdDrive;
	}

	public void setCdDrive(CD cdDrive) {
		this.cdDrive = cdDrive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdDrive == null) ? 0 : cdDrive.hashCode());
		result = prime * result
				+ ((purchaseOrder == null) ? 0 : purchaseOrder.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseOrderItemId other = (PurchaseOrderItemId) obj;
		if (cdDrive == null) {
			if (other.cdDrive != null)
				return false;
		} else if (!cdDrive.equals(other.cdDrive))
			return false;
		if (purchaseOrder == null) {
			if (other.purchaseOrder != null)
				return false;
		} else if (!purchaseOrder.equals(other.purchaseOrder))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseOrderItemId [purchaseOrder=" + purchaseOrder
				+ ", cdDrive=" + cdDrive + "]";
	}

}
