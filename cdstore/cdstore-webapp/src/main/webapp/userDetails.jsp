<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>User Details</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Le styles  -->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet" />
<link href="assets/css/docs.css" rel="stylesheet" />
<link href="style.css" rel="stylesheet" />
<link href="assets/js/google-code-prettify/prettify.css"
	rel="stylesheet" />
</head>
<body>
<!-- Navbar
    ================================================== -->
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a id="logoM"
					href="${pageContext.request.contextPath}/CdShowServlet"><img
					src="assets/img/logo.png" alt="EliteCoderzCDShop" /></a> <a
					data-target="#sidebar" data-toggle="collapse"
					class="btn btn-navbar"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li class="active"><a href="/cdstore-webapp/CdShowServlet">Home</a></li>
					</ul>
				</div>
				<!-- /.nav-collapse -->
			</div>
		</div>
		<!-- /navbar-inner -->
	</div>
	<!-- ======================================================================================================================== -->
	<div id="mainBody" class="container">
<header id="header">
<div class="row">
<div class="span12">
	<a href="index.html"><img src="assets/img/logo.png" alt="Bootsshop"/></a>
</div>
</div>
<div class="clr"></div>
</header
<!-- ==================================================Header End====================================================================== -->
<hr class="soft">
	</br></br>
	<h2><c:out value="${user.firstName} ${user.lastName}"></c:out> below is you account information: </h2>
	<div class="row well">
		<div class="accordion" id="accordion2">
			  <div class="accordion-group">
                  <div class="accordion-heading">
                    <h4><a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                      Account Information:
                    </a></h4>
                  </div>
                  <div id="collapseOne" class="accordion-body collapse"  >
                    <div class="accordion-inner">
						<label>First Name : <c:out value="${user.firstName} ${user.lastName}"></c:out></label>
						<label>Last  Name : <c:out value="${user.address.street}"></c:out></label>
						<label>Province&nbsp;&nbsp;&nbsp;: <c:out value="${user.address.province}"></c:out></label>
						<label>Country&nbsp;&nbsp;&nbsp;&nbsp;: <c:out value="${user.address.country}"></c:out></label>
						<label>Zip Code&nbsp;&nbsp;&nbsp;: <c:out value="${user.address.zip}"></c:out></label>
						<label>Phone&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <c:out value="${user.address.phone}"></c:out></label>
					</div>
                  </div>
                </div>
				<div class="accordion-heading">
                    <h4><a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion2" >
                      PO History: 
                    </a></h4>
					<c:forEach var="po" items="${user.purchaseOrderList}">
			 <div class="accordion-group" >
                  <div class="accordion-heading">
                    <h5><a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion2" href="#${po.purchaseOrderId}">
                      <c:out value="PurchaseOrderID: ${po.purchaseOrderId}"></c:out>
                    </a></h5>
                  </div>
                  <div id="${po.purchaseOrderId}" class="accordion-body collapse"  >
                    <div class="accordion-inner">
						<c:forEach var="poItem" items="${po.purchaseOrderItem}">
						<label>Purchase Order Detail: </label>
						<label>CD Title:  <c:out value="${poItem.poId.cd.title}"></c:out>$</label>
						<label>CD Price:  <c:out value="${poItem.price}"></c:out>$</label>						
					</c:forEach>		
					</div>
                  </div>
                </div>	
			</c:forEach>
                  </div>
			<hr class="soft">
		<div id="footerSection">			
			<hr class="soft">
			<p class="pull-right">&copy; Elite Coderz</p>
		</div>
		 </div>
	</div>
	</div> <!-- container ends -->
</body>
<!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
    <script src="assets/js/jquery.js"></script>
	<script src="assets/js/google-code-prettify/prettify.js"></script>
    <script src="assets/js/application.js"></script>
    <script src="assets/js/bootstrap-transition.js"></script>
    <script src="assets/js/bootstrap-modal.js"></script>
    <script src="assets/js/bootstrap-scrollspy.js"></script>
    <script src="assets/js/bootstrap-alert.js"></script>
    <script src="assets/js/bootstrap-dropdown.js"></script>
    <script src="assets/js/bootstrap-tab.js"></script>
    <script src="assets/js/bootstrap-tooltip.js"></script>
    <script src="assets/js/bootstrap-popover.js"></script>
    <script src="assets/js/bootstrap-button.js"></script>
    <script src="assets/js/bootstrap-collapse.js"></script>
    <script src="assets/js/bootstrap-carousel.js"></script>
    <script src="assets/js/bootstrap-typeahead.js"></script>
    <script src="assets/js/bootstrap-affix.js"></script>
    <script src="assets/js/jquery.lightbox-0.5.js"></script>
	<script src="assets/js/bootsshoptgl.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.js"></script>
</html>