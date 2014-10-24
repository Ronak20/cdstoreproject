package com.cdstore.webapp.restws.test;

import java.util.List;

import com.cdstore.model.CD;
import com.cdstore.webapp.restclient.CdRestClient;

import java.lang.System;




import javax.servlet.jsp.tagext.TryCatchFinally;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CdCategoryRestClientTest extends TestCase {
	
	Constant_Values cv=new Constant_Values();
	CdRestClient cdRestClient = new CdRestClient();
	 public void testCdCategory()  
	 {
		 	//CdRestClient cdRestClient = new CdRestClient();
			List<String> asd = cdRestClient.getAllCDCategories();
			//System.out.println(asd.get(0).getClass().toString());
			//System.out.print(asd.size());
			assertEquals(cv.CdCategory, asd.size());
			
	}
	
	 public void testGetCDByCategory()
	 {
		 List<String> data=cdRestClient.getAllCDCategories();
		 List<CD> cat1=cdRestClient.getAllCDsForCategory(data.get(0).toString());
		 assertEquals(cv.CdCategory,cat1.size());
		 List<CD> cat2=cdRestClient.getAllCDsForCategory(data.get(1).toString());
		 assertEquals(cv.CdCategory,cat2.size());
		 List<CD> cat3=cdRestClient.getAllCDsForCategory(data.get(2).toString());
		 assertEquals(cv.CdCategory,cat3.size());
	 }
	//return null;
	
}
