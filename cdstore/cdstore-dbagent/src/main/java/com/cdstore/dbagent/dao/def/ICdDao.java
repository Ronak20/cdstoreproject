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
	 * @param categoryName name of category
	 * @return list of cd of specified category
	 */
	List<CD> getCdsForACategory(String categoryName);

	Map<String, List<CD>> getCdMap();

	List<CD> getCds(List<String> cdIds);
}
