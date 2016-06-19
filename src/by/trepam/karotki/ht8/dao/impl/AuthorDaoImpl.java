package by.trepam.karotki.ht8.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.trepam.karotki.ht8.connectionpool.exception.ConnectionPoolException;
import by.trepam.karotki.ht8.dao.DaoFactory;
import by.trepam.karotki.ht8.dao.IAuthorDao;
import by.trepam.karotki.ht8.entity.Author;

public class AuthorDaoImpl implements IAuthorDao{

	@Override
	public List<Author> getAuthorListByCountry(String country) {
		List<Author> authorList = new ArrayList<Author>();
		String sql = "SELECT AuthorFirstName, AuthorLastName "
				+ "FROM Author JOIN Country ON Country.idCountry = Author.CountryOfBirth_id "
				+ " WHERE CountryName = ? ;";
		Connection con = null;
		try {
			con = DaoFactory.getConnection();
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, country);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Author author = new Author();
				author.setFirstName(rs.getString("AuthorFirstName"));
				author.setLastName(rs.getString("AuthorLastName"));
				authorList.add(author);
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
		return authorList;
	}

	@Override
	public List<Author> getAuthorListByFilm(String title) {
		List<Author> authorList = new ArrayList<Author>();
		String sql = "SELECT AuthorFirstName, AuthorLastName, Role "
				+ "FROM Author JOIN Film_has_Authors ON Film_has_Authors.Authors_idAuthors = Author.idAuthor "
				+ "JOIN Film ON film.idFilm = Film_has_Authors.Film_id "
				+ "WHERE Title = ? "
				+ "ORDER BY Role ;";
		Connection con = null;
		try {
			con = DaoFactory.getConnection();
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Author author = new Author();
				author.setFirstName(rs.getString("AuthorFirstName"));
				author.setLastName(rs.getString("AuthorLastName"));
				authorList.add(author);
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
		return authorList;
	}

}
