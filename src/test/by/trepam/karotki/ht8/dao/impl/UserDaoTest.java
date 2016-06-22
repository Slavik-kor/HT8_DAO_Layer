package test.by.trepam.karotki.ht8.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import by.trepam.karotki.ht8.dao.DaoFactory;
import by.trepam.karotki.ht8.dao.IAccountDao;
import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.Account;

public class UserDaoTest {
	private static DaoFactory factory;
	private static IAccountDao uDao;
	private List<Account> uList;
	private static final String city = "Минск";
	private static final String country = "Беларусь";
	private static final int top = 5;

	@BeforeClass
	public static void initDaoUser() {
		try {
			factory = DaoFactory.getDaoFactory();
		} catch (DaoException e) {
			fail("DaoException expected");
		}
		uDao = factory.getUserDao();
	}

	@After
	public void clearUserList() {
		uList = null;
	}

	@Test
	public void getUsersByCityTest() {

		try {
			uList = uDao.getUsersByCity(city);
		} catch (DaoException e) {
			fail("DaoException expected");
		}
		for (Account i : uList) {
			assertNotNull("NotNull", i);
		}
	}

	@Test
	public void getUsersByCountryTest() {
		try {
			uList = uDao.getUsersByCity(country);
		} catch (DaoException e) {
			fail("DaoException expected");
		}
		for (Account i : uList) {
			assertNotNull("NotNull", i);
		}
	}

	@Test
	public void getbannedTest() {
		try {
			uList = uDao.getBannedUsers();
		} catch (DaoException e) {
			fail("DaoException expected");
		}
		for (Account i : uList) {
			assertEquals(false, i.isActive());
		}
	}

	@Test
	public void getActiveUsersByRateTest() {
		try {
			uList = uDao.getActiveUsersByRate(top);
		} catch (DaoException e) {
			fail("DaoException expected");
		}
		for (Account i : uList) {
			assertNotNull("NotNull", i);
		}
	}

	@Test
	public void getActiveUsersByCommentTest() {
		try {
			uList = uDao.getActiveUsersByRate(top);
		} catch (DaoException e) {
			fail("DaoException expected");
		}
		for (Account i : uList) {
			assertNotNull("NotNull", i);
		}
	}

}
