package by.trepam.karotki.ht8.dao;

import java.util.List;

import by.trepam.karotki.ht8.entity.User;

public interface IUserDao {
	
	List<User> getUsersByCity(String city);
	List<User> getUsersByCountry(String country);
	List<User> getBannedUsers();
	List<User> getActiveUsersByRate(int value);
	List<User> getActiveUsersByComment(int value);
	

}
