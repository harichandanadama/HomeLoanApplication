package com.cg.customer.service;

import java.util.List;

import com.cg.customer.entity.LoanApplication;
import com.cg.customer.entity.LoanTracker;


public interface CustomerLoanService {
	
	LoanApplication register(LoanApplication loan);

	LoanApplication findByCustId(int id, int appid);

	List<LoanApplication> findByCustId(int id);

	LoanTracker loanTracker(LoanApplication loan);

	void remove(int applicationid);

}