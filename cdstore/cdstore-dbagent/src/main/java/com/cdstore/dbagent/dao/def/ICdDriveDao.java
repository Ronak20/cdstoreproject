package com.cdstore.dbagent.dao.def;

import java.util.List;

import com.cdstore.dbagent.model.CdDrive;

public interface ICdDriveDao {
	
	/**
	 * Retrieves list of all cd drives.
	 * @return
	 */
	List<CdDrive> getCdDriveList();
}
