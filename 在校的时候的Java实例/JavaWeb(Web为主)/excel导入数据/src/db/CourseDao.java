package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.AbstractData;
import model.Courses;
import model.Role;
import model.User;

public class CourseDao extends AbstractDao {

	@Override
	public int addRecords(ArrayList<AbstractData> datas) {
		// TODO Auto-generated method stub
		int amount = 0;
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = "insert into courses (course_id,course_name,course_type,course_nature,course_xf,course_startdate) value (?,?,?,?,?,?)";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int size = datas.size();
			for(int index = 0;index < size;index++){
				Courses cou = (Courses)datas.get(index);
				psmt.setString(1, cou.getCourse_id());
				psmt.setString(2, cou.getCourse_name());
				psmt.setString(3, cou.getCourse_type());
				psmt.setString(4,cou.getCourse_nature());
				psmt.setInt(5, cou.getCourse_xf());
				psmt.setString(6, cou.getCourse_startdate());
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
		PreparedStatement pstm = null;
		String sql = "delete courses where course_id = ?";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				Courses cou = (Courses)datas.get(index);
				pstm.setString(1, cou.getCourse_id());
				pstm.addBatch();
			}
			int[] result = pstm.executeBatch();
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
				if(pstm != null){
					pstm.close();
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
		String sql = "update courses set course_name = ? where course_id = ?";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				Courses cou = (Courses)datas.get(index);
				psmt.setString(1, cou.getCourse_id());
				psmt.setString(2, cou.getCourse_name());
				psmt.setString(3, cou.getCourse_type());
				psmt.setString(4,cou.getCourse_nature());
				psmt.setInt(5, cou.getCourse_xf());
				psmt.setString(6, cou.getCourse_startdate());
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
	
	public String[] getColumnNames(String[] names){
		String[] ColunmNames = new String[names.length];
		for(int i = 0;i < names.length;i++){
			ColunmNames[i] = names[i];
		}
		ColunmNames[names.length] = "Ìí¼Ó";
		ColunmNames[names.length+1] = "É¾³ý";
		ColunmNames[names.length+2] = "ÐÞ¸Ä";
		return ColunmNames;
	}
}
