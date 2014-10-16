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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(final IUserService userService) {
		this.userService = userService;
	}

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		userService = new UserService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(" Username : " + username + " Password : "
				+ password);
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		User authenticatedUser = userService.authenticate(user);

		if (authenticatedUser != null) {
			request.getSession().setAttribute("user", authenticatedUser);
			request.setAttribute("message", "user is authenticated");
		} else {
			request.setAttribute("message", "Invalid username or password");
		}

		this.getServletContext().getRequestDispatcher("/cd.jsp")
				.forward(request, response);
	}

}
