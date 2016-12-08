package Lee.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			FileInputStream fis = new FileInputStream("bin" + File.separator + "Lee" + File.separator + "com" + File.separator +"students.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setIgnoringElementContentWhitespace(true);
			
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();
			Document doc = docBuilder.parse(fis);
			Element root = doc.getDocumentElement();
			
			fis.close();
			
			ArrayList<Student> students = new ArrayList<Student>();
			
			//
			NodeList list = root.getChildNodes();
			for(int index = 0; index < list.getLength(); index++){
				Node node = list.item(index);
				String id = getValue((Element)node, "Student_ID");
				String name = getValue((Element)node, "Student_Name");
				String sex = getValue((Element)node, "Student_Sex");
				String age = getValue((Element)node, "Student_Age");
				
				Student student = new Student();
				student.setStudent_id(id);
				student.setStudent_name(name);
				student.setStudent_sex(sex);
				student.setStudent_age(Integer.parseInt(age));
				
				students.add(student);
			}
			//
			
			for(int index = 0; index < students.size(); index++){
				Student stud = students.get(index);
				System.out.println("id: " + stud.getStudent_id() + "\tname: " + stud.getStudent_name() + "\tsex: " + stud.getStudent_sex() + "\tage: " + stud.getStudent_age());
			}
			
			root = null;
			
		}catch(Exception fnfe){
			fnfe.printStackTrace();
		}
	}

	private static String getValue(Element parent, String childTagName){
		Element child = (Element)parent.getElementsByTagName(childTagName).item(0);
		Node node = child.getChildNodes().item(0);
		
		return node.getNodeValue();
	}
}
