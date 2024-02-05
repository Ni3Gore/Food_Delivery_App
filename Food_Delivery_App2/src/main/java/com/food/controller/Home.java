package com.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.daoImplementation.RestaurantDAOImpl;
import com.food.daoImplementation.UserDAOImpl;
import com.food.model.Restaurant;
import com.food.model.User;

@WebServlet("/home")
public class Home extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		RestaurantDAOImpl restaurantDAOImpl = new RestaurantDAOImpl();
		List<Restaurant> allRestaurant = restaurantDAOImpl.getAllRestaurant();
		
		req.setAttribute("allresto", allRestaurant);
		
		RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
		rd.include(req, resp);
		
	}
}
