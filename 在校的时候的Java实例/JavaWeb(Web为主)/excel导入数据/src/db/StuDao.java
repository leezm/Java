package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import model.AbstractData;
import model.Students;

public class StuDao extends AbstractDao{
	
	@Override
	public int addRecords(ArrayList<AbstractData> datas) {
		// TODO Auto-generated method stub
		int amount = 0;
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = "insert into students (examId,stu_name,stu_sex,stu_birthId,stu_birthname,stu_classname," +
				"stu_majorId,stu_majorname,stu_learnyear,stu_grade,stu_DZBY,stu_nation,stu_politics,stu_HuKou,stu_JG,stu_type," +
				"stu_state) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			psmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int i = 0;i < count;i++){
				Students stu = (Students) datas.get(i);
				psmt.setString(1, stu.getExamId());
				psmt.setString(2, stu.getStu_name());
				psmt.setBoolean(3, stu.isStu_sex());  //*****
				psmt.setString(4, stu.getStu_birthId());
				psmt.setDate(5, stu.getStu_birthdate());
				psmt.setString(6, stu.getStu_classname());
				psmt.setString(7, stu.getStu_majorId());
				psmt.setString(8, stu.getStu_majorname());
				psmt.setString(9, stu.getStu_learnyear());
				psmt.setString(10, stu.getStu_grade());
				psmt.setDate(11, stu.getStu_DZBY());
				psmt.setString(12, stu.getStu_nation());
				psmt.setString(13, stu.getStu_politics());
				psmt.setString(14, stu.getStu_HuKou());
				psmt.setString(15, stu.getStu_JG());
				psmt.setString(16, stu.getStu_type());
				psmt.setString(17, stu.getStu_state());
				psmt.addBatch();
			}
			int[] lenamount = psmt.executeBatch();
			con.commit();
			con.setAutoCommit(old);
			for(int i = 0;i < lenamount.length;i++){
				amount += lenamount[i];
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
		String sql = "delete Students where examId = ?";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int i = 0;i < count;i++){
				Students stu = (Students) datas.get(i);
				psmt.setString(1, stu.getExamId());
				psmt.addBatch();
			}
			int[] lenamount = psmt.executeBatch();
			con.commit();
			con.setAutoCommit(old);
			for(int i = 0;i < lenamount.length;i++){
				amount+=lenamount[i];
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
		String sql = "update Students set stu_name = ?,stu_sex = ?,stu_birthId = ?,stu_birthname = ?,stu_classname = ?," +
				"stu_majorId = ?,stu_majorname = ?,stu_learnyear = ?,stu_grade = ?,stu_DZBY = ?,stu_nation = ?," +
				"stu_politics = ?,stu_HuKou = ?,stu_JG = ?,stu_type = ?,stu_state = ?" +
				"where examId = ?";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			psmt = con.prepareStatement(sql);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int i = 0;i < count;i++){
				Students stu = (Students) datas.get(i);
				psmt.setString(1, stu.getExamId());
				psmt.setString(2, stu.getStu_name());
				psmt.setBoolean(3, stu.isStu_sex());  //*****
				psmt.setString(4, stu.getStu_birthId());
				psmt.setDate(5, stu.getStu_birthdate());
				psmt.setString(6, stu.getStu_classname());
				psmt.setString(7, stu.getStu_majorId());
				psmt.setString(8, stu.getStu_majorname());
				psmt.setString(9, stu.getStu_learnyear());
				psmt.setString(10, stu.getStu_grade());
				psmt.setDate(11, stu.getStu_DZBY());
				psmt.setString(12, stu.getStu_nation());
				psmt.setString(13, stu.getStu_politics());
				psmt.setString(14, stu.getStu_HuKou());
				psmt.setString(15, stu.getStu_JG());
				psmt.setString(16, stu.getStu_type());
				psmt.setString(17, stu.getStu_state());
				psmt.addBatch();
			}
			int[] len = psmt.executeBatch();
			con.commit();
			con.setAutoCommit(old);
			for(int i = 0;i < len.length;i++){
				amount += len[i];
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
	
	public String[] getColumnName(String[] names){
		String[] columnNames = new String[names.length];
		for(int i = 0;i < names.length;i++){
			columnNames[i] = names[i];
		}
		columnNames[names.length] = "Ìí¼Ó";
		columnNames[names.length+1] = "É¾³ý ";
		columnNames[names.length+2] = "ÐÞ¸Ä";
		return columnNames;
	}
}
