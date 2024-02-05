package com.food.daoImplementation;

import java.util.List;

import com.food.model.OrderItem;
import com.food.model.User;

public class test {

	public static void main(String[] args) {
		
//		User user = new User(1, "nitingore", "niti@31", "Niting@1995", "nitin@gmail.com", "Customer");
		UserDAOImpl impluser = new UserDAOImpl();
//		impluser.addUser(user);
		impluser.deletUser(1);
		List<User> allUser = impluser.getAllUser();
		System.out.println(allUser);
//		
//		Restaurant restaurant = new Restaurant(1, "Donne_Biryani", "Biryani", 5, "Bengaluru", 1, 3.8f, true, null);
//		RestaurantDAOImpl implrest = new RestaurantDAOImpl();
//		implrest.addRestaurent(restaurant);
//		List<Restaurant> allRestaurant = implrest.getAllRestaurant();
//		System.out.println(allRestaurant);
		
//		Menu menu = new Menu(1, 1, "Biryani", "very nice", 350, false);
//		MenuDAOImpl implmenu = new MenuDAOImpl();
//		implmenu.addMenu(menu);
//		List<Menu> allMenusByrestaurent = implmenu.getAllMenusByrestaurent(1);
//		System.out.println(allMenusByrestaurent);
		
//		 Order order = new Order(1, 1, 1, null, 0.00, "Delivered", "UPI");
//		 OrderDAOImpl implorder = new OrderDAOImpl();
//		 implorder.addOrder(order);
//		 List<Order> allOrdersByUser = implorder.getAllOrdersByUser(1);
//		 System.out.println(allOrdersByUser);
		
//		OrderItem orderItem = new OrderItem(1, 1, 1, 1, 125.00);
//		OrderItemDAOImpl orderItemDAOImpl = new OrderItemDAOImpl();
//		orderItemDAOImpl.addOrderItem(orderItem);
//		OrderItem orderItem = orderItemDAOImpl.getOrderItem(1);
//		orderItem.setItemTotal(175.0);
//		orderItemDAOImpl.updateOrderItem(orderItem);
//		List<OrderItem> allOrderItemByOrder = orderItemDAOImpl.getAllOrderItemByOrder(1);
//		System.out.println(allOrderItemByOrder);
		
		
	}

}
