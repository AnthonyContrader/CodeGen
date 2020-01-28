<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.EntityDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Entity</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
<a  href="../homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="EntityServlet?mode=entitylist">Entities</a>
  <a href="FieldServlet?mode=fieldlist" class="active">Fields</a>
  <a href="RelationshipServlet?mode=relationshiplist">Relationships</a>
  <a href="ProjectServlet?mode=projectlist">Projects</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">


<%EntityDTO e = (EntityDTO) request.getAttribute("dto"); //Assicurati che nella servelet %>

<form id="floatleft" action="EntityServlet?mode=update&id=<%=e.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=e.getName()%>>
    </div>
  </div>
 
 	
  
      <button type="submit" >Edit</button>
	
</form>		
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>