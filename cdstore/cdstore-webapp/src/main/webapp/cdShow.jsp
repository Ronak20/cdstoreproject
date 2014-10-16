<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Online CD Shop</title>
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
				<a id="logoM" href="/cdstore-webapp/CdShowServlet"><img
					src="assets/img/logo.png" alt="EliteCoderzCDShop" /></a> <a
					data-target="#sidebar" data-toggle="collapse"
					class="btn btn-navbar"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li class="active"><a href="/cdstore-webapp/CdShowServlet">Home</a></li>
						<li class=""><a href="special_offer.html">Specials Offer</a></li>
						<li class=""><a href="normal.html">Delivery</a></li>
						<li class=""><a href="contact.html">Contact</a></li>
					</ul>
					<form action="#" class="navbar-search pull-left">
						<input id="srchFld" type="text" placeholder="I'm looking for ..."
							class="search-query span5" />
					</form>
					<!-- <ul class="nav pull-right">						
						<li><label class="btn-large"> <a
								href="/product_details.html">Proceed To Check Out</a>
						</label></li>
					</ul> -->
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
					<a href="index.html"><img src="assets/img/logo.png"
						alt="Bootsshop" /></a>
					<div class="pull-right">
						<br /> <a href="product_summary.html"> <span
							class="btn btn-mini btn-warning"> <i
								class="icon-shopping-cart icon-white"></i>[ Check Out ]</span>
						</a> <a href="product_summary.html"><span
							class="btn btn-mini active cost">$00.00</span></a>
					</div>
				</div>
			</div>
			<div class="clr"></div>
		</header>
		<!-- ==================================================Header End====================================================================== -->
		<hr>
		<div class="row">
			<div id="sidebar" class="span3">
				<ul class="nav nav-list bs-docs-sidenav" style="display: block;">
					<li class="subMenu active"><a><strong>Browse
								Categories</strong></a></li>
					<c:forEach var="category" items="${categories}">
						<li><a
							href="${pageContext.request.contextPath}/cdsForCategories?category=${category}"><c:out
									value="${category}"></c:out></a></li>
					</c:forEach>
					<li> <a href="product_summary.html"><strong><span class= "cartcount" id="cartid">[ 0 ] Items in your cart</span>
					<span class="badge badge-warning pull-right cost" style="line-height:18px;">$00.00</span></strong></a></li>
					<li style="border: 0">&nbsp;</li>
				</ul>
			</div>

			<div class="span9">
				<div>
					<h3>All Products</h3>
					<ul class="thumbnails">					
						<c:forEach var="cd" items="${cdDriveList}">
						
							<li class="span3">
								<div class="thumbnail">
									<img
										src="assets/products/<c:out value="${cd.cdId}"></c:out>.jpg"
										alt="" />
									<div class="caption">
										<h5>
											<c:out value="${cd.title}"></c:out>
										</h5>
										<p>
										<h5>
											Category:
											<c:out value="${cd.category}"></c:out>
										</h5>
										</p>
										<h4>
											<label class="checkbox"><input type="checkbox"
												name="addToCartCheckBox" onchange='handleChange(this);'
												value='<c:out value="${cd.cdId}"></c:out>'> Add to
												cart</label> <span id="${cd.cdId}" class="pull-middle">$<c:out
													value="${cd.price}"></c:out></span>
										</h4>
									</div>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<!-- Footer ------------------------------------------------------ -->
		<hr class="soft">
		<div id="footerSection">
			<div class="row">
				<div class="span3">
					<h5>ACCOUNT</h5>
					<a href="login.html">YOUR ACCOUNT</a> <a href="login.html">PERSONAL
						INFORMATION</a> <a href="login.html">ADDRESSES</a> <a
						href="login.html">DISCOUNT</a> <a href="login.html">ORDER
						HISTORY</a>
				</div>
				<div class="span3">
					<h5>INFORMATION</h5>
					<a href="contact.html">CONTACT</a> <a href="register.html">REGISTRATION</a>
					<a href="legal_notice.html">LEGAL NOTICE</a> <a href="tac.html">TERMS
						AND CONDITIONS</a> <a href="faq.html">FAQ</a>
				</div>
				<div class="span3">
					<h5>OUR OFFERS</h5>
					<a href="#">NEW PRODUCTS</a> <a href="#">TOP SELLERS</a> <a
						href="special_offer.html">SPECIAL OFFERS</a> <a href="#">MANUFACTURERS</a>
					<a href="#">SUPPLIERS</a>
				</div>
				<div id="socialMedia" class="span3 pull-right">
					<h5>SOCIAL MEDIA</h5>
					<a href="#"><img width="60" src="assets/img/facebook.png"
						title="facebook" /></a> <a href="#"><img width="60"
						src="assets/img/twitter.png" title="twitter" /></a> <a href="#"><img
						width="60" src="assets/img/rss.png" title="rss" /></a> <a href="#"><img
						width="60" src="assets/img/youtube.png" title="youtube" /></a>
				</div>
			</div>
			<hr class="soft">
			<p class="pull-right">&copy; Elite Coderz</p>
		</div>
	</div>
	<!-- /container -->


	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript"
		src="http://platform.twitter.com/widgets.js"></script>
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
		
		function handleChange(cb) {
			var list = $(".cost:first").html().split("$");
		    var price = parseFloat(list[1]);
			var spanid = cb.value;	
			var costtext = $('#' + spanid).html();
			var list2 = costtext.split("$");
			var price2 = parseFloat(list2[1]);	
			var itemcount = $("#cartid").text();
			var precounter = parseFloat(itemcount.charAt(2));
			var counter = parseFloat(itemcount.charAt(2));	
		  if(cb.checked == true){   
			price = price2+price;	 	
			counter++;	
		  }else{ 
		   price = price- price2;  
		   counter--;  
		  }
		  itemcount = itemcount.replace("[ "+precounter+" ]", "[ "+counter+" ]");
			$("#cartid").text(itemcount);
			$(".cost").text("$"+price);
			
		}
	</script>
</body>
</html>