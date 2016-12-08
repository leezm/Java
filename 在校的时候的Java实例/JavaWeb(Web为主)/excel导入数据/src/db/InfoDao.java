package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.AbstractData;
import model.Informations;
import model.Role;

public class InfoDao extends AbstractDao {

	@Override
	public int addRecords(ArrayList<AbstractData> datas) {
		// TODO Auto-generated method stub
		int amount = 0;
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = "insert into informations (info_examId,info_DZBY,info_DZBYBAB,info_englishscore,info_birthId,info_photo,info_BKBY,info_XS,info_exam,info_DZCJD) values (?,?,?,?,?,?,?,?,?,?)";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				Informations info = (Informations) datas.get(index);
				psmt.setString(1, info.getInfo_examId());
				psmt.setString(2, info.getInfo_DZBY());
				psmt.setString(3, info.getInfo_DZBYBAB());
				psmt.setString(4, info.getInfo_englishscore());
				psmt.setString(5, info.getInfo_birthId());
				psmt.setString(6, info.getInfo_photo());
				psmt.setString(7, info.getInfo_BKBY());
				psmt.setString(8, info.getInfo_XS());
				psmt.setString(9, info.getInfo_exam());
				psmt.setString(10, info.getInfo_DZCJD());
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
			}catch(Exception ex){
				ex.printStackTrace();
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
		String sql = "delete informations where info_examId = ?";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				Informations info = (Informations)datas.get(index);
				pstm.setString(1, info.getInfo_birthId());
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
		String sql = "update Roles set info_DZBY = ?,info_DZBYBAB = ?,info_englishscore = ?,info_birthId = ?,info_photo = ?,info_BKBY = ?,info_XS = ?,info_exam = ?,info_DZCJD = ? " +
				"where info_examId = ?";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				Informations info = (Informations) datas.get(index);
				psmt.setString(1, info.getInfo_examId());
				psmt.setString(2, info.getInfo_DZBY());
				psmt.setString(3, info.getInfo_DZBYBAB());
				psmt.setString(4, info.getInfo_englishscore());
				psmt.setString(5, info.getInfo_birthId());
				psmt.setString(6, info.getInfo_photo());
				psmt.setString(7, info.getInfo_BKBY());
				psmt.setString(8, info.getInfo_XS());
				psmt.setString(9, info.getInfo_exam());
				psmt.setString(10, info.getInfo_DZCJD());
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

	public String[] columnNames(String[] names){
		String[] columnNames = new String[names.length];
		for(int i = 0;i < names.length;i++){
			columnNames[i] = names[i];
		}
		columnNames[names.length] = "Ìí¼Ó";
		columnNames[names.length+1] = "É¾³ý";
		columnNames[names.length+2] = "ÐÞ¸Ä";
		return columnNames;
	}
}
