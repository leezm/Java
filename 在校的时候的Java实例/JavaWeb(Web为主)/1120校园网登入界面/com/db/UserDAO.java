package wang.com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import wang.com.helper.StudentScoreConstants;
import wang.com.model.Role;
import wang.com.model.User;

public class UserDAO {
	private String url = "jdbc:sqlserver://localhost:1433;databasename=test";
	private String username = "sa";
	private String password = "1122";
	
	public String editUsers(ArrayList<User> users){
		StringBuffer buffer = new StringBuffer();
		ArrayList<User> addList = new ArrayList<User>();
		ArrayList<User> deleteList = new ArrayList<User>();
		ArrayList<User> updateList = new ArrayList<User>();
		int count = users.size();
		for(int index = 0; index < count; index++){
			User user = users.get(index);
			byte oper_code = user.getOper_code();
			if(oper_code == StudentScoreConstants.ADD){
				addList.add(user);
			}else if(oper_code == StudentScoreConstants.DELETE){
				deleteList.add(user);
			}else if(oper_code == StudentScoreConstants.UPDATE){
				updateList.add(user);
			}
		}
		int add = addUsers(addList);
		int delete = deleteUsers(deleteList);
		int update = updateUsers(updateList);
		buffer.append("成功添加" + add + "条记录，成功删除" + delete + "条记录，成功修改" + update + "条记录");
		return buffer.toString();
	}
	public int addUsers(ArrayList<User> users){
		int amount = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "insert into users (user_name,user_password,user_role) values (?,?,?)";
		try{
			conn = ConnectionFactory.getConnection("jdbc:sqlserver://localhost:1433;databasename=test", "sa", "1122");
			pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			boolean old = conn.getAutoCommit();
			conn.setAutoCommit(false);
			
			int count = users.size();
			for(int index = 0; index < count; index++){
				User user = users.get(index);
				pstm.setString(1, user.getUser_name());
				pstm.setString(2, user.getUser_password());
				pstm.setByte(3, user.getUser_role());
				pstm.addBatch();
			}
			int[] result = pstm.executeBatch();
			conn.commit();
			conn.setAutoCommit(old);
			
			for(int i = 0; i < result.length; i++){
				amount += result[i];
			}
			
		}catch(Exception e){
			try{
				amount = 0;
				conn.rollback();
			}catch(Exception ex){
				
			}
			e.printStackTrace();
		}finally{
			try{
				if(pstm != null){
					pstm.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return amount;
	}
	public int deleteUsers(ArrayList<User> users){
		int amount = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "delete users where user_name=?";
		try{
			conn = ConnectionFactory.getConnection("jdbc:sqlserver://localhost:1433;databasename=test", "sa", "1122");
			pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			boolean old = conn.getAutoCommit();
			conn.setAutoCommit(false);
			
			int count = users.size();
			for(int index = 0; index < count; index++){
				User user = users.get(index);
				pstm.setString(1, user.getUser_name());
				pstm.addBatch();
			}
			int[] result = pstm.executeBatch();
			conn.commit();
			conn.setAutoCommit(old);
			
			for(int i = 0; i < result.length; i++){
				amount += result[i];
			}
			
		}catch(Exception e){
			try{
				amount = 0;
				conn.rollback();
			}catch(Exception ex){
				
			}
			e.printStackTrace();
		}finally{
			try{
				if(pstm != null){
					pstm.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return amount;
	}
	public int updateUsers(ArrayList<User> users){
		int amount = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "update users set user_password=?,user_role=? where user_name=?";
		try{
			conn = ConnectionFactory.getConnection("jdbc:sqlserver://localhost:1433;databasename=test", "sa", "1122");
			pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			boolean old = conn.getAutoCommit();
			conn.setAutoCommit(false);
			
			int count = users.size();
			for(int index = 0; index < count; index++){
				User user = users.get(index);
				pstm.setString(1, user.getUser_password());
				pstm.setByte(2, user.getUser_role());
				pstm.setString(3, user.getUser_name());
				pstm.addBatch();
			}
			int[] result = pstm.executeBatch();
			conn.commit();
			conn.setAutoCommit(old);
			
			for(int i = 0; i < result.length; i++){
				amount += result[i];
			}
			
		}catch(Exception e){
			try{
				amount = 0;
				conn.rollback();
			}catch(Exception ex){
				
			}
			e.printStackTrace();
		}finally{
			try{
				if(pstm != null){
					pstm.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return amount;
	}
	
	public User anthenticate(String name, String psw, byte User){
		User user = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select user_name,user_password,user_User from users where user_name=\'" + name + "\' and user_password=\'" + psw + "\' and user_User="  + User;
		
		try{
			conn = ConnectionFactory.getConnection(url, username, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				user = new User(rs.getString(1),rs.getString(2), rs.getByte(3));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}	
		}
		
		return user;
	}
	public ArrayList<User> getUsers(){
		ArrayList<User> users = new ArrayList<User>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select user_name,user_password,user_role from users";
		
		try{
			conn = ConnectionFactory.getConnection(url, username, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				User user = new User(rs.getString(1),rs.getString(2), rs.getByte(3));
				users.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}	
		}
		
		return users;
	}
	
	public String[] getColumnNames(){
		String[] columnNames = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select user_name as 用户名,user_password as 密码,user_role as 角色  from users";
		
		try{
			conn = ConnectionFactory.getConnection(url, username, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int size = rsmd.getColumnCount();
			columnNames = new String[size];
			
			for(int i = 0; i < size; i++){
				columnNames[i] = rsmd.getColumnLabel(i + 1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}	
		}
		
		return columnNames;
	}
}
