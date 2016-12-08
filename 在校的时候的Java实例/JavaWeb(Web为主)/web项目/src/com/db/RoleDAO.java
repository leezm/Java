package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import com.domain.AbstractData;
import com.domain.Role;

public class RoleDAO extends AbstractDAO {


	@Override
	public int addRecords(ArrayList<AbstractData> datas, Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstm = null;
		String sql = "insert into roles (user_role,role_name) values(?,?)";
		int count = 0;
		
		try{			
			pstm = conn.prepareStatement(sql);
			int amt = datas.size();
			for(int index = 0; index < amt; index++){
				Role role = new Role();
				pstm.setByte(1, role.getUser_role());
				pstm.setString(2, role.getRole_name());
				
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
		String sql = "delete roles where user_role=?";
		int count = 0;
		try{			
			pstm = conn.prepareStatement(sql);
			int amt = datas.size();
			for(int index = 0; index < amt; index++){
				Role role = (Role)datas.get(index);
				pstm.setByte(1,role.getUser_role());
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
		String sql = "update roles set role_name=? where user_role=?";
		int count = 0;
		try{			
			pstm = conn.prepareStatement(sql);
			int amt = datas.size();
			for(int index = 0; index < amt; index++){
				Role role = (Role)datas.get(index);
				
				pstm.setString(1, role.getRole_name());
				pstm.setByte(2,role.getUser_role());
				pstm.addBatch();
				
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
		String sql = "select user_role,role_name from roles";
		ArrayList<AbstractData> datas = new ArrayList<AbstractData>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				Role role = new Role();
				role.setUser_role(rs.getByte(1));
				role.setRole_name(rs.getString(2));
				
				datas.add(role);
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
		String sql = "select user_role,role_name from roles";
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
			columnNames = new String[cols+3];
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
		String sql = "select user_role as 角色,role_name as 角色名称 from roles";
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

	@Override
	public ArrayList<AbstractData> getOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getOptionNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
