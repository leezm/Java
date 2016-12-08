package db;

import help.HelpConstants;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import model.AbstractData;

public abstract class AbstractDao {
	protected String url = "jdbc:sqlserver://localhost:1433;databasename = StudentsInfos";
	protected String username = "sa";
	protected String passwd = "0519";
	
	public String editRecords(ArrayList<AbstractData> datas){
		ArrayList<AbstractData> addList = new ArrayList<AbstractData>();
		ArrayList<AbstractData> deleteList = new ArrayList<AbstractData>();
		ArrayList<AbstractData> updateList = new ArrayList<AbstractData>();
		int count = datas.size();
		for(int index = 0;index < count ;index++){
			AbstractData data = datas.get(index);
			byte operCode = data.getOper_code();
			if(operCode == HelpConstants.ADD){
				addList.add(data);
			}else if(operCode == HelpConstants.DELETE){
				deleteList.add(data);
			}else if(operCode == HelpConstants.UPDATE){
				updateList.add(data);
			}
		}		
		int add = addRecords(addList);
		int delete = deleteRecords(deleteList);
		int update = updateRecords(updateList);
		StringBuffer buffer = new StringBuffer();
		buffer.append("成功添加"+add+"条记录，成功删除"+delete+"条记录，成功修改"+update+"条记录");
		return buffer.toString();
		
	}
	
	public String[] getColumnNames(String sql){
		String[] columnNames = null;
		Connection con = null;
		Statement state = null;
		ResultSet rs = null;
		try{
			con = ConnectionFactory.getConnection(url, username, passwd);
			state =con.createStatement();
			rs = state.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int size = rsmd.getColumnCount();
			columnNames = new String[size];
			for(int i = 0;i < size;i++){
				columnNames[i] = rsmd.getColumnLabel(i+1);
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
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		}
		return columnNames;
	}
	
	public abstract int addRecords(ArrayList<AbstractData> datas);
	public abstract int deleteRecords(ArrayList<AbstractData> datas);
	public abstract int updateRecords(ArrayList<AbstractData> datas);
}
