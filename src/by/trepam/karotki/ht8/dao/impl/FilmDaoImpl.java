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

	@Override
	public List<Film> getTopFilmsByRating(int value) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		String sql = "SELECT Title, ROUND(AVG(Rate),2) Rating " + "FROM film JOIN rate ON rate.Film_id = film.idFilm "
				+ "GROUP BY Title " + "ORDER BY Rating DESC " + " LIMIT ? ;";

		Connection con = DaoFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, value);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString("Title"));
				film.setRate(rs.getDouble("Rating"));
				filmList.add(film);
			}
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} finally {
			DaoFactory.returnConnection(con);
		}
		return filmList;
	}

	@Override
	public List<Film> getFilmsByActors(String firstName, String lastName) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		String sql = "SELECT Title" + " FROM film JOIN Film_has_Authors ON Film_has_Authors.Film_id = film.idFilm"
				+ " JOIN Author ON Author.idAuthor = Film_has_Authors.Authors_idAuthors"
				+ " WHERE (AuthorFirstName = ?) AND (AuthorLastName = ?) AND (Role = 'Actor');";
		Connection con = DaoFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString("Title"));
				filmList.add(film);
			}
		} catch (SQLException e) {
			// log
			throw new DaoException("Can't perform query", e);
		} finally {
			DaoFactory.returnConnection(con);
		}
		return filmList;
	}

	@Override
	public List<Film> getFilmsByDirectors(String firstName, String lastName) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		String sql = "SELECT Title " + "FROM film JOIN Film_has_Authors ON Film_has_Authors.Film_id = film.idFilm "
				+ "JOIN Author ON Author.idAuthor = Film_has_Authors.Authors_idAuthors "
				+ "WHERE (AuthorFirstName = ?) AND (AuthorLastName = ?) AND (Role = 'Director');";

		Connection con = DaoFactory.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString("Title"));
				filmList.add(film);
			}
		} catch (SQLException e) {
			// log
			throw new DaoException("Can't perform query", e);
		} finally {
			DaoFactory.returnConnection(con);
		}
		return filmList;
	}

	@Override
	public List<Film> getFilmsByScenarioWriters(String firstName, String lastName) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		String sql = "SELECT Title " + "FROM film JOIN Film_has_Authors ON Film_has_Authors.Film_id = film.idFilm "
				+ "JOIN Author ON Author.idAuthor = Film_has_Authors.Authors_idAuthors "
				+ "WHERE (AuthorFirstName = ?) AND (AuthorLastName = ?) AND (Role = 'ScenarioWriter');";

		Connection con = DaoFactory.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString("Title"));
				filmList.add(film);
			}
		} catch (SQLException e) {
			// log
			throw new DaoException("Can't perform query", e);
		} finally {
			DaoFactory.returnConnection(con);
		}
		return filmList;
	}

	@Override
	public List<Film> getFilmsByGenre(String genre) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		String sql = "SELECT Title " + "FROM film JOIN Film_Genre ON Film_Genre.Film_id = film.idFilm "
				+ "JOIN Genre ON Genre.idGenre = Film_Genre.Genre_id " + "WHERE Name = ? ;";

		Connection con = DaoFactory.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, genre);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setTitle(rs.getString("Title"));
				filmList.add(film);
			}
		} catch (SQLException e) {
			// log
			throw new DaoException("Can't perform query", e);
		} finally {
			DaoFactory.returnConnection(con);
		}
		return filmList;
	}

	@Override
	public List<Film> getMostBudgetFilms(int value) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		String sql = "SELECT Title, Budget " + "FROM film " + "ORDER BY Budget DESC " + "LIMIT ? ;";

		Connection con = DaoFactory.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, value);
			ResultSet rs = ps.executeQuery();
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
			DaoFactory.returnConnection(con);
		}
		return filmList;
	}

	@Override
	public List<Film> getMostCashBoxFilms(int value) throws DaoException {
		List<Film> filmList = new ArrayList<Film>();
		String sql = "SELECT Title, BoxOfficeCash " + "FROM film " + "ORDER BY BoxOfficeCash DESC LIMIT ?";

		Connection con = DaoFactory.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, value);
			ResultSet rs = ps.executeQuery();
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
			DaoFactory.returnConnection(con);
		}
		return filmList;
	}

}
