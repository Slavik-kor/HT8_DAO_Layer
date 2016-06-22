package by.trepam.karotki.ht8.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.trepam.karotki.ht8.connectionpool.ConnectionPool;
import by.trepam.karotki.ht8.connectionpool.exception.ConnectionPoolException;
import by.trepam.karotki.ht8.dao.IFilmDao;
import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.Film;

public class FilmDaoImpl implements IFilmDao {
	private static final Logger LOG = LogManager.getLogger();
	private ConnectionPool conPool = ConnectionPool.getInstance();

	private static final String FILM_BY_RATING = "SELECT Title, ROUND(AVG(Rate),2) Rating FROM film "
			+ "JOIN rate ON rate.Film_id = film.idFilm " + "GROUP BY Title " + "ORDER BY Rating DESC LIMIT ? ;";

	private static final String FILM_BY_ACTOR = "SELECT Title FROM film "
			+ "JOIN Film_has_Authors ON Film_has_Authors.Film_id = film.idFilm "
			+ "JOIN Author ON Author.idAuthor = Film_has_Authors.Authors_idAuthors "
			+ "WHERE (AuthorFirstName = ?) AND (AuthorLastName = ?) AND (Role = 'Actor');";

	private static final String FILM_BY_DIRECTOR = "SELECT Title FROM film "
			+ "JOIN Film_has_Authors ON Film_has_Authors.Film_id = film.idFilm "
			+ "JOIN Author ON Author.idAuthor = Film_has_Authors.Authors_idAuthors "
			+ "WHERE (AuthorFirstName = ?) AND (AuthorLastName = ?) AND (Role = 'Director');";

	private static final String FILM_BY_SCENARIO_WRITER = "SELECT Title FROM film "
			+ "JOIN Film_has_Authors ON Film_has_Authors.Film_id = film.idFilm "
			+ "JOIN Author ON Author.idAuthor = Film_has_Authors.Authors_idAuthors "
			+ "WHERE (AuthorFirstName = ?) AND (AuthorLastName = ?) AND (Role = 'ScenarioWriter');";

	private static final String FILM_BY_GENRE = "SELECT Title FROM film "
			+ "JOIN Film_Genre ON Film_Genre.Film_id = film.idFilm "
			+ "JOIN Genre ON Genre.idGenre = Film_Genre.Genre_id " + "WHERE Name = ? ;";

	private static final String FILM_BY_BUDGET = "SELECT Title, Budget FROM film " + "ORDER BY Budget DESC LIMIT ? ;";

	private static final String FILM_BY_BOX_OFFICE_CASH = "SELECT Title, BoxOfficeCash FROM film "
			+ "ORDER BY BoxOfficeCash DESC LIMIT ?";

	private static final String TITLE = "Title";
	private static final String BUDGET = "Budget";
	private static final String BOX_OFFICE_CASH = "BoxOfficeCash";

	@Override
	public List<Film> getTopFilmsByRating(int value) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(FILM_BY_RATING);
			ps.setInt(1, value);
			rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString(TITLE));
				filmList.add(film);
			}
		} catch (ConnectionPoolException e) {
			throw new DaoException("Can't get connection from ConnectionPool", e);
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				LOG.warn("Can't close PreparedStatement or ResultSet");
			}
			conPool.returnConnection(con);
		}
		return filmList;
	}

	@Override
	public List<Film> getFilmsByActors(String firstName, String lastName) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(FILM_BY_ACTOR);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString(TITLE));
				filmList.add(film);
			}
		} catch (ConnectionPoolException e) {
			throw new DaoException("Can't get connection from ConnectionPool", e);
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				LOG.warn("Can't close PreparedStatement or ResultSet");
			}
			conPool.returnConnection(con);
		}
		return filmList;
	}

	@Override
	public List<Film> getFilmsByDirectors(String firstName, String lastName) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(FILM_BY_DIRECTOR);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString(TITLE));
				filmList.add(film);
			}
		} catch (ConnectionPoolException e) {
			throw new DaoException("Can't get connection from ConnectionPool", e);
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				LOG.warn("Can't close PreparedStatement or ResultSet");
			} 
			conPool.returnConnection(con);
		}
		return filmList;
	}

	@Override
	public List<Film> getFilmsByScenarioWriters(String firstName, String lastName) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(FILM_BY_SCENARIO_WRITER);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString(TITLE));
				filmList.add(film);
			}
		} catch (ConnectionPoolException e) {
			throw new DaoException("Can't get connection from ConnectionPool", e);
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				LOG.warn("Can't close PreparedStatement or ResultSet");
			} 
			conPool.returnConnection(con);
		}
		return filmList;
	}

	@Override
	public List<Film> getFilmsByGenre(String genre) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(FILM_BY_GENRE);
			ps.setString(1, genre);
			rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString(TITLE));
				filmList.add(film);
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
				LOG.warn("Can't close PreparedStatement or ResultSet");
			} 
		}
		return filmList;
	}

	@Override
	public List<Film> getMostBudgetFilms(int value) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(FILM_BY_BUDGET);
			ps.setInt(1, value);
			rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString(TITLE));
				film.setBudget(rs.getDouble(BUDGET));
				filmList.add(film);
			}
		} catch (ConnectionPoolException e) {
			throw new DaoException("Can't get connection from ConnectionPool", e);
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				LOG.warn("Can't close PreparedStatement or ResultSet");
			} 
		}
		conPool.returnConnection(con);
		return filmList;
	}

	@Override
	public List<Film> getMostCashBoxFilms(int value) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(FILM_BY_BOX_OFFICE_CASH);
			ps.setInt(1, value);
			rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString(TITLE));
				film.setBoxOfficeCash(rs.getDouble(BOX_OFFICE_CASH));
				filmList.add(film);
			}
		} catch (ConnectionPoolException e) {
			throw new DaoException("Can't get connection from ConnectionPool", e);
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				LOG.warn("Can't close PreparedStatement or ResultSet");
			} 
			conPool.returnConnection(con);
		}
		return filmList;
	}

}
