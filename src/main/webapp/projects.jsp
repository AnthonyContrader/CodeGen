<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"
	import="it.contrader.dto.ProjectDTO"%>
	
<!DOCTYPE html>
<html>
<head> <link rel="icon" href="/images/fav.png" type="image/png" />
<meta charset="ISO-8859-1">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Project Manager</title>
</head>
<body  >
<%@ include file="./css/header.jsp" %>

<div class="main">
	<%
		List<ProjectDTO> list = (List<ProjectDTO>) request.getSession().getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Shipping Date</th>
			<th>Action</th>
		</tr>
		<%
			for (ProjectDTO p : list) {
		%>
		<tr>
			<td><a href="/project/read?id=<%=p.getId()%>">
					<%=p.getName()%>
			</a></td>
			<td><%=p.getDescription()%></td>
			<td><%=p.getShippingdate()%></td>
			<td><a class="edit" href="/project/preupdate?id=<%=p.getId()%>">&nbsp;&nbsp;</a><a class="delete" href="/project/delete?id=<%=p.getId()%>"></a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="/project/insert" method="post" 
onsubmit="document.getElementById('description').value=document.getElementById('description').value.replaceAll(' ','-');">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" placeholder="Insert Name" required>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="description">Description</label>
    </div>
    <div class="col-75">
      	<input type="text" id="description" name="description" placeholder="Insert Description" required>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="shippingdate">Shipping date</label>
    </div>
    <div class="col-75">
      	<input type="date" id="shippingdate" name="shippingdate" placeholder="Insert Shipping date" required>
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="./css/footer.jsp" %>
</body>
</html>