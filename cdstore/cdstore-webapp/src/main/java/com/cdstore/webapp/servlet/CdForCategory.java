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
 * Servlet implementation class CDForCategory
 */
@WebServlet("/cdsForCategories")
public class CdForCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICdService iCdService;

	public ICdService getiCdService() {
		return iCdService;
	}

	public void setiCdService(ICdService iCdService) {
		this.iCdService = iCdService;
	}

	public CdForCategory() {
		setiCdService(new CdService());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("cartItems", cartItems);
		String categorieString = request.getParameter("category");
		List<CD> cdListForCategory = iCdService.getAllCDsForCategory(categorieString);
		List<String> categories = iCdService.getAllCDCategories();
		request.setAttribute("cdForCategoryList", cdListForCategory);
		request.setAttribute("categories", categories);
		request.setAttribute("selectedCategory", request.getParameter("category"));
		this.getServletContext().getRequestDispatcher("/cdForACategory.jsp").include(request, response);
	}

}