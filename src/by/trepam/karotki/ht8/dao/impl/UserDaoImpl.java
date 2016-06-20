package by.trepam.karotki.ht8.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.trepam.karotki.ht8.dao.DaoFactory;
import by.trepam.karotki.ht8.dao.IUserDao;
import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public List<User> getUsersByCity(String city) throws DaoException {
		List<User> userList = new ArrayList<User>();
		String sql = "SELECT AccountFirstName, AccountLastName "
				+ "FROM Account JOIN City ON City.idCity = Account.City_id " + " WHERE CityName = ? ;";

		Connection con = DaoFactory.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, city);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setFirstName(rs.getString("AccountFirstName"));
				user.setLastName(rs.getString("AccountLastName"));
				userList.add(user);
			}
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} finally {
			DaoFactory.returnConnection(con);
		}
		return userList;
	}

	@Override
	public List<User> getUsersByCountry(String country) throws DaoException {
		List<User> userList = new ArrayList<User>();
		String sql = "SELECT AccountFirstName, AccountLastName "
				+ "FROM Account JOIN City ON City.idCity = Account.City_id "
				+ "JOIN Country ON Country.idCountry = City.Country_id " + " WHERE CountryName = ? ;";

		Connection con = DaoFactory.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, country);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setFirstName(rs.getString("AccountFirstName"));
				user.setLastName(rs.getString("AccountLastName"));
				userList.add(user);
			}
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} finally {
			DaoFactory.returnConnection(con);
		}
		return userList;
	}

	@Override
	public List<User> getBannedUsers() throws DaoException {
		List<User> userList = new ArrayList<User>();
		String sql = "SELECT AccountFirstName, AccountLastName " + "FROM Account " + " WHERE AccountActive = 'false' ;";
		Connection con = DaoFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setFirstName(rs.getString("AccountFirstName"));
				user.setLastName(rs.getString("AccountLastName"));
				userList.add(user);
			}
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} finally {
			DaoFactory.returnConnection(con);
		}
		return userList;
	}

	@Override
	public List<User> getActiveUsersByRate(int value) throws DaoException {
		List<User> userList = new ArrayList<User>();
		String sql = "SELECT AccountFirstName, AccountLastName, COUNT(Rate) Rate "
				+ "FROM Account JOIN Rate ON Rate.Account_id = Account.idAccount " + "GROUP BY AccountFirstName "
				+ "ORDER BY Rate DESC " + "LIMIT ? ;";
		Connection con = DaoFactory.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, value);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setFirstName(rs.getString("AccountFirstName"));
				user.setLastName(rs.getString("AccountLastName"));
				user.setRate(rs.getInt("Rate"));
				userList.add(user);
			}
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} finally {
			DaoFactory.returnConnection(con);
		}
		return userList;
	}

	@Override
	public List<User> getActiveUsersByComment(int value) throws DaoException {
		List<User> userList = new ArrayList<User>();
		String sql = "SELECT AccountFirstName, AccountLastName, COUNT(CommentText) Comment "
				+ "FROM Account JOIN Comment ON Comment.Account_id = Account.idAccount " + "GROUP BY AccountFirstName "
				+ "ORDER BY Comment DESC " + "LIMIT ? ;";
		Connection con = DaoFactory.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, value);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setFirstName(rs.getString("AccountFirstName"));
				user.setLastName(rs.getString("AccountLastName"));
				user.setRate(rs.getInt("Comment"));
				userList.add(user);
			}
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} finally {
			DaoFactory.returnConnection(con);

		}
		return userList;
	}

}
