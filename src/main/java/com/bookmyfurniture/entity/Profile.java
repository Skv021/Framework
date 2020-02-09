package com.bookmyfurniture.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Profile")
public class Profile {
	public Profile() {		
	}
	public Profile(String emailId, String mobileNo, String name, String password) {
		super();
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.name = name;
		this.password = password;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id",updatable = false, nullable = false)
	int user_id;
	@Column(nullable = true)
	String address_city;
	@Column(nullable = true)
	String address_land_mark;
	@Column(nullable = true)
	String address_lane1;
	@Column(nullable = true)
	String address_lane2;
	@Column(nullable = true)
	String address_state;
	@Column(nullable = true)
	String address_zip_code;
	@Column(name="email_id",nullable = false,unique=true)
	String emailId;
	@Column(nullable = true)
	String gender;	
	@Column(name="mobile_no",nullable = true,unique=true)
	String mobileNo;
	@Column(nullable = true)
	String name;
	@Column(nullable = false)
	String password;
	@Column(nullable = true)
	int user_status;
	
	@ManyToOne//(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
   // @JoinTable(name="Role", inverseJoinColumns=@JoinColumn(name="roleId"))
	@JoinColumn()
	private Role role;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAddress_city() {
		return address_city;
	}
	public void setAddress_city(String address_city) {
		this.address_city = address_city;
	}
	public String getAddress_land_mark() {
		return address_land_mark;
	}
	public void setAddress_land_mark(String address_land_mark) {
		this.address_land_mark = address_land_mark;
	}
	public String getAddress_lane1() {
		return address_lane1;
	}
	public void setAddress_lane1(String address_lane1) {
		this.address_lane1 = address_lane1;
	}
	public String getAddress_lane2() {
		return address_lane2;
	}
	public void setAddress_lane2(String address_lane2) {
		this.address_lane2 = address_lane2;
	}
	public String getAddress_state() {
		return address_state;
	}
	public void setAddress_state(String address_state) {
		this.address_state = address_state;
	}
	public String getAddress_zip_code() {
		return address_zip_code;
	}
	public void setAddress_zip_code(String address_zip_code) {
		this.address_zip_code = address_zip_code;
	}
	public String getEmail_id() {
		return emailId;
	}
	public void setEmail_id(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile_no() {
		return mobileNo;
	}
	public void setMobile_no(String mobileNo) {
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
	public int getUser_status() {
		return user_status;
	}
	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}
	
	
	public Profile(int user_id, String address_city, String address_land_mark, String address_lane1,
			String address_lane2, String address_state, String address_zip_code, String emailId, String gender,
			String mobileNo, String name, String password, int user_status, Role role_role_id) {
		super();
		this.user_id = user_id;
		this.address_city = address_city;
		this.address_land_mark = address_land_mark;
		this.address_lane1 = address_lane1;
		this.address_lane2 = address_lane2;
		this.address_state = address_state;
		this.address_zip_code = address_zip_code;
		this.emailId = emailId;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.name = name;
		this.password = password;
		this.user_status = user_status;
		this.role = role_role_id;
	}
	@Override
	public String toString() {
		return "UserProfile [user_id=" + user_id + ", address_city=" + address_city + ", address_land_mark="
				+ address_land_mark + ", address_lane1=" + address_lane1 + ", address_lane2=" + address_lane2
				+ ", address_state=" + address_state + ", address_zip_code=" + address_zip_code + ", emailId="
				+ emailId + ", gender=" + gender + ", mobileNo=" + mobileNo + ", name=" + name + ", password="
				+ password + ", user_status=" + user_status + ", role_role_id=" + role + "]";
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
    public boolean equals(Object obj)
    {
		Profile retrivedUserProfile=(Profile) obj;
		return (this.emailId.equals(retrivedUserProfile.getEmail_id())&& this.name.equals(retrivedUserProfile.getName())&&this.mobileNo.equals(retrivedUserProfile.getMobile_no()));
    }
}


