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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getir.readingisgood.domain.dto.OrderFilterRequestDTO;
import com.getir.readingisgood.domain.dto.OrderFilterResponseDTO;
import com.getir.readingisgood.domain.entity.Orders;
import com.getir.readingisgood.service.IOrderCommandService;
import com.getir.readingisgood.service.IOrderQueryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {

	private final IOrderQueryService orderQueryService;
	private final IOrderCommandService orderCommandService;
	
	@PostMapping(value="/create", consumes = {MediaType.APPLICATION_JSON_VALUE})
	private ResponseEntity<Orders> save(@RequestBody @Valid @NotNull Orders order){
		return new ResponseEntity<>(orderCommandService.save(order), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Orders> getOrderById(@PathVariable("id") @Valid @NotNull @Min(0) Long id){
		return new ResponseEntity<>(orderQueryService.getOrderById(id, false), HttpStatus.OK);
	}
	
	@GetMapping
	private ResponseEntity<List<Orders>> getAllOrders() {
		return new ResponseEntity<>(orderQueryService.getAllOrders(), HttpStatus.OK);
	}
	
	@PostMapping(value="/filter", consumes = {MediaType.APPLICATION_JSON_VALUE})
	private ResponseEntity<OrderFilterResponseDTO> getOrdersByFilter(@RequestBody @Valid OrderFilterRequestDTO orderFilterRequestDTO) {
		return new ResponseEntity<>(orderQueryService.getOrdersByFilter(orderFilterRequestDTO), HttpStatus.OK);
	}
	
}
