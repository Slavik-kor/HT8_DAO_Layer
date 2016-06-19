package by.trepam.karotki.ht8.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.trepam.karotki.ht8.connectionpool.exception.ConnectionPoolException;
import by.trepam.karotki.ht8.dao.DaoFactory;
import by.trepam.karotki.ht8.dao.IFilmDao;

import by.trepam.karotki.ht8.entity.Comment;
import by.trepam.karotki.ht8.entity.Film;

public class FilmDaoImpl implements IFilmDao {

	@Override
	public List<Comment> getCommentsByFilm(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Film> getTopFilmsByRating(int value) {
		List<Film> filmList = new ArrayList<Film>();
		String sql = "SELECT Title, ROUND(AVG(Rate),2) Rating "
				+ "FROM film JOIN rate ON rate.Film_id = film.idFilm "
				+ "GROUP BY Title "
				+ "ORDER BY Rating DESC "
				+ " LIMIT ?;";
		Connection con = null;
		try {
			con = DaoFactory.getConnection();
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
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

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// log
			}
		}
		return filmList;
	}

	@Override
	public List<Film> getFilmsByActors(String firstName, String lastName) {
		List<Film> filmList = new ArrayList<Film>();
		String sql = "SELECT Title"
				+ " FROM film JOIN Film_has_Authors ON Film_has_Authors.Film_id = film.idFilm"
				+ " JOIN Author ON Author.idAuthor = Film_has_Authors.Authors_idAuthors"
				+ " WHERE (AuthorFirstName = ?) AND (AuthorLastName = ?) AND (Role = 'Actor');";
		Connection con = null;
		try {
			con = DaoFactory.getConnection();
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
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
         e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// log
				 e.printStackTrace();
			}
		}
		return filmList;
	}

	@Override
	public List<Film> getFilmsByDirectors(String firstName, String lastName) {
		List<Film> filmList = new ArrayList<Film>();
		String sql = "SELECT Title "
				+ "FROM film JOIN Film_has_Authors ON Film_has_Authors.Film_id = film.idFilm "
				+ "JOIN Author ON Author.idAuthor = Film_has_Authors.Authors_idAuthors "
				+ "WHERE (AuthorFirstName = ?) AND (AuthorLastName = ?) AND (Role = 'Director');";
		Connection con = null;
		try {
			con = DaoFactory.getConnection();
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
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
         e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// log
				 e.printStackTrace();
			}
		}
		return filmList;
	}

	@Override
	public List<Film> getFilmsByScenarioWriters(String firstName, String lastName) {
		List<Film> filmList = new ArrayList<Film>();
		String sql = "SELECT Title "
				+ "FROM film JOIN Film_has_Authors ON Film_has_Authors.Film_id = film.idFilm "
				+ "JOIN Author ON Author.idAuthor = Film_has_Authors.Authors_idAuthors "
				+ "WHERE (AuthorFirstName = ?) AND (AuthorLastName = ?) AND (Role = 'ScenarioWriter');";
		Connection con = null;
		try {
			con = DaoFactory.getConnection();
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
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
         e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// log
				 e.printStackTrace();
			}
		}
		return filmList;
	}

	@Override
	public List<Film> getFilmsByGenre(String genre) {
		List<Film> filmList = new ArrayList<Film>();
		String sql = "SELECT Title "
				+ "FROM film JOIN Film_Genre ON Film_Genre.Film_id = film.idFilm "
				+ "JOIN Genre ON Genre.idGenre = Film_Genre.Genre_id "
				+ "WHERE Name = ? ;";
		Connection con = null;
		try {
			con = DaoFactory.getConnection();
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
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
         e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// log
				 e.printStackTrace();
			}
		}
		return filmList;
	}

	@Override
	public List<Film> getMostBudgetFilms(int value) {
		List<Film> filmList = new ArrayList<Film>();
		String sql = "SELECT Title, Budget "
				+ "FROM film "
				+ "ORDER BY Budget DESC "
				+ "LIMIT ? ;";
		Connection con = null;
		try {
			con = DaoFactory.getConnection();
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
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
         e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// log
				 e.printStackTrace();
			}
		}
		return filmList;
	}

	@Override
	public List<Film> getMostCashBoxFilms(int value) {
		List<Film> filmList = new ArrayList<Film>();
		String sql = "SELECT Title, BoxOfficeCash "
				+ "FROM film "
				+ "ORDER BY BoxOfficeCash DESC LIMIT ?";
		Connection con = null;
		try {
			con = DaoFactory.getConnection();
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
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
         e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// log
				 e.printStackTrace();
			}
		}
		return filmList;
	}

}
