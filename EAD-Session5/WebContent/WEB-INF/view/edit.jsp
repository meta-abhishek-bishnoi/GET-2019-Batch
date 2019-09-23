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
	<div align="right" id="dashboard"><a href="dashboard">Edit</a></div>
	<div align="center" id="items">
		<form action="saveEdit" method="post">
			<label name="name" id="name">${order.getProductName()}</label><br>
			<label name="price" id="price">${order.getProductPrice()}</label><br>
			<input type="text" name="quantity" id="quantity" value="${order.getQuantity()}"><br>
			<input type="hidden" name="product_id" id="product_id" value="${order.getProductPrice()}">
			<input type="hidden" name="order_id" id="order_id" value="${order.getOrderId()}">
			<input type="submit" value="edit">
		</form>
	</div>
</body>
</html>
