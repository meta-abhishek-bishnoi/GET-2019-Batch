package com.metacube.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.util.Connector;
import com.metacube.util.Query;

public class AddProductsDAO {
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
