<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="it.contrader.dto.RelationshipDTO"%>
<!DOCTYPE html>
<html>
<head> <link rel="icon" href="images/fav.png" type="image/png" />
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Relationship</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>


<br>

<div class="main">
<%RelationshipDTO r = (RelationshipDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Entity1</th>
		<th>Entity2</th>
	</tr>
	<tr>
		<td><%=r.getEntity1()%></td>
		<td> <%=r.getEntity2()%></td>
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