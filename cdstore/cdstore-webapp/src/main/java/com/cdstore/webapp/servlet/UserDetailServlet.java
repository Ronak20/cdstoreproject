package com.cdstore.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdstore.model.User;
import com.cdstore.webapp.service.UserService;
import com.cdstore.webapp.service.def.IUserService;

/**
 * Servlet implementation class UserDetailServlet
 */
@WebServlet("/userDetail")
public class UserDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public UserDetailServlet() {
		userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userId = req.getParameter("userid");

		User user = userService.getUser(userId);

		req.setAttribute("user", user);
		this.getServletContext().getRequestDispatcher("/userDetails.jsp")
				.include(req, resp);
	}

}
