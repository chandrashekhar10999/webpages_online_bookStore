
<%@page import="com.carowner.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
String msg = (String) session.getAttribute("msg");
User user=(User)session.getAttribute("user");
%>
<jsp:include page="header.jsp" />
<div class="container">
<h1>Index page</h1>
<%
	if (msg != null) {
	%>
	<div class="alert alert-success">
		<%=msg%>
	</div>
	<%
	session.setAttribute("msg", null);
	}
	%>
</div>

<jsp:include page="footer.jsp" />