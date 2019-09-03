package com.metacube.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.metacube.util.Connector;
import com.metacube.util.Query;

public class DeleteProductDAO {
	public static boolean deleteProduct(int orderId){
		String query = Query.deleteProduct();
		boolean result = true;
		int rowsEffected=0;
		try(Connection connect = Connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setInt(1, orderId);
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
