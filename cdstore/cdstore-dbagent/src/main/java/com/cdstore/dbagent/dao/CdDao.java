package com.cdstore.dbagent.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdstore.dbagent.dao.def.ICdDao;
import com.cdstore.model.CD;

@Repository
public class CdDao implements ICdDao {

	@Autowired
	SessionFactory sessionFactory;
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
		logger.debug(LogConstant.RETURN + "cdDriveList :" + cdDriveList);
		logger.info(LogConstant.EXITED + "getAllCD");
		return cdDriveList;
	}

	/*
	 * @author : Sandarbh Method to fetch the CD categories from database.
	 */
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

	/*
	 * @author Sandarbh method to fetch all the Cds for given categories, from
	 * database.
	 */
	@Transactional
	public List<CD> getCdsForACategory(String categoryName) {
		logger.info(LogConstant.ENTERED + "getCdsForACategory");
		logger.info(LogConstant.PARAMETER + "categoryName :" + categoryName);
		try {
			String hql = "FROM CD C WHERE C.category in (:categories)";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("categories", categoryName);
			logger.debug(LogConstant.RETURN + "cdList :" + (List<CD>) query.list()));
			logger.info(LogConstant.EXITED + "getCdsForACategory");
			return ((List<CD>) query.list());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.info(LogConstant.EXITED + "getCdsForACategory");
			return null;
		}
	}

	/*
	 * @author Sandarbh Method to fetch CD map from database.
	 */
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

	/**
	 * @author Sandarbh
	 * @param cdId
	 *            the cdId of the CD that needs to be fetched
	 * @return
	 */
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

}
