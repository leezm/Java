package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DemoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("gb2312");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		JSONObject obj = new JSONObject();
		
		String[] columnNames = {"username","password","role","add","delete","update"};
		String[] titles = {"用户名","密码","角色","添加","删除","修改"};
		
		
		JSONArray array = new JSONArray();
		
		User user = new User();
		user.setUsername("AAA");
		user.setPassword("111");
		user.setRole(1);
		array.add(user);
		
		user.setUsername("BBB");
		user.setPassword("222");
		user.setRole(2);
		array.add(user);		
		
		obj.element("columnNames", columnNames);
		obj.element("titles", titles);
		obj.element("datas", array);
		
		out.println(obj.toString());
		out.flush();
		out.close();
		
	}

}
