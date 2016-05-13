package dao;

import bean.User;

public interface UserDao {

	/**
	 * �����û����������ѯ�û�
	 * @param username �û���
	 * @param password ����
	 * @return ��ѯ���û����ش��û������򷵻�null
	 */
	public User findUserByUserNameAndPassword(String username,String password) ;
	
	/**
	 * ע���û�
	 * @param user Ҫע����û�
	 */
	public void add(User user) ;
	
	/**
	 * �����û������ֲ����û�
	 * @param name �û�������
	 * @return ��ѯ���˷��ش��û������򷵻�null
	 */
	public User findUserByUserName(String name) ;
}
