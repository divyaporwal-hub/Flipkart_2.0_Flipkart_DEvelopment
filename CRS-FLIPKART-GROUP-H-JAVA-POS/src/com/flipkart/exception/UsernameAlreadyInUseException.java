package com.flipkart.exception;

/**
 * Exception thrown when attempting to register a user with an email or username that is already in use.
 */
public class UsernameAlreadyInUseException extends Exception {

    private String username;

    /**
     * Constructs a new UsernameAlreadyInUseException with the specified username.
     * @param username The username or email that is already in use.
     */
    public UsernameAlreadyInUseException(String username) {
        this.username = username;
    }

    /**
     * Returns a detailed message about the exception.
     * @return A message indicating that the specified username or email is already in use.
     */
    @Override
    public String getMessage() {
        return "Email: " + username + " is already in use.";
    }
}