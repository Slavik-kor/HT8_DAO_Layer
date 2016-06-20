package test.by.trepam.karotki.ht8.test.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import by.trepam.karotki.ht8.dao.DaoFactory;
import by.trepam.karotki.ht8.dao.IUserDao;
import by.trepam.karotki.ht8.entity.User;

public class UserDaoTest {
	private static DaoFactory factory;
	private static IUserDao uDao;
	private List<User> uList;

	@BeforeClass
	public static void initDaoUser() {
		factory = DaoFactory.getDaoFactory();
		uDao = factory.getUserDao();
	}

	@After
	public void clearUserList() {
		uList = null;
	}

	@Test
	public void getUsersByCityTest() {
		uList = uDao.getUsersByCity("Минск");
		for (User i : uList) {
			assertNotNull("NotNull", i);
		}
	}

	@Test
	public void getUsersByCountryTest() {
		uList = uDao.getUsersByCity("Беларусь");
		for (User i : uList) {
			assertNotNull("NotNull", i);
		}
	}

	@Test
	public void getbannedTest() {
		uList = uDao.getBannedUsers();
		for (User i : uList) {
			assertEquals(false, i.isActive());
		}
	}

	@Test
	public void getActiveUsersByRateTest() {
		uList = uDao.getActiveUsersByRate(5);
		for (User i : uList) {
			assertNotNull("NotNull", i);
		}
	}

	@Test
	public void getActiveUsersByCommentTest() {
		uList = uDao.getActiveUsersByRate(5);
		for (User i : uList) {
			assertNotNull("NotNull", i);
		}
	}

}
