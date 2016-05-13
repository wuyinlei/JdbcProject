package dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import bean.User;
import dao.UserDao;
import utils.JaxpUtils;

public class UserDaoImpl implements UserDao {

	public User findUserByUserNameAndPassword(String username, String password) {
		//����Dom��
		Document document = JaxpUtils.getDocument() ;
		//��ѯ��Ҫ��node�ڵ�
		Node node = document.selectSingleNode("//user[@username='" + username+ "' and @password='" + password + "']") ;
		if(node != null){
			//�ҵ����û�����װ����
			User user = new User() ;
			user.setUsername(username) ;
			user.setPassword(password) ;
			user.setEmail(node.valueOf("@email")) ;
			String bithday = node.valueOf("@birthday") ;
			
			try {
				user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(bithday)) ;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return user;
		}
		
		return null;
	}

	public void add(User user) {
		//����dom��
		Document document = JaxpUtils.getDocument() ;
		//�õ����ڵ�
		Element root = document.getRootElement() ;
		//���һ��user�ڵ�
		root.addElement("user").addAttribute("username", user.getUsername())
				.addAttribute("password", user.getPassword())
				.addAttribute("email", user.getEmail())
				.addAttribute("birthday", new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday())) ;
		
		//��dom�����浽Ӳ����
		JaxpUtils.write2xml(document) ;
		
	}

	public User findUserByUserName(String name) {
		//����Dom��
				Document document = JaxpUtils.getDocument() ;
				//��ѯ��Ҫ��node�ڵ�
				Node node = document.selectSingleNode("//user[@username='" + name +"']") ;
				if(node != null){
					//�ҵ����û�����װ����
					User user = new User() ;
					user.setUsername(name) ;
					user.setPassword("@password") ;
					user.setEmail(node.valueOf("@email")) ;
					String bithday = node.valueOf("@birthday") ;
					
					try {
						user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(bithday)) ;
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return user;
				}
		return null;
	}

}
