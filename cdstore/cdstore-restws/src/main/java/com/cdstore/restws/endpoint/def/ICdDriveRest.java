package com.cdstore.restws.endpoint.def;

import java.util.List;

import com.cdstore.dbagent.model.CdDrive;

public interface ICdDriveRest {
	List<CdDrive> getAllCD();
}
