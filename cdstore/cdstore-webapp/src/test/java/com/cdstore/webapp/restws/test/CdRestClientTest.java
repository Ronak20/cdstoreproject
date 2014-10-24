package com.cdstore.webapp.restws.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.cdstore.model.CD;
import com.cdstore.webapp.restclient.CdRestClient;

public class CdRestClientTest extends TestCase {

	private CdRestClient cdRestClient;

	public void setUp() throws Exception {
		cdRestClient = new CdRestClient();
	}

	public void testGetAll() {
		List<CD> cdList = cdRestClient.getAll();
		Assert.assertTrue(cdList.size() == 9);
	}

	public void testGetAllCDCategories() {
		List<String> cdList = cdRestClient.getAllCDCategories();
		Assert.assertTrue(cdList.size() == 3);
	}

	public void testGetAllCDsForCategory() {
		List<CD> cdList = cdRestClient.getAllCDsForCategory("POP");
		Assert.assertTrue(cdList.size() == 3);
	}

	public void testGetCds() {
		List<String> cdIds = new ArrayList<String>(0);
		cdIds.add("1");
		cdIds.add("2");
		cdIds.add("3");

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
