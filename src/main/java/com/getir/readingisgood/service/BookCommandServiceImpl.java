package com.getir.readingisgood.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.getir.readingisgood.domain.entity.Book;
import com.getir.readingisgood.repository.BookRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class BookCommandServiceImpl implements IBookCommandService {

	private final BookRepository bookRepository;
	private final IBookQueryService bookQueryService;

	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void updateStockCount(Long bookId, int stockCount) {
		Book book = bookQueryService.getBookById(bookId, true);
		book.setStockCount(stockCount);
		save(book);

	}

}
