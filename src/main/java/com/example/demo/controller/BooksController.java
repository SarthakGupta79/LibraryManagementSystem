package com.example.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Books;
import com.example.demo.model.BookModel;
import com.example.demo.service.BookService;

@RestController

public class BooksController {

	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/getAllBook/{page}/{size}/{sort}")
	public List<BookModel> findAllBooksBypage(@PathVariable int page,@PathVariable int size,@PathVariable String sort){
		Pageable pageing= PageRequest.of(page,size, Sort.by(sort));
		return bookService.findAllBooksBypage(pageing);
	}
	
	@GetMapping(value = "/getAllBook")
	public List<BookModel> findAllBooks(){
		return bookService.findAllBooks();
	}

	
	@GetMapping("/getBook/{bookName}") 
    
    public List<BookModel> findByBookName(@PathVariable String bookName) {
   	 return bookService.findBYName(bookName);
    }
   
	@PostMapping(value = "/saveBook")
	public Books saveBook(@RequestBody BookModel bm) {
		return bookService.saveBook(bm);
		
	}
	
	
	@PutMapping(value = "/updateBook/{bookId}")
	public BookModel updateBook(@PathVariable int bookId,@RequestBody BookModel bm) {
		
		return bookService.updateBook(bookId, bm);
	}
	
	
	@PostMapping(value = "/addBookShelf/{bookId}/{shelfId}")
		public String addBookToShelve(@PathVariable int bookId,@PathVariable int shelfId) {
			
			 return bookService.addBookToShelve(bookId, shelfId);
		
	
	}
}
