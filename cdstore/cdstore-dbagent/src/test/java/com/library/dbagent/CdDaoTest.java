package com.library.dbagent;

import java.util.List;

import junit.framework.TestCase;

import com.cdstore.dbagent.dao.CdDao;
import com.cdstore.dbagent.dao.def.ICdDao;
import com.cdstore.model.CD;

/*@RunWith(SpringJUnit4ClassRunner.class)
 @ContextConfiguration(locations = { "classpath:dbagent-context.xml" })*/
public class CdDaoTest extends TestCase {

	public void test() {
		ICdDao iCdDao = new CdDao();
		List<CD> cdList = iCdDao.getAllCD();
		System.out.println(" cdList : " + cdList.size());
	}

}
