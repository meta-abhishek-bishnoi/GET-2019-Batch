/**
 * This Connector Class is used to create a connection
 * @author Abhishek Bishnoi
 * @since Aug 16, 2019
 */
package com.metacube.util;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	/**
	 * this function establish a JDBC Connection
	 * @return Object Of Connection
	 * @throws IOException 
	 * @throws ClassNotFoundException any class is missing from enviornment
	 * @throws SQLException when some Exception occurs in SQL queries
	 */
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException{
		Connection connect = null;
		String url = "jdbc:mysql://localhost:3306/shopping"; 
		String username = "root";
		String password = "1234";
		/**
		 * establishing connection
		 */
		Class.forName( "com.mysql.jdbc.Driver" );
		connect = DriverManager.getConnection(url,username,password);
		return connect;
	}
}
