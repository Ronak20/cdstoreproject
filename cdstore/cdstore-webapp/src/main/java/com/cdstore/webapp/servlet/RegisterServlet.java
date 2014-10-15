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
 * Servlet implementation class HomeServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IUserService iUserService;

	public IUserService save() {
		return iUserService;
	}

	public void setiUserService(IUserService iUserservice) {
		this.iUserService = iUserservice;
	}

	/**
	 * Default constructor.
	 */
	public RegisterServlet() {
		setiUserService(new UserService());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(request, resp);
		this.doGet(request, resp);
		User user = new User();
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		iUserService.save(user);
	}
}
