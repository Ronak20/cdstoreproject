package com.cdstore.restws.service.def;

import com.cdstore.model.Address;

/**
 * service definition of Address
 * 
 * @author Ronak
 *
 */
public interface IAddressService {
	/**
	 * saves address
	 * 
	 * @param address
	 *            to be saved
	 */
	void save(Address address);
}
