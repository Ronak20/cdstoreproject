package com.cdstore.restws.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*CREATE TABLE Address (
 id 	     INT UNSIGNED NOT NULL AUTO_INCREMENT,
 street    VARCHAR(100) NOT NULL,
 province  VARCHAR(20)  NOT NULL,
 country   VARCHAR(20)  NOT NULL,
 zip       VARCHAR(20)  NOT NULL,
 phone     VARCHAR(20),
 PRIMARY KEY(id)
 ) ;*/

@Entity
@Table(name = "address")
public class Address {

	@Id
	@Column(name = "id")
	private String addressId;

	@Column(name = "street")
	private String street;

	@Column(name = "province")
	private String province;

	@Column(name = "country")
	private String country;

	@Column(name = "zip")
	private String zip;

	@Column(name = "phone")
	private String phone;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "address", orphanRemoval = true)
	List<PurchaseOrder> purchaseOrderList;

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<PurchaseOrder> getPurchaseOrderList() {
		return purchaseOrderList;
	}

	public void setPurchaseOrderList(List<PurchaseOrder> purchaseOrderList) {
		this.purchaseOrderList = purchaseOrderList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((province == null) ? 0 : province.hashCode());
		result = prime
				* result
				+ ((purchaseOrderList == null) ? 0 : purchaseOrderList
						.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
		Address other = (Address) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (purchaseOrderList == null) {
			if (other.purchaseOrderList != null)
				return false;
		} else if (!purchaseOrderList.equals(other.purchaseOrderList))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street
				+ ", province=" + province + ", country=" + country + ", zip="
				+ zip + ", phone=" + phone + ", purchaseOrderList="
				+ purchaseOrderList + "]";
	}

}