package com.food.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.daoImplementation.UserDAOImpl;
import com.food.model.User;
import com.food.util.HashingPassword;

@WebServlet("/Setpassword")
public class Setnewpassword extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		String rawPassword = req.getParameter("password");
		String password = HashingPassword.hashString(rawPassword);
		
		HttpSession session = req.getSession();
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		User u = (User)session.getAttribute("User");
		u.setPassword(password);
		userDAOImpl.updateUser(u);
		
		RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
		rd.include(req, resp);
	}
}
