package com.cdstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.cdstore.model.serializer.CdDriveSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "cd")
@JsonSerialize(using = CdDriveSerializer.class)
public class CD {

	@Id
	@Column(name = "cdid")
	private String cdId;

	@Column(name = "title")
	private String title;

	@Column(name = "price")
	private Integer price;

	@Column(name = "category")
	private String category;

	//@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "poId.cd", cascade = CascadeType.ALL)
	List<PurchaseOrderItem> purchaseOrderItem;

	//@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cd", orphanRemoval = true)
	List<VisitEvent> visitEventList;

	public String getCdId() {
		return cdId;
	}

	public void setCdId(String cdId) {
		this.cdId = cdId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<PurchaseOrderItem> getPurchaseOrderItem() {
		return purchaseOrderItem;
	}

	public void setPurchaseOrderItem(List<PurchaseOrderItem> purchaseOrderItem) {
		this.purchaseOrderItem = purchaseOrderItem;
	}

	public List<VisitEvent> getVisitEventList() {
		return visitEventList;
	}

	public void setVisitEventList(List<VisitEvent> visitEventList) {
		this.visitEventList = visitEventList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((cdId == null) ? 0 : cdId.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime
				* result
				+ ((purchaseOrderItem == null) ? 0 : purchaseOrderItem
						.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result
				+ ((visitEventList == null) ? 0 : visitEventList.hashCode());
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
		CD other = (CD) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (cdId == null) {
			if (other.cdId != null)
				return false;
		} else if (!cdId.equals(other.cdId))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (purchaseOrderItem == null) {
			if (other.purchaseOrderItem != null)
				return false;
		} else if (!purchaseOrderItem.equals(other.purchaseOrderItem))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (visitEventList == null) {
			if (other.visitEventList != null)
				return false;
		} else if (!visitEventList.equals(other.visitEventList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CD [cdId=" + cdId + ", title=" + title + ", price=" + price
				+ ", category=" + category + ", purchaseOrderItem="
				+ purchaseOrderItem + ", visitEventList=" + visitEventList
				+ "]";
	}

}
