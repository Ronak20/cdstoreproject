package com.cdstore.webapp.restws.test;

import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.cdstore.model.Address;
import com.cdstore.model.PurchaseOrder;
import com.cdstore.model.PurchaseOrderItem;
import com.cdstore.model.User;
import com.cdstore.webapp.TestConstant;
import com.cdstore.webapp.restclient.UserRestClient;
import com.cdstore.webapp.restclient.def.IUserRestClient;

/**
 * unit test cases for user rest client
 * 
 * @author Ronak
 *
 */
public class UserRestClientTest extends TestCase {

	private IUserRestClient userRestClient;
	private IUserRestClient userRestClientWithAuth;

	public void setUp() throws Exception {
		userRestClient = new UserRestClient();
		userRestClientWithAuth = new UserRestClient(
				TestConstant.CREDENTIAL_BUYER_USERNAME,
				TestConstant.CREDENTIAL_BUYER_PASSWORD);
	}

	public void testAuthenticateUser() {
		User user = new User();
		user.setUsername("jon");
		// user.setPassword("6cb570acdab0e0bfc8e3dcb7bb4edf");
		user.setPassword("6cb570acdab0e0bfc8e3dcb7bb4edf");

		userRestClient.authenticate(user);

		User aUser = userRestClient.authenticate(user);
		Assert.assertNotNull(aUser);
	}

	public void testGetUserDetails() {

		User user = userRestClientWithAuth.getUser("9");

		Assert.assertNotNull(user.getFirstName());
		Assert.assertNotNull(user.getLastName());
		Assert.assertNotNull(user.getPassword());
		Assert.assertNotNull(user.getUserId());
		Assert.assertNotNull(user.getUsername());
		Assert.assertNotNull(user.getPurchaseOrderList());

		Address address = user.getAddress();

		Assert.assertNotNull(address.getAddressId());
		Assert.assertNotNull(address.getCountry());
		Assert.assertNotNull(address.getPhone());
		Assert.assertNotNull(address.getProvince());
		Assert.assertNotNull(address.getStreet());
		Assert.assertNotNull(address.getZip());

		List<PurchaseOrder> purchaseOrderList = user.getPurchaseOrderList();

		Assert.assertNotNull(purchaseOrderList);

		for (PurchaseOrder po : purchaseOrderList) {
			Assert.assertNotNull(po.getPurchaseOrderId());
			Assert.assertNotNull(po.getStatus());

			List<PurchaseOrderItem> poItemList = po.getPurchaseOrderItem();
			Assert.assertNotNull(poItemList);

			for (PurchaseOrderItem poItem : poItemList) {
				Assert.assertNotNull(poItem.getPoId());
				Assert.assertNotNull(poItem.getPrice());
				Assert.assertNotNull(poItem.getPoId().getCd().getCdId());
				Assert.assertNotNull(poItem.getPoId().getCd().getTitle());
				Assert.assertNotNull(poItem.getPoId().getCd().getCategory());
				Assert.assertNotNull(poItem.getPoId().getCd().getPrice());
			}
		}

	}
}
