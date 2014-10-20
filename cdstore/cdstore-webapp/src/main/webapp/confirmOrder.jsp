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
					  <li class=""><a href="index.html">Home	</a></li>
					  <li class=""><a href="special_offer.html">Specials Offer</a></li>
					  <li class=""><a href="normal.html">Delivery</a></li>
					  <li class=""><a href="contact.html">Contact</a></li>
					</ul>
                  </div><!-- /.nav-collapse -->
                </div>
              </div><!-- /navbar-inner -->
            </div>
<!-- ======================================================================================================================== -->	
<div id="mainBody" class="container">
<header id="header">
<div class="row">
<div class="span12">
	<a href="index.html"><img src="assets/img/logo.png" alt="Bootsshop"/></a>

<div class="pull-right"> <br/>
	<a href="product_summary.html"> <span class="btn btn-mini btn-warning"> <i class="icon-shopping-cart icon-white"></i> [ <c:out value="${cartItems}"></c:out> ] </span> </a>
	<a href="product_summary.html"><span class="btn btn-mini active">$${totalPrice}</span></a> 
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
<!-- Footer ------------------------------------------------------ -->
<hr class="soft">
<div  id="footerSection">
	<div class="row">
		<div class="span3">
			<h5>ACCOUNT</h6>
			<a href="login.html">YOUR ACCOUNT</a>
			<a href="login.html">PERSONAL INFORMATION</a> 
			<a href="login.html">ADDRESSES</a> 
			<a href="login.html">DISCOUNT</a>  
			<a href="login.html">ORDER HISTORY</a>
		 </div>
		<div class="span3">
			<h5>INFORMATION</h5>
			<a href="contact.html">CONTACT</a>  
			<a href="register.html">REGISTRATION</a>  
			<a href="legal_notice.html">LEGAL NOTICE</a>  
			<a href="tac.html">TERMS AND CONDITIONS</a> 
			<a href="faq.html">FAQ</a>
		 </div>
		<div class="span3">
			<h5>OUR OFFERS</h5>
			<a href="#">NEW PRODUCTS</a> 
			<a href="#">TOP SELLERS</a>  
			<a href="special_offer.html">SPECIAL OFFERS</a>  
			<a href="#">MANUFACTURERS</a> 
			<a href="#">SUPPLIERS</a> 
		 </div>
		<div id="socialMedia" class="span3 pull-right">
			<h5>SOCIAL MEDIA </h5>
			<a href="#"><img width="60" src="assets/img/facebook.png" title="facebook"/></a>
			<a href="#"><img width="60" src="assets/img/twitter.png" title="twitter"/></a>
			<a href="#"><img width="60" src="assets/img/rss.png" title="rss"/></a>
			<a href="#"><img width="60" src="assets/img/youtube.png" title="youtube"/></a>
		 </div> 
	 </div>
	 <hr class="soft">
	<p class="pull-right">&copy; Elite Coderz</p>
	</div><!-- /footer -->
</div><!-- /container -->


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
	 <script type="text/javascript">
    $(function() {
        $('#gallery a').lightBox();
    });
    </script>
  </body>
</html>