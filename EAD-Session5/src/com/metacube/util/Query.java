package com.metacube.util;

public class Query {
	public static String loadProducts(){
		return "select product_code as code, product_type as type, product_name as name, product_price as price from product";
	}
	public static String checkOrderProduct(){
		return "select count(*) as product_count, quantity from orders where product_code = ?";
	}
	public static String updateOrderProduct(){
		return "update orders set quantity=? where product_code=?";
	}
	public static String insertOrderProduct(){
		return "insert into orders(product_code, quantity) values(?,?)";
	}
}
