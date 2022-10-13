package com.getir.readingisgood.api.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getir.readingisgood.domain.entity.Book;
import com.getir.readingisgood.service.IBookCommandService;
import com.getir.readingisgood.service.IBookQueryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor
public class BookController {

	private final IBookQueryService bookQueryService;
	private final IBookCommandService bookCommandService;

	@GetMapping
	private ResponseEntity<List<Book>> getAllBooks() {
		return new ResponseEntity<>(bookQueryService.getAllBooks(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	private ResponseEntity<Book> getBookById(@PathVariable("id") @NotNull @Min(0) Long id) {
		return new ResponseEntity<>(bookQueryService.getBookById(id, false), HttpStatus.OK);

	}

	@PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE})
	private ResponseEntity<Book> save(@Valid @RequestBody  Book book) {
		return new ResponseEntity<>(bookCommandService.save(book), HttpStatus.OK);
	}

	@PutMapping(value = "/update/stock/{bookId}/{stockCount}")
	private ResponseEntity<Book> updateStockCount(@Valid @PathVariable("bookId") @NotNull Long bookId, @PathVariable("stockCount") @Valid @Min(0) int stockCount) {
		bookCommandService.updateStockCount(bookId,stockCount);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
