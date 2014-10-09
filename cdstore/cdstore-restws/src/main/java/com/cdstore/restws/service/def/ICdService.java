package com.cdstore.restws.service.def;

import java.util.List;

import com.cdstore.dbagent.model.CdDrive;
import com.cdstore.restws.model.CdDriveJsonModel;

public interface ICdService {
	List<CdDriveJsonModel> getCdDriveList();
	List<CdDrive> getAllCD();
}
