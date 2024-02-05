package com.food.dao;

import java.util.List;

import com.food.model.OrderHistory;

public interface OrderHistoryDAO {

	void addOrderHistory(OrderHistory orderhistory);
	OrderHistory getOrderHistory(int orderHistoryId);
	void updateOrderHistory(OrderHistory orderhistory);
	void deleteOrderHistory(int orderHistoryId);
	List<OrderHistory> getAllOrderHistoryByUser(int userId);
}
