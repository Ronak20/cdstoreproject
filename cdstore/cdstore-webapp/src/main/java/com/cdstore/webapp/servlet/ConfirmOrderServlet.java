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
import com.cdstore.model.User;
import com.cdstore.webapp.exception.InternalServerException;
import com.cdstore.webapp.exception.InvalidParameterException;
import com.cdstore.webapp.exception.NotFoundException;
import com.cdstore.webapp.service.CdService;
import com.cdstore.webapp.service.PurchaseOrderService;
import com.cdstore.webapp.service.def.ICdService;
import com.cdstore.webapp.service.def.IPurchaseOrderService;

@WebServlet("/confirmOrder")
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IPurchaseOrderService purchaseOrderService;
	private ICdService iCdService;

	public IPurchaseOrderService getPurchaseOrderService() {
		return purchaseOrderService;
	}

	public void setUserService(final IPurchaseOrderService purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;
	}

	public ICdService getiCdService() {
		return iCdService;
	}

	public void setiCdService(ICdService iCdService) {
		this.iCdService = iCdService;
	}

	/**
	 * Default constructor.
	 */
	public ConfirmOrderServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		try {
			User authUser = (User) request.getSession().getAttribute("user");
			purchaseOrderService = new PurchaseOrderService(
					authUser.getUsername(), authUser.getPassword());
			setiCdService(new CdService(authUser.getUsername(),
					authUser.getPassword()));
			Integer totalPrice = 0; // the total price that should show up in
									// shopping cart. We will update in later
									// according to the request received.
			Integer cartItems = 0; // Total number of items in cart, We will
									// update
									// this later in the code.
			// fetch the selected cds from session
			ArrayList<String> checkedIds = (ArrayList<String>) request
					.getSession().getAttribute("selectedcds");
			if (checkedIds != null) {
				List<CD> selectedCds;

				selectedCds = iCdService.getCds(checkedIds);

				request.setAttribute("requestselectedcds", selectedCds);
				for (CD cd : selectedCds) {
					totalPrice = totalPrice + cd.getPrice();
				}
				cartItems = selectedCds.size();
				request.setAttribute("totalPrice", totalPrice);
				request.setAttribute("cartItems", cartItems);
				/*
				 * Cookie[] requestCookies= request.getCookies(); for (Cookie
				 * cookie : requestCookies) { if(cookie.getName() ==
				 * "credidCardError" && cookie.getValue()=="true"){
				 * request.setAttribute("credidCardFailed", "true"); return; } }
				 */
				this.getServletContext()
						.getRequestDispatcher("/confirmOrder.jsp")
						.forward(request, response);
				return;
			} else {
				// if session doesn't contain information about shopping cart.
				// redirect to home page.
				// set this attribute to display a warning message to user that
				// at
				// lease
				// one cd has to be selected before checking out.
				request.getSession().setAttribute("nocdselected", "true");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {

	}

}
