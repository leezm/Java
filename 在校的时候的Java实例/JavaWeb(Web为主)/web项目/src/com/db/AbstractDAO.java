package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import com.domain.AbstractData;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public abstract class AbstractDAO {

	public static final byte ADD = 10;
	public static final byte DELETE = 20;
	public static final byte UPDATE = 30;
	
	public String editRecords(ArrayList<AbstractData> datas){
		StringBuffer buffer = new StringBuffer();
		ArrayList<AbstractData> addList = new ArrayList<AbstractData>();
		ArrayList<AbstractData> deleteList = new ArrayList<AbstractData>();
		ArrayList<AbstractData> updateList = new ArrayList<AbstractData>();
		
		int amount = datas.size();
		for(int index = 0; index < amount; index++){
			AbstractData data = datas.get(index);
			byte opercode = data.getOpercode();
			if(opercode == AbstractDAO.ADD){
				addList.add(data);
			}else if(opercode == AbstractDAO.DELETE){
				deleteList.add(data);
			}else if(opercode == AbstractDAO.UPDATE){
				updateList.add(data);
			}
		}
		int add = 0; 
		int delete = 0;
		int update = 0;
		
		Connection conn = null;
		try{
			conn = ConnectionFactory.getConnection();
			boolean old = conn.getAutoCommit();
			conn.setAutoCommit(false);
			
			add = addRecords(addList, conn);
			delete = deleteRecords(deleteList, conn);
			update = updateRecords(updateList, conn);
			
			conn.commit();
			conn.setAutoCommit(old);
		}catch(Exception e){
			try{
				conn.rollback();
			}catch(Exception ex){}
			e.printStackTrace();
		}finally{
			try{
				if(conn != null){
					conn.close();
				}
			}catch(Exception e){}
		}		
		buffer.append("成功添加" + add + "条记录，删除" + delete + "条记录，修改" + update + "条记录");
		return buffer.toString();
	}
	
	public String getJSONText(){
		String[] columnNames = getColumnNames();
		String[] titles = getTitles();
		ArrayList<AbstractData> datas = getAllRecords();
		ArrayList<AbstractData> options = getOptions();
		String[] optionNames = getOptionNames();
		
	
		
		
		JSONObject jsonobj = new JSONObject();
		
		jsonobj.element("columnNames", columnNames);
		jsonobj.element("titles", titles);
		jsonobj.element("datas", datas);
		jsonobj.element("options",options);
		jsonobj.element("optionNames",optionNames);
		return jsonobj.toString();
	}
	public abstract ArrayList<AbstractData> getOptions();
	public abstract String[] getOptionNames();
	public abstract String[] getColumnNames();
	public abstract String[] getTitles();
	public abstract ArrayList<AbstractData> getAllRecords();
	public abstract int addRecords(ArrayList<AbstractData> datas, Connection conn);
	public abstract int deleteRecords(ArrayList<AbstractData> datas, Connection conn);
	public abstract int updateRecords(ArrayList<AbstractData> datas, Connection conn);
}
