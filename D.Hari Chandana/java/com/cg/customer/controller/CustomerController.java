package com.cg.customer.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.customer.dto.CustomerDetails;
import com.cg.customer.dto.CustomerDetailsRequest;
import com.cg.customer.dto.LoanDetails;
import com.cg.customer.dto.emiDetails;
import com.cg.customer.entity.Customer;
import com.cg.customer.entity.Emi;
import com.cg.customer.entity.LoanApplication;
import com.cg.customer.entity.LoanTracker;
import com.cg.customer.exception.CustomerApprovedException;
import com.cg.customer.exception.CustomerLandOrFinanceException;
import com.cg.customer.exception.LoanNotApprovedException;
import com.cg.customer.service.CustomerLoanService;
import com.cg.customer.service.CustomerLoanServiceImpl;
import com.cg.customer.service.CustomerService;
import com.cg.customer.service.EmiService;
import com.cg.customer.util.CustomerUtil;
import com.cg.customer.util.LoanUtil;
import com.cg.customer.util.emiUtil;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {

	private Logger logger=Logger.getLogger(CustomerController.class);	
	
	@Autowired
	private CustomerService service;
	
	@Autowired
	private EmiService Eservice;
	
	@Autowired
	private CustomerLoanService Lservice;

	@Autowired
	private CustomerUtil customerUtil;
	
	@Autowired
	private LoanUtil loanUtil;
	
	@Autowired
	private emiUtil emiUtil;

	/*
	 * @GetMapping("/byName/{name}") public String display(@PathVariable("name")
	 * String name) { System.out.println("cntrlr fetch name: " + name); String
	 * response = name; System.out.println("by name details: " + response); return
	 * response; }
	 */

	@GetMapping("/by/id/{id}")
	public CustomerDetails fetchCustomer(@PathVariable("id") Integer id) {
		System.out.println("cntrlr fetch id: " + id);
		Customer customer = service.findById(id);
		CustomerDetails details = customerUtil.toDetails(customer);
		System.out.println("details: " + details);
		return details;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/register")
	public CustomerDetails add(@RequestBody @Valid CustomerDetailsRequest requestData) {
		System.out.println("req data: " + requestData);
		Customer customer = new Customer(requestData.getName(), requestData.getMobile(), requestData.getEmail(),
				requestData.getDob(), requestData.getGender(), requestData.getNationality(), requestData.getAadhar(),
				requestData.getPan());
		customer = service.register(customer);
		CustomerDetails details = CustomerUtil.toDetails(customer);
		return details;
	}

	@GetMapping("/loan/Apply/{date}/{applyamount}/{custid}")
	public LoanDetails addLoan(@PathVariable("date") Date date, @PathVariable("applyamount") double amount, @PathVariable("custid") int id) {
		System.out.println("Controller fetch id: " + id);
		Customer customer = service.findById(id);
		LoanApplication loan = new LoanApplication(date, amount, id,"Not approved");
		loan = Lservice.register(loan);
		LoanDetails details = loanUtil.toDetails(loan);
		return details;
	}
	
	@GetMapping("/loan/updateFinanceDocuments/{customerid}/{applicationid}/{finance}")
	public LoanDetails updateLoanFinance(@PathVariable("customerid") int id,@PathVariable("applicationid") int appid, @PathVariable("finance") boolean financeupdate) {
		System.out.println("Controller fetch Customer id: " + id + " with Application id:" + appid);
		Customer customer = service.findById(id);
		LoanApplication loan = Lservice.findByCustId(id, appid);
		if(loan.getStatus().equals("Approved") || loan.getStatus().equals("Rejected")) {
			logger.info("already update cant update again=FinanceOfficer");
			throw new CustomerApprovedException("Already Updated....... Can't update again");
		}else {
			loan.setFinanceVerificationApproval(financeupdate);
			loan = Lservice.register(loan);
		}
		LoanDetails details = loanUtil.toDetails(loan);
		return details;
	}
	
	@GetMapping("/loan/updateLandDocuments/{customerid}/{applicationid}/{landdocuments}")
	public LoanDetails updateLoanLandDocuments(@PathVariable("customerid") int id,@PathVariable("applicationid") int appid, @PathVariable("landdocuments") boolean landdocumentsupdate) {
		System.out.println("Controller fetch Customer id: " + id + " with Application id:" + appid);
		Customer customer = service.findById(id);
		LoanApplication loan = Lservice.findByCustId(id, appid);
		if(loan.getStatus().equals("Approved") || loan.getStatus().equals("Rejected")) {
			logger.info("already update cant update again-LandVerification");
			throw new CustomerApprovedException("Already Updated....... Can't update again");
		}else {
			loan.setLandVerificationApproval(landdocumentsupdate);
			loan = Lservice.register(loan);
		}
		LoanDetails details = loanUtil.toDetails(loan);
		return details;
	}
	
	@GetMapping("/loan/updateAdminApprove/{customerid}/{applicationid}/{approvedamount}/{adminapprove}/{rejectdata}")
	public LoanDetails updateAdminApproval(@PathVariable("customerid") int id, @PathVariable("applicationid") int appid, 
			@PathVariable("approvedamount") float approveamount, @PathVariable("adminapprove") boolean adminapprovalupdate,
			@PathVariable("rejectdata") String reject) {
		System.out.println("Controller fetch Customer id: " + id + " with Application id:" + appid);
		Customer customer = service.findById(id);
		LoanApplication loan = Lservice.findByCustId(id, appid);
		if(!loan.isLandVerificationApproval() || !loan.isFinanceVerificationApproval()) {
			logger.info("Land Documents or Finance Document Approval Required-Admin");
			throw new CustomerLandOrFinanceException("Land Documents or Finance Document Approval Required");
		}else if(loan.getStatus().equals("Approved") || loan.getStatus().equals("Rejected")) {
			logger.info("Already Updated,cant update again-Admin");
			throw new CustomerApprovedException("Already Updated....... Can't update again");
		}else {
			if(reject.equals("r")) {
				loan.setAdminApproval(false);
				loan.setLoanApprovedAmount(approveamount);
				loan.setStatus("Rejected");
				loan = Lservice.register(loan);
			}else {
				loan.setAdminApproval(adminapprovalupdate);
				loan.setLoanApprovedAmount(approveamount);
				loan.setStatus("Approved");
				loan = Lservice.register(loan);
			}
			
			
		}
		LoanDetails details = loanUtil.toDetails(loan);
		return details;
	}
	
	@GetMapping("/loan/getAllLoansAppliedByCustomerId/{id}")
	public List<LoanDetails> getAllLoansByCustomerId(@PathVariable("id") int id){
		System.out.println("Controller fetch Loan Applications of Customer with id: " + id);
		Customer customer = service.findById(id);
		List<LoanApplication> loans = Lservice.findByCustId(id);
		List<LoanDetails> details = loanUtil.toDetails(loans);
		logger.info(details);
		return details;
	}
	
	@GetMapping("/loan/loanTracker/{custid}/{applicationid}")
	public LoanTracker getLoanDetails(@PathVariable("custid") int id, @PathVariable("applicationid") int appid) {
		Customer customer = service.findById(id);
		LoanApplication loan = Lservice.findByCustId(id, appid);
		LoanTracker lt = new LoanTracker();
		
		lt = Lservice.loanTracker(loan);
		logger.info(lt);
		return lt;
	}
	
	@GetMapping("/loan/removeLoanByCustomer/{id}/{applicationid}")
	public LoanDetails deleteLoan(@PathVariable("id") int id,@PathVariable("applicationid") int appid) {
		logger.info("Deleting loan for customerid:"+id+"with application id:"+appid);
		Customer customer=service.findById(id);
		LoanApplication loan=Lservice.findByCustId(id,appid);
		if(loan.getStatus().equals("Approved")||loan.getStatus()=="Rejected") {
			logger.error("Tried to delete approved/rejected loan....");
			throw new CustomerApprovedException("Cannot delete approvedd/rejected loans");
		}
		LoanDetails details=loanUtil.toDetails(loan);
		Lservice.remove(loan.getApplicationid());
		return details;
	}
	@GetMapping("/emi/emicalculator/{loanamount}/{interestrate}/{tenure}/{loandate}")
	public Emi emiCalculator(@PathVariable("loanamount") double amount, @PathVariable("interestrate") float rate,@PathVariable("tenure") int period,@PathVariable("loandate") Date date) { 
		Emi emi = new Emi(amount,rate,period,date);
		emi=Eservice.calculate(emi);
		System.out.println(emi);
		logger.info(emi);
		return emi;
	}
	@GetMapping("/approvedEMI/{custid}/{applicationid}/{rateOfInterest}/{timePeriod}")
	public Emi calculateApprovedEmi(@PathVariable("custid") int id, @PathVariable("applicationid") int appid,@PathVariable("rateOfInterest") float rateOfInterest, @PathVariable("timePeriod") int timePeriod) {
		Customer customer = service.findById(id);
		LoanApplication loan = Lservice.findByCustId(id, appid);
		Emi emi = null;
		if(loan.getStatus().equals("Approved")){
			double loanAmount = loan.getLoanApprovedAmount();
			double interest = (double) ((loanAmount * (rateOfInterest * 0.01))/timePeriod);
			double emiAmount = ((loanAmount/timePeriod) + interest);
			double totalEmiAmount = interest * timePeriod;
			double totalAmount = emiAmount * timePeriod;
			emi = new Emi(loanAmount, rateOfInterest, timePeriod, interest, emiAmount, totalEmiAmount, totalAmount);
			return emi;
		}
		else {
			throw new LoanNotApprovedException("Loan is not approved to check EMI");
		}
	}

}
