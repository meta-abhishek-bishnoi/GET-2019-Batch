/**
* This is utility class for return querty for each SQl Operation
* @author Abhishek Bishnoi
* @since Sept 2,2019
*/
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
	public static String loadOrders() {
		return "select o.order_id as orderId, o.product_code as productCode, o.quantity as quantity, "+
				"p.product_type as productType, p.product_name as productName, p.product_price as productPrice from orders as o "+
				"inner join product as p on p.product_code = o.product_code";
	}
	public static String deleteProduct(){
		return "delete from orders where order_id = ?";
	}
	public static String loadOrdersById() {
		return "select o.order_id as orderId, o.product_code as productCode, o.quantity as quantity, "+
				"p.product_type as productType, p.product_name as productName, p.product_price as productPrice from orders as o "+
				"inner join product as p on p.product_code = o.product_code where order_id=?";
	}
}
