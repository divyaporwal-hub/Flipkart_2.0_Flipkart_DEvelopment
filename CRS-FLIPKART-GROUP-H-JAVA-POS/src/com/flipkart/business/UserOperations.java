package com.flipkart.business;

import java.util.HashMap;
import java.util.Map;

import com.flipkart.bean.*;
import com.flipkart.dao.UserDaoServices;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.exception.UsernameAlreadyInUseException;
import com.flipkart.dao.UserDaoInterface;

/**
 * Provides implementation for user management operations, including user retrieval, creation,
 * password management, student registration, and user information retrieval.
 */
public class UserOperations implements UserInterface {
    // A map storing users with their usernames as keys
    UserDaoInterface udi = new UserDaoServices();

    /**
     * Retrieves a user based on their username and password.
     * @param username The username of the user.
     * @param password The password of the user.
     * @return A `User` object if the username and password match an existing user; `null` otherwise.
     */
    @Override
    public User retrieve(String username, String password) {
        User user;
        try {
            user = udi.getUser(username);
            if (password.equals(user.getPassword())) 
                return user;
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Creates a new user and adds them to the system.
     * @param username The username of the new user.
     * @param user The `User` object representing the new user.
     */
    @Override
    public void makeNew(String username, User user) {
        users.put(username, user);
    }

    /**
     * Changes the password for a specified user.
     * @param username The username of the user whose password is being changed.
     * @param password The current password of the user.
     * @param newPassword The new password to be set.
     * @return `true` if the password was successfully changed; `false` otherwise.
     */
    @Override
    public boolean changePassword(String username, String password, String newPassword) {
        try {
            return udi.updatePassword(username, password, newPassword);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Registers a new student with the provided details.
     * @param username The username for the new student.
     * @param name The name of the student.
     * @param contact The contact number of the student.
     * @param email The email address of the student.
     * @param password The password for the student.
     * @param branch The branch/department of the student.
     * @return A `String` message indicating the result of the registration operation (e.g., success or failure).
     */
    @Override
    public String registerStudent(String username, String name, String contact, 
                                  String email, String password, String branch) {
        try {
            return udi.registerStudent(username, name, contact, email, password, branch);
        } catch (UsernameAlreadyInUseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Finds a user by their ID.
     * @param id The ID of the user.
     * @return The `User` object corresponding to the given ID; `null` if no such user exists.
     */
    @Override
    public User findByID(String id) {
        return users.values().stream()
                    .filter(user -> user.getID().equals(id))
                    .findFirst()
                    .orElse(null);
    }

    /**
     * Prints the details of all students in the system.
     */
    @Override
    public void printUsers() {
        users.entrySet().stream()
             .map(Map.Entry::getValue)
             .filter(user -> "Student".equals(user.getRole()))
             .map(user -> (Student) user)
             .forEach(stu -> System.out.println(stu.getID() + "-" + stu.getName()));
    }
}