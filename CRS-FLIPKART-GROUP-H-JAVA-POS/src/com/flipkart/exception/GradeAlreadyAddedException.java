package com.flipkart.exception;

/**
 * Exception thrown when an attempt is made to add a grade for a student who already has a grade for the specified course.
 */
public class GradeAlreadyAddedException extends Exception {

    private String studentId;
    private String courseId;

    /**
     * Constructs a new GradeAlreadyAddedException with the specified student ID and course ID.
     * @param studentId The ID of the student for whom the grade has already been added.
     * @param courseId The ID of the course for which the grade has already been added.
     */
    public GradeAlreadyAddedException(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    /**
     * Returns a detailed message about the exception.
     * @return A message indicating that the grade has already been added for the student in the specified course.
     */
    @Override
    public String getMessage() {
        return "Grade already added for student with ID: " + studentId + " in course with ID: " + courseId;
    }
}