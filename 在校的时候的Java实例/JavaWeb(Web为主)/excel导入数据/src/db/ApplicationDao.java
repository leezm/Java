package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.AbstractData;
import model.Applications;
import model.User;

public class ApplicationDao extends AbstractDao {

	@Override
	public int addRecords(ArrayList<AbstractData> datas) {
		// TODO Auto-generated method stub
		int amount = 0;
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = "insert into applications (name,sex,learnyear,id,birthdate,nation,politics,HuKou,JG,contactWay,grade,DZBY,BMQR) " +
				"values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				Applications app = (Applications)datas.get(index);
				psmt.setString(1, app.getName());
				psmt.setBoolean(2, app.isSex());
				psmt.setString(3, app.getLearnyear());
				psmt.setString(4, app.getId());
				psmt.setDate(5, app.getBirthdate());
				psmt.setByte(6, app.getNation());
				psmt.setByte(7, app.getPolitics());
				psmt.setString(8, app.getHuKou());
				psmt.setString(9, app.getJG());
				psmt.setByte(10, app.getContactWay());
				psmt.setString(11, app.getGrade());
				psmt.setDate(12, app.getDZBY());
				psmt.setBoolean(13, app.isBMQR());
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
		String sql = "delete applications id = ?";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				Applications app = (Applications)datas.get(index);
				psmt.setString(1, app.getId());
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
		String sql = "update applications set name = ?,sex = ?,learnyear = ?,birthdate = ?,nation = ?,politics = ?," +
				" Hukou = ?,JG = ?,contactWay = ?,grade = ?,DZBY = ?,BMQR = ? where id = ?";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				Applications app = (Applications)datas.get(index);
				psmt.setString(1, app.getName());
				psmt.setBoolean(2, app.isSex());
				psmt.setString(3, app.getLearnyear());
				psmt.setString(4, app.getId());
				psmt.setDate(5, app.getBirthdate());
				psmt.setByte(6, app.getNation());
				psmt.setByte(7, app.getPolitics());
				psmt.setString(8, app.getHuKou());
				psmt.setString(9, app.getJG());
				psmt.setByte(10, app.getContactWay());
				psmt.setString(11, app.getGrade());
				psmt.setDate(12, app.getDZBY());
				psmt.setBoolean(13, app.isBMQR());
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
		String[] columnNames = new String[names.length+3];
		for(int i = 0;i < names.length;i++){
			columnNames[i] = names[i];
		}
		columnNames[names.length] = "Ìí¼Ó";
		columnNames[names.length+1] = "É¾³ý";
		columnNames[names.length+2] = "ÐÞ¸Ä";
		return columnNames;
	}
}
