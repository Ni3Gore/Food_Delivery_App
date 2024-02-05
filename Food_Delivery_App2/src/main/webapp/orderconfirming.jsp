<%@page import="com.food.model.Restaurant"%>
<%@page import="com.food.model.CartItem"%>
<%@page import="java.util.Map"%>
<%@page import="com.food.daoImplementation.CartDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="confirmorder.css">
<title>Order Confirmation</title>

</head>
<body>
	<div class="navbar">
		<div class="logo">Food Delivery</div>
		<div class="nav-links">
			<a href="home">Restaurant</a> <a href="cart">Cart</a> <a href="Profile">Profile</a>
			<a href="Logout.jsp">Logout</a>
		</div>
	</div>

	<div class="confirmation-box">
		<h2>Order Confirmed</h2>

		<%
		Restaurant restaurant = (Restaurant) session.getAttribute("restaurentdetails");
		%>
		 <h3>
			Restaurant :<%=restaurant.getName()%></h3> 
		<p>Order Status: Preparing</p>
		<p>
			Arriving In:<%=restaurant.getDeliveryTime()%>
			Minutes
		</p>

		<div class="ordered-items">
			<p>Items Ordered:</p>
			<table>
				<thead>
					<tr>
						<th>Item Name</th>
						<th>Quantity</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<%
					CartDAOImpl cart = (CartDAOImpl) session.getAttribute("cart");

					Map<Integer, CartItem> allitems = cart.getAllItem();

					for (CartItem ci : allitems.values()) {
					%>
					<tr>
						<td><%=ci.getItemname()%></td>
						<td><%=ci.getQuantity()%></td>
						<td>&#8377;<%=ci.getPrice()%></td>
					</tr>
					<%
					}
					%>


				</tbody>
			</table>
		</div>
		<%
		String d = (String) session.getAttribute("formatedTotalAmount");
		%>
		<fmt:formatNumber type="number" maxFractionDigits="2" value="${total}" />
		<p class="total-amount">
			Total Amount:&#8377;<%=d%>
		</p>

		<p>
			Payment Method:<%=request.getParameter("payment-method")%></p>
			
		<%session.setAttribute("cart", null); %>
	</div>
	<div class="footer">
		<a href="#">About Us</a> <a href="#">Contact Us</a> <a href="#">Privacy
			Policy</a> <a href="#">Terms and Conditions</a>
	</div>
</body>
</html>
