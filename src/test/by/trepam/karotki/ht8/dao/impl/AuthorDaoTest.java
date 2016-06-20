package test.by.trepam.karotki.ht8.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import by.trepam.karotki.ht8.dao.DaoFactory;
import by.trepam.karotki.ht8.dao.IAuthorDao;
import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.Author;

public class AuthorDaoTest {
	private static DaoFactory factory;
	private static IAuthorDao aDao;
	private List<Author> aList;
	private static final String country = "Беларусь";
	private static final String filmTitle = "Брестская крепость";

	@BeforeClass
	public static void initDaoUser() {
		factory = DaoFactory.getDaoFactory();
		aDao = factory.getAuthorDao();
	}

	@After
	public void clearAuthorList() {
		aList = null;
	}

	@Test
	public void getAuthorByCountryTest() {
		try {
			aList = aDao.getAuthorListByCountry(country);
		} catch (DaoException e) {
			fail("DaoException expected");
		}
		for (Author i : aList) {
			assertNotNull("NotNull", i);
		}
	}

	@Test
	public void getAuthorByFilmTest() {
		try {
			aList = aDao.getAuthorListByFilm(filmTitle);
		} catch (DaoException e) {
			fail("DaoException expected");
		}
		for (Author i : aList) {
			assertNotNull("NotNull", i);
		}
	}

}
