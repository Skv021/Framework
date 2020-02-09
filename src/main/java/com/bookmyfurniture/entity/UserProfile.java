package com.bookmyfurniture.entity;

public class UserProfile {

	String emailId;
	String mobileNo;
	String name;
	String password;
	

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserProfile(String emailId, String mobileNo, String name, String password) {
		super();
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.name = name;
		this.password = password;
	}

}

