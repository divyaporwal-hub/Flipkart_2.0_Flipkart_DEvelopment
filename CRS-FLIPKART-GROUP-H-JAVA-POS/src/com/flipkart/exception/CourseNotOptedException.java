package com.flipkart.exception;

/**
 * Exception thrown when a course with a specified ID is not opted for by a student with a specified ID.
 */
public class CourseNotOptedException extends Exception {

    private String studentId;
    private String courseId;

    /**
     * Constructs a new CourseNotOptedException with the specified student ID and course ID.
     * @param studentId The ID of the student who has not opted for the course.
     * @param courseId The ID of the course that the student has not opted for.
     */
    public CourseNotOptedException(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    /**
     * Returns a detailed message about the exception.
     * @return A message indicating that the course with the specified ID is not opted for by the student with the specified ID.
     */
    @Override
    public String getMessage() {
        return "Course with ID: " + courseId + " not opted for by student with ID: " + studentId;
    }
}