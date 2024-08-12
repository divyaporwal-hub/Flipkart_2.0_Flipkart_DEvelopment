package com.flipkart.exception;

/**
 * Exception thrown when a report card for a specified student is not generated.
 */
public class ReportCardNotGeneratedException extends Exception {

    private String studentId;

    /**
     * Constructs a new ReportCardNotGeneratedException with the specified student ID.
     * @param studentId The ID of the student for whom the report card was not generated.
     */
    public ReportCardNotGeneratedException(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Returns a detailed message about the exception.
     * @return A message indicating that the report card for the specified student was not generated.
     */
    @Override
    public String getMessage() {
        return "Report card not generated for student with ID: " + studentId;
    }
}