<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div class="wrapper">

        <div class="login-box">
          <form action="signup" method="post">
            <h2>Signup</h2>
      
            <div class="input-box">
              <span class="icon">
                <ion-icon name="mail"></ion-icon>
              </span>
              <input type="text" required name="username">
              <label>Username</label>
            </div>
      
            <div class="input-box">
              <span class="icon">
                <ion-icon name="lock-closed"></ion-icon>
              </span>
              <input type="password" required name="password">
              <label>Password</label>
            </div>
            
                  <div class="input-box">
              <span class="icon">
                <ion-icon name="lock-closed"></ion-icon>
              </span>
              <input type="email" required name="email">
              <label>Email</label>
            </div>
            
            <div class="input-box">
              <span class="icon">
                <ion-icon name="lock-closed"></ion-icon>
              </span>
              <input list="enum" required name="enum">
              <datalist id="enum">
              <option>Customer</option>
              <option>RestaurantAdmin</option>
              <option>SystemAdmin</option>
              </datalist>
               <label>Role</label>             
            </div> 
      
            <button type="submit">Signup</button>
          </form>
        </div>
      
      </div>
</body>
</html>