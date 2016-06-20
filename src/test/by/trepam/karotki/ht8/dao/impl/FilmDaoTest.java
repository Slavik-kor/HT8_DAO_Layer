package test.by.trepam.karotki.ht8.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import by.trepam.karotki.ht8.dao.DaoFactory;
import by.trepam.karotki.ht8.dao.IFilmDao;
import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.Film;


public class FilmDaoTest {

	private static DaoFactory factory;
	private static IFilmDao fDao;
	private List<Film> fList;
	private static final String firstName = "Сильвестр";
	private static final String lastName = "Сталлоне";
	private static final String genre = "Боевик";
	private static final int top = 5;

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
		try{
		fList = fDao.getFilmsByActors(firstName, lastName);
		}catch(DaoException e){fail("DaoException expected");}
		for (Film i : fList) {
			assertNotNull("NotNull", i);
		}
	}
	
	@Test
	public void getFilmsByDirectorsTest() {
		try{
			fList = fDao.getFilmsByDirectors(firstName, lastName);
			}catch(DaoException e){fail("DaoException expected");}
		
		for (Film i : fList) {
			assertNotNull("NotNull", i);
		}
	}
	
	@Test
	public void getFilmsByScenarioWritersTest() {
		try{
			fList = fDao.getFilmsByScenarioWriters(firstName, lastName);
			}catch(DaoException e){fail("DaoException expected");}
		
		for (Film i : fList) {
			assertNotNull("NotNull", i);
		}
	}
	
	@Test
	public void getFilmsByGenreTest() {
		
		try{
			fList = fDao.getFilmsByGenre(genre);
			}catch(DaoException e){fail("DaoException expected");}
		for (Film i : fList) {
			assertNotNull("NotNull", i);
		}
	}
	
	@Test
	public void getMostBudgetFilmsTest() {
		try{
			fList = fDao.getMostBudgetFilms(top);
			}catch(DaoException e){fail("DaoException expected");}
		
		for (Film i : fList) {
			assertNotNull("NotNull", i);
		}
	}
	
	@Test
	public void getMostCashBoxOfficeFilmsTest() {
		try{
			fList = fDao.getMostCashBoxFilms(top);
			}catch(DaoException e){fail("DaoException expected");}
		for (Film i : fList) {
			assertNotNull("NotNull", i);
		}
	}
	
	

}
