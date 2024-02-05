<%@page import="com.food.model.User"%>
<%@page import="com.food.model.Restaurant"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="com.food.model.Restaurant, com.food.model.User"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>HOME</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

	<div class="navbar">
		<div class="logo">Food Delivery</div>
		<div class="nav-links">
			<a href="home">Restaurant</a> <a href="cart.jsp">Cart</a> <a href="Profile">Profile</a>
			<a href="Logout.jsp">Logout</a>
		</div>
	</div>

	<div class="container">
		<%
		User u = (User) session.getAttribute("User");
		%>
		<h3>
			Welcome
			<%=u.getUserName()%></h3>
		<h1>RESTAURANTS</h1>



		<div class="card-container">
			<!-- Restaurant Card 1 -->

			<%
			List<Restaurant> allRestaurant = (List<Restaurant>) request.getAttribute("allresto");
			for (Restaurant rest : allRestaurant) {

				int id = rest.getRestaurantId();
				String name = rest.getName();
				String cusinType = rest.getCuisine_type();
				String address = rest.getAddress();
				float rating = rest.getRating();
				String path = rest.getImagePath();
				int ariving = rest.getDeliveryTime();
				request.setAttribute("restId", rest.getRestaurantId());
			%>
			<div class="card">
				<a href="Menu?restid=<%=id%>"> 
				<img src="https://source.unsplash.com/720x600/?Restaurant, <%=cusinType%><%=name %>" alt="Restaurant">
				</a>

				<h2><%=name%></h2>
				<p>
					<strong>CusinType: </strong><%=cusinType%></p>
				<p>
					<strong>Will be Ariving in: </strong><%=ariving%>
					minutes
				</p>
				<p>
					<strong>Rating: </strong><%=rating%></p>



			</div>
			<%
			}
			/*  response.sendRedirect("Menu"); */
			%>
		</div>
	</div>
	<div class="footer">
		<a href="#">About Us</a> <a href="#">Contact Us</a> <a href="#">Privacy
			Policy</a> <a href="#">Terms and Conditions</a>
	</div>
</body>
</html>
