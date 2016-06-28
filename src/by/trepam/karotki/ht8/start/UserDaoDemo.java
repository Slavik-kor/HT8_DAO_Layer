package by.trepam.karotki.ht8.start;

import java.util.List;

import by.trepam.karotki.ht8.dao.DaoFactory;
import by.trepam.karotki.ht8.dao.IAccountDao;
import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.Account;

public class UserDaoDemo {
	private static final String HEAD_ACCOUNTS_BY_CITY = "List of users from Минск:";
	private static final String HEAD_ACCOUNTS_BY_COUNTRY = "List of users from России:";
	private static final String HEAD_BANNED_ACCOUNTS = "List of banned users:";
	private static final String HEAD_MOST_RATE_ACCOUNTS = "Top 5 users having most rate:";
	private static final String HEAD_MOST_COMMETS_ACCOUNTS = "Top 5 users having most comments:";
	private static final String CITY_NAME = "Минск";
	private static final String COUNTRY_NAME = "Россия";
	
	private static final String SEPARATOR = "---------------------------------------";

	public static void main(String[] args) throws DaoException {
		DaoFactory factory = DaoFactory.getDaoFactory();
		IAccountDao uDao = factory.getUserDao();

		System.out.println(HEAD_ACCOUNTS_BY_CITY);
		List<Account> uList = uDao.getUsersByCity(CITY_NAME);
		for (Account i : uList) {
			System.out.println(i.getFirstName() + "  " + i.getLastName());
		}
		System.out.println(SEPARATOR);

		System.out.println(HEAD_ACCOUNTS_BY_COUNTRY);
		uList = uDao.getUsersByCountry(COUNTRY_NAME);
		for (Account i : uList) {
			System.out.println(i.getFirstName() + "  " + i.getLastName());
		}

		System.out.println(SEPARATOR);

		System.out.println(HEAD_BANNED_ACCOUNTS);
		uList = uDao.getBannedUsers();
		for (Account i : uList) {
			System.out.println(i.getFirstName() + "  " + i.getLastName());
		}

		System.out.println(SEPARATOR);

		System.out.println(HEAD_MOST_RATE_ACCOUNTS);
		uList = uDao.getActiveUsersByRate(5);
		for (Account i : uList) {
			System.out.println(i.getFirstName() + "  " + i.getLastName());
		}

		System.out.println(SEPARATOR);

		System.out.println(HEAD_MOST_COMMETS_ACCOUNTS);
		uList = uDao.getActiveUsersByComment(5);
		for (Account i : uList) {
			System.out.println(i.getFirstName() + "  " + i.getLastName());
		}

		System.out.println(SEPARATOR);

	}

}
