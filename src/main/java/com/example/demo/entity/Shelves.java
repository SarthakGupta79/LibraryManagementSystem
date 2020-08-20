package com.example.demo.entity;

import java.util.List;

import javax.persistence.*;
@Entity
@Table(name = "Shelves")
public class Shelves {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shelfId;
	
	private String shelfName;
	private int bookCount;

	@OneToMany(targetEntity = Books.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "shelf_book",referencedColumnName = "shelveId")
	private List<Books> book;

	public Shelves() {
	}

	public Shelves(int shelfId, String shelfName, int bookCount, List<Books> book) {
		super();
		this.shelfId = shelfId;
		this.shelfName = shelfName;
		this.bookCount = bookCount;
		this.book = book;
	}

	public int getShelfId() {
		return shelfId;
	}

	public void setShelfId(int shelfId) {
		this.shelfId = shelfId;
	}

	public String getShelfName() {
		return shelfName;
	}

	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public List<Books> getBook() {
		return book;
	}

	public void setBook(List<Books> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Shelves [shelfId=" + shelfId + ", shelfName=" + shelfName + ", bookCount=" + bookCount + ", book="
				+ book + "]";
	}
	
	
	
}