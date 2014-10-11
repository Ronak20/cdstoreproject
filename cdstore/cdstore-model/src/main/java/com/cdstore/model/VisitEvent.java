package com.cdstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "visitevent")
public class VisitEvent {

	@Id
	@Column(name = "visiteventid")
	private String visitEventId;

	@Column(name = "day")
	String day;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cdid", referencedColumnName = "cdid")
	CD cd;

	@Column(name = "eventtype")
	String eventType;

	public String getVisitEventId() {
		return visitEventId;
	}

	public void setVisitEventId(String visitEventId) {
		this.visitEventId = visitEventId;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public CD getCd() {
		return cd;
	}

	public void setCd(CD cd) {
		this.cd = cd;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cd == null) ? 0 : cd.hashCode());
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result
				+ ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result
				+ ((visitEventId == null) ? 0 : visitEventId.hashCode());
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
		VisitEvent other = (VisitEvent) obj;
		if (cd == null) {
			if (other.cd != null)
				return false;
		} else if (!cd.equals(other.cd))
			return false;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (visitEventId == null) {
			if (other.visitEventId != null)
				return false;
		} else if (!visitEventId.equals(other.visitEventId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VisitEvent [visitEventId=" + visitEventId + ", day=" + day
				+ ", cd=" + cd + ", eventType=" + eventType + "]";
	}

}