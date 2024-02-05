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

import com.food.daoImplementation.CartDAOImpl;
import com.food.daoImplementation.MenuDAOImpl;
import com.food.model.CartItem;
import com.food.model.Menu;

@WebServlet("/cart")
public class Cart extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		HttpSession session = req.getSession();
		CartDAOImpl cart = (CartDAOImpl) session.getAttribute("cart");
		if (cart == null) {

			cart = new CartDAOImpl();
			session.setAttribute("cart", cart);
		}

		String action = req.getParameter("action");
		if (action.equals("add")) {
			addtemToCart(req, resp, cart);
		} else if (action.equals("Update")) {
			updateItemToCart(req, cart);
		} else if (action.equals("Remove")) {
			removeItemToCart(req, cart);
		}

		session.setAttribute("cart", cart);
		resp.sendRedirect("cart.jsp");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.sendRedirect("cart.jsp");
	}

	private void removeItemToCart(HttpServletRequest req, CartDAOImpl cart) {

		int itemId = Integer.parseInt(req.getParameter("itemId"));
		cart.removeItem(itemId);
	}

	private void updateItemToCart(HttpServletRequest req, CartDAOImpl cart) {

		int itemId = Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		cart.updateItem(itemId, quantity);
	}

	private void addtemToCart(HttpServletRequest req, HttpServletResponse resp, CartDAOImpl cart)
			throws ServletException, IOException {

		int itemId = Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));

		MenuDAOImpl menuDAO = new MenuDAOImpl();
		Menu menu = menuDAO.getMenu(itemId);

		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = req.getSession();

		if (cart.getAllItem().isEmpty()) {
			session.setAttribute("FirstRestId", menu.getResturantId());
		}

		if (menu.getResturantId() == (Integer) session.getAttribute("FirstRestId")) {
			session.setAttribute("restaurentId", menu.getResturantId());

			CartItem cartItem = new CartItem(menu.getMenuId(), menu.getResturantId(), menu.getItemName(),
					menu.getPrice(), quantity);

			cart.addItem(cartItem);

		} else {

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please first complete your Pending orders in cart OR try to add from same restaurent');");
			out.println("</script>");
			RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
			rd.include(req, resp);

		}

	}
}
