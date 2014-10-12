<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cd Drives</title>
<style type="text/css">
table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
</style>
</head>
<body>
	<div>
		<table align="center" border="1" class="gridtable">
			<tr>
				<th colspan="4">Cd</th>
			</tr>
			<tr>
				<th>Cd Id</th>
				<th>Title</th>
				<th>Price</th>
				<th>Category</th>
			</tr>
			<c:forEach var="cdDrive" items="${cdDriveList}">
				<tr>
					<td><c:out value="${cdDrive.cdId}"></c:out></td>
					<td><c:out value="${cdDrive.title}"></c:out></td>
					<td><c:out value="${cdDrive.price}"></c:out></td>
					<td><c:out value="${cdDrive.category}"></c:out></td>
			</c:forEach>
		</table>
	</div>
</body>
</html>