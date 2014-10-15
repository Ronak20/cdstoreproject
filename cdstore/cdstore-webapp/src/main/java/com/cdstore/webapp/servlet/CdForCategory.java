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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String categorieString = request.getParameter("category");
		List<CD> cdListForCategory = iCdService
				.getAllCDsForCategory(categorieString);
		List<String> categories = iCdService.getAllCDCategories();
		request.setAttribute("cdForCategoryList", cdListForCategory);
		request.setAttribute("categories", categories);
		request.setAttribute("selectedCategory",
				request.getParameter("category"));
		this.getServletContext().getRequestDispatcher("/cdForACategory.jsp")
				.include(request, response);
	}

}