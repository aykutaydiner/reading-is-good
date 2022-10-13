package com.getir.readingisgood.service;

import java.util.List;

import com.getir.readingisgood.domain.dto.OrderFilterRequestDTO;
import com.getir.readingisgood.domain.dto.OrderFilterResponseDTO;
import com.getir.readingisgood.domain.entity.Orders;

public interface IOrderQueryService {

	Orders getOrderById(Long id, boolean throwNotFoundException);

	List<Orders> getAllOrders();

	OrderFilterResponseDTO getOrdersByFilter(OrderFilterRequestDTO orderFilterRequestDTO);

}
