package com.cdstore.restws.endpoint.def;

import java.util.List;

import javax.ws.rs.core.Response;

import com.cdstore.model.CD;

/**
 * rest endpoint definition for cd
 * 
 * @author Ronak
 *
 */
public interface ICdRest {

	/**
	 * provides list of cds
	 * 
	 * @return list of cd json object
	 */
	Response getAllCD();

	/**
	 * Provides list of all cd categories
	 * 
	 * @return list of cd json object
	 */
	Response getAllCDCategories();

	/**
	 * Provides cd of particular category
	 * 
	 * @param categoryString
	 * @return list of cd json object
	 */
	Response getAllCDsForCategory(String categoryString);

	/**
	 * Provides cd using cd ids
	 * 
	 * @param cdIds
	 *            list of cd ids
	 * @return list of cd json objct
	 */
	Response getCds(List<String> cdIds);

	/**
	 * 
	 * @param cd
	 */
	Response save(CD cd);
}
