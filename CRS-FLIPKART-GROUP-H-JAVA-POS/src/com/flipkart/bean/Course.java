package com.flipkart.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * The Course class represents a course with details such as ID, name, professor, available seats, 
 * semester, and enrolled students. It provides methods to manage course information and student enrollment.
 */

public class Course {

	private String courseID;
	private String courseName;
	String courseProf; // Professor user ID
	private int seats;
	String semesterID;
	private Set<String> enrolledStudents; // To keep track of enrolled students
	float price;
	/**
     * Default constructor initializes an empty set of enrolled students.
     */
	public Course() {
		this.enrolledStudents = new HashSet<>();
	}
	
	/**
     * Constructs a Course object with the specified ID, name, professor ID, and available seats.
     * 
     * @param courseID    the ID of the course
     * @param courseName  the name of the course
     * @param courseProf  the professor's user ID
     * @param seats       the number of available seats
     */
	public Course(String courseID, String courseName, String courseProf, int seats) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseProf = courseProf;
		this.seats = seats;
		this.enrolledStudents = new HashSet<>();
		this.semesterID=null;
		this.price=0;
	}
	
	/**
     * Constructs a Course object with the specified ID, name, professor ID, available seats, and price.
     * 
     * @param courseID    the ID of the course
     * @param courseName  the name of the course
     * @param courseProf  the professor's user ID
     * @param seats       the number of available seats
     * @param price       the price of the course
     */
	
	public Course(String courseID, String courseName, String courseProf, int seats, float price) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseProf = courseProf;
		this.seats = seats;
		this.enrolledStudents = new HashSet<>();
		this.semesterID=null;
		this.price=price;
	}
	
	/**
     * Gets the course ID.
     * 
     * @return the course ID
     */
	public String getCourseID() {
		return courseID;
	}
	
	/**
     * Sets the course ID.
     * 
     * @param courseID the course ID to set
     */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	
	/**
     * Gets the course name.
     * 
     * @return the course name
     */
	public String getCourseName() {
		return courseName;
	}
	
	/**
     * Sets the course name.
     * 
     * @param courseName the course name to set
     */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
     * Gets the number of available seats.
     * 
     * @return the number of available seats
     */
	public int getSeats() {
		return seats;
	}
	
	/**
     * Sets the number of available seats.
     * 
     * @param seats the number of available seats to set
     * 
     * @throws IllegalArgumentException if the number of seats is negative
     */
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	/**
     * Gets the professor's user ID.
     * 
     * @return the professor's user ID
     */
	public String getCourseProf() {
		return courseProf;
	}
	
	/**
     * Sets the professor's user ID.
     * 
     * @param courseProf the professor's user ID to set
     */
	public void setCourseProf(String courseProf) {
		this.courseProf = courseProf;
	}
	
	/**
     * Checks if the course is full.
     * 
     * @return true if the course is full, false otherwise
     */
	
	public boolean isCourseFull() {
		return enrolledStudents.size() >= seats;
	}
	
	/**
     * Gets the semester ID.
     * 
     * @return the semester ID
     */
	
	public String getSemesterID() {
		return this.semesterID;
	}
	
	/**
     * Sets the semester ID.
     * 
     * @param semesterID the semester ID to set
     */
	
	public void setSemesterID(String semesterID) {
		this.semesterID=semesterID;
	}
	
	/**
     * Adds a student to the course.
     * 
     * @param studentID the ID of the student to add
     * 
     * @return true if the student was added successfully, 
     *         false if the course is full
     */
	public boolean addStudent(String studentID) {
		if (!isCourseFull()) {
			return enrolledStudents.add(studentID);
		}
		return false; // Course is full
	}
	
	/**
     * Sets the price of the course.
     * 
     * @param price the price to set
     */
	
	public void setPrice(float price) {
		this.price=price;
	}
	
	/**
     * Gets the price of the course.
     * 
     * @return the price of the course
     */
	
	public float getPrice() {
		return this.price;
	}
	
	/**
     * Gets the set of students enrolled in the course.
     * 
     * @return a set of student IDs enrolled in the course
     */
	
	public Set<String> getStudents(){
		return enrolledStudents;
	}
}
