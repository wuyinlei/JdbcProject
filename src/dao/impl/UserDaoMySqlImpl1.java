package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import bean.User;
import dao.UserDao;
import utils.JdbcUtils;

//�������ݿ�(����Ԥ�����������)
public final class UserDaoMySqlImpl1 implements UserDao {

	public User findUserByUserNameAndPassword(String username, String password) {
		// �õ����Ӷ���
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// �����������
		try {
			pstmt = conn.prepareStatement("select * from users where username=? and password = ?") ;
			//ָ��?��ֵ
			pstmt.setString(1, username) ;
			pstmt.setString(2, password) ;
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// �д���
				// ��װ����
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));

				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.release(rs, pstmt, conn);
		}
		return null;
	}

	public void add(User user) {
		// �õ����Ӷ���
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstmt = null;
		// �����������
		try {
			pstmt = conn.prepareStatement("insert into users(username,password,email,birthday) values(?,?,?,?)") ;
			//ָ��?��ֵ
			pstmt.setString(1, user.getUsername()) ;
			pstmt.setString(2, user.getPassword()) ;
			pstmt.setString(3, user.getEmail()) ;
			pstmt.setDate(4, new java.sql.Date(user.getBirthday().getTime())) ;
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.release(null, pstmt, conn);
		}
	}

	public User findUserByUserName(String name) {
		// �õ����Ӷ���
		Connection conn = JdbcUtils.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		// �����������
		try {
			pstmt = conn.prepareStatement("select * from users where username = '" + name + "'") ;
			// дsql���
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// �д���
				// ��װ����
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));

				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.release(rs, pstmt, conn);
		}
		return null;
	}

}
