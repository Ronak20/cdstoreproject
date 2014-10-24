<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
    <title>Order Failed. Redirecting page..</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<meta http-equiv="refresh" content="1;url=/cdstore-webapp/confirmOrder">
        <script type="text/javascript">
        	window.alert("Credit Card Authentication Failed.\nPress okay to provide alternative details..");
            window.location.href = "/cdstore-webapp/confirmOrder"
        </script>   
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
                  
                </div>
              </div><!-- /navbar-inner -->
            </div>
<body>
 <body>
        <!-- Note: don't tell people to `click` the link, just tell them that it is a link. -->
        Credit Card Authentication Failed.If you are not redirected automatically, click on <a href='/cdstore-webapp/confirmOrder'> to go back to order 
        confirmation page to verify the credit card details</a>
    </body>
</body>
</html>