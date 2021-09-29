package com.cg.customer.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "loan_application")
public class LoanApplication {

	@Id
	@GeneratedValue
	private int applicationid;
	@Column(name="Date")
	private Date date;
	@Column(name="loanAppliedAmount")
	private double loanAppliedAmount;
	@Column(name="loanApprovedAmount")
	@Value("0")
	private double loanApprovedAmount;
	@Column(name="landVerificationApproval")
	@Value("false")
	private boolean landVerificationApproval;
	@Column(name="financeVerificationApproval")
	@Value("false")
	private boolean financeVerificationApproval;
	@Column(name="adminApproval")
	@Value("false")
	private boolean adminApproval;
	@Column(name="LoanStatus")
	private String status;
	@Column(name="customerid")
	private int id;

	public LoanApplication() {
		super();
	}

	public LoanApplication(int applicationid, Date date, double loanAppliedAmount, double loanApprovedAmount,
			boolean landVerificationApproval, boolean financeVerificationApproval, boolean adminApproval,
			String status) {
		super();
		this.applicationid = applicationid;
		this.date = date;
		this.loanAppliedAmount = loanAppliedAmount;
		this.loanApprovedAmount = loanApprovedAmount;
		this.landVerificationApproval = landVerificationApproval;
		this.financeVerificationApproval = financeVerificationApproval;
		this.adminApproval = adminApproval;
		this.status = status;
	}

	public LoanApplication(int applicationid, Date date, double loanAppliedAmount, double loanApprovedAmount,
			boolean landVerificationApproval, boolean financeVerificationApproval, boolean adminApproval, String status,
			int id) {
		super();
		this.applicationid = applicationid;
		this.date = date;
		this.loanAppliedAmount = loanAppliedAmount;
		this.loanApprovedAmount = loanApprovedAmount;
		this.landVerificationApproval = landVerificationApproval;
		this.financeVerificationApproval = financeVerificationApproval;
		this.adminApproval = adminApproval;
		this.status = status;
		this.id = id;
	}

	public LoanApplication(Date date, double loanAppliedAmount, int id, String status) {
		super();
		this.date=date;
		this.loanAppliedAmount=loanAppliedAmount;
		this.id=id;
		this.status=status;
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

	@Override
	public String toString() {
		return "LoanApplication [applicationid=" + applicationid + ", date=" + date + ", loanAppliedAmount="
				+ loanAppliedAmount + ", loanApprovedAmount=" + loanApprovedAmount + ", landVerificationApproval="
				+ landVerificationApproval + ", financeVerificationApproval=" + financeVerificationApproval
				+ ", adminApproval=" + adminApproval + ", status=" + status + ", id=" + id + "]";
	}

	

}
