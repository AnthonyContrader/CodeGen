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
				
				String temp = ""+request.getSession().getAttribute("user");				
				temp = (""+request.getSession().getAttribute("user")).replace("UserDTO(","").replace(")", "");
				String[] User_temp = temp.split(",");
				
				String USER=User_temp[1].replace("username=","");
				
				if(u.getUser().toUpperCase().trim().equals(USER.trim().toUpperCase())){ 
		%>
		<tr>
			<td><% out.print( u.getAction().toUpperCase() ); %></td>
			<td><%
			out.print(u.getUser().toUpperCase());
				%></td>
			<td><%
			 	String[] Str = (""+u.getMoment()).split("-"); 
				String[] H = Str[2].split(" "); 
			
			
			String gg = H[0];
			String mm = Str[1];
			String aa = Str[0];
			
			
			out.print(gg+"/"+mm+"/"+aa+" "+H[1].replace(".0", ""));
			
			  %></td>

		</tr>
		<%
		
				}
				
			}
		%>
	</table>




</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>