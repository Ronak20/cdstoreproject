package com.cdstore.restws.service.def;

import java.util.List;
import java.util.Map;

import com.cdstore.model.CD;

/**
 * definition of cd service
 * 
 * @author Ronak
 *
 */
public interface ICdService {

	/**
	 * Retrieves list of all cds
	 * 
	 * @return all cds
	 */
	List<CD> getAllCD();

	/**
	 * Retrieves cd categories
	 * 
	 * @return all cd categories
	 */
	List<String> getAllCDCategories();

	/**
	 * Retrieves cd of particular category
	 * 
	 * @param categoryString
	 *            name of category
	 * @return all cds of category
	 */
	List<CD> getAllCDForCategory(String categoryName);

	/**
	 * Creates map by category and list of cds
	 * 
	 * @return category as key and list of cds of that category
	 */
	Map<String, List<CD>> getCDMap();

	/**
	 * Retrives cd using cd ids
	 * 
	 * @param cdIds
	 *            list of all cd ids
	 * @return list of cd for cd ids
	 */
	List<CD> getCds(List<String> cdIds);
}
