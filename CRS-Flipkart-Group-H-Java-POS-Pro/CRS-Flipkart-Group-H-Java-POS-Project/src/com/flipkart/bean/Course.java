package com.flipkart.bean;

public class Course {

	private String courseCode;
	private String courseName;
	private String staffId;
	private int capacity = 50;
	

	public Course() {
		
	}
	

	public Course(String courseCode, String courseName, String staffId, int capacity)
	{
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.setStaffId(staffId);
		this.capacity = capacity;
	}
	

	public String getCourseCode() {
		return courseCode;
	}
	

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	

	public String getCourseName() {
		return courseName;
	}
	

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	

	public String getStaffId() {
		return staffId;
	}
	

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
}
