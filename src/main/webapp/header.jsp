<%@page import="com.bookstore.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	User user = (User) session.getAttribute("user");
%> 
    
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Online-BookStore</title>
	<!--  Bootstrap CSS -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	
	<!--  Bootstrap icon CSS-->
	<link rel="stylesheet" type="text/css" href="font/bootstrap-icons.css"/>
	
	<!-- Custom CSS -->
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">BookStore</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="bookurl?action=list">Menu</a>
          <!--  
          	BookController perform multiple actions like show list,add book,update book
          	delete book  etc.
          	so To differentiate each action we use action parameter in URL.
          -->
        </li>
        <li class="nav-item">
          <a class="nav-link" href="bookurl?action=add">Add Book</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="aboutus.jsp">About Us</a>
        </li>
      </ul>
    </div>
    <div class="float-ends">
    <%if(user==null){%>
      	<a href="userurl?action=login" class="btn btn-outline-success me-2">Login</a>
      	<a href="userurl?action=register" class="btn btn-outline-success">Register</a>
    <%} %> 
    <%if(user!=null){%>
     	<p>
     		Welcome <strong><%=user.getUserName()%></strong>
     		<a  href="userurl?action=logout" class="btn btn-outline-primary"
     		onclick="return confirm('Are you Sure you want Logout')">
     			Logout
     		</a>
     	</p>
     <%} %> 
      
      </div>
  </div>
</nav>

