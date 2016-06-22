package by.trepam.karotki.ht8.dao;

import java.util.List;

import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.Account;

public interface IAccountDao {

	List<Account> getUsersByCity(String city) throws DaoException;

	List<Account> getUsersByCountry(String country) throws DaoException;

	List<Account> getBannedUsers() throws DaoException;

	List<Account> getActiveUsersByRate(int value) throws DaoException;

	List<Account> getActiveUsersByComment(int value) throws DaoException;

}
