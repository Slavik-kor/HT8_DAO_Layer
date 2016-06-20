package by.trepam.karotki.ht8.dao;

import java.util.List;

import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.Film;

public interface IFilmDao {

	List<Film> getTopFilmsByRating(int value) throws DaoException;

	List<Film> getFilmsByActors(String firstName, String lastName) throws DaoException;

	List<Film> getFilmsByDirectors(String firstName, String lastName) throws DaoException;

	List<Film> getFilmsByScenarioWriters(String firstName, String lastName) throws DaoException;

	List<Film> getFilmsByGenre(String genre) throws DaoException;

	List<Film> getMostBudgetFilms(int value) throws DaoException;

	List<Film> getMostCashBoxFilms(int value) throws DaoException;

}
