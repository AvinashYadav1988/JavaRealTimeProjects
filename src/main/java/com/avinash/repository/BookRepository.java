package com.avinash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avinash.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

}
