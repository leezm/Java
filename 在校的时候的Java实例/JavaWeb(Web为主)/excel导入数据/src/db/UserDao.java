package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import model.AbstractData;
import model.User;

public class UserDao extends AbstractDao {
	@Override
	public int addRecords(ArrayList<AbstractData> datas) {
		// TODO Auto-generated method stub
		int amount = 0;
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = "insert into users (user_name,user_passwd,user_role) values (?,?,?)";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int size = datas.size();
			for(int index = 0;index < size;index++){
				User user = (User) datas.get(index);
				psmt.setString(1, user.getUser_name());
				psmt.setString(2, user.getUser_passwd());
				psmt.setByte(3, user.getUser_role());
				psmt.addBatch();
			}
			int[] result = psmt.executeBatch();
			con.commit();
			con.setAutoCommit(old);
			
			for(int i = 0;i < result.length;i++){
				amount += result[i];
			}
		}catch(Exception e){
			try{
				amount = 0;
				con.rollback();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try{
				if(psmt != null){
					psmt.close();
				}
				if(con != null){
					con.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return amount;
	}

	@Override
	public int deleteRecords(ArrayList<AbstractData> datas) {
		// TODO Auto-generated method stub
		int amount = 0;
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = "delete users where user_name = ?";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				User user = (User)datas.get(index);
				psmt.setString(1, user.getUser_name());
				psmt.addBatch();
			}
			int[] result = psmt.executeBatch();
			con.commit();
			con.setAutoCommit(old);
			
			for(int i = 0;i < result.length;i++){
				amount += result[i];
			}
		}catch(Exception e){
			try{
				amount = 0;
				con.rollback();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try{
				if(psmt != null){
					psmt.close();
				}
				if(con != null){
					con.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return amount;
	}

	@Override
	public int updateRecords(ArrayList<AbstractData> datas) {
		// TODO Auto-generated method stub
		int amount = 0;
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = "update users set user_passwd = ?,user_role = ? where user_name = ?";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				User user = (User)datas.get(index);
				psmt.setString(1, user.getUser_name());
				psmt.setString(2, user.getUser_passwd());
				psmt.setByte(3, user.getUser_role());
				psmt.addBatch();
			}
			int[] result = psmt.executeBatch();
			con.commit();
			con.setAutoCommit(old);
			
			for(int i = 0;i < result.length;i++){
				amount += result[i];
			}
		}catch(Exception e){
			try{
				amount = 0;
				con.rollback();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try{
				if(psmt != null){
					psmt.close();
				}
				if(con != null){
					con.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return amount;
	}

	//登录验证
	public User anthenticate(String name,String pw,byte role){
		User user = null;
		Connection con = null;
		Statement state = null;
		ResultSet rs = null;
		String sql = "select user_name,user_passwd,user_role from users where user_name = \'" + name + "\' " +
				"and user_passwd = \'" + pw + "\' " +
						"and user_role = \'" + role + "\'";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			state = con.createStatement();
			rs = state.executeQuery(sql);
			if(rs.next()){
				user = new User(rs.getString(1),rs.getString(2),rs.getByte(3));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(state != null){
					state.close();
				}
				if(con != null){
					con.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public ArrayList<User> getUsers(){
		ArrayList<User> users = new ArrayList<User>();
		Connection con = null;
		Statement state = null;
		ResultSet rs = null;
		String sql = "select user_name,user_passwd,user_role from users";
		
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			state = con.createStatement();
			rs = state.executeQuery(sql);
			while(rs.next()){
				User user = new User(rs.getString(1),rs.getString(2),rs.getByte(3));
				users.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(state != null){
					state.close();
				}
				if(con != null){
					con.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return users;
	}
	
	public String[] ColumnNames(String[] names){
		String[] columnNames = new String[names.length+3];
		for(int i = 0;i < names.length;i++){
			columnNames[i] = names[i];
		}
		columnNames[names.length] = "添加";
		columnNames[names.length+1] = "删除";
		columnNames[names.length+2] = "修改";
		return columnNames;
	}
}
