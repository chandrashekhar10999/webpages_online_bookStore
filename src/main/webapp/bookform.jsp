<%@page import="com.bookstore.pojo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
	this page can not access directly because 
	It need the data from database.
	and that will be given by the controller
 -->
<%
String action = (String) request.getAttribute("action");
Book book = (Book)request.getAttribute("book");
%>

<jsp:include page="header.jsp" />

<div class="container">
	<h1><%=action%> Book</h1>
	<form action="bookurl" method="post">
		<input type="hidden" name="action" value="<%=action%>"/>
		<%if(action!=null && action.equals("update")){ %>
		<div class="mb-3">
			<label for="bookId" class="form-label">Book Id</label> 
			<input type="number" class="form-control" id="bookId" name="bookId" 
			placeholder="Enter book Id" readonly value="<%=book.getBookId()%>">
		</div>
		<%} %>
		<div class="mb-3">
			<label for="bookName" class="form-label">Book Name</label> 
			<input type="text" class="form-control" id="bookName" name="bookName" 
			placeholder="Enter book Name" value="<%=book.getBookName()%>">
		</div>
		<div class="mb-3">
			<label for="bookPrice" class="form-label">Book Price</label> 
			<input type="text" class="form-control" id="bookPrice" name="bookPrice" 
			placeholder="Enter book Price" value="<%=book.getBookPrice()%>">
		</div>
		<input class="btn btn-outline-success" type="submit" value="<%=action%> Book"/>
	</form>
</div>

<jsp:include page="footer.jsp" />