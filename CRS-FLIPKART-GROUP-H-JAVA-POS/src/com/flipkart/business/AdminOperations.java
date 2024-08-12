package com.flipkart.business;

import java.util.Set;

import com.flipkart.bean.*;
import com.flipkart.dao.AdminDaoServices;
import com.flipkart.exception.CourseAlreadyExistsException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.UserAlreadyExistsException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.dao.AdminDaoInterface;

/**
 * 
 * @author GROUP-H
 * Class to handle administrative operations related to professors, courses, and students.
 * Implements the AdminInterface.
 * 
 */
public class AdminOperations implements AdminInterface {
    
    private AdminDaoInterface adi = new AdminDaoServices();

    /**
     * Method to add a professor.
     * @param prof: the professor to add
     * @param username: the username for the professor
     * @return a success message with the professor ID if added, or "Operation Failed..." if not
     */
    public String addProf(Prof prof, String username) {
        String userID;
        try {
            userID = adi.addProf(prof, username);
            if (!userID.isEmpty()) return "Professor Added with id: " + userID;
        } catch (UserAlreadyExistsException e) {
            e.printStackTrace();
        }
        return "Operation Failed...";
    }

    /**
     * Method to remove a professor.
     * @param profID: the ID of the professor to remove
     * @return a success message if the professor was removed, or "Operation Failed..." if not
     */
    public String removeProf(String profID) {
        try {
            if (adi.removeProf(profID)) return "Professor removed successfully";
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return "Operation Failed...";
    }

    /**
     * Method to update a course.
     * @param courseID: the code of the course to update
     * @param updatedCourse: the updated course details
     * @return a success message if the course was updated, or "Operation Failed..." if not
     */
    public String updateCourse(String courseID, Course updatedCourse) {
        try {
            if (adi.updateCourse(courseID, updatedCourse)) return "Course information updated successfully";
        } catch (CourseAlreadyExistsException | CourseNotFoundException e) {
            e.printStackTrace();
        }
        return "Operation Failed...";
    }

    /**
     * Method to add a course.
     * @param course: the course to add
     * @return a success message if the course was added, or "Operation Failed..." if not
     */
    public String addCourse(Course course) {
        try {
            if (adi.addCourse(course)) return "Course added Successfully";
        } catch (CourseAlreadyExistsException e) {
            e.printStackTrace();
        }
        return "Operation Failed...";
    }

    /**
     * Method to remove a course.
     * @param courseID: the code of the course to remove
     * @return a success message if the course was removed, or "Operation Failed..." if not
     */
    public String removeCourse(String courseID) {
        try {
            if (adi.removeCourse(courseID)) return "Course removed Successfully";
        } catch (CourseNotFoundException e) {
            e.printStackTrace();
        }
        return "Operation Failed...";
    }

    /**
     * Method to register a student.
     * @param studentID: the ID of the student to register
     * @return a success message if the student was approved, or "Operation Failed..." if not
     */
    public String registerStudent(String studentID) {
        try {
            if (adi.registerStudent(studentID)) return "Student approved";
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return "Operation Failed...";
    }

    /**
     * Method to view all courses.
     * @return a string representation of all courses with their details
     */
    @Override
    public String viewCourses() {
        Set<Course> courses = adi.viewCourses();
        StringBuilder catalog = new StringBuilder();
        courses.forEach(course -> {
            String prof = course.getCourseProf();
            if (prof == null) prof = "Prof Awaited";
            catalog.append(course.getCourseID()).append("\t")
                   .append(course.getCourseName()).append("\t\t")
                   .append(prof).append("\t\t")
                   .append(course.getSeats()).append("\n");
        });
        return catalog.toString().trim();
    }

    /**
     * Method to view all professors.
     * @return a string representation of all professors with their details
     */
    @Override
    public String viewProfessors() {
        Set<Prof> profs = adi.viewProfessors();
        StringBuilder catalog = new StringBuilder();
        profs.forEach(prof ->
            catalog.append(prof.getName()).append("\t\t")
                   .append(prof.getID()).append("\t\t")
                   .append(prof.getDept()).append("\n")
        );
        return catalog.toString().trim();
    }

    /**
     * Method to view all unapproved students.
     * @return a string representation of all unapproved students with their details
     */
    @Override
    public String viewUnapprovedStudents() {
        Set<Student> studentList = adi.viewUnapprovedStudents();
        StringBuilder students = new StringBuilder();
        studentList.forEach(student ->
            students.append(student.getID()).append("\t\t")
                    .append(student.getName()).append("\t\t")
                    .append(student.getRollNum()).append("\n")
        );
        return students.toString().trim();
    }
}