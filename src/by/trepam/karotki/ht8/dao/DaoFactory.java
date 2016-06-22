package by.trepam.karotki.ht8.dao;

import by.trepam.karotki.ht8.connectionpool.ConnectionPool;
import by.trepam.karotki.ht8.connectionpool.exception.ConnectionPoolException;
import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.dao.impl.AuthorDaoImpl;
import by.trepam.karotki.ht8.dao.impl.FilmDaoImpl;
import by.trepam.karotki.ht8.dao.impl.AccountDaoImpl;

public class DaoFactory {
	private static final ConnectionPool conPool = ConnectionPool.getInstance();
	private static DaoFactory instance;
	private static final IAuthorDao authorDao = new AuthorDaoImpl();
	private static final IFilmDao filmDao = new FilmDaoImpl();
	private static final IAccountDao userDao = new AccountDaoImpl();

	private DaoFactory() throws DaoException{
		try {
			conPool.initPoolData();
		} catch (ConnectionPoolException e) {
			throw new DaoException("Can't initialize ConnectionPool data",e);
		}
	}

	public static DaoFactory getDaoFactory() throws DaoException {
		if (instance == null) {
			instance = new DaoFactory();
		}
		return instance;
	}

	public IAuthorDao getAuthorDao() {
		return authorDao;
	}

	public IFilmDao getFilmDao() {
		return filmDao;
	}

	public IAccountDao getUserDao() {
		return userDao;
	}

}
