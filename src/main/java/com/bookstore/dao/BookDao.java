package com.bookstore.dao;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

import com.bookstore.pojo.Book;

// dao stands Data Access Object it used access the data book from database 
// ie. Using dao class we can add,update,delete and read data book with database.
public class BookDao 
{
	Connection con = null;
	Statement stmt = null;        // Use for static SQL Queries (select) 
	
	PreparedStatement ps = null;  // Use for Dynamic SQL Queries (insert,update,delete)
	
	ResultSet rs = null;
	
	
	private Connection getCon()
	{
		try 
		{
			//Driver Registration 
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Establishing the connection
			String url="jdbc:mysql://localhost:3306/jdbc";
			String user="root";
			String password="root";
			Connection con = DriverManager.getConnection(url, user, password);
			
			return con;  // if connected with database return connection object.
		}
		catch(Exception e)
		{
			e.printStackTrace();
				
		}
		return null; // if not able connect with database return null.
	}
	
	
	
	public void addBook(Book book)
	{	
		con = getCon();
		try 
		{
			// bookid is auto generate by database.
			ps = con.prepareStatement("insert into book (bookname,bookPrice) values (?,?)");
			// this 2 ? are represent the data of book 1st for bookname
			// 2nd for bookprice 
			
			// here we Set the ? with value of specific type.
			ps.setString(1, book.getBookName());
			ps.setDouble(2,book.getBookPrice());
			
			
			int row = ps.executeUpdate();
			System.out.println(row+" Inserted.");
			
			ps.close();
			con.close();
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
	}
	
	public List<Book> getAllBooks()
	{
		List<Book> booklist = new ArrayList<Book>(); // Empty list
		try 
		{
			con = getCon();   // establish the connection and return its object
	 		stmt = con.createStatement();
			
			rs = stmt.executeQuery("select * From book");
			
			while(rs.next())
			{
				Book book = new Book(rs.getInt(1),rs.getString(2),rs.getDouble(3));				
				booklist.add(book);
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return booklist;
	}	
	
	
	public boolean deleteBook(int bookId)
	{
		con = getCon();
		try 
		{
			ps = con.prepareStatement("delete from book where bookId=?");
			
			ps.setInt(1, bookId); // here we set the value to the ? of query.
			
			int row = ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}// end delete method.
	
	public  boolean updateBook(int bookId,Book book)
	{
		con = getCon();
		try 
		{
			ps = con.prepareStatement("update book set bookname=?,bookPrice=? where bookid=?");
			ps.setString(1, book.getBookName());
			ps.setDouble(2,book.getBookPrice());
			ps.setInt(3, bookId);
			
			int row = ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
			ps.close();
			con.close();
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
		return false; // by default returns false.
	}
	
	public  boolean updateBook(int bookId,String bookName)
	{
		con = getCon();
		try 
		{
			ps = con.prepareStatement("update book set bookname=? where bookid=?");
			ps.setString(1, bookName);
			ps.setInt(2, bookId);
			
			int row = ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
			ps.close();
			con.close();
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
		return false; // by default returns false.
	}
	
	public Book getBookById(int bookId)
	{
		try 
		{
			con = getCon();   // establish the connection and return its object
	 		stmt = con.createStatement();
			
			rs = stmt.executeQuery("select * From book where bookId="+bookId);
			
			while(rs.next())
			{
				Book book = new Book(rs.getInt(1),rs.getString(2),rs.getDouble(3));				
				return book;
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
}
