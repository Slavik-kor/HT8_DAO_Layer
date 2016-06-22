package by.trepam.karotki.ht8.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.trepam.karotki.ht8.connectionpool.ConnectionPool;
import by.trepam.karotki.ht8.connectionpool.exception.ConnectionPoolException;
import by.trepam.karotki.ht8.dao.IAccountDao;
import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.Account;

public class AccountDaoImpl implements IAccountDao {
	private ConnectionPool conPool = ConnectionPool.getInstance();

	private static final String ACCOUNT_BY_CITY = "SELECT AccountFirstName, AccountLastName FROM Account "
			+ "JOIN City ON City.idCity = Account.City_id "
			+ "WHERE CityName = ? ;";
	private static final String ACCOUNT_BY_COUNTRY = "SELECT AccountFirstName, AccountLastName FROM Account "
			+ "JOIN City ON City.idCity = Account.City_id "
			+ "JOIN Country ON Country.idCountry = City.Country_id "
			+ "WHERE CountryName = ? ;";
	private static final String BANNED_ACCOUNT = "SELECT AccountFirstName, AccountLastName FROM Account "
			+ " WHERE AccountActive = 'false' ;";
	private static final String ACCOUNT_BY_RATE = "SELECT AccountFirstName, AccountLastName, COUNT(Rate) Rate FROM Account "
			+ "JOIN Rate ON Rate.Account_id = Account.idAccount " 
			+ "GROUP BY AccountFirstName "
			+ "ORDER BY Rate DESC LIMIT ? ;";
	private static final String ACCOUNT_BY_COMMENT = "SELECT AccountFirstName, AccountLastName, COUNT(CommentText) Comment FROM Account "
			+ "JOIN Comment ON Comment.Account_id = Account.idAccount " 
			+ "GROUP BY AccountFirstName "
			+ "ORDER BY Comment DESC LIMIT ? ;";

	private static final String FIRST_NAME = "AccountFirstName";
	private static final String LAST_NAME = "AccountLastName";
	
	@Override
	public List<Account> getUsersByCity(String city) throws DaoException {
		List<Account> userList = new ArrayList<Account>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(ACCOUNT_BY_CITY);
			ps.setString(1, city);
			rs = ps.executeQuery();
			while (rs.next()) {
				Account user = new Account();
				user.setFirstName(rs.getString(FIRST_NAME));
				user.setLastName(rs.getString(LAST_NAME));
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
	public List<Account> getUsersByCountry(String country) throws DaoException {
		List<Account> userList = new ArrayList<Account>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(ACCOUNT_BY_COUNTRY);
			ps.setString(1, country);
			rs = ps.executeQuery();
			while (rs.next()) {
				Account user = new Account();
				user.setFirstName(rs.getString(FIRST_NAME));
				user.setLastName(rs.getString(LAST_NAME));
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
	public List<Account> getBannedUsers() throws DaoException {
		List<Account> userList = new ArrayList<Account>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(BANNED_ACCOUNT);
			rs = ps.executeQuery();
			while (rs.next()) {
				Account user = new Account();
				user.setFirstName(rs.getString(FIRST_NAME));
				user.setLastName(rs.getString(LAST_NAME));
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
	public List<Account> getActiveUsersByRate(int value) throws DaoException {
		List<Account> userList = new ArrayList<Account>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(ACCOUNT_BY_RATE);
			ps.setInt(1, value);
			rs = ps.executeQuery();
			while (rs.next()) {
				Account user = new Account();
				user.setFirstName(rs.getString(FIRST_NAME));
				user.setLastName(rs.getString(LAST_NAME));
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
				throw new DaoException("Can't close PreparedStatement or ResultSet", e);// log
			} catch (ConnectionPoolException e) {
				throw new DaoException("Can't return connection to ConnectionPool", e);// log
			}
		}
		return userList;
	}

	@Override
	public List<Account> getActiveUsersByComment(int value) throws DaoException {
		List<Account> userList = new ArrayList<Account>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(ACCOUNT_BY_COMMENT);
			ps.setInt(1, value);
			rs = ps.executeQuery();
			while (rs.next()) {
				Account user = new Account();
				user.setFirstName(rs.getString(FIRST_NAME));
				user.setLastName(rs.getString(LAST_NAME));
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
				throw new DaoException("Can't close PreparedStatement or ResultSet", e);// log
			} catch (ConnectionPoolException e) {
				throw new DaoException("Can't return connection to ConnectionPool", e);// log
			}
		}
		return userList;
	}

}
