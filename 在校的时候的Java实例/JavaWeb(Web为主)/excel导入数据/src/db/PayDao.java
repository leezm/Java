package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.AbstractData;
import model.Payments;
import model.Role;

public class PayDao extends AbstractDao {

	@Override
	public int addRecords(ArrayList<AbstractData> datas) {
		// TODO Auto-generated method stub
		int amount = 0;
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = "insert into payments (examId,pay_first,pay_second,pay_ZLF,pay_XWF) values (?,?,?,?,?)";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				Payments pay = (Payments) datas.get(index);
				psmt.setString(1, pay.getExamId());
				psmt.setBoolean(2, pay.isPay_first());
				psmt.setBoolean(3, pay.isPay_second());
				psmt.setBoolean(4, pay.isPay_ZLF());
				psmt.setBoolean(5, pay.isPay_XWF());
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
		String sql = "delete payments where examId = ?";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				Payments pay = (Payments) datas.get(index);
				pstm.setString(1, pay.getExamId());
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
		String sql = "update payments set pay_first = ?,pay_second = ?,pay_ZLF,pay_XWF where examId = ?";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				Payments pay = (Payments) datas.get(index);
				psmt.setString(1, pay.getExamId());
				psmt.setBoolean(2, pay.isPay_first());
				psmt.setBoolean(3, pay.isPay_second());
				psmt.setBoolean(4, pay.isPay_ZLF());
				psmt.setBoolean(5, pay.isPay_XWF());
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
		columnNames[names.length] = "É¾³ý";
		columnNames[names.length] = "ÐÞ¸Ä";
		return columnNames;
	}
}
