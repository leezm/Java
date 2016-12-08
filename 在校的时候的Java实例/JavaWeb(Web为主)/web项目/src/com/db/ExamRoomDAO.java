package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import com.domain.AbstractData;
import com.domain.ExamRoom;

public class ExamRoomDAO extends AbstractDAO {

	@Override
	public int addRecords(ArrayList<AbstractData> datas, Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstm = null;
		String sql = "insert into examrooms (examroom_id,examroom_name) values(?,?)";
		int count = 0;
		
		try{			
			pstm = conn.prepareStatement(sql);
			int amt = datas.size();
			for(int index = 0; index < amt; index++){
				ExamRoom exam = (ExamRoom)datas.get(index);
				pstm.setString(1, exam.getExamroom_id());
				pstm.setString(2, exam.getExamroom_name());
				
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
		String sql = "delete examrooms where examroom_id=?";
		int count = 0;
		try{			
			pstm = conn.prepareStatement(sql);
			int amt = datas.size();
			for(int index = 0; index < amt; index++){
				ExamRoom exam = (ExamRoom)datas.get(index);
				pstm.setString(1, exam.getExamroom_id());
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
		String sql = "update examrooms set examroom_name=? where examroom_id=?";
		int count = 0;
		try{			
			pstm = conn.prepareStatement(sql);
			int amt = datas.size();
			for(int index = 0; index < amt; index++){
				ExamRoom exam = (ExamRoom)datas.get(index);
				pstm.setString(1, exam.getExamroom_name());
				pstm.setString(2, exam.getExamroom_id());
				
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
		String sql = "select examroom_id, examroom_name from examrooms";
		ArrayList<AbstractData> datas = new ArrayList<AbstractData>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				ExamRoom exam = new ExamRoom();
				exam.setExamroom_id(rs.getString(1));
				exam.setExamroom_name(rs.getString(2));
				
				datas.add(exam);
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
		String sql = "select examroom_id,examroom_name from examrooms";
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
		String sql = "select examroom_id as ¿¼³¡±àºÅ,examroom_name as ¿¼³¡Ãû³Æ from examrooms";
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
			
			titles[cols] = "Ìí¼Ó";
			titles[cols + 1] = "É¾³ý";
			titles[cols + 2] = "ÐÞ¸Ä";
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
