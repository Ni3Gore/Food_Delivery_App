<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<link rel="stylesheet" href="style.css">
<body>
    <div class="wrapper">
    
<%-- <%
Cookie[] arr =request.getCookies();
if(arr != null){
	String s= arr.toString();
for(int i=0; i<s.length();i++){
	out.println(s);
}
}
%> --%>
        <div class="login-box">
          <form action="login" method="post">
            <h2>Login</h2>
      
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
      
            <div class="remember-forgot">
              <label><input type="checkbox" name="action" value="remember"> Remember me</label>
              <a href="signup2.jsp">Forgot Password?</a>
            </div>
      
            <button type="submit">Login</button>
      
            <div class="register-link">
              <p>Don't have an account? <a href="signup.jsp">Register</a></p>
           		<button type="reset" name="reset">   Reset</button>
           		</div>
           
          </form>
        </div>
      
      </div>
</body>
</html>
