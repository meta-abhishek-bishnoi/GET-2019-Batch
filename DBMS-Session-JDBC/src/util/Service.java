/**
 * 
 */
package util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserOrder;

public class Service {
	Connector connector = new Connector();
	/**
	 * 
	 * @param userid
	 * @return
	 */
	public List<UserOrder> getUserShhipedOrders(int userid){
		List<UserOrder> result = new ArrayList<UserOrder>();
		String query = Query.getQueryUserShippedOrders(userid);
		try(Connection connect = connector.getConnection();
			PreparedStatement preparedStatement = connect.prepareStatement(query)){
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					int id = resultSet.getInt( "ID" );
					String timestamp = resultSet.getTimestamp( "ORDER_TIME" ).toString();
					double amount = resultSet.getDouble( "AMOUNT" );
					result.add(new UserOrder(id,timestamp,amount));
				}
			}catch( SQLException sql ){
				sql.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		return result;
	}
	/**
	 * 
	 * @param urls
	 * @param productId
	 * @return
	 */
	public boolean addImage(List<String> urls, int productId){
		String query = Query.getInsertProductImageQuery();
		try(Connection connect = connector.getConnection();
			PreparedStatement preparedStatement = connect.prepareStatement(query)){
				connect.setAutoCommit(false);
				for(String url : urls){
					preparedStatement.setString(1, url);
					preparedStatement.setInt(2, productId);
					preparedStatement.addBatch();
				}
				preparedStatement.executeBatch();
				connect.commit();
		} catch (SQLException sql) {
			sql.printStackTrace();
		}
		return true;
	}
}
