package com.flipkart.exception;

/**
 * Exception thrown when a user with a specified user ID cannot be found.
 */
public class UserNotFoundException extends Exception {
    
    private String userId;

    /**
     * Constructs a new UserNotFoundException with the specified user ID.
     * @param id The user ID of the user that cannot be found.
     */
    public UserNotFoundException(String id) {
        this.userId = id;
    }

    /**
     * Returns a detailed message about the exception.
     * @return A message indicating that the user with the specified user ID was not found.
     */
    @Override
    public String getMessage() {
        return "User with userId: " + userId + " not found.";
    }
}