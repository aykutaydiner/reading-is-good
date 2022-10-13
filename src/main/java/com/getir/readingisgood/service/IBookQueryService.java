package com.getir.readingisgood.service;

import java.util.List;

import com.getir.readingisgood.domain.entity.Book;

public interface IBookQueryService {

	List<Book> getAllBooks();

	Book getBookById(Long id, boolean throwNotFoundException);

}
