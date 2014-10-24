package com.cdstore.webapp.service;

import java.util.List;

import com.cdstore.model.CD;
import com.cdstore.webapp.exception.InternalServerException;
import com.cdstore.webapp.exception.InvalidParameterException;
import com.cdstore.webapp.exception.NotFoundException;
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

	public List<CD> getAll() throws InternalServerException, NotFoundException {
		List<CD> cdDriveList = iCdRestClient.getAll();
		return cdDriveList;
	}

	public List<String> getAllCDCategories() throws InternalServerException,
			NotFoundException {
		return iCdRestClient.getAllCDCategories();
	}

	public List<CD> getAllCDsForCategory(String categoryStrings)
			throws InternalServerException, NotFoundException,
			InvalidParameterException {
		return iCdRestClient.getAllCDsForCategory(categoryStrings);
	}

	public List<CD> getCds(List<String> cdIds) throws InternalServerException,
			NotFoundException, InvalidParameterException {
		return iCdRestClient.getCds(cdIds);
	}
}
