package com.food.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.daoImplementation.MenuDAOImpl;
import com.food.daoImplementation.RestaurantDAOImpl;
import com.food.model.Restaurant;

@WebServlet("/Menu")
public class MenuServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MenuDAOImpl menuDAOImpl = new MenuDAOImpl();

		RestaurantDAOImpl restaurantDAOImpl = new RestaurantDAOImpl();
		int restaurentId = Integer.parseInt(req.getParameter("restid"));
		List<com.food.model.Menu> allMenusByrestaurent = menuDAOImpl.getAllMenusByrestaurent(restaurentId);
		HttpSession session = req.getSession();
		Restaurant restaurant = restaurantDAOImpl.getRestaurant(restaurentId);
		
		session.setAttribute("restaurentdetails", restaurant);
//		session.setAttribute("restaurentId", restaurentId);
		req.setAttribute("AllMenuRestId", allMenusByrestaurent);
		RequestDispatcher rd = req.getRequestDispatcher("Menu.jsp");
		rd.include(req, resp);
		
		
	}
}
