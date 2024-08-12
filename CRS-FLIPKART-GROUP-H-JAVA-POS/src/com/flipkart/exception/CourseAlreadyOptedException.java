package com.flipkart.exception;

/**
 * Exception thrown when a student attempts to opt for a course they have already opted for.
 */
public class CourseAlreadyOptedException extends Exception {

    private String studentId;
    private String courseId;

    /**
     * Constructs a new CourseAlreadyOptedException with the specified student ID and course ID.
     * @param studentId The ID of the student who has already opted for the course.
     * @param courseId The ID of the course that the student has already opted for.
     */
    public CourseAlreadyOptedException(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    /**
     * Returns a detailed message about the exception.
     * @return A message indicating that the course with the specified ID has already been opted for by the student with the specified ID.
     */
    @Override
    public String getMessage() {
        return "Course with ID: " + courseId + " already opted by student with ID: " + studentId;
    }
}