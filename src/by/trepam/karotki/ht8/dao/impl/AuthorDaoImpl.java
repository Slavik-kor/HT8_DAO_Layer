package by.trepam.karotki.ht8.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.trepam.karotki.ht8.connectionpool.ConnectionPool;
import by.trepam.karotki.ht8.connectionpool.exception.ConnectionPoolException;
import by.trepam.karotki.ht8.dao.IAuthorDao;
import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.Author;

public class AuthorDaoImpl implements IAuthorDao {
	private ConnectionPool conPool = ConnectionPool.getInstance();

	private static final String AUTHOR_BY_COUNTRY = "SELECT AuthorFirstName, AuthorLastName FROM Author "
			+ "JOIN Country ON Country.idCountry = Author.CountryOfBirth_id " + "WHERE CountryName = ? ;";

	private static final String AUTHOR_BY_FILM = "SELECT AuthorFirstName, AuthorLastName, Role FROM Author "
			+ "JOIN Film_has_Authors ON Film_has_Authors.Authors_idAuthors = Author.idAuthor "
			+ "JOIN Film ON film.idFilm = Film_has_Authors.Film_id " + "WHERE Title = ? ORDER BY Role ;";

	private static final String FIRST_NAME = "AuthorFirstName";
	private static final String LAST_NAME = "AuthorLastName";

	@Override
	public List<Author> getAuthorListByCountry(String country) throws DaoException {

		List<Author> authorList = new ArrayList<Author>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(AUTHOR_BY_COUNTRY);
			ps.setString(1, country);
			rs = ps.executeQuery();
			while (rs.next()) {
				Author author = new Author();
				author.setFirstName(rs.getString(FIRST_NAME));
				author.setLastName(rs.getString(LAST_NAME));
				authorList.add(author);
			}
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Can't get connection from ConnectionPool", e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				throw new DaoException("Can't close PreparedStatement or ResultSet", e);
			}
			conPool.returnConnection(con);
		}
		return authorList;
	}

	@Override
	public List<Author> getAuthorListByFilm(String title) throws DaoException {
		List<Author> authorList = new ArrayList<Author>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = conPool.takeConnection();
			ps = con.prepareStatement(AUTHOR_BY_FILM);
			ps.setString(1, title);
			rs = ps.executeQuery();
			while (rs.next()) {
				Author author = new Author();
				author.setFirstName(rs.getString(FIRST_NAME));
				author.setLastName(rs.getString(LAST_NAME));
				authorList.add(author);
			}
		} catch (SQLException e) {
			throw new DaoException("Can't perform query", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Can't get connection from ConnectionPool", e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				throw new DaoException("Can't close PreparedStatement or ResultSet", e);
			}
			conPool.returnConnection(con);
		}
		return authorList;
	}

}
