package com.flipkart.exception;

/**
 * Exception thrown when attempting to create a user that already exists.
 */
public class UserAlreadyExistsException extends Exception {

    private String userId;

    /**
     * Constructs a new UserAlreadyExistsException with the specified user ID.
     * @param userId The ID or username of the user that already exists.
     */
    public UserAlreadyExistsException(String userId) {
        this.userId = userId;
    }

    /**
     * Returns a detailed message about the exception.
     * @return A message indicating that a user with the specified ID or username already exists.
     */
    @Override
    public String getMessage() {
        return "User with userID/username: " + userId + " already exists.";
    }
}