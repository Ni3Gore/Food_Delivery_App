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

import com.food.daoImplementation.UserDAOImpl;
import com.food.model.User;
import com.food.util.HashingPassword;

@WebServlet("/signup")
public class Signup extends HttpServlet {	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		String rawPassword = req.getParameter("password");
		String password = HashingPassword.hashString(rawPassword);
		String email = req.getParameter("email");
//		String role = req.getParameter("enum");
		User user = new User(username, password, email, null, "Customer");
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		userDAOImpl.addUser(user);

		RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
		rd.include(req, resp);
	}
}
