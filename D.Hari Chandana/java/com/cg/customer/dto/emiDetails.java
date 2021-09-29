package com.cg.customer.dto;

import java.sql.Date;

public class emiDetails {
	private int id;
	private double loanAmount;
	private String dueDate;
	private int tenure;
	private float interestRate;
	private double interestAmount;
	private double emiAmount;
	private int loanAgreementId;
	private Date loandate;
	private double totalEmiAmount;

	public emiDetails() {
		super();
	}

	public emiDetails(int id, double loanAmount, String dueDate, int tenure, float interestRate, double interestAmount,
			double emiAmount, int loanAgreementId) {
		super();
		this.id = id;
		this.loanAmount = loanAmount;
		this.dueDate = dueDate;
		this.tenure = tenure;
		this.interestRate = interestRate;
		this.interestAmount = interestAmount;
		this.emiAmount = emiAmount;
		this.loanAgreementId = loanAgreementId;
	}

	public emiDetails(double amount, float rate, int period, Date loandate) {
		super();
		this.loanAmount = amount;
		this.interestRate = rate;
		this.tenure = period;
		this.loandate = loandate;
	}

	public emiDetails(double emiAmount2, double interestAmount2, double totalEmiAmount, String dueDate2) {
		this.emiAmount = emiAmount;
		this.interestAmount = interestAmount;
		this.totalEmiAmount = totalEmiAmount;
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "emiDetails [dueDate=" + dueDate + ", interestAmount=" + interestAmount + ", emiAmount=" + emiAmount
				+ "totalAmount="+totalEmiAmount+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public double getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(double interestAmount) {
		this.interestAmount = interestAmount;
	}

	public double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public int getLoanAgreementId() {
		return loanAgreementId;
	}

	public void setLoanAgreementId(int loanAgreementId) {
		this.loanAgreementId = loanAgreementId;
	}

}
