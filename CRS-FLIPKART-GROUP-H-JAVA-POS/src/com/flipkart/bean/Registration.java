package com.flipkart.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The Registration class handles course registration information for students.
 * It tracks the registration status, student details, registration date, and enrolled courses.
 * 
 * @author GROUP-H
 */
public class Registration {

    private boolean status;
    private long studentID;
    private Date date;
    private List<CourseRegistered> courseRegistrations; // List of registered courses

    /**
     * Constructs a Registration object with the specified student ID and registration date.
     * 
     * @param studentID the ID of the student
     * @param date      the registration date
     */
    public Registration(long studentID, Date date) {
        this.studentID = studentID;
        this.date = date;
        this.courseRegistrations = new ArrayList<>();
    }

    /**
     * Gets the student ID.
     * 
     * @return the ID of the student
     */
    public long getStudentID() {
        return studentID;
    }

    /**
     * Sets the student ID.
     * 
     * @param studentID the ID of the student to set
     */
    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    /**
     * Gets the registration date.
     * 
     * @return the registration date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the registration date.
     * 
     * @param date the registration date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the list of course registrations.
     * 
     * @return the list of course registrations
     */
    public List<CourseRegistered> getCourseRegistrations() {
        return courseRegistrations;
    }

    /**
     * Sets the list of course registrations.
     * 
     * @param courseRegistrations the list of course registrations to set
     */
    public void setCourseRegistrations(List<CourseRegistered> courseRegistrations) {
        this.courseRegistrations = courseRegistrations;
    }

    /**
     * Registers a course for the student.
     * 
     * @param course the course to register
     * @return true if the registration was successful, false otherwise
     */
    public boolean registerCourse(Course course) {
        CourseRegistered newRegistration = new CourseRegistered(course.getCourseID(), (int)studentID);
        return courseRegistrations.add(newRegistration);
    }

    /**
     * Notifies the student to pay the outstanding fee.
     * 
     * @return a notification message
     */
    public String notifyForFee() {
        return "Fee notification: Please pay the outstanding fee.";
    }

    /**
     * Views the courses registered by the student.
     * 
     * @return a list of registered courses
     */
    public List<Course> viewRegisteredCourses() {
        List<Course> courses = new ArrayList<>();
        // Implementation should be added to populate the list of registered courses
        return courses;
    }

    /**
     * Gets a list of available courses based on the provided list of all courses.
     * 
     * @param allCourses the list of all available courses
     * @return a list of available courses
     */
    public List<Course> availableCourses(List<Course> allCourses) {
        List<Course> courses = new ArrayList<>();
        // Implementation should be added to filter available courses
        return courses;
    }

    /**
     * Gets the registration status.
     * 
     * @return true if registration is complete, false otherwise
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Sets the registration status.
     * 
     * @param status the registration status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
}