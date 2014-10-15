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

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<CD> getAllCD() {
		List<CD> cdDriveList = sessionFactory.getCurrentSession()
				.createCriteria(CD.class).list();
		return cdDriveList;
	}

	/*
	 * @author : Sandarbh Method to fetch the CD categories from database.
	 */
	@Transactional
	public List<String> getCdCategories() {
		try {
			List<String> categoryList = sessionFactory
					.getCurrentSession()
					.createCriteria(CD.class)
					.setProjection(
							Projections.distinct(Projections
									.property("category"))).list();
			return categoryList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * @author Sandarbh method to fetch all the Cds for given categories, from
	 * database.
	 */
	@Transactional
	public List<CD> getCdsForACategory(List<String> categoryNames) {
		try {
			String hql = "FROM CD C WHERE C.category in (:categories)";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameterList("categories", categoryNames);
			return ((List<CD>) query.list());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * @author Sandarbh Method to fetch CD map from database.
	 */
	@Transactional
	public Map<String, List<CD>> getCdMap() {
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
			return cdMap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
