package com.getir.readingisgood.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

import com.getir.readingisgood.domain.entity.Book;
import com.getir.readingisgood.domain.entity.BookAmount;
import com.getir.readingisgood.domain.entity.Customer;
import com.getir.readingisgood.domain.entity.OrderBook;
import com.getir.readingisgood.domain.entity.Orders;
import com.getir.readingisgood.repository.OrderRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class OrderCommandServiceImpl implements IOrderCommandService {

	private final OrderRepository orderRepository;
	private final IBookQueryService bookQueryService;
	private final IBookCommandService bookCommandService;
	private final ICustomerQueryService customerQueryService;
	
	@Override
	public Orders save(Orders order) {
		
		customerQueryService.getCustomerById(order.getCustomerId(), true);
		for (OrderBook orderBook : order.getOrderBookList()) {
			Book orderedBook = bookQueryService.getBookById(orderBook.getBookId(), true);
			if (orderedBook.getStockCount() >= orderBook.getOrderCount()) {
				bookCommandService.updateStockCount(orderedBook.getId(),
						orderedBook.getStockCount() - orderBook.getOrderCount());
				orderBook.setBookName(orderedBook.getName());
				List<BookAmount> bookAmountList = orderedBook.getBookAmountList();
				if (bookAmountList != null && !bookAmountList.isEmpty()) {
					Optional<BookAmount> optionalBookAmount = bookAmountList.stream().filter(b -> b.isActive())
							.findFirst();
					if (optionalBookAmount.isPresent()) {

						orderBook.setBookPrice(optionalBookAmount.get().getAmount());
					}
				}
			} else {
				throw new ValidationException("Book's stock count not enough for orderCount. BookId:"
						+ orderBook.getBookId() + ", StockCount:" + orderedBook.getStockCount() + ", OrderCount:"
						+ orderBook.getOrderCount());
			}
		}
			
		return orderRepository.save(order);
	}

}
