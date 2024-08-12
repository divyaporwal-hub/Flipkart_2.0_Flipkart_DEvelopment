package com.flipkart.exception;

/**
 * Exception thrown when a professor with a specified ID is not found.
 */
public class ProfessorNotFoundException extends Exception {

    private String professorId;

    /**
     * Constructs a new ProfessorNotFoundException with the specified professor ID.
     * @param professorId The ID of the professor that was not found.
     */
    public ProfessorNotFoundException(String professorId) {
        this.professorId = professorId;
    }

    /**
     * Returns a detailed message about the exception.
     * @return A message indicating that the professor with the specified ID was not found.
     */
    @Override
    public String getMessage() {
        return "Professor with ID: " + professorId + " not found.";
    }
}