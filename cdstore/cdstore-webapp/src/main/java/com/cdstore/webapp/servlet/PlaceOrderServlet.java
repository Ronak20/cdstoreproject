package com.cdstore.webapp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdstore.model.CD;
import com.cdstore.model.PurchaseOrder;
import com.cdstore.model.PurchaseOrderItem;
import com.cdstore.model.PurchaseOrderItemId;
import com.cdstore.model.User;
import com.cdstore.webapp.exception.InternalServerException;
import com.cdstore.webapp.exception.InvalidParameterException;
import com.cdstore.webapp.exception.NotFoundException;
import com.cdstore.webapp.service.CdService;
import com.cdstore.webapp.service.PurchaseOrderService;
import com.cdstore.webapp.service.UserService;
import com.cdstore.webapp.service.def.ICdService;
import com.cdstore.webapp.service.def.IPurchaseOrderService;
import com.cdstore.webapp.service.def.IUserService;

/*
 * @author Sandarbh
 * This servlet handles the client response from OrderConfirmationPage.
 * If the user confirms the order, it will initiate the proceedings to save the order in DB and then cleanup the order from session and redirects user to home page.
 * If the user cancels the order, it will then just clean up the order from session and redirects user to application home page. 
 */
@WebServlet("/placeOrder")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IPurchaseOrderService purchaseOrderService;
	private ICdService iCdService;
	private IUserService iUserService;

	public PlaceOrderServlet() {
		purchaseOrderService = new PurchaseOrderService();
		iCdService = new CdService();
		iUserService = new UserService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			User loggedUser = (User) request.getSession().getAttribute("user");
			String cancelOrderButton = request.getParameter("cancelOrder");
			String confirmOrderButton = request.getParameter("confirmOrder");
			PurchaseOrder poOrder = new PurchaseOrder();
			List<PurchaseOrderItem> poItemList = new ArrayList<PurchaseOrderItem>();
			if (confirmOrderButton != null) {
				// read the order from sesssion
				ArrayList<String> checkedIds = (ArrayList<String>) request
						.getSession().getAttribute("selectedcds");
				if (checkedIds != null && checkedIds.size() > 0) {
					request.getSession().setAttribute("nocdselected", "false");
					String creditCardNumber = request
							.getParameter("inputCreditTextBox");
					request.getSession().setAttribute("cardNumber",
							creditCardNumber);
					String expiryDate = request
							.getParameter("expiryDateTextBox");
					request.getSession().setAttribute("expirydate", expiryDate);
					String cvvValue = request.getParameter("cvvTextBox");
					request.getSession().setAttribute("cvvValue", cvvValue);
					if (loggedUser == null) {
						// if user is not logged in, transfer to login page
						this.getServletContext()
								.getRequestDispatcher("/login.html")
								.forward(request, response);
						return;
					}
					List<CD> selectedCds;

					selectedCds = iCdService.getCds(checkedIds);

					// save the order in database
					for (CD cd : selectedCds) {
						PurchaseOrderItemId purchaseOrderItemId = new PurchaseOrderItemId();
						purchaseOrderItemId.setCd(cd);
						PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
						purchaseOrderItem.setPoId(purchaseOrderItemId);
						purchaseOrderItem.setPrice(cd.getPrice());
						poItemList.add(purchaseOrderItem);
					}
					poOrder.setStatus("ORDERED");
					poOrder.setUser(loggedUser);// This should be fetched from
												// session.
					poOrder.setPurchaseOrderItem(poItemList);
					String responseString = purchaseOrderService
							.purchase(poOrder);
					if (responseString.equals("success")) {
						// order was placed successfully, take the user to home
						// page
						// user can see account on home page, which shows the
						// order
						// history
						// But we need to clean the shopping cart from session
						// first
						request.getSession().setAttribute("selectedcds", null);
						this.getServletContext()
								.getRequestDispatcher("/orderSucess.jsp")
								.include(request, response);
						return;
					} else if (responseString.equals("creditcarderror")) {
						// every fifth request is rejected with credit card
						// error,
						// in such case redirect user to confirm order page
						// where
						// user needs to fill out the credit card information
						// again.
						// of-course, a warning message will be displayed that
						// provided credit card information was wrong
						this.getServletContext()
								.getRequestDispatcher("/creditCardError.jsp")
								.forward(request, response);
						return;
					} else if (responseString.equals("tryagain")) {
						// some exception occurred while saving the order,
						// redirect
						// the user to home page without clearing the cart
						// detail
						// from session
						response.sendRedirect("/cdstore-webapp/CdShowServlet");
						return;
					}
				}

			} else if (cancelOrderButton != null) {
				// if user clicks the cancel button then clear the cart and
				// redirect
				// the user to home page.
				request.getSession().setAttribute("selectedcds", null);
				response.sendRedirect("/cdstore-webapp/CdShowServlet");
				return;
			}
		} catch (InternalServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
