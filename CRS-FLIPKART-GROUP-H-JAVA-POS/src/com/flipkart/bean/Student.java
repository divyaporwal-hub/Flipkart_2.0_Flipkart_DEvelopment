package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * The Student class stores information about a student and inherits from the User class.
 * It tracks details such as the student's branch, roll number, registered courses, and approval status.
 * 
 * @author GROUP-H
 */
public class Student extends User {

    private String branch;
    private int rollNum;
    private List<String> registeredCourses; // List of courses registered by the student
    private boolean approved; // Approval status of the student

    /**
     * Constructs a Student object with the specified details.
     * 
     * @param ID         the student ID
     * @param name       the student's name
     * @param contact    the student's contact information
     * @param email      the student's email
     * @param branch     the branch of the student
     * @param rollNum    the roll number of the student
     * @param approved   the approval status of the student
     * @param password   the password for the student
     */
    public Student(String ID, String name, String contact, String email, String branch, int rollNum, boolean approved, String password) {
        super(ID, name, "Student", contact, email, password);
        this.branch = branch;
        this.rollNum = rollNum;
        this.registeredCourses = new ArrayList<>();
        this.approved = approved;
    }

    /**
     * Gets the branch of the student.
     * 
     * @return the branch of the student
     */
    public String getBranch() {
        return branch;
    }

    /**
     * Sets the branch of the student.
     * 
     * @param branch the branch to set
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * Gets the roll number of the student.
     * 
     * @return the roll number of the student
     */
    public int getRollNum() {
        return rollNum;
    }

    /**
     * Sets the roll number of the student.
     * 
     * @param rollNum the roll number to set
     */
    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }

    /**
     * Updates the student information.
     * This method should be implemented to update the student's details.
     */
    //@Override
    public void update() {
        // Code to update student information
    }

    /**
     * Changes the student's password.
     * 
     * @param password the new password
     */
    //@Override
    public void changePassword(String password) {
        super.setPassword(password);
    }

    /**
     * Gets the list of courses registered by the student.
     * 
     * @return the list of registered courses
     */
    public List<String> courseList() {
        return registeredCourses;
    }

    /**
     * Adds a course to the list of registered courses.
     * 
     * @param courseID the ID of the course to add
     */
    public void addCourse(String courseID) {
        registeredCourses.add(courseID);
    }

    /**
     * Gets the approval status of the student.
     * 
     * @return true if the student is approved, false otherwise
     */
    public boolean isApproved() {
        return approved;
    }

    /**
     * Sets the approval status of the student.
     * 
     * @param status the approval status to set
     */
    public void setApproved(boolean status) {
        this.approved = status;
    }
}