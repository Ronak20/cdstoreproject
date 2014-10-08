package com.cdstore.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public HomeServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*Session session = HibernateUtil.getSessionFactory().openSession();

		CdDriveDao cdDriveDao = new CdDriveDao(session);
		CdService cdService = new CdService(cdDriveDao);

		List<CdDrive> cdDriveList = cdService.getCdDriveList();

		for (CdDrive cdDrive : cdDriveList) {
			for (PurchaseOrderItem purchaseOrderItem : cdDrive
					.getPurchaseOrderItem()) {
				PurchaseOrder purchaseOrder = purchaseOrderItem.getPoId()
						.getPurchaseOrder();
				System.out
						.println(" Lastname : " + purchaseOrder.getLastName());
			}
		}

		session.close();
		request.setAttribute("cdDriveList", cdDriveList);

		this.getServletContext().getRequestDispatcher("/index.jsp")
				.include(request, response);*/
	}

}
