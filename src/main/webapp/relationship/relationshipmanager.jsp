<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.RelationshipDTO"
	import="it.contrader.dto.EntityDTO"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Relationship Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="EntityServlet?mode=entitylist">Entities</a>
  <a href="FieldServlet?mode=fieldlist">Fields</a>
  <a href="RelationshipServlet?mode=relationshiplist"class="active">Relationships</a>
  <a href="ProjectServlet?mode=projectlist">Projects</a>
  <a href="LogoutServlet" id="logout">Logout</a>
  <a href="LogServlet?mode=loglist" id ="log">Logs</a>
</div>
<div class="main">
	<%
		List<RelationshipDTO> list = (List<RelationshipDTO>) request.getAttribute("list");
		List<EntityDTO> listE = (List<EntityDTO>)request.getAttribute("listP");
	%>

<br>

	<table>
		<tr>
			<th>Entity1</th>
			<th>Entity2</th>
			<th>Action</th>
		</tr>
		<%
			for (RelationshipDTO r : list) {
		%>
		<tr>
			<td><a href=RelationshipServlet?mode=read&id=<%=r.getId()%>>
					<%=r.getEntity1()%>
			</a></td>
			<td><%=r.getEntity2()%></td>
			<td><%		
			
				for (EntityDTO e : listE){ 
					if( e.getId()==r.getEntity1()|| e.getId()==r.getEntity2())
						out.print(e.getName());
				}%>
			</td>
			<td><a class="edit" href=RelationshipServlet?mode=read&update=true&id=<%=r.getId()%>></a>&nbsp;&nbsp;<a class="delete" href=RelationshipServlet?mode=delete&id=<%=r.getId()%>></a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="RelationshipServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="entity1">Entity1</label>
    </div>
    <div class="col-75">
      <input type="text" id="entity1" name="entity1" placeholder="Insert Name of Entity1" required>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="entity2">Entity2</label>
    </div>
    <div class="col-75">
      	<input type="text" id="entity2" name="entity2" placeholder="Insert Name of Entity2" required>
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label for="type">Select Entity1</label>
    </div>
   		 <div class="col-75">
 			<select id="identity" name="identity" required> <!-- il name della select combina il name con la richiesta del post nella servlet -->
 				<option value="" disabled selected>Select Entity1</option>
 				<% 			
					for (EntityDTO e : listE) {
				%>
				<option value="<%=e.getId()%>"><%=e.getName()%></option>
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