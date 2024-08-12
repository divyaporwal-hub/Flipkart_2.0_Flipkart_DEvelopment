package com.flipkart.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * The Admin class extends the User class and represents an admin in the system.
 * It manages a collection of professors, courses, and students.
 */

public class Admin extends User {

    private Map<String, Prof> professors; // Map of professor ID to Professor object
    private Map<String, Course> courses; // Map of course code to Course object
    private Map<String, Student> students; // Map of student ID to Student object
    
    /**
     * Parameterized constructor
     * @param ID: the admin ID
     * @param name: the admin's name
     * @param contact: the admin's contact information
     * @param email: the admin's email
     */
    public Admin(String ID, String name, String contact, String email, String password) {
        super(ID, name, "Admin", contact, email, password);
        this.professors = new HashMap<>();
        this.courses = new HashMap<>();
        this.students = new HashMap<>();
    }
    
    
    /**
     * Updates the admin's information.
     * (This method is intended to be overridden with specific update logic.)
     */
    //@Override
    
    public void update() {
        // Code to update admin information
    }
    
    /**
     * Changes the admin's password.
     * 
     * @param password the new password to set
     */
    //@Override
    public void changePassword(String password) {
        // Code to change admin password
    	super.setPassword(password);
    }
}
