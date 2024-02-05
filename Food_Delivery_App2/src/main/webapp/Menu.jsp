<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page import="com.food.model.Menu"%>
<%@page import="java.util.ArrayList"%>

<html>
<head>
<title>Menu Page</title>
<link rel="stylesheet" type="text/css" href="Menu.css">
</head>
<body>

	<div class="navbar">
		<div class="logo">Food Delivery</div>
		<div class="nav-links">
			<a href="home">Restaurant</a> <a href="cart">Cart</a> <a href="Profile">Profile</a>
			<a href="Logout.jsp">Logout</a>
		</div>
	</div>
	<div class="container">
		<h1>MENU</h1>

		<div class="card-container">
			<!-- Restaurant Card 1 -->
			<%
			ArrayList<Menu> allRestMenu = (ArrayList<Menu>) request.getAttribute("AllMenuRestId");

			if (allRestMenu != null) {

				for (Menu menu : allRestMenu) {

					int menuid = menu.getMenuId();
					String Itemname = menu.getItemName();
					String Discription = menu.getDiscription();
					double price = menu.getPrice();
			%>
			<div class="card">
				<img src="https://source.unsplash.com/720x600/?food, <%=Itemname%>"
					alt="Menu 1">
				<h3><%=Itemname%></h3>
				<p>
					<strong>Description : </strong>
				<p><%=Discription%></p>

				<p>
					<strong>Price: &#8377;</strong><%=price%></p>
				<form action="cart" method="post">
					<p>
						<strong>Quantity: </strong> <input type="number" name="quantity"
							min="1" value="1">
					</p>

					<input type="hidden" name="itemId" value="<%=menuid%>">
					<button type="submit" name="action" value="add">Add to
						cart</button>
				</form>
			</div>

			<%
			}
			} else {
			%>
			<p>No Menu Items is available</p>

			<%
			}
			%>

		</div>

	</div>
	<div class="footer">
		<a href="#">About Us</a> <a href="#">Contact Us</a> <a href="#">Privacy
			Policy</a> <a href="#">Terms and Conditions</a>
	</div>
</body>
</html>
