package com.flipkart.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * The ReportCard class manages and displays a student's report card.
 * It tracks the student's ID and their grades for various courses.
 * 
 * @author GROUP-H
 */
public class ReportCard {

    private String studentID; // ID of the student
    private Map<String, String> grades; // Map to store course IDs and corresponding grades

    /**
     * Constructs a ReportCard object for the specified student ID.
     * 
     * @param studentID the ID of the student
     */
    public ReportCard(String studentID) {
        this.studentID = studentID;
        this.grades = new HashMap<>();
    }

    /**
     * Gets the student ID.
     * 
     * @return the ID of the student
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Sets the student ID.
     * 
     * @param studentID the ID of the student to set
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * Gets the grades map, which contains course IDs and their corresponding grades.
     * 
     * @return a map of course IDs to grades
     */
    public Map<String, String> getGrades() {
        return grades;
    }

    /**
     * Sets the grades map.
     * 
     * @param grades a map of course IDs to grades to set
     */
    public void setGrades(Map<String, String> grades) {
        this.grades = grades;
    }

    /**
     * Adds or updates the grade for a specified course.
     * 
     * @param courseID the ID of the course
     * @param grade    the grade for the course
     */
    public void addOrUpdateGrade(String courseID, String grade) {
        grades.put(courseID, grade);
    }

    /**
     * Displays the student's report card, which includes all grades.
     * 
     * @return a map of course IDs to their corresponding grades
     */
    public Map<String, String> showReport() {
        return grades; // Return the map of grades
    }
}