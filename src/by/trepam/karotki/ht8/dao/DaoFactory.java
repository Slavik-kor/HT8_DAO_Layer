package by.trepam.karotki.ht8.dao;

import java.sql.Connection;

import by.trepam.karotki.ht8.connectionpool.ConnectionPool;
import by.trepam.karotki.ht8.connectionpool.exception.ConnectionPoolException;
import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.dao.impl.AuthorDaoImpl;
import by.trepam.karotki.ht8.dao.impl.FilmDaoImpl;
import by.trepam.karotki.ht8.dao.impl.UserDaoImpl;

public class DaoFactory {
	private static final ConnectionPool conPool = ConnectionPool.getInstance();
	private static final DaoFactory instance = new DaoFactory();
	private static final IAuthorDao authorDao = new AuthorDaoImpl();
	private static final IFilmDao filmDao = new FilmDaoImpl();
	private static final IUserDao userDao = new UserDaoImpl();
	
	private DaoFactory() {
		try {
			conPool.initPoolData();
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}

	}

	public static DaoFactory getDaoFactory() {
		return instance;
	}


	public static Connection getConnection() throws DaoException {
		Connection con = null;
		try {
			con = conPool.takeConnection();
		} catch (ConnectionPoolException e) {
			// log
			throw new DaoException("Can't get connection from connection pool", e);
		}
		return con;
	}

	public static Connection returnConnection(Connection con) throws DaoException {
		try {
			conPool.returnConnection(con);
		} catch (ConnectionPoolException e) {
			// log
			throw new DaoException("Can't return connection to connection pool", e);
		}
		return con;
	}

	public IAuthorDao getAuthorDao() {
		return authorDao;
	}

	public IFilmDao getFilmDao() {
		return filmDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

}
