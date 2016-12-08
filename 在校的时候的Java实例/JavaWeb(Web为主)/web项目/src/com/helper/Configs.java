package com.helper;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Configs {
	public ArrayList<Config> getConfigs(){
		ArrayList<Config> configs = null;
		try{
			//F:\MyEclipse\Workspaces\Common\523-16\WebRoot\WEB-INF
			//File.separator----文件分隔符，可以跨平台编译
			FileInputStream fis = new FileInputStream("F:"+File.separator+"MyEclipse"+File.separator+"Workspaces"+File.separator+"Common"+File.separator+"523-24"+File.separator+"WebRoot" + File.separator + "WEB-INF" + File.separator + "configs.xml");
			//创建解析器对象
			//第一步：创建解析器工厂对象
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			//忽略空白
			dbf.setIgnoringElementContentWhitespace(true);
			dbf.setValidating(true);
			//第二部：用解析器工厂对象调用newDocumentBuilder()方法产生解析器对象
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();
			Document doc = docBuilder.parse(fis);
			Element root = doc.getDocumentElement();
			fis.close();
			//getChildNodes()返回所包含的子节点的集合
			NodeList list = root.getChildNodes();
			 configs= new ArrayList<Config>();
			for(int index = 0; index < list.getLength(); index++){
				Node node = list.item(index);
				String id = getValue((Element)node,"Config_id");
				String dao = getValue((Element)node,"Config_dao");
				
				String data = getValue((Element)node,"Config_data");
				
				
				
				Config config = new Config();
				config.setId(id);
				config.setDaoclassname(dao);
				config.setDataclassname(data);
				configs.add(config);
			
			}
			
			}catch(Exception e){
				e.printStackTrace();
			}
		return configs;
	}


	private static String getValue(Element parent,String childTagName){
		Element child = (Element)parent.getElementsByTagName(childTagName).item(0);
		Node node = child.getChildNodes().item(0);
		return node.getNodeValue();
	}

	
}
