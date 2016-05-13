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
		//加载Dom树
		Document document = JaxpUtils.getDocument() ;
		//查询需要的node节点
		Node node = document.selectSingleNode("//user[@username='" + username+ "' and @password='" + password + "']") ;
		if(node != null){
			//找到了用户，封装数据
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
		//加载dom树
		Document document = JaxpUtils.getDocument() ;
		//拿到根节点
		Element root = document.getRootElement() ;
		//添加一个user节点
		root.addElement("user").addAttribute("username", user.getUsername())
				.addAttribute("password", user.getPassword())
				.addAttribute("email", user.getEmail())
				.addAttribute("birthday", new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday())) ;
		
		//将dom树保存到硬盘上
		JaxpUtils.write2xml(document) ;
		
	}

	public User findUserByUserName(String name) {
		//加载Dom树
				Document document = JaxpUtils.getDocument() ;
				//查询需要的node节点
				Node node = document.selectSingleNode("//user[@username='" + name +"']") ;
				if(node != null){
					//找到了用户，封装数据
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
