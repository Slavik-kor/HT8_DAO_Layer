package test.by.trepam.karotki.ht8.test.dao.impl;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import by.trepam.karotki.ht8.dao.DaoFactory;
import by.trepam.karotki.ht8.dao.IFilmDao;
import by.trepam.karotki.ht8.entity.Film;


public class FilmDaoTest {

	private static DaoFactory factory;
	private static IFilmDao fDao;
	private List<Film> fList;
	private static final String firstName = "Сильвестр";
	private static final String lastName = "Сталлоне";
	private static final String genre = "Боевик";

	@BeforeClass
	public static void initDaoUser() {
		factory = DaoFactory.getDaoFactory();
		fDao = factory.getFilmDao();
	}

	@After
	public void clearUserList() {
		fList = null;
	}

	@Test
	public void getFilmsByActorsTest() {
		fList = fDao.getFilmsByActors(firstName, lastName);
		for (Film i : fList) {
			assertNotNull("NotNull", i);
		}
	}
	
	@Test
	public void getFilmsByDirectorsTest() {
		fList = fDao.getFilmsByDirectors(firstName, lastName);
		for (Film i : fList) {
			assertNotNull("NotNull", i);
		}
	}
	
	@Test
	public void getFilmsByScenarioWritersTest() {
		fList = fDao.getFilmsByScenarioWriters(firstName, lastName);
		for (Film i : fList) {
			assertNotNull("NotNull", i);
		}
	}
	
	@Test
	public void getFilmsByGenreTest() {
		fList = fDao.getFilmsByGenre(genre);
		for (Film i : fList) {
			assertNotNull("NotNull", i);
		}
	}
	
	@Test
	public void getMostBudgetFilmsTest() {
		fList = fDao.getMostBudgetFilms(5);
		for (Film i : fList) {
			assertNotNull("NotNull", i);
		}
	}
	
	@Test
	public void getMostCashBoxOfficeFilmsTest() {
		fList = fDao.getMostCashBoxFilms(5);
		for (Film i : fList) {
			assertNotNull("NotNull", i);
		}
	}
	
	

}
