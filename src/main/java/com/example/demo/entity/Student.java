package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studId;
	
	private String studName;

	@OneToMany(targetEntity = Books.class,cascade = CascadeType.ALL)
//	@JoinTable(name="user_book",joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns = @JoinColumn(name="bookId"))
	@JoinColumn(name = "user_book",referencedColumnName = "userId")
	private List<Books> book;

	
	
	
	public String getUserName() {
		return studName;
	}
	public void setUserName(String studentName) {
		this.studName = studentName;
	}
	public List<Books> getBook() {
		return book;
	}
	public void setBook(List<Books> book) {
		this.book = book;
	}
	public Student() {
	
	}
	public Student(int studentId, String studentName) {
		super();
		this.studId = studentId;
		this.studName = studentName;
	}
	public int getUserId() {
		return studId;
	}
	public void setUserId(int studentId) {
		this.studId = studentId;
	}
	public String getuserName() {
		return studName;
	}
	public void setuserName(String studentName) {
		this.studName = studentName;
	}
	@Override
	public String toString() {
		return "User [userId=" + studId + ", userName=" + studName + ", phoneNo=" + "]";
	}
	

}
