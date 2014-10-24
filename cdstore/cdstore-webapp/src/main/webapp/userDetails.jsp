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
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
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
				<td>User Id</td>
				<td><c:out value="${user.userId}"></c:out></td>
			</tr>
			<tr>
				<td>Firstname</td>
				<td><c:out value="${user.firstName}"></c:out></td>
			</tr>
			<tr>
				<td>Lastname</td>
				<td><c:out value="${user.lastName}"></c:out></td>
			</tr>
			<tr>
				<td>Address Id</td>
				<td><c:out value="${user.address.addressId}"></c:out></td>
			</tr>
			<tr>
				<td>Street</td>
				<td><c:out value="${user.address.street}"></c:out></td>
			</tr>
			<tr>
				<td>Province</td>
				<td><c:out value="${user.address.province}"></c:out></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><c:out value="${user.address.country}"></c:out></td>
			</tr>
			<tr>
				<td>Zip</td>
				<td><c:out value="${user.address.zip}"></c:out></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><c:out value="${user.address.phone}"></c:out></td>
			</tr>

			<c:forEach var="po" items="${user.purchaseOrderList}">
				<tr>
					<td>Status</td>
					<td>${po.status}</td>
				</tr>
				<tr>
					<c:forEach var="poItem" items="${po.purchaseOrderItem}">
						<td>Price</td>
						<td>${poItem.price}</td>
						<td>Price</td>
						<td>${poItem.poId.cd.cdId}</td>
						<td>Price</td>
						<td>${poItem.poId.cd.title}</td>
						<td>Cd Price</td>
						<td>${poItem.poId.cd.price}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>