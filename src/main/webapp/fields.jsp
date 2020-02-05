<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"
	import="it.contrader.dto.FieldDTO"
	import="it.contrader.dto.EntityOwnerDTO"%>
<!DOCTYPE html>
<html>
<head> <link rel="icon" href="/images/fav.png" type="image/png" />
<meta charset="ISO-8859-1">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Field Manager</title>
</head>
<body >
<%@ include file="./css/header.jsp" %>


<div class="main">

	<%

		List<FieldDTO> list = (List<FieldDTO>) request.getAttribute("list");
		

		List<EntityOwnerDTO> list_E = (List<EntityOwnerDTO>)request.getAttribute("listEntity");	

	%>
	

<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Type (Lenght)</th>
			<th>Entity</th>
			<th>Action</th>
		</tr>
		<%
			for (FieldDTO u : list) { System.out.println(u.getEntityowner().getName());
		%>
		<tr>
			<td><%=u.getName()%></td>
			<td><%=u.getType()%>&nbsp;(<%=u.getLenght()%>)</td>
			<td><%	
					out.print(u.getEntityowner().getName()); %></td>
			<td><a class="edit" href=/field/preupdate?id=<%=u.getId()%>></a>&nbsp;&nbsp;
			<a class="delete" href=field/delete?id=<%=u.getId()%>></a>
			</td>
		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="/field/insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" placeholder="Insert Name" required maxlength="20"  oninput="" >
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="type">Type</label>
    </div>
    <div class="col-75">
      	<select id="type" name="type" required>
 				<option value="" disabled selected>Insert Type</option>
 				<option value="string"  >String</option>
 				<option value="int"  >Int</option>
 				<option value="double"  >Double</option>
 				<option value="date"  >Date</option>
		</select>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="lenght">Lenght (<span id="v_len">50</span>)</label>
    </div>
    <div class="col-75">
      	  <input type="range" min="1" max="255" value="50" class="slider-color" id="lenght" name="lenght" step="1" 
      	  oninput="document.getElementById('v_len').innerHTML=this.value;" 
      	  >
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Select Entity</label>
    </div>
   		 <div class="col-75">
 			<select id="entity" name="entity" required>
 				<option value="" disabled selected>Select Entities</option>
 				<% 			
					for (EntityOwnerDTO e : list_E) {
						%> <option value="<%=e.getId()%>"><%=e.getName()%></option> <%
					}%> 
			</select>
    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="./css/footer.jsp" %>
</body>
</html>