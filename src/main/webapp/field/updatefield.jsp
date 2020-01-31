<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.FieldDTO" import="it.contrader.dto.EntityDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Field</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
<a  href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="EntityServlet?mode=entitylist">Entities</a>
  <a href="FieldServlet?mode=fieldlist" class="active">Fields</a>
  <a href="RelationshipServlet?mode=relationshiplist">Relationships</a>
  <a href="ProjectServlet?mode=projectlist">Projects</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%FieldDTO u = (FieldDTO) request.getAttribute("dto");

List<EntityDTO> list_E = (List<EntityDTO>) request.getAttribute("listEntity"); //Assicurati che nella servelet c'è l'attributo %>

<form id="floatleft" action="FieldServlet?mode=update&id=<%=u.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=u.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="type">Type</label>
    </div>
    <div class="col-75">
    	<select id="type" name="type" required>
 				<option value="string"  <%if (u.getType().toLowerCase().equals("string")) {%>selected<%} %> >String</option>
 				<option value="int" <%if (u.getType().toLowerCase().equals("int")) {%>selected<%} %> >Int</option>
 				<option value="double" <%if (u.getType().toLowerCase().equals("double")) {%>selected<%} %> >Double</option>
 				<option value="date" <%if (u.getType().toLowerCase().equals("date")) {%>selected<%} %> >Date</option>
		</select>

    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="entity">Entity</label>
    </div>
   		 <div class="col-75">
 			<select id="entity" name="entity">
 				<%
					for (EntityDTO e : list_E) {
				%>
					<option value="<%=e.getId()%>"  <%if(e.getId()==u.getEntity()) {%>selected<%} %>  ><%=e.getName()%></option>
				<%
					}
				%>
			</select>
    	</div>
  </div>
<div class="row">
    <div class="col-25">
     <label for="lenght">Lenght (<span id="v_len"><%=u.getLenght()%></span>)</label>
    </div>
    <div class="col-75">
      	  <input type="range" min="1" max="255" value="<%=u.getLenght()%>" class="slider-color" id="lenght" name="lenght" step="1" style="width:90%;"
      	  oninput="document.getElementById('v_len').innerHTML=this.value;" 
      	  >
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>