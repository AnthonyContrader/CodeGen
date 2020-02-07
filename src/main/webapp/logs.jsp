<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.LogDTO"%>
<!DOCTYPE html>
<html>
<head> <link rel="icon" href="images/fav.png" type="image/png" />
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Log Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>


<div class="main">
	<%
		List<LogDTO> list = (List<LogDTO>) request.getSession().getAttribute("list");

	%>

<br>

	<table style="margin-left: 23%;">
		<tr>
			<th>Action</th>
			<th>User</th>
			<th>Date</th>
		</tr>
		<%
			for (LogDTO u : list) {
		%>
		<tr>
			<td><% out.print( u.getAction().toUpperCase() ); %></td>
			<td><%
			out.print(u.getUser().toUpperCase());
				%></td>
			<td><%
			 String[] Str = (""+u.getMoment()).split("-"); 
			String gg = Str[2];
			String mm = Str[1];
			String aa = Str[0];
			
			
			out.print(gg+"/"+mm+"/"+aa);
			
			
			//out.print();
			  %></td>

		</tr>
		<%
			}
		%>
	</table>




</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>