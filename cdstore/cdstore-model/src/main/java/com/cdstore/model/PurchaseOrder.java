package com.cdstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*CREATE TABLE PO (
 id        INT UNSIGNED NOT NULL AUTO_INCREMENT,
 lname     VARCHAR(20) NOT NULL,
 fname     VARCHAR(20) NOT NULL,
 status    ENUM('ORDERED','PROCESSED','DENIED') NOT NULL,
 address   INT UNSIGNED NOT NULL,
 PRIMARY KEY(id),
 INDEX (address),
 FOREIGN KEY (address) REFERENCES Address (id) ON DELETE CASCADE
 ) ;*/

@Entity
@Table(name = "po")
public class PurchaseOrder {

	@Id
	@Column(name = "id")
	String purchaseOrderId;

	@Column(name = "lname")
	String lastName;

	@Column(name = "fname")
	String firstName;

	@Column(name = "status")
	String status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address", referencedColumnName = "id")
	Address address;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "poId.purchaseOrder", orphanRemoval = true)
	List<PurchaseOrderItem> purchaseOrderItem;

	public String getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(String purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<PurchaseOrderItem> getPurchaseOrderItem() {
		return purchaseOrderItem;
	}

	public void setPurchaseOrderItem(List<PurchaseOrderItem> purchaseOrderItem) {
		this.purchaseOrderItem = purchaseOrderItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((purchaseOrderId == null) ? 0 : purchaseOrderId.hashCode());
		result = prime
				* result
				+ ((purchaseOrderItem == null) ? 0 : purchaseOrderItem
						.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		PurchaseOrder other = (PurchaseOrder) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (purchaseOrderId == null) {
			if (other.purchaseOrderId != null)
				return false;
		} else if (!purchaseOrderId.equals(other.purchaseOrderId))
			return false;
		if (purchaseOrderItem == null) {
			if (other.purchaseOrderItem != null)
				return false;
		} else if (!purchaseOrderItem.equals(other.purchaseOrderItem))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [purchaseOrderId=" + purchaseOrderId
				+ ", lastName=" + lastName + ", firstName=" + firstName
				+ ", status=" + status + ", address=" + address
				+ ", purchaseOrderItem=" + purchaseOrderItem + "]";
	}

}