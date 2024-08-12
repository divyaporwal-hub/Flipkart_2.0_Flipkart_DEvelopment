package com.flipkart.exception;

/**
 * Exception thrown when attempting to add a course that already exists.
 */
public class CourseAlreadyExistsException extends Exception {

    private String courseId;

    /**
     * Constructs a new CourseAlreadyExistsException with the specified course ID.
     * @param courseId The ID of the course that already exists.
     */
    public CourseAlreadyExistsException(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Returns a detailed message about the exception.
     * @return A message indicating that a course with the specified ID already exists.
     */
    @Override
    public String getMessage() {
        return "Course with ID: " + courseId + " already exists.";
    }
}	