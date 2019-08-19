/**
 * 
 */
package util;

public class Query {

	/**
	 * 
	 * @param userid
	 * @return
	 */
	public static String getQueryUserShippedOrders( int userid ) {
		return "select o.order_id as ID , o.ordertime as ORDER_TIME, ( i.quantity * p.price ) as AMOUNT "+ 
				"from orders as o "+"inner join items as i on i.order_id = o.order_id "+"inner join product as p on p.product_id = i.product_id "+
				"where o.customer_id = "+ userid +" and i.status like 'shipped' order by ORDER_TIME";
	}

	/**
	 * 
	 * @return
	 */
	public static String getInsertProductImageQuery(){
		return "insert into images ( image_url, product_id ) values ( ?, ? )";
	}
}
