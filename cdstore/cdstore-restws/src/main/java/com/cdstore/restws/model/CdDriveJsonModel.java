package com.cdstore.restws.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.cdstore.dbagent.model.CdDrive;

/*DROP TABLE IF EXISTS CD;
 CREATE TABLE CD (
 cdid      VARCHAR(20) NOT NULL,
 title     VARCHAR(60) NOT NULL,
 price     INT UNSIGNED NOT NULL,
 category  ENUM('COUNTRY','POP','ROCK') NOT NULL,
 PRIMARY KEY(cdid)
 ) ;*/
@XmlRootElement
public class CdDriveJsonModel {

	public CdDriveJsonModel(CdDrive cdDrive) {
		setCategory(cdDrive.getCategory());
		setCdId(cdDrive.getCdId());
		setPrice(cdDrive.getPrice());
		setTitle(cdDrive.getTitle());
	}

	@XmlElement
	private String cdId;

	@XmlElement
	private String title;

	@XmlElement
	private Integer price;

	@XmlElement
	private String category;

	List<PurchaseOrderItem> purchaseOrderItem;

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
		CdDriveJsonModel other = (CdDriveJsonModel) obj;
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
		return "CdDrive [cdId=" + cdId + ", title=" + title + ", price="
				+ price + ", category=" + category + ", purchaseOrderItem="
				+ purchaseOrderItem + ", visitEventList=" + visitEventList
				+ "]";
	}

}
