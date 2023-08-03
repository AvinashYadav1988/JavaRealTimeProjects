package com.avinash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avinash.entity.BookEntity;
import com.avinash.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	public BookRepository repository;

	/* public BookServiceImpl(BookRepository repository) {
		super();
		this.repository = repository;
	}*/

	@Override
	public String upsertBook(BookEntity book) {
		Integer bookId = book.getBookId();
		repository.save(book);
		if (bookId == null) {

			return "Book Inserted";

		} else {

			return "Book updated";
		}
		
	}

	@Override
	public String deleteBook(Integer bookId) {
		repository.deleteById(bookId);
		return "Book Deleted";
	}

	@Override
	public List<BookEntity> getAllBooks() {
		// TODO Auto-generated method stub
		List<BookEntity> books = repository.findAll();
		return books;
	}

}
