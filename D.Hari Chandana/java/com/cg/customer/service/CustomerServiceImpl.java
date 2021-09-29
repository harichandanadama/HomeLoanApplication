package com.cg.customer.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.customer.dao.CustomerDao;
import com.cg.customer.entity.Customer;
import com.cg.customer.entity.LoanApplication;
import com.cg.customer.exception.CustomerAlreadyExistsException;
import com.cg.customer.exception.CustomerNotFoundException;



@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	private Logger logger=Logger.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerDao dao;

	@Override
	public Customer register(Customer customer) {

		boolean exists=customer.getId()!=null&&dao.existsById(customer.getId());
		if(exists) {
			logger.info(customer+"customer already exists exception");
			throw new CustomerAlreadyExistsException("customer already exists for id="+customer.getId());
		}
		customer=dao.save(customer);
		logger.info(customer+":added succesfully");
		System.out.println("returning saved customer: "+customer);
		return customer;
	}

	@Override
	public Customer findById(Integer id) {
		System.out.println("id: "+id);
        Optional<Customer> optional = dao.findById(id);
        if(!optional.isPresent()){
        	logger.info(id+"CustomerNotFound Exception");
        	System.out.println("***error***");
            throw new CustomerNotFoundException("customer not found for id="+id);
        }
        Customer customer=optional.get();
        logger.info(customer+":found with an id:"+id);
        System.out.println("customer: "+ customer);
		return customer;
	}

	
}

