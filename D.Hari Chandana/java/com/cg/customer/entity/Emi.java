package com.cg.customer.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="EMI")
public class Emi implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="loanamount")
	private double loanAmount;
	@Column(name="dueDate")
	private String dueDate;
	@Column(name="tenure")
	private int tenure;
	@Column(name="rate")
	private float interestRate;
	@Column(name="interestAmount")
	private double interestAmount;
	@Column(name="emiAmount")
	private double emiAmount;
	@Column(name="loanid")
	private int loanid;
	@Column(name="loandate")
	private Date loandate;
	@Column(name="totalEmiAmnt")
	private double totalEmiAmount;
    

	public Emi() {
		super();
	}
	
	public Emi(double loanAmount, String dueDate, int tenure, float interestRate, double interestAmount,
			double emiAmount, int loanid, double totalEmiAmount,Date loandate) {
		super();
		//this.id = id;
		this.loanAmount = loanAmount;
		this.dueDate = dueDate;
		this.tenure = tenure;
		this.interestRate = interestRate;
		this.interestAmount = interestAmount;
		this.emiAmount = emiAmount;
		this.loanid = loanid;
		this.totalEmiAmount = totalEmiAmount;
		this.loandate=loandate;
	}

	public Emi(double amount, float rate, int period, int id2) {
		this.loanAmount=amount;
		this.interestRate=rate;
		this.tenure=period;
		this.loanid=id2;

	}

	public Emi(double amount, float rate, int period, Date date) {
		this.loanAmount=amount;
		this.interestRate=rate;
		this.tenure=period;
		this.loandate=date;

	}

	public Emi(double loanAmount2, float rateOfInterest, int timePeriod, double interest, double emiAmount2,
			double totalEmiAmount2, double totalAmount) {
	this.loanAmount=loanAmount2;
	this.interestRate=rateOfInterest;
	
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

	public int getLoanid() {
		return loanid;
	}

	public void setLoanid(int loanid) {
		this.loanid = loanid;
	}

	public double getTotalEmiAmount() {
		return totalEmiAmount;
	}

	public void setTotalEmiAmount(double totalEmiAmount) {
		this.totalEmiAmount = totalEmiAmount;
	}

	
	
	public Date getLoandate() {
		return loandate;
	}

	public void setLoandate(Date loandate) {
		this.loandate = loandate;
	}

	@Override
	public String toString() {
		return "Emi [loanAmount=" + loanAmount + ", dueDate=" + dueDate + ", tenure=" + tenure
				+ ", interestRate=" + interestRate + ", interestAmount=" + interestAmount + ", emiAmount=" + emiAmount
				+ ", loanid=" + loanid + ", loandate=" + loandate + ", totalEmiAmount=" + totalEmiAmount + "]";
	}

	
}
	