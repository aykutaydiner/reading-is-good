package com.getir.readingisgood.service;

import com.getir.readingisgood.domain.entity.Book;

public interface IBookCommandService {

	Book save(Book book);

	void updateStockCount(Long bookId, int stockCount);

}
