package com.food.dao;

import java.util.List;

import com.food.model.Order;

public interface OrderDAO {

	void addOrder(Order order);
	void deleteOrder(int orderId);
	void updateOrder(Order order);
	Order getOrder(int orderId);
	List<Order> getAllOrdersByUser(int userId);	
}
