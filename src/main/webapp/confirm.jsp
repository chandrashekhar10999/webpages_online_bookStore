<%@page import="com.bookstore.pojo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
    
    <% Book book = (Book)request.getAttribute("book");  %>
    
    <div class="container"> 
    <p class="alert alert-danger my-5"> Are You sure you want to delete <%=book.getBookName()%> ?</p>
    
    <form action="bookurl" method="post">
    <input type="hidden" name="action" value="delete" />
    <input type="hidden" name="bookId" value="<%=book.getBookId() %>" />
    <input class="btn btn-danger" type="submit" value="Delete">
     <a class="btn btn-primary ms-2" href="bookurl?action=list">Back</a>
    
    
    </form>
   
    </div>
    
<jsp:include page="footer.jsp"/>