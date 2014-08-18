package user;

import ConnectionProvider.ConnectionProvider;
import bean.userBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userd {

	private Connection conn;

	public userd() {
		conn = ConnectionProvider.getConnection();
	}

	public void addUser(userBean userBean) {
		try {
			String sql = "INSERT INTO users VALUES (?, ?, ? )";
			System.out.println("kutta");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userBean.getId());
			ps.setString(2, userBean.getfName());
			ps.setString(3, userBean.getlName());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeUser(int userId) {
		try {
			String sql = "DELETE FROM users WHERE userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editUser(userBean userBean) {
		try {
			String sql = "UPDATE users SET firstname=?, lastname=?"
					+ " WHERE userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userBean.getfName());
			ps.setString(2, userBean.getlName());
			ps.setInt(3, userBean.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<userBean> getAllUsers() {
		List users = new ArrayList();
		try {
			String sql = "SELECT * FROM users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				userBean userBean = new userBean();
				userBean.setId(rs.getInt("userid"));
				userBean.setfName(rs.getString("firstname"));
				userBean.setlName(rs.getString("lastname"));
				users.add(userBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public userBean getUserById(int userId) {
		userBean userBean = new userBean();
		try {
			String sql = "SELECT * FROM users WHERE userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				userBean.setId(rs.getInt("userid"));
				userBean.setfName(rs.getString("firstname"));
				userBean.setlName(rs.getString("lastname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userBean;
	}
}
