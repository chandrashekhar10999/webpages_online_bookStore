<%@page import="com.carowner.pojo.Car"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List"%>

<!-- THIS PAGE CANNOT ACCESS DIRECTLY BECAUSE IT NEEDS THE DATA FORM DATABASE
  AND THAT WILL BE GIVEN BY THE CONTROLLER -->
<jsp:include page="header.jsp" />

<%
List<Car> bList = (List<Car>) session.getAttribute("bList");
String msg = (String) session.getAttribute("msg");
%>
<div class="container">
	<h1>Employee's List</h1>


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

	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Car book : bList) {
			%>
			<tr>
				<td><%=book.getCarId()%></td>
				<td><%=book.getCarName()%></td>
				<td><%=book.getCarPrice()%></td>
				<td><a
					onclick="return confirm('Are you sure you want to delete?')"
					class="btn btn-outline-danger "
					href="bookurl?action=delete&bookId=<%=book.getCarId()%>">Delete</a>
					<a class="btn btn-outline-success "
					href="bookurl?action=update&bookId=<%=book.getCarId()%>">Update</a>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

</div>



<jsp:include page="footer.jsp" />