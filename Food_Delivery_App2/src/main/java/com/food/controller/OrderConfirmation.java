package com.food.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.daoImplementation.CartDAOImpl;
import com.food.daoImplementation.OrderDAOImpl;
import com.food.daoImplementation.OrderItemDAOImpl;
import com.food.daoImplementation.UserDAOImpl;
import com.food.model.CartItem;
import com.food.model.Order;
import com.food.model.OrderItem;
import com.food.model.Restaurant;
import com.food.model.User;
import com.food.util.OrderIdGenerator;

@WebServlet("/orderconfirm")
public class OrderConfirmation extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		OrderDAOImpl orderimpl = new OrderDAOImpl();
		OrderItemDAOImpl itemimpl = new OrderItemDAOImpl();
		UserDAOImpl uimpl = new UserDAOImpl();
		CartDAOImpl cart = (CartDAOImpl) session.getAttribute("cart");

		User user = (User) session.getAttribute("User");
		user.setAddress(req.getParameter("address"));
		uimpl.updateUser(user);

		Restaurant restaurant = (Restaurant) session.getAttribute("restaurentdetails");
		int orderId = Integer.parseInt(OrderIdGenerator.getId());
		Order order = new Order(orderId, user.getUserId(), restaurant.getRestaurantId(),
				(double) session.getAttribute("TotalAount"), "In Progress", req.getParameter("payment-method"));
		orderimpl.addOrder(order);

		Map<Integer, CartItem> allitems = cart.getAllItem();
		for (CartItem ci : allitems.values()) {
			OrderItem oi = new OrderItem(orderId, ci.getItemid(), ci.getQuantity(), ci.getPrice() * ci.getQuantity());
			itemimpl.addOrderItem(oi);
		}

		req.getRequestDispatcher("orderconfirming.jsp").forward(req, resp);
	}
}
