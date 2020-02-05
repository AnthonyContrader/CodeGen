<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    

<div class="header">
</div>
<div class="navbar">
	
	<a  href="/homeadmin.jsp">Home</a> 
	<a href=/user/getall <% if(  request.getRequestURL().toString().toLowerCase().contains("user".toLowerCase()) )	out.print( " class='active' " ); %> >Users</a>
    <a href="/project/getall"  <% if(  request.getRequestURL().toString().toLowerCase().contains("prject".toLowerCase()) )	out.print( " class='active' " ); %> >Projects</a>
  	<a href="/entity/getall" <% if(  request.getRequestURL().toString().toLowerCase().contains("entit".toLowerCase()) )	out.print( " class='active' " ); %> >Entities</a>
  	<a href="/field/getall"  <% if(  request.getRequestURL().toString().toLowerCase().contains("field".toLowerCase()) )	out.print( " class='active' " ); %> >Fields</a>
  	<a href="/relationship/getall" <% if(  request.getRequestURL().toString().toLowerCase().contains("relationship".toLowerCase()) )	out.print( " class='active' " ); %> >Relationships</a>
  	
  
		<a href="/user/logout" id="logout">Logout</a>

	</div>