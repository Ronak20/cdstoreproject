package com.cdstore.restws.endpoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdstore.model.Address;
import com.cdstore.model.PurchaseOrder;
import com.cdstore.model.User;
import com.cdstore.restws.endpoint.def.IUserRest;
import com.cdstore.restws.service.def.IAddressService;
import com.cdstore.restws.service.def.IPurchaseOrderService;
import com.cdstore.restws.service.def.IUserService;

/**
 * rest endpoint of User
 * 
 * @author Ronak
 *
 */
@Component
@Path("/user")
public class UserRest implements IUserRest {

	@Autowired
	private IUserService userservice;

	@Autowired
	private IAddressService addressService;

	@Autowired
	private IPurchaseOrderService iPurchaseOrderService;

	public IUserService getUserservice() {
		return userservice;
	}

	public void setUserservice(IUserService userservice) {
		this.userservice = userservice;
	}

	public IAddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(IAddressService addressService) {
		this.addressService = addressService;
	}

	public IPurchaseOrderService getiPurchaseOrderService() {
		return iPurchaseOrderService;
	}

	public void setiPurchaseOrderService(
			IPurchaseOrderService iPurchaseOrderService) {
		this.iPurchaseOrderService = iPurchaseOrderService;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void save(User user) {
		Address address = user.getAddress();
		if (address != null) {
			addressService.save(address);
		}
		userservice.save(user);
	}

	@POST
	@Path("/authenticate")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public User authenticate(User user) {
		User dbUser = userservice.authenticate(user);
		return dbUser;
	}

	@GET
	@Path("/details")
	@Produces({ MediaType.APPLICATION_JSON })
	public User getUser(@QueryParam("userId") String userId) {
		User user = userservice.getUser(userId);

		List<PurchaseOrder> purchaseOrderList = iPurchaseOrderService
				.getPurchaseOrder(userId);
		
		user.setPurchaseOrderList(purchaseOrderList);

		return user;
	}

}
