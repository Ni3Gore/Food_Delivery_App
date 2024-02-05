<%@page import="java.io.Console"%>
<%@page import="com.food.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

    session.invalidate();
    response.sendRedirect("Login.jsp");
    
/* session.removeAttribute("User");
session.removeAttribute("restaurentId");
User u = (User)session.getAttribute("User");
response.sendRedirect("Login.jsp"); */
%>
</body>
</html>