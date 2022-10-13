package com.getir.readingisgood.service;

import java.util.List;

import com.getir.readingisgood.domain.dto.OrderMonthlyStatisticsResponseDTO;

public interface IStatisticsServise {

	List<OrderMonthlyStatisticsResponseDTO> getOrderMonthlyStatistics();

}
