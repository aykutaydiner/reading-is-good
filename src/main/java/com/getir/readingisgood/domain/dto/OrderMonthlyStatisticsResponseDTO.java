package com.getir.readingisgood.domain.dto;

import java.math.BigDecimal;

public interface OrderMonthlyStatisticsResponseDTO {

	String getMonthName();
	int getYearNumber();
	long getTotalOrderCount();
	long getTotalBookCount();
	BigDecimal getTotalAmount();
	
}
