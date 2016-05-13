package dao;

import bean.User;

public interface UserDao {

	/**
	 * 根据用户名和密码查询用户
	 * @param username 用户名
	 * @param password 密码
	 * @return 查询到用户返回此用户，否则返回null
	 */
	public User findUserByUserNameAndPassword(String username,String password) ;
	
	/**
	 * 注册用户
	 * @param user 要注册的用户
	 */
	public void add(User user) ;
	
	/**
	 * 根据用户的名字查找用户
	 * @param name 用户的名字
	 * @return 查询到了返回此用户，否则返回null
	 */
	public User findUserByUserName(String name) ;
}
