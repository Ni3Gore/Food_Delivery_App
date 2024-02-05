package com.food.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.daoImplementation.OrderDAOImpl;
import com.food.model.Order;
import com.food.model.User;

@WebServlet("/Profile")
public class Profile extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("User");
		
		OrderDAOImpl orderimpl = new OrderDAOImpl();
		List<Order> allOrdersByUser = orderimpl.getAllOrdersByUser(user.getUserId());
		
		req.setAttribute("allOrdersByUser", allOrdersByUser);
		
		
		req.getRequestDispatcher("Profile.jsp").forward(req, resp);
		
		
	}
}