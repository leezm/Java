package wang.com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import wang.com.helper.StudentScoreConstants;
import wang.com.model.Role;

public class RoleDAO {

	public String editRoles(ArrayList<Role> roles){
		StringBuffer buffer = new StringBuffer();
		ArrayList<Role> addList = new ArrayList<Role>();
		ArrayList<Role> deleteList = new ArrayList<Role>();
		ArrayList<Role> updateList = new ArrayList<Role>();
		int count = roles.size();
		for(int index = 0; index < count; index++){
			Role role = roles.get(index);
			byte oper_code = role.getOperCode();
			if(oper_code == StudentScoreConstants.ADD){
				addList.add(role);
			}else if(oper_code == StudentScoreConstants.DELETE){
				deleteList.add(role);
			}else if(oper_code == StudentScoreConstants.UPDATE){
				updateList.add(role);
			}
		}
		int add = addRoles(addList);
		int delete = deleteRoles(deleteList);
		int update = updateRoles(updateList);
		buffer.append("成功添加" + add + "条记录，成功删除" + delete + "条记录，成功修改" + update + "条记录");
		return buffer.toString();
	}
	public int addRoles(ArrayList<Role> roles){
		int amount = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "insert into roles (role_id, role_name) values (?,?)";
		try{
			conn = ConnectionFactory.getConnection("jdbc:sqlserver://localhost:1433;databasename=test", "sa", "1122");
			pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			boolean old = conn.getAutoCommit();
			conn.setAutoCommit(false);
			
			int count = roles.size();
			for(int index = 0; index < count; index++){
				Role role = roles.get(index);
				pstm.setByte(1, role.getRole_id());
				pstm.setString(2, role.getRole_name());
				pstm.addBatch();
			}
			int[] result = pstm.executeBatch();
			conn.commit();
			conn.setAutoCommit(old);
			
			for(int i = 0; i < result.length; i++){
				amount += result[i];
			}
			
		}catch(Exception e){
			try{
				amount = 0;
				conn.rollback();
			}catch(Exception ex){
				
			}
			e.printStackTrace();
		}finally{
			try{
				if(pstm != null){
					pstm.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return amount;
	}
	public int updateRoles(ArrayList<Role> roles){
		int amount = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "update roles set role_name=? where role_id=?";
		try{
			conn = ConnectionFactory.getConnection("jdbc:sqlserver://localhost:1433;databasename=test", "sa", "1122");
			pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			boolean old = conn.getAutoCommit();
			conn.setAutoCommit(false);
			
			int count = roles.size();
			for(int index = 0; index < count; index++){
				Role role = roles.get(index);
				pstm.setString(1, role.getRole_name());
				pstm.setByte(2, role.getRole_id());
				pstm.addBatch();
			}
			int[] result = pstm.executeBatch();
			conn.commit();
			conn.setAutoCommit(old);
			
			for(int i = 0; i < result.length; i++){
				amount += result[i];
			}
			
		}catch(Exception e){
			try{
				amount = 0;
				conn.rollback();
			}catch(Exception ex){
				
			}
			e.printStackTrace();
		}finally{
			try{
				if(pstm != null){
					pstm.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return amount;
	}
	public int deleteRoles(ArrayList<Role> roles){
		int amount = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "delete roles where role_id=?";
		try{
			conn = ConnectionFactory.getConnection("jdbc:sqlserver://localhost:1433;databasename=test", "sa", "1122");
			pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			boolean old = conn.getAutoCommit();
			conn.setAutoCommit(false);
			
			int count = roles.size();
			for(int index = 0; index < count; index++){
				Role role = roles.get(index);
				pstm.setByte(1, role.getRole_id());
				pstm.addBatch();
			}
			int[] result = pstm.executeBatch();
			conn.commit();
			conn.setAutoCommit(old);
			
			for(int i = 0; i < result.length; i++){
				amount += result[i];
			}
			
		}catch(Exception e){
			try{
				amount = 0;
				conn.rollback();
			}catch(Exception ex){
				
			}
			e.printStackTrace();
		}finally{
			try{
				if(pstm != null){
					pstm.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return amount;
		
	}
	public Role[] getAll(){
		Role[] roles = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select role_id, role_name from roles";
		try{
			conn = ConnectionFactory.getConnection("jdbc:sqlserver://localhost:1433;databasename=test", "sa", "1122");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			rs.last();
			int count = rs.getRow();
			roles = new Role[count];
			int index = 0;
			rs.beforeFirst();
			while(rs.next()){
				byte role_id = rs.getByte(1);
				String role_name = rs.getString(2);
				roles[index] = new Role();
				roles[index].setRole_id(role_id);
				roles[index].setRole_name(role_name);
				index++;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return roles;
	}
}
