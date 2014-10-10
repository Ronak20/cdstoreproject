package com.cdstore.dbagent.dao.def;

import java.util.List;

import com.cdstore.model.CD;

public interface ICdDao {

	/**
	 * Retrieves list of all cd drives.
	 * 
	 * @return
	 */
	List<CD> getAllCD();
}
