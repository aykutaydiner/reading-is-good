package com.getir.readingisgood.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.getir.readingisgood.domain.dto.OrderMonthlyStatisticsResponseDTO;
import com.getir.readingisgood.repository.OrderRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatisticsService implements IStatisticsServise {

	private final OrderRepository orderRepository;
	
	@Override
	public List<OrderMonthlyStatisticsResponseDTO> getOrderMonthlyStatistics() {
		return orderRepository.getOrderMonthlyStatistics();
	}

}
