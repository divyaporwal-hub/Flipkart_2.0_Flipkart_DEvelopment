package com.flipkart.exception;

/**
 * Exception thrown when billing information for a student cannot be found.
 */
public class BillingNotFoundException extends Exception {
    private String studentID;

    /**
     * Constructs a new BillingNotFoundException with the specified student ID.
     * @param studentID The ID of the student whose billing information was not found.
     */
    public BillingNotFoundException(String studentID) {
        this.studentID = studentID;
    }

    /**
     * Returns a detailed message about the exception.
     * @return A message indicating that the billing ID for the specified student could not be found.
     */
    @Override
    public String getMessage() {
        return "Billing ID for student " + studentID + " not found.";
    }
}