package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.BookRepo;
import com.example.demo.Repository.ShelfRepo;
import com.example.demo.entity.Books;
import com.example.demo.entity.Shelves;
import com.example.demo.model.BookModel;

@Service	
public class BookService {
	
	@Autowired
	private  BookRepo bookRepo;
	@Autowired
	private  ShelfRepo shelveRepo;
	
	@Transactional public List<BookModel> findAllBooksBypage(Pageable page){
		 
		 Page<Books> bookList=bookRepo.findAll(page);
		 List<BookModel>modelList=new ArrayList<>();
		 for( Books b:bookList) {
			 BookModel bm=new BookModel();
			 bm.setBookId(b.getBookId());
			 bm.setBookName(b.getBookName());
			 bm.setCurrentStatus(b.getIssue());
			 modelList.add(bm);
			 
		 }
	return modelList;
		}
	
	 @Transactional public List<BookModel> findAllBooks(){
		 
		 List<Books> bookList=bookRepo.findAll();
		 List<BookModel>modelList=new ArrayList<>();
		 for( Books b:bookList) {
			 BookModel bm=new BookModel();
			 bm.setBookId(b.getBookId());
			 bm.setBookName(b.getBookName());
			 bm.setCurrentStatus(b.getIssue());
			 modelList.add(bm);
			 
		 }
	return modelList;
		}

	 @Transactional public List<BookModel> findBYName(String bookName){
		 
		 List<Books> bookList=bookRepo.findByBookName(bookName);
		 List<BookModel>modelList=new ArrayList<>();
		 for( Books b:bookList) {
			 BookModel bm=new BookModel();
			 bm.setBookId(b.getBookId());
			 bm.setBookName(b.getBookName());
			 bm.setCurrentStatus(b.getIssue());
			 modelList.add(bm);
			 
		 }
	return modelList;
		}

	@Transactional public Books saveBook(BookModel bm) {
		 
		Books book=new Books();
		book.setBookId(bm.getBookId());
		book.setBookName(bm.getBookName());
		book.setIssue(bm.getCurrentStatus());
		
		bookRepo.save(book);
		   return book;
     	}
		
	public String addBookToShelve(int bookId, int shelfId) {
		 Books book=bookRepo.getOne(bookId);
		Shelves shelf=shelveRepo.getOne(shelfId);
		List<Books>lbs=new ArrayList<>();
		shelf.setBookCount(shelf.getBookCount()+1);
		lbs.add(book);
		shelf.setBook(lbs);
		book.setShelve(shelf);
		shelveRepo.save(shelf);
		bookRepo.save(book);
			
		return"added";
		
	}

	@Transactional public BookModel updateBook(int bookId,BookModel bm) {
		
		Books book=bookRepo.getOne(bookId);
		book.setBookName(bm.getBookName());
		book.setIssue(bm.getCurrentStatus());;
		bookRepo.save(book);

		   return bm;
    }
	
	
}
