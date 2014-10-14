package com.cdstore.dbagent.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

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
	
	/*
	 * @author : Sandarbh
	 * Method to fetch the CD categories from database.
	 */
	public List<String> getCdCategories(){
		try {
			List<String> categoryList = session.createCriteria(CD.class).setProjection(Projections.distinct(Projections.property("category"))).list();
			return categoryList;
		} catch (Exception e) {
			e.printStackTrace();			
			return null;
		}
	}
	
	/*
	 * @author Sandarbh
	 * method to fetch all the Cds for given categories, from database.
	 */
	public List<CD> getCdsForACategory(List<String> categoryNames) 	{
		try {
			String hql = "FROM CD C WHERE C.category in (:categories)";
			Query query = session.createQuery(hql);
			query.setParameterList("categories", categoryNames);
			return ((List<CD>) query.list());			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * @author Sandarbh
	 * Method to fetch CD map from database. 
	 */
	public Map<String, List<CD>> getCdMap() {
		List<CD> allCds = getAllCD(); 
		List<CD> categoryCds = new ArrayList<CD>();
		List<String> categories = getCdCategories();
		Map<String, List<CD>> cdMap = new HashMap<String, List<CD>>(categories.size());
		try {
			for (String category : categories) {
				for (CD cd : allCds) {
					if(cd.getCategory().toUpperCase().equals(category.toUpperCase()))
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
