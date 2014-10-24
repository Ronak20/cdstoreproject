<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
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
	<div id="mainBody" class="container">
	<div class="span9">    
	<h3> Login</h3>	
	<hr class="soft"/>
	
	<div class="row">
	
		<div class="span1"> &nbsp;</div>
		<div class="span4">
			<div class="well">
			<h5>ALREADY REGISTERED ?</h5>
	<form method="post" action="login" id="loginForm">
	<c:choose>
		<c:when test="${message == 'Invalid username or password'}">
		<p>***Invalid username or password***</p>
		</c:when>
		
	</c:choose>
		<table>
			<tr>
				<td>Username :</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>			
		</table>
		<b><p>Not Registered Yet?  <a href="register.html">Click</a> to register</p></b>
	</form>
	</div>
		</div>
	</div>
	<!-- Footer ------------------------------------------------------ -->
		<hr class="soft">
		<p class="pull-right">&copy; Elite Coderz</p>
		<hr class="soft">			
		
	</div>
	</div>
	<script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
    <script src="assets/js/jquery.js"></script>
	<script src="assets/js/google-code-prettify/prettify.js"></script>
    <script src="assets/js/jquery.lightbox-0.5.js"></script>	
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.js"></script>
 <script type="text/javascript">   
    $(document).ready(function () {
		//form validation
        $('#loginForm').validate({ 
            rules: {
            	username: {
                    required: true
                },
                password: {
                    required: true
                    
                }
            }
        });

    });
    </script>
</body>
</html>