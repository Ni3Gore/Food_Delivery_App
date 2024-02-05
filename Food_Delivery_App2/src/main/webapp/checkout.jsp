<%@page import="com.food.model.CartItem"%>
<%@page import="java.util.Map"%>
<%@page import="com.food.daoImplementation.CartDAOImpl"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page import="java.util.ArrayList"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="checkout.css">
<title>Checkout</title>
</head>
<body>

<div class="navbar">
		<div class="logo">Food Delivery</div>
		<div class="nav-links">
			<a href="home">Restaurant</a> <a href="cart">Cart</a> <a href="Profile">Profile</a>
			<a href="Logout.jsp">Logout</a>
		</div>
	</div>
	

	<h1>CHECKOUT</h1>
	<section>
		<div class="item-box">
			<div class="item-box-header">
				<h3 style="color: white-space; margin-left: 40%;">Food Details</h3>
			</div>

			<%
			CartDAOImpl cart = (CartDAOImpl) session.getAttribute("cart");
			double totalAmount = 0.0;
			if (cart != null) {

				Map<Integer, CartItem> allitems = cart.getAllItem();

				for (CartItem ci : allitems.values()) {
					double price = ci.getPrice();
					int quantity = ci.getQuantity();
					double totalPrice = price * quantity;
			%>


			<div class="item-details">
				<p style="color: black;">
					<strong>Item Name:<%=ci.getItemname()%></strong>
				</p>
				<p style="color: black;">
					<strong>Price:&#8377;<%=price%></strong>
				</p>
			</div>
			<div class="item-details">
				<p style="color: black;">
					<strong>Quantity:<%=quantity%></strong>
				</p>
				<p style="color: black;">
					<strong>Total Price:&#x20B9;<%=totalPrice%></strong>
				</p>
			</div>
			<div class="item-separator"></div>

			 <%
			totalAmount += totalPrice; //'UPI', 'Cash', 'Debit Card', 'Credit Card
			}
			}
			
			String GSTamount = String.format("%.2f", totalAmount*0.08);
			double totalamount =  Double.parseDouble(GSTamount) + totalAmount+10.78+35;
			String formatedTotalAmount =  String.format("%.2f", totalamount);
			%> 

		</div>

		<div class="total-amount" >
			<div class="item-box-header"
				style="margin: -20px; margin-bottom: 10px">
				<h3 style="color: #333; margin-left: 40%;">Bill Details</h3>
			</div>

			<!-- Additional Information -->
			<div class="item-details">
				<p style="color: black;">
					<strong>Item Total:</strong>
				</p>
				<p style="color: black;">
					<strong>&#8377;<%=totalAmount%></strong>
				</p>
			</div>
			<div class="item-details">
				<p style="color: black;">
					<strong>Packaging Charges:</strong>
				</p>
				<p style="color: black;">
					<strong>&#8377;10.78</strong>
				</p>
			</div>

			<div class="item-details">
				<p style="color: black;">
					<strong>GST:</strong>
				</p>
				<p style="color: black;">
					<strong>&#8377;<%=GSTamount%></strong>
				</p>
			</div>

			<div class="item-details">
				<p style="color: black;">
					<strong>Delivery Charge:</strong>
				</p>
				<p style="color: black;">
					<strong>&#8377;35</strong>
				</p>
			</div>

			<div class="item-separators"></div>

			<div class="item-details">
				<p style="color: black;">
					<strong><b>Amount to Pay:</b></strong>
				</p>
				<p style="color: black;">
					<strong><b>&#8377;<%=formatedTotalAmount%></b></strong>
				</p>

			</div>
			<%
			session.setAttribute("TotalAount",totalamount);
			session.setAttribute("formatedTotalAmount", formatedTotalAmount);
			%>
		
		</div>


		<div class="payment-form">
		<form action="orderconfirm" method="post">
			<label for="payment-method" style="color: black;">Payment
				Method:</label> <select id="payment-method" name="payment-method"
				required="required">
				<option value="UPI">UPI</option>
				<option value="Debit Card">Debit Card</option>
				<option value="Credit Card">Credit Card</option>
				<option value="Cash">Cash On Delivery</option>
				<!-- Add more options as needed -->
			
			</select> <label for="address" style="color: black;">Delivery Address:</label>
			<input type="text" id="address" name="address"
				placeholder="Enter your address" required>

			<button class="submit-btn" type="submit">Order</button>
			</form>
		</div>
	</section>

<div class="footer">
		<a href="#">About Us</a> <a href="#">Contact Us</a> <a href="#">Privacy
			Policy</a> <a href="#">Terms and Conditions</a>
	</div>

</body>
</html>
