<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true" %>
<html>
<head> <link rel="icon" href="/images/fav.png" type="image/png" />
<link href="css/vittoriostyle.css" rel="stylesheet">

<title>Login Codegen</title>
</head>
<body <% if( request.getParameterMap().containsKey("cred") && request.getParameter("cred").equals( "1") ){ %>onload='alert("Credenziali Errate.\nSi prega di riprovare.");' <% }  %>>

		<form class="login" action="LoginServlet" method="post">

				<label for="user">Username: </label>
			
				<input type="text" id="user" name="username" placeholder="Insert username" required>
		
				<label for="pass">Password: </label>
			
				 <input type="password" id="pass" name="password" placeholder="Insert password" required>
		
			<button type="submit" value="Login" name="pulsante">Login</button>
		</form>

	
</body>
</html>