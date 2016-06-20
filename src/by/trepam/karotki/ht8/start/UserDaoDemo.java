package by.trepam.karotki.ht8.start;

import java.util.List;

import by.trepam.karotki.ht8.dao.DaoFactory;
import by.trepam.karotki.ht8.dao.IUserDao;
import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.User;

public class UserDaoDemo {

	public static void main(String[] args) throws DaoException{
		DaoFactory factory = DaoFactory.getDaoFactory();
		IUserDao uDao = factory.getUserDao();

		System.out.println("List of users from Минск:");
		List<User> uList = uDao.getUsersByCity("Минск");
		for (User i : uList) {
			System.out.println(i.getFirstName() + "  " + i.getLastName());
		}
		System.out.println("---------------------------------------");

		System.out.println("List of users from России:");
		uList = uDao.getUsersByCountry("Россия");
		for (User i : uList) {
			System.out.println(i.getFirstName() + "  " + i.getLastName());
		}

		System.out.println("---------------------------------------");
		
		System.out.println("List of banned users:");
		uList = uDao.getBannedUsers();
		for (User i : uList) {
			System.out.println(i.getFirstName() + "  " + i.getLastName());
		}

		System.out.println("---------------------------------------");

		System.out.println("Top 5 users having most rate:");
		uList = uDao.getActiveUsersByRate(5);
		for (User i : uList) {
			System.out.println(i.getFirstName() + "  " + i.getLastName()+" "+i.getRate());
		}

		System.out.println("---------------------------------------");
		
		
		System.out.println("Top 5 users having most comments:");
		uList = uDao.getActiveUsersByComment(5);
		for (User i : uList) {
			System.out.println(i.getFirstName() + "  " + i.getLastName()+" "+i.getRate());
		}

		System.out.println("---------------------------------------");
		
	}

}
