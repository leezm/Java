package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.db.UserDAO;
import com.domain.User;

public class LoginServlet extends HttpServlet {


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
		handler(request,response);
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
		handler(request,response);
		
	}
	public void handler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html");
		response.setCharacterEncoding("GB18030");
		request.setCharacterEncoding("GB18030");
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		byte role = Byte.valueOf(request.getParameter("select"));
		UserDAO userdao = new UserDAO();
		User user = null;
		user = userdao.checkUser(username,pwd,role);
	
		
		RequestDispatcher de = null;
		if(user == null){
			request.setAttribute("tip", "用户名或密码输入错误，请重新输入！");
			de=request.getRequestDispatcher("ProtectedJSP/first.jsp"); 
		}else if(user.getUser_role() == 0){
			request.getSession().setAttribute("user", user);
			 de=request.getRequestDispatcher("ProtectedJSP/testjs.jsp"); 
			
		}else if(user.getUser_role() == 1){
			request.getSession().setAttribute("user", user);
			 de=request.getRequestDispatcher("ProtectedJSP/order.jsp"); 
		}
		de.forward(request, response); 
		
	}

}
