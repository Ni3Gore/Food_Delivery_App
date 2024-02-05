package com.food.dao;

import java.util.List;

import com.food.model.User;

public interface UserDAO {

	void addUser(User user);
	User getUser(int userId);
	List<User> getAllUser();
	void updateUser(User user);
	void deletUser(int userId);
	User getUser(String email);
}
