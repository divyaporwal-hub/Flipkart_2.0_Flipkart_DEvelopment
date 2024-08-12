package com.flipkart.exception;

/**
 * Exception thrown when a student has not been approved.
 */
public class StudentNotApprovedException extends Exception {
    private String studentId;

    /**
     * Constructs a new StudentNotApprovedException with the specified student ID.
     * @param id The ID of the student who has not been approved.
     */
    public StudentNotApprovedException(String id) {
        this.studentId = id;
    }

    /**
     * Retrieves the student ID associated with this exception.
     * @return The ID of the student who has not been approved.
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Returns a detailed message about the exception.
     * @return A message indicating that the student with the specified ID has not been approved.
     */
    @Override
    public String getMessage() {
        return "StudentId: " + studentId + " has not been approved!";
    }
}