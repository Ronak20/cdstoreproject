package com.cdstore.webapp.service.def;

import java.util.List;

import com.cdstore.model.CD;

/**
 * Contains definition of cd service
 * 
 * @author Ronak Chaudhari
 *
 */
public interface ICdService {

	/**
	 * Retrieves list of all cds
	 * 
	 * @return all cds
	 */
	List<CD> getAll();

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
	List<CD> getAllCDsForCategory(String categoryStrings);

	/**
	 * Retrives cd using cd ids
	 * 
	 * @param cdIds
	 *            list of all cd ids
	 * @return list of cd for cd ids
	 */
	List<CD> getCds(List<String> cdIds);
}
