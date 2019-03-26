package com.servlet.dto;

public class BookDTO {
	int bookid;
	String bookname;
	String bookloc;
	
	public BookDTO(int bookid,String bookname,String bookloc) {
		this.bookid = bookid;
		this.bookname = bookname;
		this.bookloc = bookloc;
	}

	public int getBookid() {
		return bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public String getBookloc() {
		return bookloc;
	}
}