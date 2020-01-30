<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="java.util.List"
    import="it.contrader.dto.ProjectDTO"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Project</title>
</head>
<body>
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
<br>
<div class="main">
<%
	ProjectDTO u = (ProjectDTO) request.getAttribute("dto");
	List<ProjectDTO> list = (List<ProjectDTO>) request.getAttribute("list");
%>

<form id="floatleft" action="ProjectServlet?mode=update&id=<%=u.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Project name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=u.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="description">Description</label>
    </div>
    <div class="col-75">
      <input type="text" id="description" name="description" value=<%=u.getDescription()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="shippingdate">Shipping date</label>
    </div>
    <div class="col-75">
      <input type="date" id="shippingdate" name="shippingdate" value=<%=u.getShippingdate()%>> 
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>