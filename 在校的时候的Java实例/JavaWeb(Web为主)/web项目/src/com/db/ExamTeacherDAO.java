package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.domain.AbstractData;
import com.domain.ExamTeacher;
import com.domain.Teacher;

public class ExamTeacherDAO extends AbstractDAO {

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

	@Override
	public String[] getColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getTitles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AbstractData> getAllRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addRecords(ArrayList<AbstractData> datas, Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRecords(ArrayList<AbstractData> datas, Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRecords(ArrayList<AbstractData> datas, Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int addRecords(ArrayList<AbstractData> datas) {
		// TODO Auto-generated method stub
		PreparedStatement pstm = null;
		String sql = "insert into examteachers (examroom_id,teacher_id,date) values(?,?,?)";
		int count = 0;
		Connection conn = null;
		
			conn = ConnectionFactory.getConnection();
		try{			
			pstm = conn.prepareStatement(sql);
			int amt = datas.size();
			for(int index = 0; index < amt; index++){
				ExamTeacher et = (ExamTeacher)datas.get(index);
				pstm.setString(1,et.getExamroom_id());
				pstm.setString(2, et.getTeacher_id());
				pstm.setString(3, et.getDate());
				
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

}
