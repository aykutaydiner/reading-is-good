package com.getir.readingisgood.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.getir.readingisgood.domain.dto.OrderFilterRequestDTO;
import com.getir.readingisgood.domain.dto.OrderFilterResponseDTO;
import com.getir.readingisgood.domain.entity.Orders;
import com.getir.readingisgood.repository.OrderRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderQueryServiceImpl implements IOrderQueryService {

	private final OrderRepository orderRepository;
	
	@Override
	public Orders getOrderById(Long id, boolean throwNotFoundException) {
		Optional<Orders> optionalBook = orderRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}else if(throwNotFoundException){
			throw new EntityNotFoundException("Order not found on db. OrderId :"+ id);
		}else {
			return null;
		}
	}

	@Override
	public List<Orders> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public OrderFilterResponseDTO getOrdersByFilter(OrderFilterRequestDTO orderFilterRequestDTO) {
		Pageable page = PageRequest.of(orderFilterRequestDTO.getPageNumber(), orderFilterRequestDTO.getPageSize());
		Page<Orders> ordersPage = orderRepository.getOrdersByFilter(orderFilterRequestDTO.getCustomerId(), orderFilterRequestDTO.getStartDate(), orderFilterRequestDTO.getEndDate(), page);
		OrderFilterResponseDTO response = new OrderFilterResponseDTO(ordersPage.getTotalPages(), ordersPage.getTotalElements(), ordersPage.getNumber(), ordersPage.getContent());
		 return response;
	}

}
