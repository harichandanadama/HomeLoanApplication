package com.cg.customer.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.customer.dao.CustomerLoanDao;
import com.cg.customer.entity.LoanApplication;
import com.cg.customer.entity.LoanTracker;
import com.cg.customer.exception.CustomerApplicationNotFoundException;
import com.cg.customer.exception.CustomerNotFoundException;

@Service
@Transactional
public class CustomerLoanServiceImpl implements CustomerLoanService {

	@Autowired
	private CustomerLoanDao dao;

	private Logger logger=Logger.getLogger(CustomerLoanServiceImpl.class);	
	@Override
	public LoanApplication register(LoanApplication loan) {
		loan = dao.save(loan);
		logger.info(loan+"loan added successfully");
		System.out.println(loan);
		return loan;	
	}

	@Override
	public LoanApplication findByCustId(int id, int appid) {
		List<LoanApplication> loanList = dao.findByCustId(id);
		if(!(loanList.size()>0)) {
			System.out.println("Error");
			logger.info("No loans applied by customer:id"+id);
			throw new CustomerNotFoundException("No loans applied by Customer with id : " + id);
		}
		Optional<LoanApplication> opt1 = dao.findByAppId(id, appid);
		if(!opt1.isPresent()) {
			System.out.println("Error");
			logger.info("Application with id:"+appid+"not present for customer with id:"+id);
			throw new CustomerApplicationNotFoundException("Application with id : " + appid + " not present for Customer id : " + id);
		}
		LoanApplication loan = opt1.get();
		logger.info("loan applied by customer with id:"+id+"and application id:"+appid+"is:"+loan);
		System.out.println(loan);
		return loan;
	
	}

	@Override
	public List<LoanApplication> findByCustId(int id) {
		List<LoanApplication> loanList = dao.findByCustId(id);
		if(!(loanList.size()>0)) {
			System.out.println("Error");
			logger.info("No loans applied by customer:id"+id);
			throw new CustomerNotFoundException("No loans applied by Customer with id : " + id);
		}
		logger.info("loans applied by customer:id"+id+":"+loanList);
		return loanList;
	}

	@Override
	public LoanTracker loanTracker(LoanApplication loan) {
LoanTracker lt = new LoanTracker();
		
		lt.setStatus(loan.getStatus());
		
		if(loan.isFinanceVerificationApproval() == false)
			lt.setFinanceApproval("Finance Approval Required");
		else
			lt.setFinanceApproval("Finance Details Approved");
		
		if(loan.isLandVerificationApproval() == false)
			lt.setLandApproval("Land Approval Required");
		else
			lt.setLandApproval("Land Details Approved");
		
		if(loan.isAdminApproval() == false)
			lt.setAdminApproval("Admin Approval Required");
		else
			lt.setAdminApproval("Admin Approved");
		logger.info("loan tracker for loan:"+loan+"status+"+lt);
		return lt;
	}

	@Override
	public void remove(int applicationid) {
		dao.deleteById(applicationid);
		
	}

}
