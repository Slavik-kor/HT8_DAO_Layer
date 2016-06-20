package by.trepam.karotki.ht8.dao;

import java.util.List;

import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.Author;

public interface IAuthorDao {

	List<Author> getAuthorListByCountry(String country) throws DaoException;

	List<Author> getAuthorListByFilm(String Title) throws DaoException;

}
