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
		
		//��ȡҳ�������
		String name = request.getParameter("username") ;
		String pass = request.getParameter("password") ;
		
		//��֤����(��)
		
		//����service�����ҵ���߼�
		UserService us = new UserServiceImpl() ;
		User user = us.login(name, pass) ;
		if(user != null){
			//�Ϸ��û�
			request.getSession().setAttribute("loginuser", user) ;
			request.getRequestDispatcher("/main.jsp").forward(request, response) ;
		}else{
			//�Ƿ��û�
			request.getSession().setAttribute("error", "�û��������������") ;
			response.sendRedirect(request.getContextPath() + "/login.jsp") ;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
