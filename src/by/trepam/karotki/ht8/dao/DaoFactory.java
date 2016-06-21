package by.trepam.karotki.ht8.dao;

import by.trepam.karotki.ht8.connectionpool.ConnectionPool;
import by.trepam.karotki.ht8.connectionpool.exception.ConnectionPoolException;
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
