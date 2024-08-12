package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.ProfDaoInterface;
import com.flipkart.dao.ProfDaoServices;
import com.flipkart.exception.CourseNotAvailableException;
import com.flipkart.exception.CourseNotOfferedException;
import com.flipkart.exception.CourseNotOptedException;
import com.flipkart.exception.GradeAlreadyAddedException;

import java.util.Set;

/**
 * Implements the `ProfInterface` to provide operations for professors related to course offerings, student management, and grading.
 */
public class ProfOperations implements ProfInterface {

    private ProfDaoInterface pdi = new ProfDaoServices();

    /**
     * Allows a professor to offer a course.
     * @param courseID The ID of the course being offered.
     * @param prof The `Prof` object representing the professor offering the course.
     * @return A `String` message indicating the result of the operation (e.g., success or failure).
     */
    public String offerCourse(String courseID, Prof prof) {
        try {
            if (pdi.offerCourse(courseID, prof)) {
                return "Course enrolled successfully";
            }
        } catch (CourseNotAvailableException e) {
            e.printStackTrace();
        }
        return "Enrollment failed...";
    }

    /**
     * Retrieves a list of students registered for a specific course.
     * @param courseID The ID of the course whose students are to be retrieved.
     * @param prof The `Prof` object representing the professor requesting the student list.
     * @return A `String` representation of the list of students registered for the course.
     */
    public String getStudents(String courseID, Prof prof) {
        Set<Student> studentList = pdi.getStudents(courseID, prof);
        StringBuilder students = new StringBuilder();
        studentList.forEach(student ->
            students.append(student.getID()).append("\t")
                    .append(student.getName()).append("\t\t")
                    .append(student.getRollNum()).append("\n")
        );
        return students.toString().trim();
    }

    /**
     * Submits a grade for a student in a specific course.
     * @param courseID The ID of the course for which the grade is being submitted.
     * @param studentID The ID of the student receiving the grade.
     * @param grade The grade being assigned to the student.
     * @param prof The `Prof` object representing the professor submitting the grade.
     * @return A `String` message indicating the result of the operation (e.g., success or failure).
     */
    public String giveGrade(String courseID, String studentID, String grade, Prof prof) {
        try {
            if (pdi.giveGrade(courseID, studentID, grade, prof)) {
                return "Grade submitted successfully";
            }
        } catch (CourseNotOptedException | GradeAlreadyAddedException | CourseNotOfferedException e) {
            e.printStackTrace();
        }
        return "Grade submission failed...";
    }

    /**
     * Retrieves a list of all available courses.
     * @return A `String` representation of the list of available courses.
     */
    @Override
    public String viewCourses() {
        Set<Course> courses = pdi.viewCourses();
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
     * Retrieves a list of courses currently being offered by a specific professor.
     * @param prof The `Prof` object representing the professor whose course offerings are to be retrieved.
     * @return A `String` representation of the list of courses being offered by the professor.
     */
    @Override
    public String viewCourseOffering(Prof prof) {
        Set<Course> courses = pdi.viewCourseOffering(prof);
        StringBuilder catalog = new StringBuilder();
        courses.forEach(course ->
            catalog.append(course.getCourseID()).append("\t")
                   .append(course.getCourseName()).append("\n")
        );
        return catalog.toString().trim();
    }
}