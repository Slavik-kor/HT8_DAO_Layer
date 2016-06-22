package by.trepam.karotki.ht8.start;

import java.util.List;

import by.trepam.karotki.ht8.dao.DaoFactory;
import by.trepam.karotki.ht8.dao.IAuthorDao;
import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.Author;

public class AuthorDaoDemo {

	public static void main(String[] args) throws DaoException {
		DaoFactory factory = DaoFactory.getDaoFactory();
		IAuthorDao aDao = factory.getAuthorDao();
		System.out.println("List of authors from \"Беларусь\":");

		List<Author> aList = aDao.getAuthorListByCountry("Беларусь");

		for (Author i : aList) {
			System.out.println(i.getFirstName() + "  " + i.getLastName());
		}
		System.out.println("---------------------------------------");
		
		System.out.println("List of authors from film \"Брестская крепость\":");

		aList = aDao.getAuthorListByFilm("Брестская крепость");

		for (Author i : aList) {
			System.out.println(i.getFirstName() + "  " + i.getLastName());
		}
		System.out.println("---------------------------------------");
	}

}
