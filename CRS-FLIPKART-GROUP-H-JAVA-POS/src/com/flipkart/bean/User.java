package com.flipkart.bean;

/**
 * Abstract class representing a user with basic attributes and methods.
 * This class serves as a base class for different types of users in the system.
 * 
 * @author GROUP-H
 */
public abstract class User {
    // Attributes
    private String ID; // Unique identifier for the user
    private String name; // Name of the user
    private String role; // Role of the user (e.g., Student, Professor, Admin)
    private String contact; // Contact information of the user
    private String email; // Email address of the user
    private String password; // Password for user authentication

    /**
     * Parameterized constructor to initialize a user with specific details.
     * 
     * @param ID: the unique identifier for the user
     * @param name: the name of the user
     * @param role: the role of the user (e.g., Student, Professor, Admin)
     * @param contact: the contact information of the user
     * @param email: the email address of the user
     * @param password: the password for user authentication
     */
    public User(String ID, String name, String role, String contact, String email, String password) {
        this.ID = ID;
        this.name = name;
        this.role = role;
        this.contact = contact;
        this.email = email;
        this.password = password;
    }

    // Getter and Setter methods

    /**
     * Gets the unique identifier for the user.
     * 
     * @return the user ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Sets the unique identifier for the user.
     * 
     * @param ID: the new user ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Gets the name of the user.
     * 
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     * 
     * @param name: the new name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the role of the user.
     * 
     * @return the user's role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     * 
     * @param role: the new role of the user
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets the contact information of the user.
     * 
     * @return the user's contact information
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets the contact information of the user.
     * 
     * @param contact: the new contact information of the user
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Gets the email address of the user.
     * 
     * @return the user's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     * 
     * @param email: the new email address of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Abstract method to update user information.
     * The implementation of this method should be provided by subclasses.
     */
    public abstract void update();

    /**
     * Abstract method to change the user's password.
     * 
     * @param password: the new password for the user
     */
    public abstract void changePassword(String password);

    /**
     * Gets the password of the user.
     * 
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * 
     * @param password: the new password for the user
     */
    public void setPassword(String password) {
        this.password = password;
    }
}