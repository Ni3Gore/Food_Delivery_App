package com.food.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.daoImplementation.UserDAOImpl;
import com.food.model.User;

@WebServlet("/findAcc")
public class Findacc extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String email = req.getParameter("email");
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		User u = userDAOImpl.getUser(email);
		if (u != null) {

			HttpSession session = req.getSession();
			session.setAttribute("User", u);
			RequestDispatcher rd = req.getRequestDispatcher("SetNewPassword.jsp");
			rd.include(req, resp);
		}else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('This email is not registered, Please SignUp');");
			out.println("</script>");
			RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
			rd.include(req, resp);
		}
	}

}
