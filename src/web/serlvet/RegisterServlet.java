package web.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import bean.User;
import exception.UserExistsException;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.WebUtils;
import web.formbean.UserFormBean;

//完成注册的功能
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//第一步，先封装数据到userbean中
		UserFormBean ufb = WebUtils.fillFormBean(UserFormBean.class, request) ;
		
		//第二步，验证数据
		if(ufb.validate()){
			//说明验证通过
			//第三步,将formbean中的数据拷贝到user对象
			User user = new User() ;
			//由于formbean中的生日是String类型,userbaen中的生日是Date类型，beanUtils类不能自动转换，因此必须注册一个日期类型转换器
			try {
				ConvertUtils.register(new DateLocaleConverter(), Date.class) ;
				BeanUtils.copyProperties(user, ufb) ;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//第四步,注册用户
			//调用业务逻辑层完成注册
			UserService us = new UserServiceImpl() ;
			try {
				us.register(user) ;
				//注册成功
				//返回登陆页面
				response.getWriter().write("恭喜你，注册成功，2秒后转向登陆页面") ;
				response.setHeader("Refresh", "2;url=" + request.getContextPath() + "/login.jsp") ;
				//response.sendRedirect(request.getContextPath() + "/login.jsp") ;
				
			} catch (UserExistsException e) {
				//说明用户已经注册过了
				ufb.getErrors().put("username", "此用户名已经被注册过了，请换一个") ;
				//将ufb存入request对象
				request.setAttribute("user", ufb) ;
				request.getRequestDispatcher("/register.jsp").forward(request, response) ;
			}
			
		}else{
			//验证不通过
			//完成数据的回显操作，把ufb对象存放到request
			request.setAttribute("user", ufb) ;
			request.getRequestDispatcher("/register.jsp").forward(request, response) ;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
