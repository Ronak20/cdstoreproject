package com.cdstore.webapp.servlet;

import java.io.IOException;
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
 * Servlet implementation class HomeServlet
 */
@WebServlet("/CdServlet")
public class CdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ICdService iCdService;

	public ICdService getiCdService() {
		return iCdService;
	}

	public void setiCdService(ICdService iCdService) {
		this.iCdService = iCdService;
	}

	/**
	 * Default constructor.
	 */
	public CdServlet() {
		setiCdService(new CdService());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<CD> cdDriveList = iCdService.getAll();
		request.setAttribute("cdDriveList", cdDriveList);
		this.getServletContext().getRequestDispatcher("/index.jsp")
				.include(request, response);
	}

}
