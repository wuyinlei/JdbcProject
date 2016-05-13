package service;

import bean.User;
import exception.UserExistsException;

public interface UserService {

	/**
	 * �����û����������¼
	 * @param username �û���
	 * @param password ����
	 * @return ��¼�ɹ����ش��û������򷵻�null
	 */
	public User login(String username,String password ) ;
	
	/**
	 * ע���û�
	 * @param user Ҫע����û�
	 * @throws UserExistsException ���û����Ѿ����ڵ�ʱ���׳�һ���û��Ѵ����쳣
	 */
	public void register(User user) throws UserExistsException ;
}
