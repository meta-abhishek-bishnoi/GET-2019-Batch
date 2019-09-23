<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
	<div align="right" id="cart"><a href="cart">Cart Items</a></div>
	<div align="center" id="items">
		<table>
			<tr>
				<th>Product Type</th>
				<th>Product Name</th>
				<th>Product Price</th>
				<th>Add To cart </th>
			</tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.getProductType()}</td>
					<td>${product.getProductName()}</td>
					<td>${product.getProductPrice()}</td>
					<td><a href="addCart?id=${product.getProductCode()}">Add</a>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>