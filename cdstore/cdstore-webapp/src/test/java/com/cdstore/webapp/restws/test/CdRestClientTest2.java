package com.cdstore.webapp.restws.test;

import java.util.List;

import junit.framework.TestCase;

import com.cdstore.model.CD;
import com.cdstore.webapp.restclient.CdRestClient;

public class CdRestClientTest2 extends TestCase {

	Constant_Values cv = new Constant_Values();

	public void test() {
		CdRestClient cdRestClient = new CdRestClient();
		List<CD> asd = cdRestClient.getAll();
		assertEquals(cv.All_Cd, asd.size());
		
	}

}
