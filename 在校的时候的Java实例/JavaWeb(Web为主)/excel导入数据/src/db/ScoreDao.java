package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.AbstractData;
import model.Role;
import model.Score;

public class ScoreDao extends AbstractDao {

	@Override
	public int addRecords(ArrayList<AbstractData> datas) {
		// TODO Auto-generated method stub
		int amount = 0;
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = "insert into scores (score_id,score_courseId,score_examId,score_cj,score_count) values (?,?,?,?,?)";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				Score score = (Score)datas.get(index); 
				psmt.setInt(1, score.getScore_id());
				psmt.setString(2, score.getScore_courseId());
				psmt.setString(3, score.getScore_examId());
				psmt.setInt(4, score.getScore_cj());
				psmt.setInt(5, score.getScore_count());
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
		String sql = "delete scores where score_id = ?";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				Score score = (Score)datas.get(index); 
				pstm.setInt(1, score.getScore_id());
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
		String sql = "update scores set score_courseId = ?,score_examId = ?,score_cj = ?,score_count = ? where score_id = ?";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				Score score = (Score)datas.get(index); 
				psmt.setInt(1, score.getScore_id());
				psmt.setString(2, score.getScore_courseId());
				psmt.setString(3, score.getScore_examId());
				psmt.setInt(4, score.getScore_cj());
				psmt.setInt(5, score.getScore_count());
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
		String[] columnNames = new String[names.length];
		for(int i = 0;i < names.length;i++){
			columnNames[i] = names[i];
		}
		columnNames[names.length] = "Ìí¼Ó";
		columnNames[names.length + 1] = "É¾³ý";
		columnNames[names.length + 2] = "ÐÞ¸Ä";
		return columnNames;
	}
}
