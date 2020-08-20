package com.example.demo.model;

import java.util.List;

public class ShelfModel {
	
	private int shelfId;
	private String shelfName;
	private int BookCount;
	
	private List<String> books;

	public int getShelfId() {
		return shelfId;
	}

	public void setShelfId(int shelveId) {
		this.shelfId = shelveId;
	}

	public String getsName() {
		return shelfName;
	}

	public void setsName(String sName) {
		this.shelfName = sName;
	}

	public int getBookCount() {
		return BookCount;
	}

	public void setBookCount(int bookCount) {
		BookCount = bookCount;
	}

	public List<String> getBooks() {
		return books;
	}

	public void setBooks(List<String> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "ShelveModel [shelveId=" + shelfId + ", sName=" + shelfName + ", BookCount=" + BookCount + ", books="
				+ books + "]";
	}
	
}
