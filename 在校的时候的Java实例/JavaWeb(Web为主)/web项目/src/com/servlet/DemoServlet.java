package com.servlet;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.db.AbstractDAO;

import com.db.ExamRoomDAO;

import com.db.UserDAO;
import com.domain.AbstractData;
import com.helper.Config;
import com.helper.Configs;
import com.helper.Helper;

public class DemoServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		HashMap<String,Config> configs = new HashMap<String,Config>();
		
		Configs cs = new Configs();
		ArrayList<Config> css = new ArrayList<Config>();
		css = cs.getConfigs();
		for(int i = 0;i < css.size();i++){
			Config config = css.get(i);
			
			configs.put(config.getId(), config);
		}
		
		this.getServletContext().setAttribute("configs",configs);
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		requestHandler(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestHandler(request, response);		
	}
	private void requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
		
		BufferedReader reader = request.getReader();
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String oper = request.getParameter("oper");
		
		
		String value = null;
		String jsontext = null;
	
		HashMap<String,Config> configs = (HashMap<String,Config>)this.getServletContext().getAttribute("configs");
		
		
		Config config = configs.get(id);
		
		Helper helper = new Helper();
		AbstractDAO dao = helper.getDao(config);
		Class<?> objClass = helper.getObjectClass(config);
		
		if(oper != null && oper.equals("search")){
			value = dao.getJSONText();
			
		}else if(oper.equals("edit")){
			
			jsontext = reader.readLine();
			ArrayList<AbstractData> datas = JSONTextToObjects.jsontextToObjects(jsontext,objClass);
			value = dao.editRecords(datas);
			
		}
		
		
		out.println(value);
		out.flush();
		out.close();
	}
}
