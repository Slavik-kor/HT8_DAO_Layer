package test.by.trepam.karotki.ht8.test.dao.impl;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import by.trepam.karotki.ht8.dao.DaoFactory;
import by.trepam.karotki.ht8.dao.IAuthorDao;
import by.trepam.karotki.ht8.entity.Author;

public class AuthorDaoTest {
	private static DaoFactory factory;
	private static IAuthorDao aDao;
	private List<Author> aList;

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
		aList = aDao.getAuthorListByCountry("Беларусь");
		for (Author i : aList) {
			assertNotNull("NotNull", i);
		}
	}
	
	@Test
	public void getAuthorByFilmTest() {
		aList = aDao.getAuthorListByFilm("Брестская крепость");
		for (Author i : aList) {
			assertNotNull("NotNull", i);
		}
	}

}
