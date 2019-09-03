<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body>
	<div align="right" id="dashboard"><a href="dashboard">Dashboard</a></div>
	<div align="center" id="items">
		<table>
			<tr>
				<th>Product Name</th>
				<th>Product Price</th>
				<th>Product Quantity</th>
				<th>Edit<th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${orders}" var="order">
				<tr>
					<td>${order.getProductName()}</td>
					<td>${order.getProductPrice() }</td>
					<td>${order.getQuantity()}</td>
					<td><a href="edit?id=${order.getOrderId()}">Edit</a></td>
					<td><a href="delete?id=${order.getOrderId()}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>