package by.trepam.karotki.ht8.start;

import java.util.List;

import by.trepam.karotki.ht8.dao.DaoFactory;
import by.trepam.karotki.ht8.dao.IAuthorDao;
import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.Author;

public class AuthorDaoDemo {
	private static final String HEAD_AUTHOR_BY_COUNTRY = "List of authors from \"Беларусь\":";
	private static final String HEAD_AUTHOR_BY_FILM = "List of authors from film \"Брестская крепость\":";
	private static final String COUNTRY_NAME = "Беларусь";
	private static final String FILM_TITLE = "Брестская крепость";
	private static final String SEPARATOR = "---------------------------------------";

	public static void main(String[] args) throws DaoException {
		DaoFactory factory = DaoFactory.getDaoFactory();
		IAuthorDao aDao = factory.getAuthorDao();
		System.out.println(HEAD_AUTHOR_BY_COUNTRY);

		List<Author> aList = aDao.getAuthorListByCountry(COUNTRY_NAME);

		for (Author i : aList) {
			System.out.println(i.getFirstName() + "  " + i.getLastName());
		}
		System.out.println(SEPARATOR);
		
		System.out.println(HEAD_AUTHOR_BY_FILM);

		aList = aDao.getAuthorListByFilm(FILM_TITLE);

		for (Author i : aList) {
			System.out.println(i.getFirstName() + "  " + i.getLastName());
		}
		System.out.println(SEPARATOR);
	}

}
