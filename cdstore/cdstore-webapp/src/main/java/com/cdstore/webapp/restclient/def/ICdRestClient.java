package com.cdstore.webapp.restclient.def;

import java.util.List;

import com.cdstore.model.CD;
import com.cdstore.webapp.exception.InternalServerException;
import com.cdstore.webapp.exception.InvalidParameterException;
import com.cdstore.webapp.exception.NotFoundException;

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
	List<CD> getAll() throws InternalServerException, NotFoundException;

	/**
	 * Retrieves cd categories
	 * 
	 * @return all cd categories
	 */
	List<String> getAllCDCategories() throws InternalServerException,
			NotFoundException;

	/**
	 * Retrieves cd of particular category
	 * 
	 * @param categoryString
	 *            name of category
	 * @return all cds of category
	 */
	List<CD> getAllCDsForCategory(String categoryString)
			throws InternalServerException, NotFoundException,
			InvalidParameterException;

	/**
	 * Retrives cd using cd ids
	 * 
	 * @param cdIds
	 *            list of all cd ids
	 * @return list of cd for cd ids
	 */
	List<CD> getCds(List<String> cdIds) throws InternalServerException,
			NotFoundException, InvalidParameterException;
}
