<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="java.util.List"
    import="it.contrader.dto.RelationshipDTO"
    import="it.contrader.dto.EntityOwnerDTO"
    import="it.contrader.dto.EntityCustomerDTO" %>
    
<!DOCTYPE html>
<html>
<head> <link rel="icon" href="images/fav.png" type="image/png" />
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Relationship</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>


<br>
<div class="main">
<%
	RelationshipDTO r = (RelationshipDTO) request.getSession().getAttribute("dto");
	List<EntityOwnerDTO> listEo = (List<EntityOwnerDTO>)request.getSession().getAttribute("listEntityo");
	List<EntityCustomerDTO> listEc = (List<EntityCustomerDTO>)request.getSession().getAttribute("listEntityc");
%>

<form id="floatleft" action="/relationship/update?id=<%=r.getId()%>" method="post">
      <div class="row">
    <div class="col-25">
      <label for="type">Select Entity1</label>
    </div>
   		 <div class="col-75">
 			<select id="selectentity1" name="entityowner"> <!-- il name della select combina il name con la richiesta del post nella servlet -->

 				<% 			
					for (EntityOwnerDTO e : listEo) {
				%>
					<option value="<%=e.getId()%>"<%if(e.getId()==r.getEntityowner().getId()) {%>selected<%} %>><%=e.getName()%></option>
				<%
					}
				%>
 
			</select>
    	</div>
    <div class="col-25">
      <label for="type">Select Entity2</label>
    </div>
    	<div class="col-75">
 			<select id="selectentity2" name="entitycustomer"> <!-- il name della select combina il name con la richiesta del post nella servlet -->
 
 				<% 			
					for (EntityCustomerDTO e : listEc) {
				%>
					<option value="<%=e.getId()%>"<%if(e.getId()==r.getEntitycustomer().getId()) {%>selected<%} %>><%=e.getName()%></option>
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
	var ent1=document.getElementById("entityowner").value;
	var ent2=document.getElementById("entitycustomer").value;
	if(ent1==ent2 || ent1.equals(ent2)){
		alert("Non puoi associare la stessa entita'.\nSi prega di riprovare");
		oggetto.selectedIndex =0; 
	}
		
}
</script>
</html>