<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="it.contrader.dto.EntityDTO"
     import="it.contrader.dto.ProjectDTO"
    %>
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
   <a href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="EntityServlet?mode=entitylist">Entities</a>
  <a href="FieldServlet?mode=fieldlist">Fields</a>
  <a href="RelationshipServlet?mode=relationshiplist">Relationships</a>
   <a href="ProjectServlet?mode=projectlist">Projects</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<EntityDTO> list = (List<EntityDTO>) request.getAttribute("list");
		List<ProjectDTO> listP = (List<ProjectDTO>)request.getAttribute("listP");	
	%>
	

<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Project</th>
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
			<td><%		
			
				for (ProjectDTO p : listP){ 
					if( p.getId()==e.getIdproject() )
						out.print(p.getName());
				}%>
			</td>
			
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
      <label for="name">Name</label>
    </div>
  <div class="col-75">
      <input type="text" id="name" name="name" placeholder="insert name">
    </div>
   </div>
  <div class="row">
    <div class="col-25">
<<<<<<< HEAD
      <label for="type">Select Project</label>
    </div>
   		 <div class="col-75">
 			<select id="idproject" name="idproject" required> <!-- il name della select combina il name con la richiesta del post nella servlest -->
 				<option value="" disabled selected>Select Project</option>
 				<% 			
=======
      <label for="type">Select Idproject</label>
    </div>
   		 <div class="col-75">
 			<select id="entity" name="entity" required>
 				<option>Select Entities</option>
 			
 				<% 		
 				
 				
 				
>>>>>>> ec58cdcfc76a705abc6acf8d3b5048fc1e04a2c3
					for (ProjectDTO p : listP) {
				%>
				<option value="<%=p.getId()%>"><%=p.getName()%></option>
			
				<%
					}
				%>
 
			</select>
    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>