package com.flipkart.bean;

import com.flipkart.utils.Gender;
import com.flipkart.utils.UserTypes;

public abstract class User {
	private String userId;
	private String name;
	private UserTypes userTypes;
	private String password;
	private Gender gender;
	private String address;
	private String country;

	public User(String userId, String name, UserTypes userTypes, String password, Gender gender, String address,
				String country) {
		super();
		this.userId = userId;
		this.name = name;
		this.userTypes = userTypes;
		this.password = password;
		this.gender = gender;
		this.address = address;
		this.country = country;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}
	

	public void setCountry(String country) {
		this.country = country;
	}

	public User(){
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserTypes getRole() {
		return userTypes;
	}

	public void setRole(UserTypes userTypes) {
		this.userTypes = userTypes;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
