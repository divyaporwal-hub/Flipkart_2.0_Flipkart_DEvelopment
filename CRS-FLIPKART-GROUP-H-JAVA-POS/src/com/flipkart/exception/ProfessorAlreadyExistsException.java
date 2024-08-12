package com.flipkart.exception;

/**
 * Exception thrown when attempting to add a professor who already exists.
 */
public class ProfessorAlreadyExistsException extends Exception {

    private String professorId;

    /**
     * Constructs a new ProfessorAlreadyExistsException with the specified professor ID.
     * @param professorId The ID of the professor that already exists.
     */
    public ProfessorAlreadyExistsException(String professorId) {
        this.professorId = professorId;
    }

    /**
     * Returns a detailed message about the exception.
     * @return A message indicating that the professor with the specified ID already exists.
     */
    @Override
    public String getMessage() {
        return "Professor with ID: " + professorId + " already exists.";
    }
}