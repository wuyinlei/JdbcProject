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
		//�����û�
		User u = dao.findUserByUserName(user.getUsername()) ;
		if(u == null)
			//˵���û�û��ע���
			dao.add(user) ;
		else
			throw new UserExistsException() ;
	}
}
