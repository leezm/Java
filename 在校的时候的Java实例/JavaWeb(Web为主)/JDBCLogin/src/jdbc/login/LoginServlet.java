package jdbc.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.db.User;
import jdbc.db.UserDAO;

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

		login(request, response);
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

		login(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String name = request.getParameter("username");
		String psw = request.getParameter("password");
		
		UserDAO userDao = new UserDAO();
		User user = userDao.authenticate(name, psw);
		
		RequestDispatcher dispacher = null;	
		if(user != null){
			request.setAttribute("tip", "欢迎您来到主界面");
			dispacher = request.getRequestDispatcher("/main.jsp");
		}else{
			request.setAttribute("tip", "此用户不存在！");
			dispacher = request.getRequestDispatcher("/login.jsp");
		}
		dispacher.forward(request, response);	
		
	}
}
