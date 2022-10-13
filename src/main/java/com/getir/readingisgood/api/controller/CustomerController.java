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

import com.getir.readingisgood.domain.entity.Customer;
import com.getir.readingisgood.service.ICustomerCommandService;
import com.getir.readingisgood.service.ICustomerQueryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value= "/api/customer")
@AllArgsConstructor
public class CustomerController {

	private final ICustomerQueryService customerQueryService;
	private final ICustomerCommandService customerCommandService;
	
	
	@PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE})
	private ResponseEntity<Customer> save(@RequestBody @Valid Customer customer){
		
		return new ResponseEntity<>(customerCommandService.save(customer), HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Customer> getCustomerById(@PathVariable("id") @Valid @NotNull @Min(0) Long id){
		
		return new ResponseEntity<>(customerQueryService.getCustomerById(id, false), HttpStatus.OK);
		
	}
	
	@GetMapping
	private ResponseEntity<List<Customer>> getAllCustomers(){
		
		return new ResponseEntity<>(customerQueryService.getAllCustomers(), HttpStatus.OK);
		
	}
	
}
