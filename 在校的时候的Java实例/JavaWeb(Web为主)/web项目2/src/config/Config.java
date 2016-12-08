package wang.com.config;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class Config {
	protected Element root;
	
	public void init(String filename){
		try{
			InputStream is = new FileInputStream(filename);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			factory.setValidating(true);
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(is);
			root = doc.getDocumentElement();
			is.close();
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
	}
	
	public String getValue(Element parent, String tagName){
		Element configele = (Element)parent.getChildNodes().item(0);
		Element ele = (Element)configele.getElementsByTagName(tagName).item(0);
		return ele.getChildNodes().item(0).getNodeValue();
	}
	public void cleanup(){
		root = null;
	}
}
