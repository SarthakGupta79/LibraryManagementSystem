package com.example.demo.model;

public class BookModel {
	
private int bookId;
	
	private String bookName;
    private String issue;
    
    private int shelve;
    
    
	public int getShelve() {
		return shelve;
	}
	public void setShelve(int shelve) {
		this.shelve = shelve;
	}
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
	public String getCurrentStatus() {
		return issue;
	}
	public void setCurrentStatus(String currentStatus) {
		this.issue = currentStatus;
	}
	@Override
	public String toString() {
		return "BooksModel [bookId=" + bookId + ", author=" + ", bookName=" + bookName + ", currentStatus="
				+ issue + "]";
	}
	
    
    
}
