<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="java.util.List"
    import="it.contrader.dto.EntityOwnerDTO"
    import="it.contrader.dto.ProjectDTO"%>
    
<!DOCTYPE html>
<html>
<head> <link rel="icon" href="/images/fav.png" type="image/png" />
<meta charset="ISO-8859-1">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Entity</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>



<br>
<div class="main">


<%
EntityOwnerDTO e = (EntityOwnerDTO) request.getSession().getAttribute("dto");

	 List<ProjectDTO> listP = (List<ProjectDTO>) request.getSession().getAttribute("listP");
	 System.out.print(listP);
%>

<form id="floatleft" action="/entityowner/update" method="post">
   <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%  out.print(e.getName().replaceAll(" ","#"));%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Select Project</label>
    </div>
   		 <div class="col-75">
 			<select id="project" name="project">
 				
 				<% 			
					for (ProjectDTO p : listP) {
						%>
					<option value="<%=p.getId()%>"  <%if(p.getId()==e.getProject().getId()) {%>selected<%} %>  ><%=p.getName()%></option>
				<%
					}%> 
			</select>
    	</div>
  </div>
  <input type="hidden" id="id" name="id" value=<%  out.print(e.getId());%>>	
  
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