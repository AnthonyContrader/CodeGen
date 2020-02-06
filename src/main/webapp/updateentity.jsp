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
EntityOwnerDTO e = (EntityOwnerDTO) request.getAttribute("dto");
	List<EntityOwnerDTO> list = (List<EntityOwnerDTO>) request.getAttribute("list");
	 List<ProjectDTO> listP = (List<ProjectDTO>) request.getSession().getAttribute("listP");
%>

<form id="floatleft" action="/entityowner/update" method="post">
   <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=e.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Select IdProject</label>
    </div>
   		 <div class="col-75">
 			<select id="idproject" name="idproject" required>
 				<option value="" disabled selected>Select Idproject</option>
 				<% 			
					for (ProjectDTO p : listP) {
						%> <option value="<%=p.getId()%>"><%=p.getName()%></option> <%
					}%> 
			</select>
    	</div>
  </div>
 	
  
      <button type="submit" >Edit</button>
	
</form>		
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>