<%@page import="com.bookstore.pojo.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
	this page can not access directly because 
	It need the data from database.
	and that will be given by the controller
 -->   
 <%
 	List<Book> blist = (List<Book>)session.getAttribute("blist");
 	String msg = (String)session.getAttribute("msg");
 %> 
<jsp:include page="header.jsp"/>

<div class="container">    
	
 	<h1>Book List</h1>
 	<%if(msg!=null) {%>
	<div class="alert alert-success">
		
		<%=msg%>
	</div>
		<%
			session.setAttribute("msg",null);
			}
		%>

	<table class="table">
		<thead>
			<tr align="center">
				<th>ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%for(Book book:blist){ %>
				<tr align="center">
					<td><%=book.getBookId()%></td>
					<td align="left"><%=book.getBookName()%></td>
					<td><%=book.getBookPrice()%></td>
					<td >
						<a onclick ="return confirm ('Are You Sure You want to Delete')"  class="btn btn-outline-danger me-5" 
						href="bookurl?action=delete&bookId=<%=book.getBookId()%>">
							Delete
						</a>
					
						<a class="btn btn-outline-warning" 
						href="bookurl?action=update&bookId=<%=book.getBookId()%>">
							Update
						</a>
					</td>
				</tr>
			<%} %>
		</tbody>
	</table> 	
</div>
 
<jsp:include page="footer.jsp"/>





