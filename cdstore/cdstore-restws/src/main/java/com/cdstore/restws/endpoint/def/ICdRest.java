package com.cdstore.restws.endpoint.def;

import java.util.List;
import java.util.Map;

import com.cdstore.model.CD;

public interface ICdRest {
	List<CD> getAllCD();
	List<String> getAllCDCategories();
	List<CD> getAllCDsForCategories(List<String> categoryStrings);
	Map<String, List<CD>> getCDMap();
}
