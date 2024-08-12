package com.flipkart.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * The Catalog class manages a collection of courses.
 * It provides methods to add, remove, and retrieve courses in the catalog.
 * 
 * @author GROUP-H
 */


public class Catalog {

    private Set<Course> courses; // Set of courses in the catalog

    /**
     * Constructs a Catalog object with an empty set of courses.
     */
    public Catalog() {
        this.courses = new HashSet<>();
    }

    /**
     * Adds a course to the catalog.
     * 
     * @param course the course to add
     * 
     * @return true if the course was added successfully, 
     *         false if the course already exists in the catalog
     */
    public boolean addCourse(Course course) {
        return courses.add(course);
    }

    /**
     * Removes a course from the catalog based on the course code.
     * 
     * @param courseCode the code of the course to remove
     * 
     * @return true if the course was removed successfully, 
     *         false if the course was not found in the catalog
     */
    public boolean removeCourse(String courseCode) {
        return courses.removeIf(course -> course.getCourseID().equals(courseCode));
    }

    /**
     * Retrieves the list of courses in the catalog.
     * 
     * @return a set of courses in the catalog
     */
    public Set<Course> getCourses() {
        return new HashSet<>(courses); // Return a copy to avoid external modification
    }
}
