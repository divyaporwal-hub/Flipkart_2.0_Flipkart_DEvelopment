package com.flipkart.bean;

import com.flipkart.utils.Gender;
import com.flipkart.utils.UserTypes;

public class Student extends User {
	private int studentId;
	private String branchName;
	private int batch;
	private boolean isApproved;

	public Student(String userId, String name, UserTypes userTypes, String password, Gender gender, String address,
				   String country, String branchName, int studentId, int batch, boolean isApproved) {
		super(userId, name, userTypes, password,gender,address,country);
		this.branchName = branchName;
		this.studentId = studentId;
		this.batch = batch;
		this.isApproved = isApproved;
	}

	public Student() {
		
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getBatch() {
		return batch;
	}

	public void setBatch(int batch) {
		this.batch = batch;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	
}
