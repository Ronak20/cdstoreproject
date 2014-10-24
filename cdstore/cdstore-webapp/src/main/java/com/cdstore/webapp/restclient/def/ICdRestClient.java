package com.cdstore.webapp.restclient.def;

import java.util.List;

import com.cdstore.model.CD;

/**
 * Contains definition of cd rest client
 * 
 * @author Ronak Chaudhari
 *
 */
public interface ICdRestClient {

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
	List<CD> getAllCDsForCategory(String categoryString);

	/**
	 * Retrives cd using cd ids
	 * 
	 * @param cdIds
	 *            list of all cd ids
	 * @return list of cd for cd ids
	 */
	List<CD> getCds(List<String> cdIds);
}
