package com.cdstore.dbagent.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/*CREATE TABLE POItem (
 id       INT UNSIGNED NOT NULL,
 cdid     VARCHAR(20) NOT NULL,
 price    INT UNSIGNED NOT NULL,
 PRIMARY KEY(id,cdid),
 INDEX (id),
 FOREIGN KEY(id) REFERENCES PO(id) ON DELETE CASCADE,
 INDEX (cdid),
 FOREIGN KEY(cdid) REFERENCES CD(cdid) ON DELETE CASCADE
 ) ;*/

@Entity
@Table(name = "poitem")
@AssociationOverrides({
		@AssociationOverride(name = "poId.purchaseOrder", joinColumns = @JoinColumn(name = "id")),
		@AssociationOverride(name = "poId.cdDrive", joinColumns = @JoinColumn(name = "cdid")) })
public class PurchaseOrderItem {

	@EmbeddedId
	private PurchaseOrderItemId poId = new PurchaseOrderItemId();

	@Column(name = "price")
	private Integer price;

	public PurchaseOrderItemId getPoId() {
		return poId;
	}

	public void setPoId(PurchaseOrderItemId poId) {
		this.poId = poId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((poId == null) ? 0 : poId.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		PurchaseOrderItem other = (PurchaseOrderItem) obj;
		if (poId == null) {
			if (other.poId != null)
				return false;
		} else if (!poId.equals(other.poId))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseOrderItem [poId=" + poId + ", price=" + price + "]";
	}

}