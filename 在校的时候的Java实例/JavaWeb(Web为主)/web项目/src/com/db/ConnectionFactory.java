package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;

import sun.jdbc.odbc.ee.DataSource;

public class ConnectionFactory {

/*	public static Connection getConnection(){
		Connection conn = null;
		try{
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/testDB");
			conn = ds.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	*/
	public static Connection getConnection(){
		Connection conn = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=testdb3", "sa", "9925");
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}
