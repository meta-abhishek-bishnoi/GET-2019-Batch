/**
* This Servlet is a controller for Adding Product DAO
* @author Abhishek Bishnoi
* @since Sept 2,2019
*/
package com.metacube.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.util.Connector;
import com.metacube.util.Query;

public class AddProductsDAO {
	/**
	*	this function is used to add product into cart (order in db table) 
	* 	@param productCode is product id
	* 	@return boolean value for success or not 
	*/
	public static boolean orderProduct(int productCode){
		int quantity = getProductCount(productCode);
		boolean result = true;
		if(quantity==0){
			result = addProduct(productCode,1);
		}else{
			result = updateProduct(productCode,quantity+1);
		}
		return true ;	
	}
	/**
	* @param productCode is product id
	* @return product count available into cart(in db order)
	*/
	public static int getProductCount(int productCode){
		int resultCount=0;
		String query = Query.checkOrderProduct();
		try(Connection connect = Connector.getConnection();
			PreparedStatement preparedStatement = connect.prepareStatement(query);){
			preparedStatement.setInt(1, productCode);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int count = resultSet.getInt("product_count");
				if(count>0){
					resultCount = resultSet.getInt("quantity");
				}
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			return 0;
		}
		return resultCount;
	}
	/**
	* @param productCode as product id 
	* @param quantity 
	* @return boolean for success of result
	*/
	public static boolean addProduct(int productCode, int quantity){
		String query = Query.insertOrderProduct();
		boolean result = true;
		try(Connection connect = Connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setInt(1, productCode);
			preparedStatement.setInt(2, quantity);
			preparedStatement.execute();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return result;
	}
	/**
	* @param productCode as product id 
	* @param quantity 
	* @return boolean for success of result
	*/
	public static boolean updateProduct(int productCode, int quantity){
		String query = Query.updateOrderProduct();
		boolean result = true;
		int rowsEffected=0;
		try(Connection connect = Connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, productCode);
			rowsEffected = preparedStatement.executeUpdate();
			if(rowsEffected==0){
				result = false;
			}else{
				result = true;
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return result;
	}
}
