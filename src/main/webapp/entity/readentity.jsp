<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EntityDTO"%>
<!DOCTYPE html>
<html>
<head> <link rel="icon" href="/images/fav.png" type="image/png" />
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Entity</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="EntityServlet?mode=entitylist" class="active">Entities</a>
  <a href="FieldServlet?mode=fieldlist" >Fields</a>
  <a href="RelationshipServlet?mode=relationshiplist">Relationships</a>
  <a href="ProjectServlet?mode=projectlist">Projects</a>
  
  <a href="LogoutServlet" id="logout">Logout</a>
  <a href="LogServlet?mode=loglist" id = "log">Logs</a>
</div>
<br>

<div class="main">
<%EntityDTO e = (EntityDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Name</th>
		<th>Idproject</th>
		
	</tr>
	<tr>
		<td><%=e.getName()%></td>
		<td><%=e.getIdproject()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>