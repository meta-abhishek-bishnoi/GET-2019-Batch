/**
 * This Connector Class is used to create a connection
 * @author Abhishek Bishnoi
 * @since Aug 16, 2019
 */
package util;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	/**
	 * this function establish a JDBC Connection
	 * @return Object Of Connection
	 * @throws ClassNotFoundException any class is missing from enviornment
	 * @throws SQLException when some Exception occurs in SQL queries
	 */
	public Connection getConnection(){
		Connection connect = null;
		LoadMessages message = null;
		/**
		 * getting username password from .properties file 
		 * using LoadMessages class
		 */
		try { //
			message = new LoadMessages( "connection.properties" );
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String url = message.getMessage( "url" ); 
		String username = message.getMessage( "username" );
		String password = message.getMessage( "password" );
		/**
		 * establishing connection
		 */
		try { //
				Class.forName( "com.mysql.jdbc.Driver" );
				connect = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}	
		return connect;
	}
}
