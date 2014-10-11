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
	private CD cd;

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public CD getCd() {
		return cd;
	}

	public void setCd(CD cd) {
		this.cd = cd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cd == null) ? 0 : cd.hashCode());
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
		if (cd == null) {
			if (other.cd != null)
				return false;
		} else if (!cd.equals(other.cd))
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
		return "PurchaseOrderItemId [purchaseOrder=" + purchaseOrder + ", cd="
				+ cd + "]";
	}

}
