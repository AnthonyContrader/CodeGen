<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EntityDTO"%>
<!DOCTYPE html>
<html>
<head> <link rel="icon" href="images/fav.png" type="image/png" />
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Entity</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>


<br>

<div class="main">
<%EntityDTO e = (EntityDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Name</th>
		<th>Idproject</th>
		
	</tr>
	<tr>
		<td><%=e.getName()%></td>
		<td><%=e.getIdproject()%></td>
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