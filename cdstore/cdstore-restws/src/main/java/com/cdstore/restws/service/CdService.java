package com.cdstore.restws.service;

import java.util.List;

import org.hibernate.SessionFactory;

import com.cdstore.dbagent.dao.CdDao;
import com.cdstore.dbagent.util.HibernateUtil;
import com.cdstore.model.CD;
import com.cdstore.restws.service.def.ICdService;

public class CdService implements ICdService {

	private CdDao cdDao;

	public CdService() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		cdDao = new CdDao(sessionFactory.openSession());
	}

	public List<CD> getAllCD() {
		return cdDao.getAllCD();
	}
}
