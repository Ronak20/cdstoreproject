package com.cdstore.dbagent.dao;

import java.util.List;

import org.hibernate.Session;

import com.cdstore.dbagent.model.CdDrive;


public class CdDriveDao {

	private Session session;

	public CdDriveDao(Session session) {
		this.session = session;
	}

	public List<CdDrive> getCdDriveList() {
		List<CdDrive> cdDriveList = session.createCriteria(CdDrive.class)
				.list();
		return cdDriveList;
	}

}
