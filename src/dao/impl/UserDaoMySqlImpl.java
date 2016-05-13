package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import bean.User;
import dao.UserDao;
import utils.JdbcUtils;


//操作数据库
public final class UserDaoMySqlImpl implements UserDao {

	public User findUserByUserNameAndPassword(String username, String password) {
		// 拿到连接对象
		Connection conn = JdbcUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		// 创建命令对象
		try {
			stmt = conn.createStatement();
			// 写sql语句
			String sql = "select * from users where username='" + username
					+ "' and password='" + password + "'";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				// 有此人
				// 封装数据
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
			JdbcUtils.release(rs, stmt, conn);
		}
		return null;
	}

	public void add(User user) {
		// 拿到连接对象
		Connection conn = JdbcUtils.getConnection();
		Statement stmt = null;
		// 创建命令对象
		try {
			stmt = conn.createStatement();
			// 写sql语句
			String sql = "insert into users(username,password,email,birthday) values('"
					+ user.getUsername()
					+ "','"
					+ user.getPassword()
					+ "','"
					+ user.getEmail() + "','" + new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday()) + "')";
			System.out.println(sql);
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.release(null, stmt, conn);
		}
	}

	public User findUserByUserName(String name) {
		// 拿到连接对象
		Connection conn = JdbcUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		// 创建命令对象
		try {
			stmt = conn.createStatement();
			// 写sql语句
			String sql = "select * from users where username = '" + name + "'";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				// 有此人
				// 封装数据
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
			JdbcUtils.release(rs, stmt, conn);
		}
		return null;
	}

}
