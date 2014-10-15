package com.cdstore.restws.service.def;

import java.util.List;
import java.util.Map;

import com.cdstore.model.CD;

public interface ICdService {
	List<CD> getAllCD();

	// Method to retrieve all the categories for CDs from Database.
	List<String> getAllCDCategories();

	// Method to retrieve cds belonging to a particular category
	List<CD> getAllCDForCategory(String categoryName);

	// Method to retrieve cds according to their categories
	Map<String, List<CD>> getCDMap();
}
