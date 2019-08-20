package consol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.Connector;

public class testConnection {
	public static void main(String[] args) {
		Connector connector = new Connector();
		String query = "Select order_id as ID, ordertime as TIME from orders";
		try(Connection connect = connector.getConnection();
			PreparedStatement preparedStatement = connect.prepareStatement(query)){
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int id = resultSet.getInt("ID");
				String name = resultSet.getTimestamp("TIME").toString();
				System.out.println(id+" "+name);
			}
		}catch(SQLException sql){
			sql.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
