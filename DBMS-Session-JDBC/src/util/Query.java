/**
 * This class contains Query for all JDBC Operations
 * @author Abhishek Bishnoi
 * @since Aug 19, 2019
 */
package util;

public class Query {

	/**
	 * @param userid user id in int form 
	 * @return generated query for corresponding user id 
	 */
	public static String getQueryUserShippedOrders( int userid ) {
		return "select o.order_id as ID , o.ordertime as ORDER_TIME, ( i.quantity * p.price ) as AMOUNT "+ 
				"from orders as o "+"inner join items as i on i.order_id = o.order_id "+"inner join product as p on p.product_id = i.product_id "+
				"where o.customer_id = "+ userid +" and i.status like 'shipped' order by ORDER_TIME";
	}

	/**
	 * to insert images url into database
	 * @return query for inserting images
	 */
	public static String getInsertProductImageQuery(){
		return "insert into images ( image_url, product_id ) values ( ?, ? )";
	}
	/**
	 * deleting products which are not purchased from last one year
	 * here we are using soft delete so instead of deleting item we mark them as inactive
	 * @return query for soft delete
	 */
	public static String getDeleteProductQuery(){
		return "update product as pr "+
				"left join items as i on i.product_id = pr.product_id "+
				"left join orders as o on o.order_id = i.order_id "+
				"set productstatus='inactive' "+
				"where (datediff(curdate(),o.ordertime)/365) >= 1";
	}
	
	/**
	 * parent category and their child count
	 * @return query for parent query and child count
	 */
	public static String getParentCategoryWithChildCount(){
		return  "select p.category_name as NAME,count(c.parent_key) as COUNT "+
				"from category as c inner join category as p on c.parent_key=p.category_id "+
				"group by p.category_name "+
				"order by p.category_name";
	}
}
