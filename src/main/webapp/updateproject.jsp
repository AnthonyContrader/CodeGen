<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="java.util.List"
    import="it.contrader.dto.ProjectDTO"%>
    
<!DOCTYPE html>
<html>
<head> <link rel="icon" href="/images/fav.png" type="image/png" />
<meta charset="ISO-8859-1">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Project</title>
</head>
<body>
<%@ include file="./css/header.jsp" %>


<br>
<div class="main">
<%
	ProjectDTO u = (ProjectDTO) request.getSession().getAttribute("dto");
%>

<form id="floatleft" action="/project/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Project name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<% out.print(u.getName().replaceAll(" ","#"));%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="description">Description</label>
    </div>
    <div class="col-75">
      <input type="text" id="description" name="description" value=<% out.print(u.getDescription().replaceAll(" ","#")); %>> 
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

	<script>
	for (i = 0; i < document.getElementById("description").value.length; i++) {
		document.getElementById("description").value=document.getElementById("description").value.replace("#", " ");
	}		
	for (i = 0; i < document.getElementById("name").value.length; i++) {
		document.getElementById("name").value=document.getElementById("name").value.replace("#", " ");
	}	
	</script>
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>