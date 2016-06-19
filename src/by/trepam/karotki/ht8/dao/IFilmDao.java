package by.trepam.karotki.ht8.dao;

import java.util.List;


import by.trepam.karotki.ht8.entity.Comment;
import by.trepam.karotki.ht8.entity.Film;

public interface IFilmDao {
	
	List<Comment> getCommentsByFilm(String title);
	List<Film> getTopFilmsByRating(int value);
	List<Film> getFilmsByActors(String firstName, String lastName);
	List<Film> getFilmsByDirectors(String firstName, String lastName);
	List<Film> getFilmsByScenarioWriters(String firstName, String lastName);
	List<Film> getFilmsByGenre(String genre);
	List<Film> getMostBudgetFilms(int value);
	List<Film> getMostCashBoxFilms(int value);


}
