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
import com.cdstore.webapp.service.CdService;
import com.cdstore.webapp.service.def.ICdService;

/**
 * Servlet implementation class CDShowServlet
 */
@WebServlet("/CdShowServlet")
public class CDShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ICdService iCdService;

	public ICdService getiCdService() {
		return iCdService;
	}

	public void setiCdService(ICdService iCdService) {
		this.iCdService = iCdService;
	}

	public CDShowServlet() {
		setiCdService(new CdService());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// look if user had already selected some cds. This may happen in a case
		// when user goes to Cds by categories web-page
		// and then comes back to homepage(this page) again. in such a case we
		// need to find out the selected cds and display the updated cart
		// accordingly on next page.
		Integer totalPrice = 0; // the total price that should show up in
								// shopping cart. We will update in later
								// according to the request received.
		Integer cartItems = 0; // Total number of items in cart, We will update
								// this later in the code.
		ArrayList<String> interimObj = (ArrayList<String>) request.getSession().getAttribute("selectedcds");
		if (interimObj != null && interimObj.size() > 0) {
			List<CD> selectedCds = iCdService.getCds(interimObj);
			// calculate the price
			for (CD cd : selectedCds) {
				totalPrice = totalPrice + cd.getPrice();
			}
			cartItems = selectedCds.size();
			request.getSession().setAttribute("nocdselected", "false"); // set
																		// this
																		// to
																		// false
																		// so
																		// that
																		// user
																		// doesn't
																		// see
																		// warning
																		// message.
		}

		List<CD> cdDriveList = iCdService.getAll();
		request.setAttribute("cdDriveList", cdDriveList);
		List<String> categories = iCdService.getAllCDCategories();
		request.setAttribute("categories", categories);
		// store the total price in request attribute
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("cartItems", cartItems);
		this.getServletContext().getRequestDispatcher("/cdShow.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
	}

}
