package com.cdstore.dbagent.dao.def;

import java.util.List;
import java.util.Map;

import com.cdstore.model.CD;

/**
 * definition of dao for cd
 * 
 * @author Ronak
 *
 */
public interface ICdDao {

	/**
	 * Retrieves list of all cd drives.
	 * 
	 * @return
	 */
	List<CD> getAllCD();

	/**
	 * Retrives cd categories
	 * 
	 * @return list of categories
	 */
	List<String> getCdCategories();

	/**
	 * list of cd for specified category
	 * 
	 * @param categoryName
	 *            name of category
	 * @return list of cd of specified category
	 */
	List<CD> getCdsForACategory(String categoryName);

	Map<String, List<CD>> getCdMap();

	/**
	 * list of cds to get details
	 * 
	 * @param cdIds
	 *            list of cd ids
	 * @return cd details by ids
	 */
	List<CD> getCds(List<String> cdIds);

	/**
	 * adds cd
	 * 
	 * @param cd
	 *            to add
	 */
	void save(CD cd);
}
