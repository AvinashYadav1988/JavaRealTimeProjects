package com.avinash.service;

import java.util.List;

import com.avinash.entity.BookEntity;

public interface BookService {
	
	public String upsertBook(BookEntity book);
	public String deleteBook(Integer bookId);
	public List<BookEntity> getAllBooks();
	

}
