package com.cg.customer.dto;

import java.sql.Date;
import com.cg.customer.entity.status;
import javax.validation.constraints.NotBlank;

public class LoanCreationRequest {
	
	@NotBlank
	private Date date;
	@NotBlank
	private double LoanAppliedAmount;
	private double LoanApprovedAmount;
	private boolean landVerificationApproval;
	private boolean financeVerificationApproval;
	private boolean adminApproval;
	private status status;
	@NotBlank
	private int id;
	public LoanCreationRequest() {
		super();
	}
	public LoanCreationRequest(@NotBlank Date date, @NotBlank double loanAppliedAmount, double loanApprovedAmount,
			boolean landVerificationApproval, boolean financeVerificationApproval, boolean adminApproval,
			com.cg.customer.entity.status status, @NotBlank int id) {
		super();
		this.date = date;
		LoanAppliedAmount = loanAppliedAmount;
		LoanApprovedAmount = loanApprovedAmount;
		this.landVerificationApproval = landVerificationApproval;
		this.financeVerificationApproval = financeVerificationApproval;
		this.adminApproval = adminApproval;
		this.status = status;
		this.id = id;
	}
	@Override
	public String toString() {
		return "LoanCreationRequest [date=" + date + ", LoanAppliedAmount=" + LoanAppliedAmount
				+ ", LoanApprovedAmount=" + LoanApprovedAmount + ", landVerificationApproval="
				+ landVerificationApproval + ", financeVerificationApproval=" + financeVerificationApproval
				+ ", adminApproval=" + adminApproval + ", status=" + status + ", id=" + id + "]";
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getLoanAppliedAmount() {
		return LoanAppliedAmount;
	}
	public void setLoanAppliedAmount(double loanAppliedAmount) {
		LoanAppliedAmount = loanAppliedAmount;
	}
	public double getLoanApprovedAmount() {
		return LoanApprovedAmount;
	}
	public void setLoanApprovedAmount(double loanApprovedAmount) {
		LoanApprovedAmount = loanApprovedAmount;
	}
	public boolean isLandVerificationApproval() {
		return landVerificationApproval;
	}
	public void setLandVerificationApproval(boolean landVerificationApproval) {
		this.landVerificationApproval = landVerificationApproval;
	}
	public boolean isFinanceVerificationApproval() {
		return financeVerificationApproval;
	}
	public void setFinanceVerificationApproval(boolean financeVerificationApproval) {
		this.financeVerificationApproval = financeVerificationApproval;
	}
	public boolean isAdminApproval() {
		return adminApproval;
	}
	public void setAdminApproval(boolean adminApproval) {
		this.adminApproval = adminApproval;
	}
	public status getStatus() {
		return status;
	}
	public void setStatus(status status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
