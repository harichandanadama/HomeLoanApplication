package com.cg.customer.service;

import com.cg.customer.entity.Customer;
import com.cg.customer.entity.LoanApplication;
import com.cg.customer.exception.CustomerAlreadyExistsException;

public interface CustomerService {

	Customer register(Customer customer);

	Customer findById(Integer id);

	
}
