<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ProjectDTO"%>
	
<!DOCTYPE html>
<html>
<head> <link rel="icon" href="images/fav.png" type="image/png" />
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Project Manager</title>
</head>
<body><body <% if(request.getParameter("mode").toLowerCase().equals( "insert")){ %>onload='window.location="ProjectServlet?mode=projectlist";' <% }  %>>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
<a href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="EntityServlet?mode=entitylist">Entities</a>
  <a href="FieldServlet?mode=fieldlist">Fields</a>
  <a href="RelationshipServlet?mode=relationshiplist">Relationships</a>
  <a href="ProjectServlet?mode=projectlist" class="active">Projects</a>
  <a href="LogoutServlet" id="logout">Logout</a>
  <a href="LogServlet?mode=loglist" id="log">Logs</a>
</div>
<div class="main">
	<%
		List<ProjectDTO> list = (List<ProjectDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Shipping Date</th>
			<th>Action</th>
		</tr>
		<%
			for (ProjectDTO p : list) {
		%>
		<tr>
			<td><a href=ProjectServlet?mode=read&id=<%=p.getId()%>>
					<%=p.getName()%>
			</a></td>
			<td><%=p.getDescription()%></td>
			<td><%=p.getShippingdate()%></td>
			<td><a class="edit" href=ProjectServlet?mode=read&update=true&id=<%=p.getId()%>></a>&nbsp;&nbsp;<a class="delete" href=ProjectServlet?mode=delete&id=<%=p.getId()%>></a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="ProjectServlet?mode=insert" method="post" 
onsubmit="document.getElementById('description').value=document.getElementById('description').value.replaceAll(' ','-');">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" placeholder="Insert Name" required>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="description">Description</label>
    </div>
    <div class="col-75">
      	<input type="text" id="description" name="description" placeholder="Insert Description" required>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="shippingdate">Shipping date</label>
    </div>
    <div class="col-75">
      	<input type="date" id="shippingdate" name="shippingdate" placeholder="Insert Shipping date" required>
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>