package com.cdstore.restws.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.cdstore.dbagent.dao.CdDriveDao;
import com.cdstore.dbagent.model.CdDrive;
import com.cdstore.dbagent.util.HibernateUtil;
import com.cdstore.restws.model.CdDriveJsonModel;
import com.cdstore.restws.service.def.ICdService;

public class CdService implements ICdService {

	private CdDriveDao cdDriveDao;

	public CdService() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		cdDriveDao = new CdDriveDao(sessionFactory.openSession());
	}

	/*
	 * public CdService(CdDriveDao cdDriveDao) { this.cdDriveDao = cdDriveDao; }
	 */

	public List<CdDriveJsonModel> getCdDriveList() {

		List<CdDrive> cdDriveList = cdDriveDao.getCdDriveList();
		List<CdDriveJsonModel> cdDriveJsonModelList = new ArrayList<CdDriveJsonModel>(
				0);

		if (cdDriveList != null) {
			for (CdDrive cdDrive : cdDriveList) {
				CdDriveJsonModel cdDriveJsonModel = new CdDriveJsonModel(
						cdDrive);
				cdDriveJsonModelList.add(cdDriveJsonModel);
			}
		}

		return cdDriveJsonModelList;
	}

	public List<CdDrive> getAllCD() {
		return cdDriveDao.getCdDriveList();
	}
}
