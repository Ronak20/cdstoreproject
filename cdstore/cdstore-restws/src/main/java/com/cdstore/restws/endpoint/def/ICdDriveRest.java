package com.cdstore.restws.endpoint.def;

import java.util.List;

import com.cdstore.dbagent.model.CdDrive;
import com.cdstore.restws.model.CdDriveJsonModel;

public interface ICdDriveRest {
	List<CdDriveJsonModel> getAll();
	List<CdDrive> getAllCD();
}
