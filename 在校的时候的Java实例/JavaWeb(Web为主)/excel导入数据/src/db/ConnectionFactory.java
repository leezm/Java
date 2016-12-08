package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection getConnection(String url,String name,String passwd){
		Connection con = null;
		String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		try{
			Class.forName(className);
			con = DriverManager.getConnection(url, name, passwd);
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return con;
	}
}
