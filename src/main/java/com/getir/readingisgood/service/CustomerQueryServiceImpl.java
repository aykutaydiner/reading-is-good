package com.getir.readingisgood.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.getir.readingisgood.domain.entity.Customer;
import com.getir.readingisgood.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerQueryServiceImpl implements ICustomerQueryService {

	private final CustomerRepository customerRepository;
	
	@Override
	public Customer getCustomerById(Long id, boolean throwNotFoundException) {
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		if(optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		}else if(throwNotFoundException){
			throw new EntityNotFoundException("Customer not found on db. CustomerId :"+ id);
		}else {
			return null;
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerByEMail(String email) {
		Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
		if(optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		}else {
			return null;
		}
	}

}
