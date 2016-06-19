package by.trepam.karotki.ht8.dao;

import java.util.List;

import by.trepam.karotki.ht8.entity.Author;

public interface IAuthorDao {

	List<Author> getAuthorListByCountry(String country);

	List<Author> getAuthorListByFilm(String Title);

}
