package com.cdstore.webapp.restclient.def;

import java.util.List;

import com.cdstore.model.CD;

public interface ICdRestClient {
	List<CD> getAll();
	
	List<String> getAllCDCategories();

	List<CD> getAllCDsForCategory(String categoryString);
	
	List<CD> getCds(List<String> cdIds);
}
