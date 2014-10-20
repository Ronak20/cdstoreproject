package com.cdstore.webapp.service.def;

import java.util.List;

import com.cdstore.model.CD;

public interface ICdService {
	List<CD> getAll();
	List<String> getAllCDCategories();
	List<CD> getAllCDsForCategory(String categoryStrings);
	List<CD> getCds(List<String> cdIds);
}
