package com.bookstore.pojo;


// Pojo stands Plain Old Java Object 
// here Book is pojo class which represent book data 
public class Book
{
	private int bookId;
	private String bookName;
	private double bookPrice;
	
	//To Create Empty book
	public Book() {
	}

	//To create book with data expect bookid
	public Book(String bookName, double bookPrice) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}
	// To create book with all data (including bookId)

	public Book(int bookId, String bookName, double bookPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}


	
	// To access a private variable outside a class we use getters and setters
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	
	// To print  Book class object in formated String form we use toString method.
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + "]";
	}

	public static void main(String[] args) 
	{
		Book b1 = new Book();
		Book b2 = new Book("Core Java",450.65);
		Book b3 = new Book(1,"Core Python",400.55);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
	}

}
