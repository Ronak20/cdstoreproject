package com.cdstore.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cdstore.webapp.LogConstant;
import com.cdstore.webapp.service.UserService;
import com.cdstore.webapp.service.def.IUserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IUserService userService;
	private static Logger logger = LogManager.getLogger(LogoutServlet.class);

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(final IUserService userService) {
		this.userService = userService;
	}

	/**
	 * Default constructor.
	 */
	public LogoutServlet() {
		userService = new UserService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		logger.info(LogConstant.GET_RECEIVED);
		request.getSession().invalidate();
		logger.info(LogConstant.REDIRECT + "/CdShowServlet");
		this.getServletContext().getRequestDispatcher("/CdShowServlet")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		logger.info(LogConstant.POST_RECEIVED);
	}

}
