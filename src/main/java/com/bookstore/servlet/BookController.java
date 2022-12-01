package com.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.BookDao;
import com.bookstore.pojo.Book;

@WebServlet("/bookurl")
public class BookController extends HttpServlet
{
	String action;
	List<Book> blist = null;
	BookDao bookDao = new BookDao();
	HttpSession session= null;
	int bookId;
	Book book;
	
	String bookName;
	double bookPrice;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		action = req.getParameter("action");
		session = req.getSession();
		
		if(action!=null && action.equals("list"))
		{
			// here we write logic to show book-list 
			blist = bookDao.getAllBooks();
			session.setAttribute("blist", blist);
			resp.sendRedirect("booklist.jsp");
			/*
			 	sendRedirect used communicate with another resource but using
			 	New request always 
			 	 
			 */			
		}
		else if(action!=null && action.equals("add"))
		{
			book = new Book(0,"",0); //for add book is empty 
			req.setAttribute("action", "add");
			req.setAttribute("book", book);
			RequestDispatcher rd = req.getRequestDispatcher("bookform.jsp");
			rd.forward(req, resp);
			/*
			    RequestDispacther is used communicate with another resource but 
			    using same request.
			*/						
		}
		else if(action!=null && action.equals("update"))
		{
			bookId = Integer.parseInt(req.getParameter("bookId"));
			book = bookDao.getBookById(bookId);
			// for update book is get from database.
			
			req.setAttribute("action", "update");
			req.setAttribute("book", book);
			RequestDispatcher rd = req.getRequestDispatcher("bookform.jsp");
			rd.forward(req, resp);
			
		}else if(action!=null && action.equals("delete"))
		{
			bookId = Integer.parseInt(req.getParameter("bookId"));
			book = bookDao.getBookById(bookId);
			
			req.setAttribute("book", book);
			
			RequestDispatcher rd = req.getRequestDispatcher("confirm.jsp");
			rd.forward(req, resp);
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		action = req.getParameter("action");
		session = req.getSession();
		if(action!=null && action.equals("add"))
		{
			bookName = req.getParameter("bookName");
			bookPrice = Double.parseDouble(req.getParameter("bookPrice"));
			book = new Book(bookName, bookPrice);
			bookDao.addBook(book);
			session.setAttribute("msg", "Book Added Successfully..");
			resp.sendRedirect("bookurl?action=list");
			
			
		}
		else if(action!=null && action.equals("update"))
		{
			bookId = Integer.parseInt(req.getParameter("bookId"));
			bookName = req.getParameter("bookName");
			bookPrice = Double.parseDouble(req.getParameter("bookPrice"));
		
			
			book = new Book(bookId,bookName, bookPrice);
			
			
			bookDao.updateBook(bookId, book);
			
			session.setAttribute("msg", "Book Updated Successfully..");
			resp.sendRedirect("bookurl?action=list");
		
		}
		else if(action!=null && action.equals("delete"))
		{
			bookId = Integer.parseInt(req.getParameter("bookId"));
			bookDao.deleteBook(bookId);
			session.setAttribute("msg", "Book Deleted Successfully..");
			resp.sendRedirect("bookurl?action=list");
			
		}
		
		
	}
	
	
	
	
	
	
	
}
