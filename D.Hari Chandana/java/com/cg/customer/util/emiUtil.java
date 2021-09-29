package com.cg.customer.util;

import org.springframework.stereotype.Component;

import com.cg.customer.dto.emiDetails;
import com.cg.customer.entity.Emi;

@Component
public class emiUtil {

	public static emiDetails toDetails(Emi emi) {
		return new emiDetails(emi.getEmiAmount(),emi.getInterestAmount(),emi.getTotalEmiAmount(),emi.getDueDate());
	}

}
