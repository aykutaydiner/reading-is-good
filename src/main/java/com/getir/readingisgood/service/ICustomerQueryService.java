package com.getir.readingisgood.service;

import java.util.List;

import com.getir.readingisgood.domain.entity.Customer;

public interface ICustomerQueryService {

	Customer getCustomerById(Long id, boolean throwNotFoundException);

	List<Customer> getAllCustomers();

	Customer getCustomerByEMail(String email);

}
