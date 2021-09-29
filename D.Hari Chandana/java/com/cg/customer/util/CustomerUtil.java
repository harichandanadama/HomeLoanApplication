package com.cg.customer.util;

import org.springframework.stereotype.Component;

import com.cg.customer.dto.CustomerDetails;
import com.cg.customer.dto.LoanDetails;
import com.cg.customer.entity.Customer;

@Component
public class CustomerUtil {

	public static CustomerDetails toDetails(Customer customer) {
		return new CustomerDetails(customer.getId(), customer.getName(), customer.getMobile(), customer.getEmail(),customer.getDob(),customer.getGender(),customer.getNationality(),customer.getAadhar(),customer.getPan());
}
}

