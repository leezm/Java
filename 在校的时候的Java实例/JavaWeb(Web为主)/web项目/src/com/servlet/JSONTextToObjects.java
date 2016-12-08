package com.servlet;

import java.util.ArrayList;

import com.domain.AbstractData;

import net.sf.json.JSONArray;




public class JSONTextToObjects {
	@SuppressWarnings("unchecked")
	public static ArrayList<AbstractData> jsontextToObjects(String jsontext, Class<?> objClass){
		
	
		JSONArray array = JSONArray.fromObject(jsontext);
		ArrayList<AbstractData> datas = (ArrayList<AbstractData>)JSONArray.toCollection(array, objClass);
		
		
		
		return datas;
	}
}
