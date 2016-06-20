package by.trepam.karotki.ht8.start;

import java.util.List;

import by.trepam.karotki.ht8.dao.DaoFactory;
import by.trepam.karotki.ht8.dao.IFilmDao;
import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.Film;

public class FilmDaoDemo {

	public static void main(String[] args) throws DaoException {
		DaoFactory factory = DaoFactory.getDaoFactory();
		IFilmDao fDao = factory.getFilmDao();
		System.out.println("Top 5 The best films by rating:");
		List<Film> fList = null;

		fList = fDao.getTopFilmsByRating(5);

		for (Film i : fList) {
			System.out.println(i.getTitle() + "  " + i.getRate());
		}

		System.out.println("---------------------------------------");
		System.out.println("List of films having Silvestre Stallone as an actor:");

		fList = fDao.getFilmsByActors("Сильвестр", "Сталлоне");

		for (Film i : fList) {
			System.out.println(i.getTitle());
		}

		System.out.println("---------------------------------------");

		System.out.println("List of films having Silvestre Stallone as an director:");

		fList = fDao.getFilmsByDirectors("Сильвестр", "Сталлоне");

		for (Film i : fList) {
			System.out.println(i.getTitle());
		}

		System.out.println("---------------------------------------");

		System.out.println("List of films having Silvestre Stallone as an scenariowriter:");

		fList = fDao.getFilmsByScenarioWriters("Сильвестр", "Сталлоне");

		for (Film i : fList) {
			System.out.println(i.getTitle());
		}

		System.out.println("---------------------------------------");

		System.out.println("List of films having genre \"Боевик\": ");

		fList = fDao.getFilmsByGenre("Боевик");

		for (Film i : fList) {
			System.out.println(i.getTitle());
		}

		System.out.println("---------------------------------------");

		System.out.println("Top 5 films by a budget:");

		fList = fDao.getMostBudgetFilms(5);

		for (Film i : fList) {
			System.out.println(i.getTitle() + "   " + i.getBudget());
		}

		System.out.println("---------------------------------------");

		System.out.println("Top 5 films by a Box Office Cash:");

		fList = fDao.getMostCashBoxFilms(5);

		for (Film i : fList) {
			System.out.println(i.getTitle() + "   " + i.getBoxOfficeCash());
		}

		System.out.println("---------------------------------------");

	}

}
