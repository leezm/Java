package jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public static Connection getConnection(String url, String name, String pswd){
		Connection connection = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, name, pswd);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}	
}
