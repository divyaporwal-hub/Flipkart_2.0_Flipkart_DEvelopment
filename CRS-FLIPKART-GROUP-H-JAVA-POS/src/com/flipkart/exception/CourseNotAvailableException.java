package com.flipkart.exception;

/**
 * Exception thrown when a requested course is not available.
 */
public class CourseNotAvailableException extends Exception {

    private String courseId;

    /**
     * Constructs a new CourseNotAvailableException with the specified course ID.
     * @param courseId The ID of the course that is not available.
     */
    public CourseNotAvailableException(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Returns a detailed message about the exception.
     * @return A message indicating that the course with the specified ID is not available.
     */
    @Override
    public String getMessage() {
        return "Course with ID: " + courseId + " is not available.";
    }
}