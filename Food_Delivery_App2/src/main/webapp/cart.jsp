<%@page import="com.food.model.Restaurant"%>
<%@page import="com.food.model.CartItem"%>
<%@page import="java.util.Map"%>
<%@page import="com.food.daoImplementation.CartDAOImpl"%>
<%@page import="com.food.controller.Cart"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page import="java.util.ArrayList"%>

<html>
<head>
<title>Order Cart</title>
<link rel="stylesheet" type="text/css" href="cart.css">
</head>
<body>

	<div class="navbar">
		<div class="logo">Food Delivery</div>
		<div class="nav-links">
			<a href="home">Restaurant</a><a
				href="Menu?restid=<%=session.getAttribute("restaurentId")%>">Menu</a>
			<a href="Cart">Cart</a> <a href="Profile">Profile</a> <a href="Logout.jsp">Logout</a>
		</div>
	</div>

	<div class="container">
		<h1>Your Cart</h1>

		<div class="cart-container">
			<%
			CartDAOImpl cart = (CartDAOImpl) session.getAttribute("cart");
			Restaurant rest	= (Restaurant)session.getAttribute("restaurentdetails");
			if (session.getAttribute("cart") != null) {
				Map<Integer, CartItem> map = cart.getAllItem();
				for (CartItem ci : map.values()) {
			%>

			<div class="cart-item">

				<p>
					<strong>Item Name :</strong>
					<%=ci.getItemname()%></p>
				<p>
					<strong>Price : &#8377;</strong><%=ci.getPrice()%></p>
				<form action="cart" method="post">
					<input type="hidden" name="itemId" value="<%=ci.getItemid()%>">
					<label for="quantity">Quantity</label> <input type="number"
						name="quantity" id="quantity" value="<%=ci.getQuantity()%>"
						min="1"> <input type="submit" name="action" value="Update"
						class="input"> <input type="submit" name="action"
						value="Remove" class="input">
				</form>
			</div>
			<%
			}
			%>

			<a href="Menu?restid=<%=rest.getRestaurantId()%>">
				<input type="submit" value="Add More Items" class="input">
			</a>
			<form action="checkout.jsp">
				<input type="submit" value="CheckOut" class="input">
			</form>
		</div>


		<%
		} else {
		%>
		<p>Your cart is empty please add some items</p>
		<%
		}
		%>

	</div>

<footer class="footer">
	<a href="#">About Us</a> <a href="#">Contact Us</a> <a href="#">Privacy
		Policy</a> <a href="#">Terms and Conditions</a>
</footer>
</body>

</html>
