package com.cdstore.restws.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdstore.dbagent.dao.def.ICdDao;
import com.cdstore.model.CD;
import com.cdstore.restws.service.def.ICdService;

/**
 * Implementation of ICdService
 * 
 * @author Ronak
 *
 */
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

	public List<String> getAllCDCategories() throws Exception {
		return cdDao.getCdCategories();
	}

	public List<CD> getAllCDForCategory(String categoryName) throws Exception {
		return cdDao.getCdsForACategory(categoryName);
	}

	public Map<String, List<CD>> getCDMap() throws Exception {
		return cdDao.getCdMap();
	}

	public List<CD> getCds(List<String> cdIds) throws Exception {
		return cdDao.getCds(cdIds);
	}

	public void save(CD cd) {
		cdDao.save(cd);
	}
}
