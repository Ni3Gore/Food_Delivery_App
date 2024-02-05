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
          <form action="findAcc" method="post">
            <h2>Find your Account</h2>
      
            
            
                  <div class="input-box">
              <span class="icon">
                <ion-icon name="lock-closed"></ion-icon>
              </span>
              <input type="email" required name="email">
              <label>Email</label>
            </div>
            
            
      
            <button type="submit">Search</button>
      
          </form>
        </div>
      
      </div>
</body>
</html>