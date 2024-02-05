<%@page import="com.food.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Account</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<div class="wrapper">

		<div class="login-box">
			<form action="Setpassword" method="post">
				<h2>Set Password</h2>
				<%
				User u = (User) session.getAttribute("User");
				%>

				<div class="input-box">
					<span class="icon"> <ion-icon name="lock-closed"></ion-icon>
					</span> <input type="text" required name="Username"
						value="<%=u.getUserName()%>"> <label>Username</label>
				</div>

				<div class="input-box">
					<span class="icon"> <ion-icon name="lock-closed"></ion-icon>
					</span> <input type="password" required name="password"> <label>New
						Password</label>
				</div>



				<button type="submit">Set Password</button>

			</form>
		</div>

	</div>
</body>
</html>