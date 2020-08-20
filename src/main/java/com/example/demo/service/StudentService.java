package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.BookRepo;
import com.example.demo.Repository.ShelfRepo;
import com.example.demo.Repository.StudentRepo;
import com.example.demo.entity.Books;
import com.example.demo.entity.Student;
import com.example.demo.model.StudentModel;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepo studRepo;
	@Autowired
	private ShelfRepo shelfRepo;
	
	@Autowired
	private BookRepo bookRepo;
	
	 @Transactional public List<StudentModel> findAllUser(){
		 List<Student> studList=studRepo.findAll();
		 List<StudentModel>modelList=new ArrayList<>();
		 for( Student u:studList) {
			StudentModel sm=new StudentModel();
			 sm.setUserId(u.getUserId());
			 sm.setUserName(u.getuserName());
			 modelList.add(sm);
			 
		     }
		         return modelList;

	 }
	
	@Transactional public List<StudentModel> findByUserName( String studentName){
			
			List<Student> studList=studRepo.findAll();
			 List<StudentModel>modelList=new ArrayList<>();
			 for( Student u:studList) {
				StudentModel sm=new StudentModel();
				 sm.setUserId(u.getUserId());
				 sm.setUserName(u.getuserName());
				 modelList.add(sm);
				 
			     }
			         return modelList;
			
			}

	@Transactional public StudentModel saveUser(StudentModel sm) {
		
		Student stud=new Student();
		stud.setUserId(sm.getUserId());
		stud.setuserName(sm.getUserName());
		
		studRepo.save(stud);
		
		return sm;	
   }
	
	@Transactional public StudentModel updateUser(int studId,StudentModel sm){
		
		Student stud=studRepo.getOne(studId);
		stud.setuserName(sm.getUserName());
		studRepo.save(stud);
		return sm;
	}
		
   	public String assignToUser( int userId, int bookId) {
		Books book =bookRepo.findById(bookId).orElse(null);
		Student user =studRepo.findById(userId).orElse(null);
		
		List<Books>bookList=user.getBook();
		
		if(book.getShelve()!=null) {
			
			if(book.getIssue().equalsIgnoreCase("available")) {
		
				bookList.add(book);
				book.setIssue("not ");
				bookRepo.save(book);
				
				int count=book.getShelve().getBookCount();
				book.getShelve().setBookCount((count-1));
				shelfRepo.save(book.getShelve());

				return "assigned"; 	
			}
			else {
				return "cant be assign";
			}
			
	 }
		else {
			   return "cant be assign shelve is not present";
			}
		}
   	
//   	public String returnBook(int userId,int bookId) {
//   		User u=userRapo.getOne(userId); 
//   		List<Books>book=u.getBook();
//   		for(Books b :book) {
//   		
//   			          if(b.getBookId()==bookId) {
//   				
////   				if(b.getCurrentStatus().equalsIgnoreCase("not")) {
//   			   		Shelves sh= b.getShelve();
//   			   		int count=sh.getBookCount()+1;
//   			   		sh.setBookCount(count);
//   			   	    b.setCurrentStatus("available");
//   			   		bookRepo.save(b);
//   			   		u.getBook().remove(b);
//   			   		userRapo.save(u);
////   			   		}
////   				      else {
////   		   			          return"book is not issue ";	
////   		   		          }
////   			            
//   			          }
//   		
//   		      else {
//   			        return"book is not issued to that user";	
//   		          }  
//   		
//   		
//   		}
//   		return "book returned";
//   	}
//
//	
	
}
