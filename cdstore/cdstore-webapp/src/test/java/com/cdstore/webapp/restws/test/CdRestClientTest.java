package com.cdstore.webapp.restws.test;

import java.util.List;

import junit.framework.TestCase;

import com.cdstore.model.CD;
import com.cdstore.webapp.restclient.CdRestClient;

public class CdRestClientTest extends TestCase {

	public void test() {
		CdRestClient cdRestClient = new CdRestClient();
		List<CD> asd = cdRestClient.getAll();
		System.out.println(asd.get(0).getClass().toString());
		System.out.print(asd.size());
	}

}
