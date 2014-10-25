package com.cdstore.webapp.restws.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.cdstore.model.CD;
import com.cdstore.webapp.exception.InternalServerException;
import com.cdstore.webapp.exception.InvalidParameterException;
import com.cdstore.webapp.exception.NotFoundException;
import com.cdstore.webapp.restclient.CdRestClient;

public class CdRestClientTest extends TestCase {

	private CdRestClient cdRestClient;

	public void setUp() throws Exception {
		cdRestClient = new CdRestClient();
	}

	public void testGetAll() throws InternalServerException, NotFoundException {
		List<CD> cdList = cdRestClient.getAll();
		Assert.assertTrue(cdList.size() == 9);
	}

	public void testGetAllCDCategories() throws InternalServerException,
			NotFoundException {
		List<String> cdList = cdRestClient.getAllCDCategories();
		Assert.assertTrue(cdList.size() == 3);
	}

	public void testGetAllCDsForCategory() throws InternalServerException,
			NotFoundException, InvalidParameterException {
		List<CD> cdList = cdRestClient.getAllCDsForCategory("POP");
		Assert.assertTrue(cdList.size() == 3);
	}

	public void testGetCds() throws InternalServerException, NotFoundException,
			InvalidParameterException {
		List<String> cdIds = new ArrayList<String>(0);
		cdIds.add("cd001");
		cdIds.add("cd002");
		cdIds.add("cd003");

		List<CD> cdList = cdRestClient.getCds(cdIds);

		for (CD cd : cdList) {
			Assert.assertNotNull(cd.getCdId());
			Assert.assertNotNull(cd.getTitle());
			Assert.assertNotNull(cd.getCategory());
			Assert.assertNotNull(cd.getPrice());
			Assert.assertNotNull(cd.getCdId());
		}

	}

	public void tearDown() {

	}

}
