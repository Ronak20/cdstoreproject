package com.cdstore.restws.service;

import java.util.List;

import org.hibernate.SessionFactory;

import com.cdstore.dbagent.dao.CdDriveDao;
import com.cdstore.dbagent.model.CdDrive;
import com.cdstore.dbagent.util.HibernateUtil;
import com.cdstore.restws.service.def.ICdService;

public class CdService implements ICdService {

	private CdDriveDao cdDriveDao;

	public CdService() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		cdDriveDao = new CdDriveDao(sessionFactory.openSession());
	}

	public List<CdDrive> getAllCD() {
		return cdDriveDao.getCdDriveList();
	}
}
