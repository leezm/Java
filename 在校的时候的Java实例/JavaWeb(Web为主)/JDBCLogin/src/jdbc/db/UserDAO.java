package jdbc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class UserDAO {
	protected String url = "jdbc:sqlserver://localhost:1433;databasename = WebDB";
	protected String username = "sa";
	protected String pswd = "1203";
	
	public static final byte SUCCESS = 10;
	public static final byte ISEXIST = 20;
	public static final byte OTHERERROR = 30;
	
	//◊¢≤·”√ªß
	public int Register(String name, String password){
		
		String sql = "insert into Users (user_name,user_pswd) values (?,?)";
		String searchSQL = "select user_name from Users where user_name=?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		PreparedStatement searchPSTM = null;
		ResultSet rs = null;
		byte value = UserDAO.OTHERERROR;
		
		try{
			conn = ConnectionFactory.getConnection(url, username, pswd);
			
			searchPSTM = conn.prepareStatement(searchSQL);
			searchPSTM.setString(1, username);
			rs = searchPSTM.executeQuery();
			if(rs.next()){
				value = UserDAO.ISEXIST;
			}else{
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, name);
				pstm.setString(2, password);
				int result = pstm.executeUpdate();
				if(result > 0){
					value = UserDAO.SUCCESS;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(searchPSTM != null){
					searchPSTM.close();
				}
				if(pstm != null){
					pstm.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(Exception e){
				
			}
		}
		
		return value;
	}
	
	
	//≤È’“
	public User authenticate(String name, String password){
		String sql = "select user_name, user_password from Users where user_name=? and user_password=?";
		User user = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = ConnectionFactory.getConnection(url, username, pswd);
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			if(rs.next()){
				user = new User(name, password);
			}
		}catch(Exception e){
			
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(pstm != null){
					pstm.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(Exception e){
				
			}
		}
		
		return user;
	}
	
}
