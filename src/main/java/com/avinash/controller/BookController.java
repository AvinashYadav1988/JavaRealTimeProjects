package com.avinash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.avinash.entity.BookEntity;
import com.avinash.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	public BookService bookService;
	
	
	
	/*public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}*/


	@PostMapping("/book")
	public ResponseEntity<String> upsertBook(@RequestBody BookEntity book){
		System.out.println(book);
		String msg = bookService.upsertBook(book);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/books")
	public ResponseEntity<List<BookEntity>> getAllBooks(){
		
		List<BookEntity> allBooks = bookService.getAllBooks();
		
		return new ResponseEntity<List<BookEntity>>(allBooks,HttpStatus.OK);
		
	}
	
	@PutMapping("/book")
	
	public ResponseEntity<String> updateBook(@RequestBody BookEntity book){
		
		String msg = bookService.upsertBook(book);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	} 
	
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer bookId) {
		
		String deleteBook = bookService.deleteBook(bookId);
		return new ResponseEntity<String>(deleteBook,HttpStatus.OK);
	}
	
}
