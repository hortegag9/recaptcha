<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script src="https://www.google.com/recaptcha/api.js"></script>
</head>
<body>
<h3>Login:</h3>
<p style="color:red;">${errorString}</p>
 
 <form name="loginForm" method="POST" action="doLogin">
      <table border="0">
          <tr>
              <td>User Name</td>
              <td><input type="text" name="userName" /></td>
          </tr>
          <tr>
              <td>Password</td>
              <td><input type="password" name="password" /></td>
          </tr>
      </table>
      
      <div class="g-recaptcha" data-sitekey="6Ldh7c0ZAAAAAKlOPzSugAPKHvHQqo8N9JMuJZyK"></div>
        <input type="submit" value="Submit" />
        
     </form>
      <p style="color:blue;">User Name: tom, Password: tom001</p>

</body>
</html>