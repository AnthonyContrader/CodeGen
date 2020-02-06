<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" 
    import="it.contrader.dto.FieldDTO"
    import="it.contrader.dto.EntityOwnerDTO"%>
<!DOCTYPE html>
<html>
<head> <link rel="icon" href="images/fav.png" type="image/png" />
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Field</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>


<br>
<div class="main">

<%FieldDTO u = (FieldDTO) request.getAttribute("dto");

List<EntityOwnerDTO> list_E = (List<EntityOwnerDTO>) request.getAttribute("listEntity"); //Assicurati che nella servelet c'è l'attributo %>

<form id="floatleft" action="/field/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%  out.print(u.getName().replaceAll(" ","#"));%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="type">Type</label>
    </div>
    <div class="col-75">
    	<select id="type" name="type" required>
 				<option value="string"  <%if (u.getType().toLowerCase().equals("string")) {%>selected<%} %> >String</option>
 				<option value="int" <%if (u.getType().toLowerCase().equals("int")) {%>selected<%} %> >Int</option>
 				<option value="double" <%if (u.getType().toLowerCase().equals("double")) {%>selected<%} %> >Double</option>
 				<option value="date" <%if (u.getType().toLowerCase().equals("date")) {%>selected<%} %> >Date</option>
		</select>

    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="entity">Entity</label>
    </div>
   		 <div class="col-75">
 			<select id="entity" name="entity">
 				<%
					for (EntityOwnerDTO e : list_E) {
				%>
					<option value="<%=e.getId()%>"  <%if(e.getId()==u.getEntityowner()) {%>selected<%} %>  ><%=e.getName()%></option>
				<%
					}
				%>
			</select>
    	</div>
  </div>
<div class="row">
    <div class="col-25">
     <label for="lenght">Lenght (<span id="v_len"><%=u.getLenght()%></span>)</label>
    </div>
    <div class="col-75">
      	  <input type="range" min="1" max="255" value="<%=u.getLenght()%>" class="slider-color" id="lenght" name="lenght" step="1" style="width:90%;"
      	  oninput="document.getElementById('v_len').innerHTML=this.value;" 
      	  >
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>
	<script>
	for (i = 0; i < document.getElementById("name").value.length; i++) {
		document.getElementById("name").value=document.getElementById("name").value.replace("#", " ");
	}		
	
	</script>
	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>