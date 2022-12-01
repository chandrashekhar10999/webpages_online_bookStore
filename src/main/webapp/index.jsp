<%@page import="com.bookstore.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String msg = (String)session.getAttribute("msg");
	User user = (User)session.getAttribute("user");
%>

<jsp:include page="header.jsp"/>
 
<div class="container"> 
	<%if(msg!=null) {%>
	<div class="alert alert-success">
		
		<%=msg%>
	</div>
		<%
			session.setAttribute("msg",null);
			}
		%>   
 	<h1>Index Page</h1>
</div>
<jsp:include page="footer.jsp"/>