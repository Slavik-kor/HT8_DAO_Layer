package by.trepam.karotki.ht8.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.trepam.karotki.ht8.dao.DaoFactory;
import by.trepam.karotki.ht8.dao.IFilmDao;
import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.Film;

public class FilmDaoImpl implements IFilmDao {
	private static final String filmByRating = "SELECT Title, ROUND(AVG(Rate),2) Rating FROM film "
			+ "JOIN rate ON rate.Film_id = film.idFilm " + "GROUP BY Title " + "ORDER BY Rating DESC LIMIT ? ;";
	private static final String filmByActor = "SELECT Title FROM film "
			+ "JOIN Film_has_Authors ON Film_has_Authors.Film_id = film.idFilm "
			+ "JOIN Author ON Author.idAuthor = Film_has_Authors.Authors_idAuthors "
			+ "WHERE (AuthorFirstName = ?) AND (AuthorLastName = ?) AND (Role = 'Actor');";
	private static final String filmByDirector = "SELECT Title FROM film "
			+ "JOIN Film_has_Authors ON Film_has_Authors.Film_id = film.idFilm "
			+ "JOIN Author ON Author.idAuthor = Film_has_Authors.Authors_idAuthors "
			+ "WHERE (AuthorFirstName = ?) AND (AuthorLastName = ?) AND (Role = 'Director');";
	private static final String filmByScenarioWriter = "SELECT Title FROM film "
			+ "JOIN Film_has_Authors ON Film_has_Authors.Film_id = film.idFilm "
			+ "JOIN Author ON Author.idAuthor = Film_has_Authors.Authors_idAuthors "
			+ "WHERE (AuthorFirstName = ?) AND (AuthorLastName = ?) AND (Role = 'ScenarioWriter');";
	private static final String filmByGenre = "SELECT Title FROM film "
			+ "JOIN Film_Genre ON Film_Genre.Film_id = film.idFilm "
			+ "JOIN Genre ON Genre.idGenre = Film_Genre.Genre_id " + "WHERE Name = ? ;";
	private static final String filmByBudget = "SELECT Title, Budget FROM film " + "ORDER BY Budget DESC LIMIT ? ;";
	private static final String mostCashBoxFilm = "SELECT Title, BoxOfficeCash FROM film "
			+ "ORDER BY BoxOfficeCash DESC LIMIT ?";

	@Override
	public List<Film> getTopFilmsByRating(int value) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		Connection con = DaoFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(filmByRating);
			ps.setInt(1, value);
			rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString("Title"));
				film.setRate(rs.getDouble("Rating"));
				filmList.add(film);
			}
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				throw new DaoException("Can't close PreparedStatement or ResultSet", e);
			}
			DaoFactory.returnConnection(con);
		}
		return filmList;
	}

	@Override
	public List<Film> getFilmsByActors(String firstName, String lastName) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		Connection con = DaoFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(filmByActor);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString("Title"));
				filmList.add(film);
			}
		} catch (SQLException e) {
			// log
			throw new DaoException("Can't perform query", e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				throw new DaoException("Can't close PreparedStatement or ResultSet", e);
			}
			DaoFactory.returnConnection(con);
		}
		return filmList;
	}

	@Override
	public List<Film> getFilmsByDirectors(String firstName, String lastName) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		Connection con = DaoFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(filmByDirector);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString("Title"));
				filmList.add(film);
			}
		} catch (SQLException e) {
			// log
			throw new DaoException("Can't perform query", e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				throw new DaoException("Can't close PreparedStatement or ResultSet", e);
			}
			DaoFactory.returnConnection(con);
		}
		return filmList;
	}

	@Override
	public List<Film> getFilmsByScenarioWriters(String firstName, String lastName) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		Connection con = DaoFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(filmByScenarioWriter);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString("Title"));
				filmList.add(film);
			}
		} catch (SQLException e) {
			// log
			throw new DaoException("Can't perform query", e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				throw new DaoException("Can't close PreparedStatement or ResultSet", e);
			}
			DaoFactory.returnConnection(con);
		}
		return filmList;
	}

	@Override
	public List<Film> getFilmsByGenre(String genre) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();

		Connection con = DaoFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(filmByGenre);
			ps.setString(1, genre);
			rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString("Title"));
				filmList.add(film);
			}
		} catch (SQLException e) {
			// log
			throw new DaoException("Can't perform query", e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				throw new DaoException("Can't close PreparedStatement or ResultSet", e);
			}
			DaoFactory.returnConnection(con);
		}
		return filmList;
	}

	@Override
	public List<Film> getMostBudgetFilms(int value) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		Connection con = DaoFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(filmByBudget);
			ps.setInt(1, value);
			rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString("Title"));
				film.setBudget(rs.getDouble("Budget"));
				filmList.add(film);
			}
		} catch (SQLException e) {
			// log
			throw new DaoException("Can't perform query", e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				throw new DaoException("Can't close PreparedStatement or ResultSet", e);
			}
			DaoFactory.returnConnection(con);
		}
		return filmList;
	}

	@Override
	public List<Film> getMostCashBoxFilms(int value) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		Connection con = DaoFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(mostCashBoxFilm);
			ps.setInt(1, value);
			rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString("Title"));
				film.setBoxOfficeCash(rs.getDouble("BoxOfficeCash"));
				filmList.add(film);
			}
		} catch (SQLException e) {
			// log
			throw new DaoException("Can't perform query", e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				throw new DaoException("Can't close PreparedStatement or ResultSet", e);
			}
			DaoFactory.returnConnection(con);
		}
		return filmList;
	}

}
