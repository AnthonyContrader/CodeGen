<%@ page import="it.contrader.dto.EntityOwnerDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Entity Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Entity</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/user/getall">Users</a> <a href="/user/logout" id="logout">Logout</a>
			<a href="/entityowner/getall" class = "active">Entities</a> <a href="/entityowner/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<EntityOwnerDTO> list = (List<EntityOwnerDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Name</th>
				<th>Idproject</th>
			
			</tr>
			<%
				for (EntityOwnerDTO eo : list) {
			%>
			<tr>
				<td><a href="/entityowner/read?id=<%=eo.getId()%>"> <%=eo.getName()%>
				</a></td>
				<td><%=eo.getName()%></td>
				<td><%=eo.getIdproject()%></td>
				<td><a href="/entityowner/preupdate?id=<%=eo.getId()%>">Edit</a></td>


				<td><a href="/entityowner/delete?id=<%=eo.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>
	
		<form id="floatright" action="/entityowner/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="entityowner" name="name"
						placeholder="inserisci name">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">Idproject</label>
				</div>
				<div class="col-75">
					<input type="text" id="idproject" name="idproject"
						placeholder="inserisci idproject">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>