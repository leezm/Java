package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import com.domain.AbstractData;
import com.domain.Grade;

public class GradeDAO extends AbstractDAO {


	@Override
	public int addRecords(ArrayList<AbstractData> datas, Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstm = null;
		String sql = "insert into grades (teacher_grade,grade_name) values(?,?)";
		int count = 0;
		
		try{			
			pstm = conn.prepareStatement(sql);
			int amt = datas.size();
			for(int index = 0; index < amt; index++){
				Grade grade = new Grade();
				pstm.setByte(1, grade.getTeacher_grade());
				pstm.setString(2, grade.getGrade_name());
				
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
		String sql = "delete grades where teacher_grade=?";
		int count = 0;
		try{			
			pstm = conn.prepareStatement(sql);
			int amt = datas.size();
			for(int index = 0; index < amt; index++){
				Grade grade = (Grade)datas.get(index);
				pstm.setByte(1,grade.getTeacher_grade());
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
		String sql = "update grades set grade_name=? where teacher_grade=?";
		int count = 0;
		try{			
			pstm = conn.prepareStatement(sql);
			int amt = datas.size();
			for(int index = 0; index < amt; index++){
				Grade grade = (Grade)datas.get(index);
				
				pstm.setString(1,grade.getGrade_name());
				pstm.setByte(2,grade.getTeacher_grade());
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
		String sql = "select teacher_grade,grade_name from grades";
		ArrayList<AbstractData> datas = new ArrayList<AbstractData>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				Grade grade = new Grade();
				grade.setTeacher_grade(rs.getByte(1));
				grade.setGrade_name(rs.getString(2));
				
				datas.add(grade);
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
		String sql = "select teacher_grade,grade_name from grades";
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
		String sql = "select teacher_grade as 教师等级,grade_name as 等级名称  from grades";
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
