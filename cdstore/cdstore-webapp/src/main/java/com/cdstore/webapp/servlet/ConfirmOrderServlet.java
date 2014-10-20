package com.cdstore.webapp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdstore.model.CD;
import com.cdstore.model.PurchaseOrder;
import com.cdstore.model.PurchaseOrderItem;
import com.cdstore.model.PurchaseOrderItemId;
import com.cdstore.model.User;
import com.cdstore.webapp.service.CdService;
import com.cdstore.webapp.service.PurchaseOrderService;
import com.cdstore.webapp.service.def.ICdService;
import com.cdstore.webapp.service.def.IPurchaseOrderService;

@WebServlet("/confirmOrder")
public class ConfirmOrderServlet extends HttpServlet {
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
	public ConfirmOrderServlet() {
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
		Integer totalPrice=0; //the total price that should show up in shopping cart. We will update in later according to the request received.
		Integer cartItems = 0; //Total number of items in cart, We will update this later in the code.
		//fetch the selected cds from session
		ArrayList<String> checkedIds= (ArrayList<String>) request.getSession().getAttribute("selectedcds");
		if(checkedIds!= null )
		{	
			List<CD> selectedCds = iCdService.getCds(checkedIds);
			request.setAttribute("requestselectedcds", selectedCds);
			for (CD cd : selectedCds) {
				totalPrice = totalPrice+cd.getPrice();
			}
			cartItems = selectedCds.size();
			request.setAttribute("totalPrice", totalPrice);
			request.setAttribute("cartItems", cartItems);
			this.getServletContext().getRequestDispatcher("/confirmOrder.jsp")
			.forward(request, response);
		}
		else {
			//if session doesn't contain information about shopping cart. redirect to home page.
			//set this attribute to display a warning message to user that at lease
			//one cd has to be selected before checking out.
			 request.getSession().setAttribute("nocdselected","true" );			 
			 response.sendRedirect("/cdstore-webapp/CdShowServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		/*//Check if user is already logged in or not.
		User loggedUser = (User)request.getSession().getAttribute("user");		
		String[] checkedIds = request.getParameterValues("addToCartCheckBox");
		PurchaseOrder poOrder = new PurchaseOrder();
		List<PurchaseOrderItem> poItemList = new ArrayList<PurchaseOrderItem>();
		if(checkedIds!= null )
		{
			//store user's choices in session.
			//This will be removed when order processing is complete. 
			//Order is either rejected or accepted. In both cases, this attribute would be removed when order processing is completed.
			//It also needs to be removed when user logs out.
			request.getSession().setAttribute("selectedcds", checkedIds);
			//set the attribute nocdselected to false, if some cd has been selected by user.
			request.getSession().setAttribute("nocdselected","false" );
			if(loggedUser == null)
			{
				//if user is not logged in, transfer to login page
				this.getServletContext().getRequestDispatcher("/login.html")
				.forward(request, response);
				return;
			}
			List<String> selectedStrings = new ArrayList<String>();
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
			purchaseOrderService.purchase(poOrder);
			this.getServletContext().getRequestDispatcher("/cdShow.jsp")
			.forward(request, response);
		}
		else {
			//set this attribute to display a warning message to user that at lease
			//one cd has to be selected before checking out.
			 request.getSession().setAttribute("nocdselected","true" );			 
			 response.sendRedirect("/cdstore-webapp/CdShowServlet");
		}*/

		
	}

}
