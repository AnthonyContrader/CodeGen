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
<title>Entity </title>
</head>
<body <% if(request.getParameter("mode").toLowerCase().equals( "insert")){ %>onload='window.location="EntityServlet?mode=entitylist";' <% }  %>>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
   <a href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="EntityServlet?mode=entitylist">Entities</a>
  <a href="FieldServlet?mode=fieldlist">Fields</a>
  <a href="RelationshipServlet?mode=relationshiplist">Relationships</a>
   <a href="ProjectServlet?mode=projectlist">Projects</a>
  
  <a href="LogoutServlet" id="logout">Logout</a>
  <a href="LogServlet?mode=loglist" id = "log">Logs</a>
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
			<th>Action</th>
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
			
			<td><a class="edit" href=EntityServlet?mode=read&update=true&id=<%=e.getId()%>></a>&nbsp;&nbsp;<a class="delete" href=EntityServlet?mode=delete&id=<%=e.getId()%>></a>
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
      <input type="text" id="name" name="name" required placeholder="Insert name" style="width: 90%;">
    </div>
   </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Select Project</label>
    </div>
   		 <div class="col-75">
 			<select id="idproject" name="idproject" required> <!-- il name della select combina il name con la richiesta del post nella servlest -->
 				<option value="" disabled selected>Select Project</option>
 				<% 			
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