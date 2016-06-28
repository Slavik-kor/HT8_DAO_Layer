package by.trepam.karotki.ht8.start;

import java.util.List;

import by.trepam.karotki.ht8.dao.DaoFactory;
import by.trepam.karotki.ht8.dao.IFilmDao;
import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.Film;

public class FilmDaoDemo {
	private static final String HEAD_TOP_5 = "Top 5 The best films by rating:";
	private static final String HEAD_FILM_BY_ACTOR = "List of films having Silvestre Stallone as an actor:";
	private static final String HEAD_FILM_BY_DIRECTOR = "List of films having Silvestre Stallone as an director:";
	private static final String HEAD_FILM_BY_SCENARIOWRITER = "List of films having Silvestre Stallone as an scenariowriter:";
	private static final String HEAD_FILM_BY_GENRE = "List of films having genre \"Боевик\": ";
	private static final String HEAD_FILM_BY_BUDGET = "Top 5 films by a budget:";
	private static final String HEAD_FILM_BY_BOX_OFFICE_CASH = "Top 5 films by a Box Office Cash:";
	private static final String GENRE = "Боевик";
	private static final String AUTHOR_FIRST_NAME = "Сильвестр";
	private static final String AUTHOR_LAST_NAME = "Сталлоне";
	
	private static final String SEPARATOR = "---------------------------------------";
	
	
	public static void main(String[] args) throws DaoException {
		
		
		DaoFactory factory = DaoFactory.getDaoFactory();
		IFilmDao fDao = factory.getFilmDao();
		System.out.println(HEAD_TOP_5);
		List<Film> fList = null;

		fList = fDao.getTopFilmsByRating(5);

		for (Film i : fList) {
			System.out.println(i.getTitle());
		}

		System.out.println(SEPARATOR);
		System.out.println(HEAD_FILM_BY_ACTOR);

		fList = fDao.getFilmsByActors(AUTHOR_FIRST_NAME, AUTHOR_LAST_NAME);

		for (Film i : fList) {
			System.out.println(i.getTitle());
		}

		System.out.println(SEPARATOR);

		System.out.println(HEAD_FILM_BY_DIRECTOR);

		fList = fDao.getFilmsByDirectors(AUTHOR_FIRST_NAME, AUTHOR_LAST_NAME);

		for (Film i : fList) {
			System.out.println(i.getTitle());
		}

		System.out.println(SEPARATOR);

		System.out.println(HEAD_FILM_BY_SCENARIOWRITER);

		fList = fDao.getFilmsByScenarioWriters(AUTHOR_FIRST_NAME, AUTHOR_LAST_NAME);

		for (Film i : fList) {
			System.out.println(i.getTitle());
		}

		System.out.println(SEPARATOR);

		System.out.println(HEAD_FILM_BY_GENRE);

		fList = fDao.getFilmsByGenre(GENRE);

		for (Film i : fList) {
			System.out.println(i.getTitle());
		}

		System.out.println(SEPARATOR);

		System.out.println(HEAD_FILM_BY_BUDGET);

		fList = fDao.getMostBudgetFilms(5);

		for (Film i : fList) {
			System.out.println(i.getTitle() + "   " + i.getBudget());
		}

		System.out.println(SEPARATOR);

		System.out.println(HEAD_FILM_BY_BOX_OFFICE_CASH);

		fList = fDao.getMostCashBoxFilms(5);

		for (Film i : fList) {
			System.out.println(i.getTitle() + "   " + i.getBoxOfficeCash());
		}

		System.out.println(SEPARATOR);

	}

}
