<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ProjectDTO"%>
<!DOCTYPE html>
<html>
<head> <link rel="icon" href="/images/fav.png" type="image/png" />
<meta charset="ISO-8859-1">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Project</title>
</head>
<body>
<%@ include file="./css/header.jsp" %>


<br>

<div class="main">
<%ProjectDTO p = (ProjectDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>ID</th>
		<th>Name</th>
		<th>Description</th>
		<th>Shipping Date</th>
	</tr>
	<tr>
		<td><%=p.getId()%></td>
		<td><%=p.getName()%></td>
		<td> <%=p.getDescription()%></td>
		<td> <%=p.getShippingdate()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="./css/footer.jsp" %>
</body>
</html>