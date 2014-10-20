package com.cdstore.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxServlet")
public class ModifyCartAjaxServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
	}
	
	
	protected void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		
		String cdId = request.getParameter("cdString");
		String action = request.getParameter("action");
		ArrayList<String>interimObj = (ArrayList<String>) request.getSession().getAttribute("selectedcds");
		String varString= "nowhere";
	   
	    if(action.equals("delete")){
	    	
	    	if(interimObj != null){
	    		interimObj.remove(cdId);
	    		request.getSession().setAttribute("selectedcds", interimObj);
	    	}
	    	varString = "inside delete";
	    }
	    else if (action.equals("add")) {
	    	varString = "inside add";
	    	if(interimObj == null){
	    		varString = "inside add null";
	    		interimObj = new ArrayList<String>();
	    		interimObj.add(cdId);
	    		request.getSession().setAttribute("selectedcds", interimObj); //This session attribute should be cleared out when user logs out or checks out the cart
	    	}
	    	else {
	    		varString = "inside add not null";
				interimObj.add(cdId);
				request.getSession().setAttribute("selectedcds", interimObj);
			}
		}
	    
	    response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Hola</title>");
	    out.println("</head>");
	    out.println("<body bgcolor=\"white\">");
	    out.println(cdId);
	    out.println(action);
	    out.println(varString);
	    out.println(interimObj.size());
	    out.println("</body>");
	    out.println("</html>");
	    
	}


}
