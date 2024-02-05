package com.food.dao;

import java.util.List;

import com.food.model.Menu;

public interface MenuDAO {

	void addMenu(Menu menu);
	void deleteMenu(int menuId);
	Menu getMenu(int menuId);
	void updateMenu(Menu menu);
	List<Menu> getAllMenusByrestaurent(int restaurantId);	
}
