package com.food.dao;

import java.util.List;

import com.food.model.OrderItem;

public interface OrderItemDAO {

	void addOrderItem(OrderItem orderitem);
	void deleteOrderItem(int orderItemId);
	void updateOrderItem(OrderItem orderitem);
	OrderItem getOrderItem(int orderitemId);
	List<OrderItem> getAllOrderItemByOrder(int orderId);
}
