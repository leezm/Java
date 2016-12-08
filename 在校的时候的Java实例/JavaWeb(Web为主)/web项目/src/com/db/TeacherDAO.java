package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import com.domain.AbstractData;
import com.domain.Teacher;

import net.sf.json.JSONObject;

public class TeacherDAO extends AbstractDAO {

	@Override
	public ArrayList<AbstractData> getOptions() {
		// TODO Auto-generated method stub
		AbstractDAO gradeDao = new GradeDAO();
		return gradeDao.getAllRecords();
	}

	@Override
	public String[] getOptionNames() {
		// TODO Auto-generated method stub
		AbstractDAO gradeDao = new GradeDAO();
		String[] optionNames =gradeDao.getColumnNames();
		return optionNames;
	}

	@Override
	public int addRecords(ArrayList<AbstractData> datas, Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstm = null;
		String sql = "insert into teachers (teacher_id,teacher_name,teacher_group,teacher_grade) values(?,?,?,?)";
		int count = 0;
		try{			
			pstm = conn.prepareStatement(sql);
			int amt = datas.size();
			for(int index = 0; index < amt; index++){
				Teacher teacher = (Teacher)datas.get(index);
				pstm.setString(1, teacher.getTeacher_id());
				pstm.setString(2, teacher.getTeacher_name());
				pstm.setString(3, teacher.getTeacher_group());
				pstm.setByte(4,teacher.getTeacher_grade());
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
		String sql = "delete teachers where teacher_id=?";
		int count = 0;
		try{			
			pstm = conn.prepareStatement(sql);
			int amt = datas.size();
			for(int index = 0; index < amt; index++){
				Teacher teacher=(Teacher)datas.get(index);
				pstm.setString(1, teacher.getTeacher_id());
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
		String sql = "update teachers set teacher_name=?,teacher_group=?,teacher_grade=? where teacher_id=?";
		int count = 0;
		try{			
			pstm = conn.prepareStatement(sql);
			int amt = datas.size();
			for(int index = 0; index < amt; index++){
				Teacher teacher=(Teacher)datas.get(index);
				pstm.setString(1, teacher.getTeacher_name());
				pstm.setString(2, teacher.getTeacher_group());
				pstm.setByte(3, teacher.getTeacher_grade());
				pstm.setString(4,teacher.getTeacher_id());
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
		String sql = "select teacher_id, teacher_name, teacher_group,teacher_grade from teachers";
		ArrayList<AbstractData> datas = new ArrayList<AbstractData>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				Teacher teacher = new Teacher();
				teacher.setTeacher_id(rs.getString(1));
				teacher.setTeacher_name(rs.getString(2));
				teacher.setTeacher_group(rs.getString(3));
				teacher.setTeacher_grade(rs.getByte(4));
				datas.add(teacher);
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
	public ArrayList<AbstractData> getGroupRecords() {
		// TODO Auto-generated method stub
		String sql = "select teacher_id, teacher_name, teacher_group,teacher_grade from teachers where teacher_grade = \'"+"0"+"\' or teacher_grade = \' "+"1"+"\'";
		ArrayList<AbstractData> datas = new ArrayList<AbstractData>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				Teacher teacher = new Teacher();
				teacher.setTeacher_id(rs.getString(1));
				teacher.setTeacher_name(rs.getString(2));
				teacher.setTeacher_group(rs.getString(3));
				teacher.setTeacher_grade(rs.getByte(4));
				datas.add(teacher);
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
		String sql = "select teacher_id,teacher_name,teacher_group,teacher_grade from teachers";
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
		String sql = "select teacher_id as 教师编号,teacher_name as 教师姓名,teacher_group as 教师组,teacher_grade as 教师等级  from teachers";
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
	public ArrayList<String> getNames() {
		// TODO Auto-generated method stub
		String sql = "select  teacher_name from teachers";
		ArrayList<String> datas = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				
				datas.add(rs.getString(1));
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
	public String getNameJSONText(){
		
		ArrayList<String> names = getNames();
		
	
		
		
		JSONObject jsonobj = new JSONObject();
		
		
		jsonobj.element("names", names);
		
		return jsonobj.toString();
	}
}
