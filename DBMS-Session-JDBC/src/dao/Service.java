/**
 * This class contains service methods for question requirements
 * @author Abhishek Bishnoi
 * @since Aug 19, 2019
 */
package dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.CategoryCount;
import pojo.UserOrder;
import util.Connector;
import util.Query;

public class Service {
	Connector connector = new Connector();
	/**
	 * This function returns shipped order for a particular user id
	 * @param userid
	 * @return List of UserOrder
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
	 * this function is used to adding images for a product
	 * @param urls List of urls in String
	 * @param productId product id
	 * @return boolean value
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public boolean addImage(List<String> urls, int productId) throws ClassNotFoundException, IOException{
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
	/**
	 * deleting those products which are not sold more then one year (Soft delete)
	 * @return effected rows or deleted products
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public int deleteProductsMoreThenOneYear() throws ClassNotFoundException, IOException{
		String query = Query.getDeleteProductQuery();
		int effectedRow =0;
		try( Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query) ){
				effectedRow = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return effectedRow;
	}

	/**
	 * this function return List of CategoryCount in which they 
	 * contains parent category(Top Most) and their child counts
	 * @return List
	 */
	public List<CategoryCount> parentCategoryWithChildCount(){
		String query = Query.getParentCategoryWithChildCount();
		List<CategoryCount> result = new ArrayList<CategoryCount>();
		try(Connection connect = connector.getConnection();
			PreparedStatement preparedStatement = connect.prepareStatement(query)){
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					String categoryName = resultSet.getString( "NAME" );
					int childCount = resultSet.getInt( "COUNT" );
					result.add(new CategoryCount(categoryName,childCount));
				}
		}catch( SQLException sql ){
					sql.printStackTrace();
		}catch(Exception e){
					e.printStackTrace();
		}
		return result;		
	}
}
