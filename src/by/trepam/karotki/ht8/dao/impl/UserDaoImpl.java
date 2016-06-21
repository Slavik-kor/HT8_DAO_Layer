package by.trepam.karotki.ht8.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.trepam.karotki.ht8.connectionpool.ConnectionPool;
import by.trepam.karotki.ht8.connectionpool.exception.ConnectionPoolException;
import by.trepam.karotki.ht8.dao.IUserDao;
import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.User;

public class UserDaoImpl implements IUserDao {
	private ConnectionPool conPool = ConnectionPool.getInstance();
	
	private static final String usersByCity = "SELECT AccountFirstName, AccountLastName FROM Account "
			+ "JOIN City ON City.idCity = Account.City_id " + "WHERE CityName = ? ;";
	private static final String usersByCountry = "SELECT AccountFirstName, AccountLastName FROM Account "
			+ "JOIN City ON City.idCity = Account.City_id " + "JOIN Country ON Country.idCountry = City.Country_id "
			+ "WHERE CountryName = ? ;";
	private static final String BannedUsers = "SELECT AccountFirstName, AccountLastName FROM Account "
			+ " WHERE AccountActive = 'false' ;";
	private static final String usersByRate = "SELECT AccountFirstName, AccountLastName, COUNT(Rate) Rate FROM Account "
			+ "JOIN Rate ON Rate.Account_id = Account.idAccount " + "GROUP BY AccountFirstName "
			+ "ORDER BY Rate DESC LIMIT ? ;";
	private static final String usersByComment = "SELECT AccountFirstName, AccountLastName, COUNT(CommentText) Comment FROM Account "
			+ "JOIN Comment ON Comment.Account_id = Account.idAccount " + "GROUP BY AccountFirstName "
			+ "ORDER BY Comment DESC LIMIT ? ;";

	@Override
	public List<User> getUsersByCity(String city) throws DaoException {
		List<User> userList = new ArrayList<User>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(usersByCity);
			ps.setString(1, city);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setFirstName(rs.getString("AccountFirstName"));
				user.setLastName(rs.getString("AccountLastName"));
				userList.add(user);
			}
		} catch (ConnectionPoolException e) {
			throw new DaoException("Can't get connection from ConnectionPool", e);
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} finally {
			try {
				rs.close();
				ps.close();
				conPool.returnConnection(con);
			} catch (SQLException e) {
				throw new DaoException("Can't close PreparedStatement or ResultSet", e);
			} catch (ConnectionPoolException e) {
				throw new DaoException("Can't return connection to ConnectionPool", e);
			}
		}
		return userList;
	}

	@Override
	public List<User> getUsersByCountry(String country) throws DaoException {
		List<User> userList = new ArrayList<User>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(usersByCountry);
			ps.setString(1, country);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setFirstName(rs.getString("AccountFirstName"));
				user.setLastName(rs.getString("AccountLastName"));
				userList.add(user);
			}
		} catch (ConnectionPoolException e) {
			throw new DaoException("Can't get connection from ConnectionPool", e);
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} finally {
			try {
				rs.close();
				ps.close();
				conPool.returnConnection(con);
			} catch (SQLException e) {
				throw new DaoException("Can't close PreparedStatement or ResultSet", e);
			} catch (ConnectionPoolException e) {
				throw new DaoException("Can't return connection to ConnectionPool", e);
			}
		}
		return userList;
	}

	@Override
	public List<User> getBannedUsers() throws DaoException {
		List<User> userList = new ArrayList<User>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(BannedUsers);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setFirstName(rs.getString("AccountFirstName"));
				user.setLastName(rs.getString("AccountLastName"));
				userList.add(user);
			}
		} catch (ConnectionPoolException e) {
			throw new DaoException("Can't get connection from ConnectionPool", e);
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} finally {
			try {
				rs.close();
				ps.close();
				conPool.returnConnection(con);
			} catch (SQLException e) {
				throw new DaoException("Can't close PreparedStatement or ResultSet", e);
			} catch (ConnectionPoolException e) {
				throw new DaoException("Can't return connection to ConnectionPool", e);
			}
		}
		return userList;
	}

	@Override
	public List<User> getActiveUsersByRate(int value) throws DaoException {
		List<User> userList = new ArrayList<User>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(usersByRate);
			ps.setInt(1, value);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setFirstName(rs.getString("AccountFirstName"));
				user.setLastName(rs.getString("AccountLastName"));
				user.setRate(rs.getInt("Rate"));
				userList.add(user);
			}
		} catch (ConnectionPoolException e) {
			throw new DaoException("Can't get connection from ConnectionPool", e);
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} finally {
			try {
				rs.close();
				ps.close();
				conPool.returnConnection(con);
			} catch (SQLException e) {
				throw new DaoException("Can't close PreparedStatement or ResultSet", e);
			} catch (ConnectionPoolException e) {
				throw new DaoException("Can't return connection to ConnectionPool", e);
			}
		}
		return userList;
	}

	@Override
	public List<User> getActiveUsersByComment(int value) throws DaoException {
		List<User> userList = new ArrayList<User>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(usersByComment);
			ps.setInt(1, value);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setFirstName(rs.getString("AccountFirstName"));
				user.setLastName(rs.getString("AccountLastName"));
				user.setRate(rs.getInt("Comment"));
				userList.add(user);
			}
		} catch (ConnectionPoolException e) {
			throw new DaoException("Can't get connection from ConnectionPool", e);
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} finally {
			try {
				rs.close();
				ps.close();
				conPool.returnConnection(con);
			} catch (SQLException e) {
				throw new DaoException("Can't close PreparedStatement or ResultSet", e);
			} catch (ConnectionPoolException e) {
				throw new DaoException("Can't return connection to ConnectionPool", e);
			}
		}
		return userList;
	}

}
