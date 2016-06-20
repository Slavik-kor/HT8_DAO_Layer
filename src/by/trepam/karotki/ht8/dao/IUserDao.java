package by.trepam.karotki.ht8.dao;

import java.util.List;

import by.trepam.karotki.ht8.dao.exception.DaoException;
import by.trepam.karotki.ht8.entity.User;

public interface IUserDao {

	List<User> getUsersByCity(String city) throws DaoException;

	List<User> getUsersByCountry(String country) throws DaoException;

	List<User> getBannedUsers() throws DaoException;

	List<User> getActiveUsersByRate(int value) throws DaoException;

	List<User> getActiveUsersByComment(int value) throws DaoException;

}
