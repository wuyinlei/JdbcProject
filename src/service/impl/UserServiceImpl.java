package service.impl;

import bean.User;
import dao.UserDao;
import dao.impl.UserDaoMySqlImpl1;
import exception.UserExistsException;
import service.UserService;

public class UserServiceImpl implements UserService {

	UserDao dao = new UserDaoMySqlImpl1() ;
	
	public User login(String username, String password) {
		return dao.findUserByUserNameAndPassword(username, password);
	}

	public void register(User user) throws UserExistsException {
		//查找用户
		User u = dao.findUserByUserName(user.getUsername()) ;
		if(u == null)
			//说明用户没有注册过
			dao.add(user) ;
		else
			throw new UserExistsException() ;
	}
}
