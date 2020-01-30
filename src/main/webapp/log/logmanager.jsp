<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.LogDTO"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Log Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a class="" href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist" >Users</a>
  <a href="EntityServlet?mode=entitylist">Entities</a>
  <a href="FieldServlet?mode=fieldlist">Fields</a>
  <a href="RelationshipServlet?mode=relationshiplist">Relationships</a>
  <a href="ProjectServlet?mode=projectlist">Projects</a>
  <a href="LogoutServlet" id="logout" >Logout</a>
  <a href="LogServlet?mode=loglist" id="log" class="active">Logs</a>
</div>
<div class="main">
	<%
		List<LogDTO> list = (List<LogDTO>) request.getAttribute("list");

	%>

<br>

	<table style="margin-left: 23%;">
		<tr>
			<th>Action</th>
			<th>User</th>
			<th>Date</th>
		</tr>
		<%
			for (LogDTO u : list) {
		%>
		<tr>
			<td><% out.print( u.getAction().toUpperCase() ); %></td>
			<td><%
			out.print(u.getUser().toUpperCase());
				%></td>
			<td><%=u.getDate()%></td>

		</tr>
		<%
			}
		%>
	</table>




</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>