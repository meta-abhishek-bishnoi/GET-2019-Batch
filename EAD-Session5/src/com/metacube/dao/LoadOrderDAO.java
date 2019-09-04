/**
* This class is for Loading Cart Orders
* @author Abhishek Bishnoi
* @since Sept 2,2019
*/
package com.metacube.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.model.Order;
import com.metacube.util.Connector;
import com.metacube.util.Query;


public class LoadOrderDAO {
	/**
	* @return List of Cart Orders
	*/
	public static List<Order> loadOrders(){
		Connector connector = new Connector();
		String query = Query.loadOrders();
		List<Order> orders = new ArrayList<Order>();
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int orderId = resultSet.getInt("orderId");
				int productCode = resultSet.getInt("productCode");
				String productType = resultSet.getString("productType");
				String productName = resultSet.getString("productName");
				double productPrice = resultSet.getDouble("productPrice");
				int quantity = resultSet.getInt("quantity");
				orders.add(new Order(orderId, productCode, productType, productName, productPrice, quantity));
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		return orders;
	}
	/**
	* @return Cart Order by order id
	*/
	public static Order loadOrdersById(int orderId){
		Connector connector = new Connector();
		String query = Query.loadOrdersById();
		Order order = null;
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setInt(1, orderId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int order_Id = resultSet.getInt("orderId");
				int productCode = resultSet.getInt("productCode");
				String productType = resultSet.getString("productType");
				String productName = resultSet.getString("productName");
				double productPrice = resultSet.getDouble("productPrice");
				int quantity = resultSet.getInt("quantity");
				order = new Order(order_Id, productCode, productType, productName, productPrice, quantity);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		return order;
	}
}
