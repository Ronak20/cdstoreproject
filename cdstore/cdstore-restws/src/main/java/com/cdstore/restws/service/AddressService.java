package com.cdstore.restws.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdstore.dbagent.dao.def.IAddressDao;
import com.cdstore.model.Address;
import com.cdstore.restws.service.def.IAddressService;

/**
 * Implementation of IAddressService
 * 
 * @author Ronak
 *
 */
public class AddressService implements IAddressService {

	@Autowired
	private IAddressDao addressDao;

	public IAddressDao getAddressDao() {
		return addressDao;
	}

	public void setAddressDao(IAddressDao addressDao) {
		this.addressDao = addressDao;
	}

	public void save(Address address) {
		addressDao.save(address);
	}

}
