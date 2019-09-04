/**
* This DAO class is for Loading Products from DB
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

import com.metacube.model.Product;
import com.metacube.util.Connector;
import com.metacube.util.Query;

public class LoadProductDAO {
	/**
	* @return List of Project Objects
	*/
	public static List<Product> loadProducts(){
		Connector connector = new Connector();
		String query = Query.loadProducts();
		List<Product> products = new ArrayList<Product>();
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int productCode = resultSet.getInt("code");
				String productType = resultSet.getString("type");
				String productName = resultSet.getString("name");
				double price = resultSet.getDouble("price");
				products.add(new Product(productCode, productType, productName, price));
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		return products;
	}
}
