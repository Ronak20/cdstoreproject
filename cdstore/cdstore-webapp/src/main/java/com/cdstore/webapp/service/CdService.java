package com.cdstore.webapp.service;

import java.util.List;

import com.cdstore.model.CD;
import com.cdstore.webapp.restclient.CdRestClient;
import com.cdstore.webapp.restclient.def.ICdRestClient;
import com.cdstore.webapp.service.def.ICdService;

public class CdService implements ICdService {

	private ICdRestClient iCdRestClient;

	public CdService() {
		setiCdRestClient(new CdRestClient());
	}

	public ICdRestClient getiCdRestClient() {
		return iCdRestClient;
	}

	public void setiCdRestClient(ICdRestClient iCdRestClient) {
		this.iCdRestClient = iCdRestClient;
	}

	public List<CD> getAll() {
		List<CD> cdDriveList = iCdRestClient.getAll();
		return cdDriveList;
	}

	public List<CD> getAllCDsForCategory(String categoryStrings) {
		return iCdRestClient.getAllCDsForCategory(categoryStrings);
	}
}
