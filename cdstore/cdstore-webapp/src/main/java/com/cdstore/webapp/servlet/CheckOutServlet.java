package com.cdstore.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdstore.model.Address;
import com.cdstore.model.CD;
import com.cdstore.model.PurchaseOrder;
import com.cdstore.model.PurchaseOrderItem;
import com.cdstore.model.PurchaseOrderItemId;
import com.cdstore.model.User;
import com.cdstore.webapp.service.CdService;
import com.cdstore.webapp.service.PurchaseOrderService;
import com.cdstore.webapp.service.def.ICdService;
import com.cdstore.webapp.service.def.IPurchaseOrderService;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/checkout")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IPurchaseOrderService purchaseOrderService;
	private ICdService iCdService;

	public IPurchaseOrderService getPurchaseOrderService() {
		return purchaseOrderService;
	}

	public void setUserService(final IPurchaseOrderService purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;
	}
	

	public ICdService getiCdService() {
		return iCdService;
	}

	public void setiCdService(ICdService iCdService) {
		this.iCdService = iCdService;
	}

	/**
	 * Default constructor.
	 */
	public CheckOutServlet() {
		purchaseOrderService = new PurchaseOrderService();
		iCdService = new CdService();
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
		//Check if user is already logged in or not.
		User loggedUser = (User)request.getSession().getAttribute("user");		
		//String[] checkedIdStrings = request.getParameterValues("addToCartCheckBox");
		PurchaseOrder poOrder = new PurchaseOrder();
		List<PurchaseOrderItem> poItemList = new ArrayList<PurchaseOrderItem>();
		ArrayList<String>interimObj =(ArrayList<String>) request.getSession().getAttribute("selectedcds");
		if(interimObj!= null )
		{
			//set the attribute nocdselected to false, because at lease one cd has been selected by user.
			request.getSession().setAttribute("nocdselected","false" );
			if(loggedUser == null)
			{
				//if user is not logged in, transfer to login page
				this.getServletContext().getRequestDispatcher("/login.html")
				.forward(request, response);
				return;
			}
			/*List<String> selectedStrings = new ArrayList<String>();
			for(int i=0; i < checkedIds.length ; i++){
				selectedStrings.add(checkedIds[i]);
			}
				
			List<CD> selectedCds = iCdService.getCds(selectedStrings);
			for (CD cd : selectedCds) {
				 PurchaseOrderItemId purchaseOrderItemId = new PurchaseOrderItemId();
				 purchaseOrderItemId.setCd(cd);
				 PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
				 purchaseOrderItem.setPoId(purchaseOrderItemId);
				 purchaseOrderItem.setPrice(cd.getPrice());
				 poItemList.add(purchaseOrderItem);
			}
			poOrder.setStatus("ORDERED");
			poOrder.setUser(loggedUser);//This should be fetched from session.
			poOrder.setPurchaseOrderItem(poItemList);
			purchaseOrderService.purchase(poOrder);*/
			response.sendRedirect("/cdstore-webapp/confirmOrder");
		}
		else {
			//set this attribute to display a warning message to user that at lease
			//one cd has to be selected before checking out.
			 request.getSession().setAttribute("nocdselected","true" );			 
			 response.sendRedirect("/cdstore-webapp/CdShowServlet");
		}

		
	}

}
