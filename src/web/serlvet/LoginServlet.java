package web.serlvet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//获取页面的数据
		String name = request.getParameter("username") ;
		String pass = request.getParameter("password") ;
		
		//验证数据(略)
		
		//调用service层完成业务逻辑
		UserService us = new UserServiceImpl() ;
		User user = us.login(name, pass) ;
		if(user != null){
			//合法用户
			request.getSession().setAttribute("loginuser", user) ;
			request.getRequestDispatcher("/main.jsp").forward(request, response) ;
		}else{
			//非法用户
			request.getSession().setAttribute("error", "用户名或者密码错误") ;
			response.sendRedirect(request.getContextPath() + "/login.jsp") ;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
