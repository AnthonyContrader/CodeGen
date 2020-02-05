<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.FieldDTO"%>
<!DOCTYPE html>
<html>
<head> <link rel="icon" href="images/fav.png" type="image/png" />
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Field</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>


<br>

<div class="main">
<%FieldDTO u = (FieldDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Name</th>
		<th>Type</th>
		<th>Entity</th>
	</tr>
	<tr>
		<td><%=u.getName()%></td>
		<td> <%=u.getType()%> (<%=u.getLenght()%>)</td>
		<td> <%=u.getEntity()%></td>
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

<%@ include file="../css/footer.jsp" %>
</body>
</html>