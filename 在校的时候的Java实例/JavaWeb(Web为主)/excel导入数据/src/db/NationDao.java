package db;

import java.sql.*;
import java.util.ArrayList;

import model.AbstractData;
import model.Nation;
import model.Role;

public class NationDao extends AbstractDao {

	@Override
	public int addRecords(ArrayList<AbstractData> datas) {
		// TODO Auto-generated method stub
		int amount = 0;
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = "insert into nations (nation_id,nation_name) values (?,?)";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				Role role = (Role) datas.get(index);
				psmt.setByte(1, role.getRole_id());
				psmt.setString(2, role.getRole_name());
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
		String sql = "delete nations where nation_id = ?";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				Role role = (Role) datas.get(index);
				pstm.setByte(1, role.getRole_id());
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
		PreparedStatement pstm = null;
		String sql = "update nations set nation_name = ? where nation_id = ?";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			boolean old = con.getAutoCommit();
			con.setAutoCommit(false);
			int count = datas.size();
			for(int index = 0;index < count;index++){
				Role role = (Role) datas.get(index);
				pstm.setByte(1, role.getRole_id());
				pstm.setString(2, role.getRole_name());
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

	public Nation[] getNationName(){
		Nation[] nations = null;
		Connection con = null;
		Statement state = null;
		ResultSet rs = null;
		String sql = "select nation_id,nation_name from nations";
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			state = con.createStatement();
			rs = state.executeQuery(sql);
			rs.last();
			int count = rs.getRow();
			rs.beforeFirst();
			nations = new Nation[count];
			int index = 0;
			while(rs.next()){
				byte nation_id = rs.getByte(1);
				String nation_name = rs.getString(2);
				nations[index++] = new Nation();
				nations[index++].setNation_id(nation_id);
				nations[index++].setNation_name(nation_name);
				index++;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(state != null){
					state.close();
				}
				if(con != null){
					con.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return nations;
	}
}
