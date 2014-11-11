package com.cdstore.dbagent.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdstore.dbagent.LogConstant;
import com.cdstore.dbagent.dao.def.ICdDao;
import com.cdstore.model.CD;

/**
 * Implementation of ICdDao
 * 
 * @author Ronak
 *
 */
@Repository
public class CdDao implements ICdDao {

	@Autowired
	private SessionFactory sessionFactory;
	private static Logger logger = LogManager.getLogger(CdDao.class);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<CD> getAllCD() {
		logger.info(LogConstant.ENTERED + "getAllCD");
		List<CD> cdDriveList = sessionFactory.getCurrentSession()
				.createCriteria(CD.class).list();
		// logger.debug(LogConstant.RETURN + "cdDriveList :" + cdDriveList);
		logger.info(LogConstant.EXITED + "getAllCD");
		return cdDriveList;
	}

	@Transactional
	public List<String> getCdCategories() {
		logger.info(LogConstant.ENTERED + "getCdCategories");
		try {
			List<String> categoryList = sessionFactory
					.getCurrentSession()
					.createCriteria(CD.class)
					.setProjection(
							Projections.distinct(Projections
									.property("category"))).list();
			logger.debug(LogConstant.RETURN + "categoryList :" + categoryList);
			logger.info(LogConstant.EXITED + "getCdCategories");
			return categoryList;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.info(LogConstant.EXITED + "getCdCategories");
			return null;
		}
	}

	@Transactional
	public List<CD> getCdsForACategory(String categoryName) {
		logger.info(LogConstant.ENTERED + "getCdsForACategory");
		logger.info(LogConstant.PARAMETER + "categoryName :" + categoryName);
		try {
			String hql = "FROM CD C WHERE C.category in (:categories)";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("categories", categoryName);
			List<CD> cdList = (List<CD>) query.list();
			// logger.debug(LogConstant.RETURN + "cdList :" + cdList);
			logger.info(LogConstant.EXITED + "getCdsForACategory");
			return cdList;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.info(LogConstant.EXITED + "getCdsForACategory");
			return null;
		}
	}

	@Transactional
	public Map<String, List<CD>> getCdMap() {
		logger.info(LogConstant.ENTERED + "getCdMap");
		List<CD> allCds = getAllCD();
		List<CD> categoryCds = new ArrayList<CD>();
		List<String> categories = getCdCategories();
		Map<String, List<CD>> cdMap = new HashMap<String, List<CD>>(
				categories.size());
		try {
			for (String category : categories) {
				for (CD cd : allCds) {
					if (cd.getCategory().toUpperCase()
							.equals(category.toUpperCase()))
						categoryCds.add(cd);
				}
				cdMap.put(category, new ArrayList<CD>(categoryCds));
				categoryCds.clear();
			}
			logger.debug(LogConstant.RETURN + "cdMap :" + cdMap);
			logger.info(LogConstant.EXITED + "getCdMap");
			return cdMap;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.info(LogConstant.EXITED + "getCdMap");
			return null;
		}

	}

	@Transactional
	public List<CD> getCds(List<String> cdIds) {
		logger.info(LogConstant.ENTERED + "getCds");
		logger.info(LogConstant.PARAMETER + "cdIds :" + cdIds);
		try {
			String hql = "FROM CD C WHERE C.cdId in (:Ids)";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			String replaced = cdIds.get(0).replace("[", "").replace("]", "");
			String[] replacedsubString = replaced.split(",\\s");
			query.setParameterList("Ids", replacedsubString);
			List<CD> cdDriveSelectedList = query.list();
			logger.debug(LogConstant.RETURN + "cdDriveSelectedList :"
					+ cdDriveSelectedList);
			logger.info(LogConstant.EXITED + "getCds");
			return cdDriveSelectedList;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.info(LogConstant.EXITED + "getCds");
			return null;
		}

	}

	@Transactional
	public void save(CD cd) {
		logger.info(LogConstant.ENTERED + "save");
		logger.info(LogConstant.PARAMETER + "cd :" + cd);
		sessionFactory.getCurrentSession().save(cd);
		logger.info(LogConstant.EXITED + "save");
	}

}
