package com.flipkart.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The Prof class represents a professor with details such as department, qualification, and courses taught.
 * It extends the User class to inherit user-related properties and methods.
 * 
 * @author GROUP-H
 */
public class Prof extends User {

    private String dept;
    private String qualification;
    private List<String> courses; // List of course IDs the professor is teaching

    /**
     * Constructs a Prof object with the specified ID, name, contact information, email, department, 
     * qualification, and password.
     * 
     * @param ID            the professor's ID
     * @param name          the professor's name
     * @param contact       the professor's contact information
     * @param email         the professor's email
     * @param dept          the department of the professor
     * @param qualification the qualification of the professor
     * @param password      the password for the professor's account
     */
    public Prof(String ID, String name, String contact, String email, String dept, String qualification, String password) {
        super(ID, name, "Professor", contact, email, password);
        this.dept = dept;
        this.qualification = qualification;
        this.courses = new ArrayList<>();
    }

    /**
     * Gets the department of the professor.
     * 
     * @return the department of the professor
     */
    public String getDept() {
        return dept;
    }

    /**
     * Sets the department of the professor.
     * 
     * @param dept the department to set
     */
    public void setDept(String dept) {
        this.dept = dept;
    }

    /**
     * Gets the qualification of the professor.
     * 
     * @return the qualification of the professor
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * Sets the qualification of the professor.
     * 
     * @param qualification the qualification to set
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    
    /**
     * Gets the list of course IDs that the professor is teaching.
     * 
     * @return a list of course IDs
     */
    public List<String> getCourses() {
        return new ArrayList<>(courses); // Return a copy to avoid external modification
    }

    /**
     * Updates the professor's information.
     * This method should be implemented to handle updates to professor details.
     */
//    @Override
    public void update() {
        // Code to update professor information
    }

    /**
     * Changes the professor's password.
     * 
     * @param password the new password to set
     */
//    @Override
    public void changePassword(String password) {
        super.setPassword(password);
    }

    /**
     * Adds a course to the list of courses the professor is teaching.
     * 
     * @param courseID the ID of the course to add
     */
    public void addCourse(String courseID) {
        if (courseID == null || courseID.isEmpty()) {
            throw new IllegalArgumentException("Course ID cannot be null or empty.");
        }
        this.courses.add(courseID);
    }
}
