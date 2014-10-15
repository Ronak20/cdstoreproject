package com.cdstore.webapp.service.def;

import java.util.List;

import com.cdstore.model.CD;

public interface ICdService {
	List<CD> getAll();

	List<CD> getAllCDsForCategory(String categoryStrings);
}
