<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="java.util.List"
    import="it.contrader.dto.RelationshipDTO"
    import="it.contrader.dto.EntityDTO"%>
    
<!DOCTYPE html>
<html>
<head> <link rel="icon" href="images/fav.png" type="image/png" />
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Relationship</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
   <a href="ProjectServlet?mode=projectlist">Projects</a>
  <a href="EntityServlet?mode=entitylist">Entities</a>
  <a href="FieldServlet?mode=fieldlist">Fields</a>
  <a href="RelationshipServlet?mode=relationshiplist"class="active">Relationships</a>
 
  <a href="LogoutServlet" id="logout">Logout</a>
  <a href="LogServlet?mode=loglist" id ="log">Logs</a>
</div>
<br>
<div class="main">
<%
	RelationshipDTO r = (RelationshipDTO) request.getAttribute("dto");
	List<EntityDTO> listE = (List<EntityDTO>)request.getAttribute("listP");
%>

<form id="floatleft" action="RelationshipServlet?mode=update&id=<%=r.getId()%>" method="post">
      <div class="row">
    <div class="col-25">
      <label for="type">Select Entity1</label>
    </div>
   		 <div class="col-75">
 			<select id="selectentity1" name="selectentity1"> <!-- il name della select combina il name con la richiesta del post nella servlet -->

 				<% 			
					for (EntityDTO e : listE) {
				%>
					<option value="<%=e.getId()%>"<%if(e.getId()==r.getEntity1()) {%>selected<%} %>><%=e.getName()%></option>
				<%
					}
				%>
 
			</select>
    	</div>
    <div class="col-25">
      <label for="type">Select Entity2</label>
    </div>
    	<div class="col-75">
 			<select id="selectentity2" name="selectentity2"> <!-- il name della select combina il name con la richiesta del post nella servlet -->
 
 				<% 			
					for (EntityDTO e : listE) {
				%>
					<option value="<%=e.getId()%>"<%if(e.getId()==r.getEntity2()) {%>selected<%} %>><%=e.getName()%></option>
				<%
					}
				%>
 
			</select>
    	</div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
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