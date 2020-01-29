<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="it.contrader.dto.EntityDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Entity Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="EntityServlet?mode=entitylist">Users</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<EntityDTO> list = (List<EntityDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Name</th>
			
			<th></th>
			<th></th>
		</tr>
		<%
			for (EntityDTO e : list) {
		%>
		<tr>
			<td><a href=EntityServlet?mode=read&id=<%=e.getId()%>>
					<%=e.getName()%>
			</a></td>
			
			<td><a href=EntityServlet?mode=read&update=true&id=<%=e.getId()%>>Edit</a>
			</td>
			<td><a href=EntityServlet?mode=delete&id=<%=e.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="EntityServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="entity">Name</label>
    </div>
  <div class="col-75">
      <input type="text" id="entity" name="name" placeholder="inserisci name">
    </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>