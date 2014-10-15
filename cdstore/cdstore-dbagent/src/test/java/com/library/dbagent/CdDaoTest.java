package com.library.dbagent;

import java.util.List;

import com.cdstore.dbagent.dao.CdDao;
import com.cdstore.dbagent.dao.def.ICdDao;
import com.cdstore.model.CD;

public class CdDaoTest {

	public void test() {
		ICdDao iCdDao = new CdDao();
		List<CD> cdList = iCdDao.getAllCD();
		System.out.println(" cdList : "+cdList.size());
	}

}
