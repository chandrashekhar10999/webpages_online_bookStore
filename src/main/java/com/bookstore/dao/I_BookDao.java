package com.bookstore.dao;

import java.util.List;

import com.bookstore.pojo.Book;


// Here we create a blueprint of the Dao class 
// On which we write logic to peform opertions.
public interface I_BookDao 
{
	void addBook(Book book);
	List<Book> getAllBooks();
	boolean deleteBook(int bookId);
	boolean updateBook(int bookId,Book book);
	
	
	// Method 
	Book getBook(int bookId);
	List<Book> getBook(String bookName);
}
