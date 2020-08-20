package com.example.demo.entity;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "Books")
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;

	private String bookName;
    private String issue;
	  
    @ManyToOne
    @JoinColumn(name = "B_s")
    private Shelves shelve;

	public Books() {
	}

	public Books(int bookId, String bookName, String issue, Shelves shelve) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.issue = issue;
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

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public Shelves getShelve() {
		return shelve;
	}

	public void setShelve(Shelves shelve) {
		this.shelve = shelve;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", issue=" + issue + ", shelve=" + shelve + "]";
	}
	
    
    
}
