package com.cdstore.restws.service;

import java.util.List;
import java.util.Map;

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
	
	/*
	 * @author Sandarbh
	 * @see com.cdstore.restws.service.def.ICdService#getAllCDCategories()
	 */
	public List<String> getAllCDCategories() {
		return cdDao.getCdCategories();
	}
	
	/*
	 * @param categories- list of categories, for which CDs are to be fetched
	 * @see com.cdstore.restws.service.def.ICdService#getAllCDForCategories(java.util.List)
	 */
	public List<CD> getAllCDForCategories(List<String> categories){
		return cdDao.getCdsForACategory(categories);
	}
	
	/*
	 * @author Sandarbh
	 * @see com.cdstore.restws.service.def.ICdService#getCDMap()
	 * This method contacts Data layer to fetch Cd categories and corresponding CDs 
	 */
	public Map<String, List<CD>> getCDMap(){
		return cdDao.getCdMap();
	}
}
