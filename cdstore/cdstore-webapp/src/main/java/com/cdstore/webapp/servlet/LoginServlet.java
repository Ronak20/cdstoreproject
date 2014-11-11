package com.cdstore.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cdstore.model.User;
import com.cdstore.webapp.MD5;
import com.cdstore.webapp.service.UserService;
import com.cdstore.webapp.service.def.IUserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IUserService userService;
	private static Logger logger = LogManager.getLogger(LoginServlet.class);

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		this.userService = new UserService();
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

		System.out.println(" this.userService ======= " + this.userService);

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(" Username : " + username + " Password : "
				+ password);
		User user = new User();
		user.setUsername(username);
		String hashedPassword = MD5.md5(password);
		user.setPassword(hashedPassword);

		try {
			User authenticatedUser = this.userService.authenticate(user);

			if (authenticatedUser != null) {
				request.getSession().setAttribute("user", authenticatedUser);
				request.setAttribute("message", "user is authenticated");
			} else {
				request.setAttribute("message", "Invalid username or password");
				this.getServletContext().getRequestDispatcher("/login.jsp")
						.include(request, response);
				return;
			}
		} catch (Exception ne) {
			request.setAttribute("message", "Invalid username or password");
			this.getServletContext().getRequestDispatcher("/login.jsp")
					.include(request, response);
			return;
		}

		if (request.getSession().getAttribute("selectedcds") != null)
			response.sendRedirect("/cdstore-webapp/confirmOrder");
		else {
			response.sendRedirect("/cdstore-webapp/CdShowServlet");
		}

	}

}
