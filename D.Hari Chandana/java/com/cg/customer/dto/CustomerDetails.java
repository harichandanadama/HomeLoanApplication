package com.cg.customer.dto;

public class CustomerDetails {
private int id;
private String name;
private long mobile;
private String email;
private String dob;
private String gender;
private String nationality;
private long aadhar;
private String pan;


public CustomerDetails() {
	super();
}
public CustomerDetails(int id, String name, long mobile, String email, String dob, String gender, String nationality,
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
@Override
public String toString() {
	return "CustomerDetails [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", dob=" + dob
			+ ", gender=" + gender + ", nationality=" + nationality + ", aadhar=" + aadhar + ", pan=" + pan + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
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

}
