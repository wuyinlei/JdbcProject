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

//���ע��Ĺ���
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//��һ�����ȷ�װ���ݵ�userbean��
		UserFormBean ufb = WebUtils.fillFormBean(UserFormBean.class, request) ;
		
		//�ڶ�������֤����
		if(ufb.validate()){
			//˵����֤ͨ��
			//������,��formbean�е����ݿ�����user����
			User user = new User() ;
			//����formbean�е�������String����,userbaen�е�������Date���ͣ�beanUtils�಻���Զ�ת������˱���ע��һ����������ת����
			try {
				ConvertUtils.register(new DateLocaleConverter(), Date.class) ;
				BeanUtils.copyProperties(user, ufb) ;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//���Ĳ�,ע���û�
			//����ҵ���߼������ע��
			UserService us = new UserServiceImpl() ;
			try {
				us.register(user) ;
				//ע��ɹ�
				//���ص�½ҳ��
				response.getWriter().write("��ϲ�㣬ע��ɹ���2���ת���½ҳ��") ;
				response.setHeader("Refresh", "2;url=" + request.getContextPath() + "/login.jsp") ;
				//response.sendRedirect(request.getContextPath() + "/login.jsp") ;
				
			} catch (UserExistsException e) {
				//˵���û��Ѿ�ע�����
				ufb.getErrors().put("username", "���û����Ѿ���ע����ˣ��뻻һ��") ;
				//��ufb����request����
				request.setAttribute("user", ufb) ;
				request.getRequestDispatcher("/register.jsp").forward(request, response) ;
			}
			
		}else{
			//��֤��ͨ��
			//������ݵĻ��Բ�������ufb�����ŵ�request
			request.setAttribute("user", ufb) ;
			request.getRequestDispatcher("/register.jsp").forward(request, response) ;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
