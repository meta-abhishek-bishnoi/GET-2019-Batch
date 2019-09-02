package com.metacube.fasade;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.metacube.util.Connector;
import com.metacube.util.Query;

public class AddProducts {
	public static boolean getProductCount(int productCode){
		String insertProducct = Query.insertOrderProduct();
		Connector connector = new Connector();
		String query = Query.insertOrderProduct();
		boolean result = true;
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setInt(1, productCode);
			preparedStatement.setInt(2, 1);
			preparedStatement.execute();
		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
