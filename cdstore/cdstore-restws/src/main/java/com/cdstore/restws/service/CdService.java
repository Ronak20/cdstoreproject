package com.cdstore.restws.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdstore.dbagent.dao.def.ICdDao;
import com.cdstore.model.CD;
import com.cdstore.restws.service.def.ICdService;

public class CdService implements ICdService {

	@Autowired
	private ICdDao cdDao;

	public ICdDao getCdDao() {
		return cdDao;
	}

	public void setCdDao(ICdDao cdDao) {
		this.cdDao = cdDao;
	}

	public List<CD> getAllCD() {
		return cdDao.getAllCD();
	}

	/*
	 * @author Sandarbh
	 * 
	 * @see com.cdstore.restws.service.def.ICdService#getAllCDCategories()
	 */
	public List<String> getAllCDCategories() {
		return cdDao.getCdCategories();
	}

	/*
	 * @param categories- list of categories, for which CDs are to be fetched
	 * 
	 * @see
	 * com.cdstore.restws.service.def.ICdService#getAllCDForCategories(java.
	 * util.List)
	 */
	public List<CD> getAllCDForCategory(String categoryName) {
		return cdDao.getCdsForACategory(categoryName);
	}

	/*
	 * @author Sandarbh
	 * 
	 * @see com.cdstore.restws.service.def.ICdService#getCDMap() This method
	 * contacts Data layer to fetch Cd categories and corresponding CDs
	 */
	public Map<String, List<CD>> getCDMap() {
		return cdDao.getCdMap();
	}
}
