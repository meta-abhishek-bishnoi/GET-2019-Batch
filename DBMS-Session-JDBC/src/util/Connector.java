/**
 * 
 */
package util;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	/**
	 * 
	 * @return
	 */
	public Connection getConnection(){
		Connection connect = null;
		LoadMessages message = null;
		try { //
			message = new LoadMessages( "connection.properties" );
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String url = message.getMessage( "url" ); //
		String username = message.getMessage( "username" );
		String password = message.getMessage( "password" );
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
