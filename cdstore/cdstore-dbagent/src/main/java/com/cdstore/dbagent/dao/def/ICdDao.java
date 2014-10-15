package com.cdstore.dbagent.dao.def;

import java.util.List;
import java.util.Map;

import com.cdstore.model.CD;

public interface ICdDao {

	/**
	 * Retrieves list of all cd drives.
	 * 
	 * @return
	 */
	List<CD> getAllCD();

	List<String> getCdCategories();

	List<CD> getCdsForACategory(String categoryName);

	Map<String, List<CD>> getCdMap();
}
