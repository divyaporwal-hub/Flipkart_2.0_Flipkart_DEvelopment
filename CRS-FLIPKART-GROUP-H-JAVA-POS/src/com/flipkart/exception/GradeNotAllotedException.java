package com.flipkart.exception;

/**
 * Exception thrown when a grade has not been allotted for a student.
 */
public class GradeNotAllotedException extends Exception {

    private String studentId;

    /**
     * Constructs a new GradeNotAllotedException with the specified student ID.
     * @param studentId The ID of the student for whom the grade has not been allotted.
     */
    public GradeNotAllotedException(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Returns a detailed message about the exception.
     * @return A message indicating that the grade has not been allotted for the student with the specified ID.
     */
    @Override
    public String getMessage() {
        return "Grade not allotted for student with ID: " + studentId;
    }
}