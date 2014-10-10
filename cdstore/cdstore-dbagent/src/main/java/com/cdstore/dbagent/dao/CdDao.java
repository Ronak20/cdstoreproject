package com.cdstore.dbagent.dao;

import java.util.List;

import org.hibernate.Session;

import com.cdstore.dbagent.dao.def.ICdDao;
import com.cdstore.model.CD;

public class CdDao implements ICdDao {

	private Session session;

	public CdDao(Session session) {
		this.session = session;
	}

	public List<CD> getAllCD() {
		List<CD> cdDriveList = session.createCriteria(CD.class).list();
		return cdDriveList;
	}

}
