package com.cg.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="mobilenum")
	private long mobile;
	@Column(name="emailid")
	private String email;
	@Column(name="Dob")
	private String dob;
	@Column(name="gender")
	private String gender;
	@Column(name="nationality")
	private String nationality;
	@Column(name="aadhar")
	private long aadhar;
	@Column(name="pan")
	private String pan;
	
	
	public Customer() {
super();
	}
	
	public Customer(Integer id, String name, long mobile, String email, String dob, String gender, String nationality,
			long aadhar, String pan) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.nationality = nationality;
		this.aadhar = aadhar;
		this.pan = pan;
	}

	public Customer(String name, long mobile, String email, String dob, String gender, String nationality,
			long aadhar, String pan) {
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


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "Customer [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", dob=" + dob
				+ ", gender=" + gender + ", nationality=" + nationality + ", aadhar=" + aadhar + ", pan=" + pan
				+ "]";
	}
	

}
