package com.cg.customer.dto;

import javax.validation.constraints.NotBlank;

public class CustomerDetailsRequest {
	private int custid;
	private double loanAppliedAmount;
	@NotBlank
	private String name;
	//@NotBlank 
	private long mobile;
	private String email;
	@NotBlank
	private String dob;
	@NotBlank
	private String gender;
	@NotBlank
	private String nationality;
	//@NotBlank
	private long aadhar;
	@NotBlank
	private String pan;
	
	
	public CustomerDetailsRequest() {
		super();
	}
	public CustomerDetailsRequest(String name, long mobile,String email, String dob, String gender, String nationality,long aadhar,String pan) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.nationality = nationality;
		this.aadhar = aadhar;
		this.pan = pan;
	}
	
	public double getLoanAppliedAmount() {
		return loanAppliedAmount;
	}
	public void setLoanamount(double loanAppliedAmount) {
		this.loanAppliedAmount = loanAppliedAmount;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public long getAadhar() {
		return aadhar;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	@Override
	public String toString() {
		return "CustomerDetailsRequest [name=" + name + ", mobile=" + mobile + ", email=" + email + ", dob=" + dob
				+ ", gender=" + gender + ", nationality=" + nationality + ", aadhar=" + aadhar + ", pan=" + pan + "]";
	}
	

}
