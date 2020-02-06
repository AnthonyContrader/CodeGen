<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.RelationshipDTO"
	import="it.contrader.dto.EntityOwnerDTO"
	import="it.contrader.dto.EntityCustomerDTO"%>
	
<!DOCTYPE html>
<html>
<head> <link rel="icon" href="/images/fav.png" type="image/png" />
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Relationship Manager</title>
</head>
<body>
<%@ include file="./css/header.jsp" %>



<div class="main">
	<%
		List<RelationshipDTO> list = (List<RelationshipDTO>) request.getSession().getAttribute("list");
		List<EntityOwnerDTO> listEo = (List<EntityOwnerDTO>) request.getSession().getAttribute("listEntityo");
		List<EntityCustomerDTO> listEc = (List<EntityCustomerDTO>) request.getSession().getAttribute("listEntityc");
	%>

<br>

	<table>
		<tr>
			<th>Entity1</th>
			<th>Entity2</th>
			<th>Action</th>
		</tr>
		<%
			for (RelationshipDTO r : list) {
		%>
		<tr>
			<td><a href="/relationship/read?id=<%=r.getId()%>">
				
				<%		
			
				for (EntityOwnerDTO e : listEo){ 
					if( e.getId()==r.getEntityowner().getId() )
						out.print(e.getName());
				}%>
			</a></td>
			<td><%		
			
				for (EntityCustomerDTO e : listEc){ 
					if( e.getId()==r.getEntityowner().getId() )
						out.print(e.getName());
				}%>
			</td>
			<td><a class="edit" href="/relationship/preupdate?id=<%=r.getId()%>"></a>&nbsp;&nbsp;<a class="delete" href="/relationship/delete?id=<%=r.getId()%>"></a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="/relationship/insert" method="post" >
    <div class="row">
    <div class="col-25">
      <label for="type">Select Entity1</label>
    </div>
   		 <div class="col-75">
 			<select id="selectentity1" name="selectentity1" required onchange="Check(this);"> <!-- il name della select combina il name con la richiesta del post nella servlet -->
 				<option value="" disabled selected>Select Entity1</option>
 				<% 			
					for (EntityOwnerDTO e : listEo) {
				%>
				<option value="<%=e.getId()%>"><%=e.getName()%></option>
				<%
					}
				%>
 
			</select>
    	</div>
    	<div class="col-25">
      	<label for="type">Select Entity2</label>
    	</div>
    	<div class="col-75">
 			<select id="selectentity2" name="selectentity2" required onchange="Check(this);"> <!-- il name della select combina il name con la richiesta del post nella servlet -->
 				<option value="" disabled selected>Select Entity2</option>
 				<% 			
					for (EntityCustomerDTO e : listEc) {
				%>
				<option value="<%=e.getId()%>"><%=e.getName()%></option>
				<%
					}
				%>
 
			</select>
    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="./css/footer.jsp" %>
</body>
<script>
function Check(oggetto){
	var ent1=document.getElementById("selectentity1").value;
	var ent2=document.getElementById("selectentity2").value;
	if(ent1==ent2 || ent1.equals(ent2)){
		alert("Non puoi associare la stessa entita'.\nSi prega di riprovare");
		oggetto.selectedIndex =0; 
	}
		
}


</script>

</html>