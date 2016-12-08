package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;


import com.domain.AbstractData;
import com.domain.User;

public class UserDAO extends AbstractDAO {

	@Override
	public ArrayList<AbstractData> getOptions() {
		// TODO Auto-generated method stub
		AbstractDAO roleDao = new RoleDAO();
		return roleDao.getAllRecords();
	}

	@Override
	public String[] getOptionNames() {
		// TODO Auto-generated method stub
		AbstractDAO roleDao = new RoleDAO();
		String[] optionNames = roleDao.getColumnNames();
		return optionNames;
	}

	@Override
	public int addRecords(ArrayList<AbstractData> datas, Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstm = null;
		String sql = "insert into users (user_name,user_password,user_role) values(?,?,?)";
		int count = 0;
		try{			
			pstm = conn.prepareStatement(sql);
			int amt = datas.size();
			for(int index = 0; index < amt; index++){
				User user = (User)datas.get(index);
				pstm.setString(1, user.getUser_name());
				pstm.setString(2, user.getUser_password());
				pstm.setByte(3, user.getUser_role());
				pstm.addBatch();
			}
			int[] result = pstm.executeBatch();
			
			for(int i = 0; i < result.length; i++){
				count += result[i];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstm != null){
					pstm.close();
				}
			}catch(Exception e){}
			
		}
		return count;
	}

	@Override
	public int deleteRecords(ArrayList<AbstractData> datas, Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstm = null;
		String sql = "delete users where user_name=?";
		int count = 0;
		try{			
			pstm = conn.prepareStatement(sql);
			int amt = datas.size();
			for(int index = 0; index < amt; index++){
				User user = (User)datas.get(index);
				pstm.setString(1, user.getUser_name());
				pstm.addBatch();
			}
			int[] result = pstm.executeBatch();
			for(int i = 0; i < result.length; i++){
				count += result[i];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstm != null){
					pstm.close();
				}
			}catch(Exception e){}
			
		}
		return count;
	}
	@Override
	public int updateRecords(ArrayList<AbstractData> datas, Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstm = null;
		String sql = "update users set user_password=?,user_role=? where user_name=?";
		int count = 0;
		try{			
			pstm = conn.prepareStatement(sql);
			int amt = datas.size();
			for(int index = 0; index < amt; index++){
				User user = (User)datas.get(index);
				pstm.setString(1, user.getUser_password());
				pstm.setByte(2, user.getUser_role());
				pstm.setString(3, user.getUser_name());
				pstm.addBatch();
			}
			int[] result = pstm.executeBatch();
			
			for(int i = 0; i < result.length; i++){
				count += result[i];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstm != null){
					pstm.close();
				}
			}catch(Exception e){}
			
		}
		return count;
	}

	@Override
	public ArrayList<AbstractData> getAllRecords() {
		// TODO Auto-generated method stub
		String sql = "select user_name, user_password, user_role from users";
		ArrayList<AbstractData> datas = new ArrayList<AbstractData>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUser_name(rs.getString(1));
				user.setUser_password(rs.getString(2));
				user.setUser_role(rs.getByte(3));
				datas.add(user);
			}
		}catch(Exception e){
			
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
			}catch(Exception e){}
		}
		
		return datas;
	}

	@Override
	public String[] getColumnNames() {
		// TODO Auto-generated method stub
		String sql = "select user_name,user_password,user_role from users";
		String[] columnNames = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			columnNames = new String[cols + 3];
			for(int col = 0; col < cols; col++){
				columnNames[col] = rsmd.getColumnName(col + 1);
			}
			
			columnNames[cols] = "add";
			columnNames[cols + 1] = "delete";
			columnNames[cols + 2] = "update";
		}catch(Exception e){
			e.printStackTrace();
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
			}catch(Exception e){}
		}
		return columnNames;
	}

	@Override
	public String[] getTitles() {
		// TODO Auto-generated method stub
		String sql = "select user_name as 用户名,user_password as 密码,user_role as 角色  from users";
		String[] titles = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			titles = new String[cols + 3];
			for(int col = 0; col < cols; col++){
				titles[col] = rsmd.getColumnLabel(col + 1);
			}
			
			titles[cols] = "添加";
			titles[cols + 1] = "删除";
			titles[cols + 2] = "修改";
		}catch(Exception e){
			e.printStackTrace();
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
			}catch(Exception e){}
		}
		return titles;
	}
	
	public User checkUser(String username, String pwd, byte role) {
		// TODO Auto-generated method stub
		
		String sql = "select user_name, user_password, user_role from users where user_name = \'" + username + "\' and user_password = \'"+pwd+"\' and user_role =\'"+role+"\'";
		User user = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				user = new User();
				user.setUser_name(rs.getString(1));
				user.setUser_password(rs.getString(2));
				user.setUser_role(rs.getByte(3));
				
			}
		}catch(Exception e){
			
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
			}catch(Exception e){}
		}
		
		return user;
	}
}
