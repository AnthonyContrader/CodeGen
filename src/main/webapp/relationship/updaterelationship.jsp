<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="java.util.List"
    import="it.contrader.dto.RelationshipDTO"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Relationship</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="EntityServlet?mode=entitylist">Entities</a>
  <a href="FieldServlet?mode=fieldlist">Fields</a>
  <a href="RelationshipServlet?mode=relationshiplist"class="active">Relationships</a>
  <a href="ProjectServlet?mode=projectlist">Projects</a>
  <a href="LogoutServlet" id="logout">Logout</a>
  <a href="LogServlet?mode=loglist" id ="log">Logs</a>
</div>
<br>
<div class="main">
<%
	RelationshipDTO r = (RelationshipDTO) request.getAttribute("dto");
	List<RelationshipDTO> list = (List<RelationshipDTO>) request.getAttribute("list");
%>

<form id="floatleft" action="RelationshipServlet?mode=update&id=<%=r.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="entity1">Entity1</label>
    </div>
    <div class="col-75">
      <input type="text" id="entity1" name="entity1" value=<%=r.getEntity1()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="entity2">Entity2</label>
    </div>
    <div class="col-75">
      <input type="text" id="entity2" name="entity2" value=<%=r.getEntity2()%>> 
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>