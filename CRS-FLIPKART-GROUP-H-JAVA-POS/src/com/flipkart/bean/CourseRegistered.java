package com.flipkart.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * The CourseRegistered class manages course registration details for students.
 * It tracks student registrations, grades, and provides methods to manage these details.
 * 
 * @author GROUP-H
 */
public class CourseRegistered {

    private String courseID;
    private int studentID;
    private Map<Integer, String> studentGrades; // Map to store grades for students

    /**
     * Constructs a CourseRegistered object with the specified course ID and student ID.
     * 
     * @param courseID  the ID of the course
     * @param studentID the ID of the student
     */
    public CourseRegistered(String courseID, int studentID) {
        this.courseID = courseID;
        this.studentID = studentID;
        this.studentGrades = new HashMap<>();
    }

    /**
     * Gets the course ID.
     * 
     * @return the ID of the course
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * Sets the course ID.
     * 
     * @param courseID the ID of the course to set
     */
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    /**
     * Gets the student ID.
     * 
     * @return the ID of the student
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * Sets the student ID.
     * 
     * @param studentID the ID of the student to set
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * Gets the map of student grades for the course.
     * 
     * @return a map where keys are student IDs and values are their grades
     */
    public Map<Integer, String> getStudentGrades() {
        return studentGrades;
    }

    /**
     * Sets the map of student grades for the course.
     * 
     * @param studentGrades the map of student IDs to their grades
     */
    public void setStudentGrades(Map<Integer, String> studentGrades) {
        this.studentGrades = studentGrades;
    }

    /**
     * Views the grade of the student for the course.
     * 
     * @return the grade of the student, or "Grade not assigned" if no grade is assigned
     */
    public String viewGrade() {
        return studentGrades.getOrDefault(studentID, "Grade not assigned");
    }

    /**
     * Drops the course for the student.
     * 
     * @return true if the course was dropped successfully, 
     *         false if the student was not registered in the course
     */
    public boolean drop() {
        if (studentGrades.containsKey(studentID)) {
            studentGrades.remove(studentID);
            return true; // Successfully dropped
        }
        return false; // Student was not registered in the course
    }

    /**
     * Views all students registered in the course.
     * 
     * @return a map of student IDs to their grades
     */
    public Map<Integer, String> viewStudents() {
        return studentGrades;
    }

    /**
     * Adds a student to the course with a specified grade.
     * 
     * @param studentID the ID of the student
     * @param grade     the grade of the student
     */
    public void addStudent(int studentID, String grade) {
        studentGrades.put(studentID, grade);
    }
}