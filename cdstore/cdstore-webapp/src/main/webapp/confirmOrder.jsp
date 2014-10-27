<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
    <title>Order confirmation</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles  -->
    <link href="assets/css/bootstrap.css" rel="stylesheet"/>
    <link href="assets/css/bootstrap-responsive.css" rel="stylesheet"/>
	<link href="assets/css/docs.css" rel="stylesheet"/>
	 
    <link href="style.css" rel="stylesheet"/>
	<link href="assets/js/google-code-prettify/prettify.css" rel="stylesheet"/>
	</head>
<body>
  <!-- Navbar
    ================================================== -->
<div class="navbar navbar-fixed-top">
              <div class="navbar-inner">
                <div class="container">
                 <a id="logoM" href="#"><img src="assets/img/logo.png" alt="Bootsshop"/></a>
					<a data-target="#sidebar" data-toggle="collapse" class="btn btn-navbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </a>
                  <div class="nav-collapse">
                    <ul class="nav">
					  <li class=""><a href="${pageContext.request.contextPath}/CdShowServlet">Home</a></li>					  
					</ul>
                  </div><!-- /.nav-collapse -->
                </div>
              </div><!-- /navbar-inner -->
            </div>
<!-- ======================================================================================================================== -->	
<form method="post" name="orderConfirmationForm" action="/cdstore-webapp/placeOrder" id="orderConfirmationForm" >
<div id="mainBody" class="container">
<header id="header">
<div class="row">
<div class="span12">
	<a href="index.html"><img src="assets/img/logo.png" alt="Bootsshop"/></a>

<div class="pull-right"> <br/>
<c:choose>
	<c:when test="${sessionScope.user != null}">	
	<c:set var="accountUrl" value="${pageContext.request.contextPath}/userDetail?userid=${sessionScope.user.userId}"></c:set>
	</c:when>
	<c:otherwise>
	<c:set var="accountUrl" value="login.jsp"></c:set>
	</c:otherwise>				
	</c:choose>
	<div class="span3">	
	<input type="submit" class="badge-warning btn-large" name="confirmOrder" value="Confirm Order" onclick="">
	<input type="submit" class="badge-warning btn-large cancel" name = "cancelOrder"value="Cancel order">		
</div>
</div>
</div>
<div class="clr"></div>
</header>
<!-- ==================================================Header End====================================================================== -->

	</br></br>
	<h2><c:out value="${sessionScope.user.firstName} ${sessionScope.user.lastName}"></c:out> please confirm your order</h2>
		
              <div class="accordion" id="accordion2">
			  <div class="accordion-group">
                  <div class="accordion-heading">
                    <h4><a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                      Delivery Address:
                    </a></h4>
                  </div>
                  <div id="collapseOne" class="accordion-body collapse"  >
                    <div class="accordion-inner">
						<label>First Name : <c:out value="${sessionScope.user.firstName} ${sessionScope.user.lastName}"></c:out></label>
						<label>Last  Name : <c:out value="${sessionScope.user.address.street}"></c:out></label>
						<label>Province&nbsp;&nbsp;&nbsp;: <c:out value="${sessionScope.user.address.province}"></c:out></label>
						<label>Country&nbsp;&nbsp;&nbsp;&nbsp;: <c:out value="${sessionScope.user.address.country}"></c:out></label>
						<label>Zip Code&nbsp;&nbsp;&nbsp;: <c:out value="${sessionScope.user.address.zip}"></c:out></label>
						<label>Phone&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <c:out value="${sessionScope.user.address.phone}"></c:out></label>
					</div>
                  </div>
                </div>
                <c:forEach var="cd" items="${requestselectedcds}">
                <div class="accordion-group">
                  <div class="accordion-heading">
                    <h4><a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion2" href="#${cd.cdId}">
                      <c:out value="${cd.title}"></c:out>
                    </a></h4>
                  </div>
                  <div id="${cd.cdId}" class="accordion-body collapse"  >
                    <div class="accordion-inner">
						<label>CD Price:  <c:out value="${cd.price}"></c:out>$</label>
						<label>CD Category:  <c:out value="${cd.category}"></c:out></label>	
					</div>
                  </div>
                </div>
                </c:forEach>
              </div>
              <div id="crediDetails" class="well">
              <h3>Credit Card information</h3>
              <c:choose>
			 <c:when test="${credidCardFailed =='true'}">
			 <strong><label class="badge-warning btn" id="creditCardErrorLabel">Credit Card Authorization Failed !</label></strong>
			</c:when>				
			</c:choose>
			<!-- check if credit card information is available in session , then fill the form from previously entered information -->
			 <c:choose>
			 <c:when test="${sessionScope.cardNumber != null}">
			 <c:set var="cCardNumber" value="${sessionScope.cardNumber}"></c:set>
			</c:when>	
			<c:otherwise>
			 <c:set var="cCardNumber" value="Input your Credit number here "></c:set>
			</c:otherwise>			
			</c:choose>
			<c:choose>
			 <c:when test="${sessionScope.expirydate != null}">
			 <c:set var="cExpiryDate" value="${sessionScope.expirydate}"></c:set>
			</c:when>	
			<c:otherwise>
			 <c:set var="cExpiryDate" value="YY-MM-DD "></c:set>
			</c:otherwise>			
			</c:choose>
			<c:choose>
			 <c:when test="${sessionScope.cvvValue != null}">
			 <c:set var="ccvvValue" value="${sessionScope.cvvValue}"></c:set>
			</c:when>	
			<c:otherwise>
			 <c:set var="cvvValue" value="cvv code on your credit card "></c:set>
			</c:otherwise>			
			</c:choose>
              <div class="control-group">
			<label class="control-label" for="inputCreditTextBox">CreditCardNummber <sup>*</sup></label>
			<div class="controls">
			  <input type="text" name="inputCreditTextBox" id="inputCredit" placeholder="${cCardNumber}">
			</div>
		 </div>
              <div class="control-group">
			<label class="control-label" for="expiryDateTextBox">Expiration Date <sup>*</sup></label>
			<div class="controls">
			  <input type="text" name="expiryDateTextBox" id="expiryDate" placeholder="${cExpiryDate}">
			</div>
		 </div>
		  <div class="control-group">
			<label class="control-label" for="cvvTextBox">cvv code on your credit card <sup>*</sup></label>
			<div class="controls">
			  <input type="text" name="cvvTextBox" id="cvvTextBox" placeholder="${ccvvValue}">
			</div>
		 </div>
              </div>
<!-- Footer ------------------------------------------------------ -->
		<hr class="soft">
		<div id="footerSection">
			<div class="row">
				<div class="span3">
					<h5>ACCOUNT</h5>
					<a href="${accountUrl}">YOUR ACCOUNT</a> 
				</div>				
			</div>
			<hr class="soft">
			<p class="pull-right">&copy; Elite Coderz</p>
		</div>
</div><!-- /container -->
</form>

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
	<script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.js"></script>
	
	<script type="text/javascript">
    $(function() {
        $('#gallery a').lightBox();
    });
    $(document).ready(function () {
		//form validation
        $('#orderConfirmationForm').validate({ 
            rules: {
            	inputCreditTextBox: {
                    required: true,
                    minlength: 16
                },
                expiryDateTextBox: {
                    required: true,
                    minlength: 8
                },
                cvvTextBox: {
                    required: true,
                    minlength: 3
                }
            }
        });

    });
    </script>
  </body>
</html>