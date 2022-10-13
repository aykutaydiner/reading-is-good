package com.getir.readingisgood.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getir.readingisgood.domain.dto.OrderMonthlyStatisticsResponseDTO;
import com.getir.readingisgood.service.IStatisticsServise;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/statistics")
@AllArgsConstructor
public class StatisticsController {

	private final IStatisticsServise statisticService;
	
	
	@GetMapping("/order/monthly")
	private ResponseEntity<List<OrderMonthlyStatisticsResponseDTO>> getOrderMonthlyStatistics(){
		return new ResponseEntity<>(statisticService.getOrderMonthlyStatistics(), HttpStatus.OK);
	}
	
}
