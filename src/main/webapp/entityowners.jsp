<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="it.contrader.dto.EntityOwnerDTO" 
    import="java.util.*" 
    import="it.contrader.dto.ProjectDTO" %>
<!DOCTYPE html>
<html>
<head> <link rel="icon" href="/images/fav.png" type="image/png" />
<meta charset="ISO-8859-1">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Entity</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>


<br>
<div class="main">

<%
			List<EntityOwnerDTO> list = (List<EntityOwnerDTO>) request.getSession().getAttribute("list");
			System.out.println("\n\n"+list);
            List<ProjectDTO> listP = (List<ProjectDTO>) request.getSession().getAttribute("listP");
		%>

		<br>

		<table>
			<tr>
				<th>Name</th>
				<th>Project</th>
				<th>Action</th>
				
			</tr>
			<%
				for (EntityOwnerDTO e : list) { System.out.println(e.getProject().getName());
			%>
			<tr>
				<td><a href="/entityowner/read?id=<%=e.getId()%>"> <%=e.getName()%> 
				</a></td>
				<td><%	
					out.print(e.getProject().getName()); %></td>
			<td><a class="edit" href=/entityowner/preupdate?id=<%=e.getId()%>></a>&nbsp;&nbsp;
			<a class="delete" href=/entityowner/delete?id=<%=e.getId()%>></a>
			</td>
			
			

			</tr>
			<%
				}
			%>
		</table>



<form id="floatright" action="/entityowner/insert" method="post">

  <div class="row">
    <div class="col-25">
      <label for="entityowner">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" placeholder="Insert Name" required>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Select Project</label>
    </div>
   		 <div class="col-75">
 			<select id="project" name="project" required>
 				<option value="" disabled selected>Select Project</option>
 				<% 			
					for (ProjectDTO p : listP) {
						%> <option value="<%=p.getId()%>"><%=p.getName()%></option> <%
				}%> 
			</select>
    	</div>
  </div>
       <button type="submit" >Insert</button>
</form>

	
</div>
	

<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>