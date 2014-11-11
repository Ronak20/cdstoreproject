package com.cdstore.webapp.restws.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.cdstore.model.CD;
import com.cdstore.webapp.TestConstant;
import com.cdstore.webapp.exception.InternalServerException;
import com.cdstore.webapp.exception.InvalidParameterException;
import com.cdstore.webapp.exception.NotFoundException;
import com.cdstore.webapp.restclient.CdRestClient;

public class CdRestClientTest extends TestCase {

	private CdRestClient cdRestClientWithBuyerAuth;
	private CdRestClient cdRestClientWithAdminAuth;

	public void setUp() throws Exception {
		cdRestClientWithBuyerAuth = new CdRestClient(
				TestConstant.CREDENTIAL_BUYER_USERNAME,
				TestConstant.CREDENTIAL_BUYER_PASSWORD);
		cdRestClientWithAdminAuth = new CdRestClient(
				TestConstant.CREDENTIAL_ADMIN_USERNAME,
				TestConstant.CREDENTIAL_ADMIN_PASSWORD);
	}

	public void testGetAll() throws InternalServerException, NotFoundException {
		List<CD> cdList = cdRestClientWithBuyerAuth.getAll();
		Assert.assertTrue(cdList.size() == 11);
	}

	public void testGetAllCDCategories() throws InternalServerException,
			NotFoundException {
		List<String> cdList = cdRestClientWithBuyerAuth.getAllCDCategories();
		Assert.assertTrue(cdList.size() == 3);
	}

	public void testGetAllCDsForCategory() throws InternalServerException,
			NotFoundException, InvalidParameterException {
		List<CD> cdList = cdRestClientWithBuyerAuth.getAllCDsForCategory("POP");
		Assert.assertTrue(cdList.size() == 3);
	}

	public void testGetCds() throws InternalServerException, NotFoundException,
			InvalidParameterException {
		List<String> cdIds = new ArrayList<String>(0);
		cdIds.add("cd001");
		cdIds.add("cd002");
		cdIds.add("cd003");

		List<CD> cdList = cdRestClientWithBuyerAuth.getCds(cdIds);

		for (CD cd : cdList) {
			Assert.assertNotNull(cd.getCdId());
			Assert.assertNotNull(cd.getTitle());
			Assert.assertNotNull(cd.getCategory());
			Assert.assertNotNull(cd.getPrice());
			Assert.assertNotNull(cd.getCdId());
		}

	}

	public void testAddCD() throws Exception {
		CD cd = new CD();
		cd.setCdId("cd0011");
		cd.setCategory("COUNTRY");
		cd.setPrice(3000);
		cd.setTitle("Ron's Hit");

		cdRestClientWithAdminAuth.save(cd);
	}

	public void tearDown() {
		cdRestClientWithBuyerAuth = null;
		cdRestClientWithAdminAuth = null;
	}

}
