package com.cg.customer.dto;

import java.sql.Date;

public class LoanDetails {
	private int applicationid;
	private Date date;
	private double loanAppliedAmount;
	private double loanApprovedAmount;
	private boolean landVerificationApproval;
	private boolean financeVerificationapproval;
	private boolean adminApproval;
	private String status;
	private int id;

	public LoanDetails() {
		super();
	}

	public LoanDetails(int applicationid, Date date, double loanAppliedAmount, double loanApprovedAmount,
			boolean landVerificationApproval, boolean financeVerificationapproval, boolean adminApproval, String status,
			int id) {
		super();
		this.applicationid = applicationid;
		this.date = date;
		this.loanAppliedAmount = loanAppliedAmount;
		this.loanApprovedAmount = loanApprovedAmount;
		this.landVerificationApproval = landVerificationApproval;
		this.financeVerificationapproval = financeVerificationapproval;
		this.adminApproval = adminApproval;
		this.status = status;
		this.id = id;
	}

	@Override
	public String toString() {
		return "LoanDetails [applicationid=" + applicationid + ", date=" + date + ", loanAppliedAmount="
				+ loanAppliedAmount + ", loanApprovedAmount=" + loanApprovedAmount + ", landVerificationApproval="
				+ landVerificationApproval + ", financeVerificationapproval=" + financeVerificationapproval
				+ ", adminApproval=" + adminApproval + ", status=" + status + ", id=" + id + "]";
	}

	public int getApplicationid() {
		return applicationid;
	}

	public void setApplicationid(int applicationid) {
		this.applicationid = applicationid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getLoanAppliedAmount() {
		return loanAppliedAmount;
	}

	public void setLoanAppliedAmount(double loanAppliedAmount) {
		this.loanAppliedAmount = loanAppliedAmount;
	}

	public double getLoanApprovedAmount() {
		return loanApprovedAmount;
	}

	public void setLoanApprovedAmount(double loanApprovedAmount) {
		this.loanApprovedAmount = loanApprovedAmount;
	}

	public boolean isLandVerificationApproval() {
		return landVerificationApproval;
	}

	public void setLandVerificationApproval(boolean landVerificationApproval) {
		this.landVerificationApproval = landVerificationApproval;
	}

	public boolean isFinanceVerificationapproval() {
		return financeVerificationapproval;
	}

	public void setFinanceVerificationapproval(boolean financeVerificationapproval) {
		this.financeVerificationapproval = financeVerificationapproval;
	}

	public boolean isAdminApproval() {
		return adminApproval;
	}

	public void setAdminApproval(boolean adminApproval) {
		this.adminApproval = adminApproval;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
