package com.getir.readingisgood.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.getir.readingisgood.domain.entity.Book;
import com.getir.readingisgood.repository.BookRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookQueryServiceImp implements IBookQueryService {

	private final BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Long id, boolean throwNotFoundException) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}else if(throwNotFoundException){
			throw new EntityNotFoundException("Book not found on db. BookId :"+ id);
		}else {
			return null;
		}
		
	}

}
