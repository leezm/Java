package jdbc.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.db.UserDAO;

public class RegisterServlet extends HttpServlet {

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
		register(request, response);
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
		register(request, response);
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String psw = request.getParameter("password");
		
		UserDAO userDao = new UserDAO();
		int result = userDao.Register(name, psw);
		
		RequestDispatcher dispacher = null;	
		if(result == UserDAO.SUCCESS){
			request.setAttribute("tip", "您已经成功注册！请重新登录");
			dispacher = request.getRequestDispatcher("/login.jsp");
		}else if(result == UserDAO.ISEXIST){
			request.setAttribute("tip", "此用户已存在！");
			dispacher = request.getRequestDispatcher("/register.jsp");
		}else{
			request.setAttribute("tip", "操作有误");
			dispacher = request.getRequestDispatcher("/register.jsp");
		}
		
		dispacher.forward(request, response);	
		
	}

}
