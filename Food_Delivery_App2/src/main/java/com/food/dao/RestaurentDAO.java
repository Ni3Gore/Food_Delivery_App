package com.food.dao;

import java.util.List;

import com.food.model.Restaurant;

public interface RestaurentDAO {

	void addRestaurent(Restaurant restaurant);
	void deleteRestaurent(int restaurantId);
	void updateRestaurent(Restaurant restaurant);
	Restaurant getRestaurant(int restaurantId);
	List<Restaurant> getAllRestaurant();
}
