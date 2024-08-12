package com.flipkart.exception;

/**
 * Exception thrown when a course with a specified ID is not offered by a professor with a specified ID.
 */
public class CourseNotOfferedException extends Exception {

    private String profID;
    private String courseId;

    /**
     * Constructs a new CourseNotOfferedException with the specified professor ID and course ID.
     * @param profID The ID of the professor who is not offering the course.
     * @param courseId The ID of the course that is not offered by the professor.
     */
    public CourseNotOfferedException(String profID, String courseId) {
        this.profID = profID;
        this.courseId = courseId;
    }

    /**
     * Returns a detailed message about the exception.
     * @return A message indicating that the course with the specified ID is not offered by the professor with the specified ID.
     */
    @Override
    public String getMessage() {
        return "Course with ID: " + courseId + " not offered by professor with ID: " + profID;
    }
}