package by.trepam.karotki.ht8.dao;

import java.sql.Connection;

import by.trepam.karotki.ht8.connectionpool.ConnectionPool;
import by.trepam.karotki.ht8.connectionpool.exception.ConnectionPoolException;
import by.trepam.karotki.ht8.dao.impl.AuthorDaoImpl;
import by.trepam.karotki.ht8.dao.impl.FilmDaoImpl;
import by.trepam.karotki.ht8.dao.impl.UserDaoImpl;

public class DaoFactory {
	private static final ConnectionPool conPool = new ConnectionPool();
	private static final DaoFactory instance = new DaoFactory();
	private static final IAuthorDao AuthorDao = new AuthorDaoImpl();
	private static final IFilmDao FilmDao = new FilmDaoImpl();
	private static final IUserDao UserDao = new UserDaoImpl();

	private DaoFactory() {
		try {
			conPool.initPoolData();
		} catch (ConnectionPoolException e) {
			// log
		}
	}

	public static Connection getConnection() throws ConnectionPoolException {
		Connection con = null;
		try {
			con = conPool.takeConnection();
		} catch (ConnectionPoolException e) {
			// log
			throw new ConnectionPoolException("can't get connection from pool", e);
		}
		return con;
	}

	public static DaoFactory getDaoFactory() {
		return instance;
	}

	public IAuthorDao getAuthorDao() {
		return AuthorDao;
	}

	public IFilmDao getFilmDao() {
		return FilmDao;
	}

	public IUserDao getUserDao() {
		return UserDao;
	}

}
