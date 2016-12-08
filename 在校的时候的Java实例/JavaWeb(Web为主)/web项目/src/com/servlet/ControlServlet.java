package com.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.db.ExamRoomDAO;
import com.db.TeacherDAO;
import com.domain.AbstractData;




public class ControlServlet extends HttpServlet {

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
		
		PrintWriter out = response.getWriter();
		
		
		TeacherDAO tdao = new TeacherDAO();
		ExamRoomDAO edao = new ExamRoomDAO();
		ArrayList<AbstractData> tdatas = tdao.getGroupRecords();
		ArrayList<AbstractData> edatas = edao.getAllRecords();
		
		JSONObject jsonobj = new JSONObject();
		
		
		jsonobj.element("teachers",tdatas);
		jsonobj.element("examrooms",edatas);
		String value =  jsonobj.toString();
		
		out.println(value);
		out.flush();
		out.close();
	}
}
