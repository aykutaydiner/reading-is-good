package com.getir.readingisgood.service;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

import com.getir.readingisgood.domain.entity.Customer;
import com.getir.readingisgood.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class CustomerCommandServiceImpl implements ICustomerCommandService {

	private final CustomerRepository customerRepository;
	private final ICustomerQueryService customerQueryService;
	
	@Override
	public Customer save(Customer customer) {
		Customer currentCustomer = customerQueryService.getCustomerByEMail(customer.getEmail());
		if(currentCustomer != null) {
			throw new ValidationException("Email exists on DB. Email:"+customer.getEmail());
		}else {
			return customerRepository.save(customer);
		}
	}

}
