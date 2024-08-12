package com.flipkart.exception;

/**
 * Exception thrown when a course with a specified ID is not found.
 */
public class CourseNotFoundException extends Exception {

    private String courseId;

    /**
     * Constructs a new CourseNotFoundException with the specified course ID.
     * @param courseId The ID of the course that was not found.
     */
    public CourseNotFoundException(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Returns a detailed message about the exception.
     * @return A message indicating that the course with the specified ID was not found.
     */
    @Override
    public String getMessage() {
        return "Course with ID: " + courseId + " not found.";
    }
}