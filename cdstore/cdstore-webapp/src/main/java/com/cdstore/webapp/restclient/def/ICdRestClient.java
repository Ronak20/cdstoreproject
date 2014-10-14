package com.cdstore.webapp.restclient.def;

import java.util.List;

import com.cdstore.model.CD;

public interface ICdRestClient {
	List<CD> getAll();
	List<String> getCdCategories();
}
