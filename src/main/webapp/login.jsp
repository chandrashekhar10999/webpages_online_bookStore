<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)session.getAttribute("msg");
%>
<jsp:include page="header.jsp"/>
<div class="container">
	<h1>Login Here</h1>
	<%if(msg!=null) {%>
	<div class="alert alert-success">
		
		<%=msg%>
	</div>
		<%
			session.setAttribute("msg",null);
			}
		%>
	
	<form action="userurl" method="post">
		<input type="hidden" name="action" value="login"/>
		<div class="mb-3">
			<label for="userEmail" class="form-label">Email Id </label> 
			<input type="text" class="form-control" id="userEmail" 
			name="userEmail" 
			placeholder="Enter Your Email Id" >
		</div>
		<div class="mb-3">
			<label for="userPassword" class="form-label">Password </label> 
			<input type="password" name="userPassword" class="form-control"
			id="userPassword" placeholder="Enter your password"/>
		</div>
		<input type="submit" 
		class="btn btn-outline-success px-3 py-2 float-end " value="Lgoin"/>
	</form>
</div>
<jsp:include page="footer.jsp"/>