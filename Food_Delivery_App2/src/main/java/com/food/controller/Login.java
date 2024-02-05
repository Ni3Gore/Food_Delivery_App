package com.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.daoImplementation.RestaurantDAOImpl;
import com.food.daoImplementation.UserDAOImpl;
import com.food.model.Restaurant;
import com.food.model.User;
import com.food.util.HashingPassword;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		String rawPassword = req.getParameter("password");
		String password = HashingPassword.hashString(rawPassword);
		String parameter = req.getParameter("action");
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		
		List<User> allUser = userDAOImpl.getAllUser();
		boolean flag = false;

		for (User u : allUser) {
			if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
				flag = true;				
				Cookie c = new Cookie("username", username);
				Cookie c1 = new Cookie("password", password);
				resp.addCookie(c);
				resp.addCookie(c1);
				HttpSession session = req.getSession();
				session.setAttribute("User", u);
				
				RequestDispatcher rd = req.getRequestDispatcher("home");
				rd.include(req, resp);
			
			}
		}
		
		if(!flag) {
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Entered credentials are Invalid Please Login again');");
			out.println("</script>");
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.include(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	}
}
