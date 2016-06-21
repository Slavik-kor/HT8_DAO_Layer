package by.trepam.karotki.ht8.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.trepam.karotki.ht8.dao.DaoFactory;
import by.trepam.karotki.ht8.dao.IAuthorDao;
import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.Author;

public class AuthorDaoImpl implements IAuthorDao {
	private static final String authorByCountry = "SELECT AuthorFirstName, AuthorLastName FROM Author "
			+ "JOIN Country ON Country.idCountry = Author.CountryOfBirth_id " + "WHERE CountryName = ? ;";
	private static final String authorByFilm = "SELECT AuthorFirstName, AuthorLastName, Role FROM Author "
			+ "JOIN Film_has_Authors ON Film_has_Authors.Authors_idAuthors = Author.idAuthor "
			+ "JOIN Film ON film.idFilm = Film_has_Authors.Film_id " + "WHERE Title = ? ORDER BY Role ;";

	@Override
	public List<Author> getAuthorListByCountry(String country) throws DaoException {

		List<Author> authorList = new ArrayList<Author>();
		Connection con = DaoFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(authorByCountry);
			ps.setString(1, country);
			rs = ps.executeQuery();
			while (rs.next()) {
				Author author = new Author();
				author.setFirstName(rs.getString("AuthorFirstName"));
				author.setLastName(rs.getString("AuthorLastName"));
				authorList.add(author);
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
		return authorList;
	}

	@Override
	public List<Author> getAuthorListByFilm(String title) throws DaoException {
		List<Author> authorList = new ArrayList<Author>();
		Connection con = DaoFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(authorByFilm);
			ps.setString(1, title);
			rs = ps.executeQuery();
			while (rs.next()) {
				Author author = new Author();
				author.setFirstName(rs.getString("AuthorFirstName"));
				author.setLastName(rs.getString("AuthorLastName"));
				authorList.add(author);
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
		return authorList;
	}

}
