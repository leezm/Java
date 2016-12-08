package com.helper;

import com.helper.Config;

import com.db.AbstractDAO;

public class Helper {
	public AbstractDAO getDao(Config config){
		AbstractDAO dao = null;
		try{
		
			dao = (AbstractDAO)Class.forName(config.getDaoclassname()).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		return dao;
	}
	public Class<?> getObjectClass(Config config){
		Class<?> objClass = null;
		try{
		
			objClass = Class.forName(config.getDataclassname());
		}catch(Exception e){
			e.printStackTrace();
		}
		return objClass;
	}
}
