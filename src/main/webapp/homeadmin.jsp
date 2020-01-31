<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"
	import="it.contrader.dto.EntityDTO"
	import="it.contrader.dto.FieldDTO"
	import="it.contrader.dto.ProjectDTO"
	import="it.contrader.dto.RelationshipDTO"
	
	%>
	
<!DOCTYPE html>
<html>
<head> <link rel="icon" href="/images/fav.png" type="image/png" />
<meta charset="ISO-8859-1">
<title>Home Admin</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@include file="css/header.jsp"%>


<div class="navbar">
  <a class="active" href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="EntityServlet?mode=entitylist">Entities</a>
  <a href="FieldServlet?mode=fieldlist">Fields</a>
  <a href="RelationshipServlet?mode=relationshiplist">Relationships</a>
  <a href="ProjectServlet?mode=projectlist">Projects</a>
  
  <a href="LogoutServlet" id="logout">Logout</a>
  <a href="LogServlet?mode=loglist" id="log" >Logs</a>
</div>

<div class="main" >
<h1 style="color: #39A8E8;" >Welcome <b><u>${user.getUsername()}</u></b></h1>
</div>
<div style="text-align:center; margin-bottom: -45px;margin-top: -5px;"> 
	<video style="margin-top:-3%;width:50%; height:auto;" align="center"  autoplay loop>
	  <source src="images/intro.mp4" type="video/mp4">
	  Your browser does not support HTML5 video.
	</video>
</div>

<%@ include file="css/footer.jsp" %>

</body>
</html>