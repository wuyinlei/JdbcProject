package service;

import bean.User;
import exception.UserExistsException;

public interface UserService {

	/**
	 * 根据用户名和密码登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 登录成功返回此用户，否则返回null
	 */
	public User login(String username,String password ) ;
	
	/**
	 * 注册用户
	 * @param user 要注册的用户
	 * @throws UserExistsException 当用户名已经存在的时候，抛出一个用户已存在异常
	 */
	public void register(User user) throws UserExistsException ;
}
