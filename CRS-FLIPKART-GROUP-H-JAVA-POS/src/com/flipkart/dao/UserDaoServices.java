package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Prof;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.DBQueries;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.exception.UsernameAlreadyInUseException;

/**
 * Implementation of the UserDaoInterface for user data access operations.
 * Provides methods for retrieving user information, registering new students, and updating user passwords.
 */
public class UserDaoServices implements UserDaoInterface {
	
    public static Connection conn = DBUtil.getConnection();
	
    @Override
    public User getUser(String username) throws UserNotFoundException {
        /**
         * Retrieves a user by their username.
         * @param username The username of the user to retrieve.
         * @return The `User` object associated with the specified username.
         * @throws UserNotFoundException If no user with the specified username is found.
         */
        try {
            PreparedStatement ps = conn.prepareStatement(DBQueries.GET_USER_USERNAME);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
	
            if (rs.next()) {
                String userID = rs.getString("userID");
                String role = rs.getString("role");
                String contact = rs.getString("contact");
                String email = rs.getString("email");
                String name = rs.getString("name");
                String password = rs.getString("password");
                
                if (role.equals("Student")) {
                    try {
                        return getStudent(userID, name, role, contact, email, password);
                    } catch (StudentNotApprovedException e) {
                        e.printStackTrace();
                        return null;
                    }
                } else if (role.equals("Professor")) {
                    return getProfessor(userID, name, role, contact, email, password);
                } else if (role.equals("Admin")) {
                    return getAdmin(userID, name, role, contact, email, password);
                }
            } else {
                throw new UserNotFoundException(username);
            }
        } catch (SQLException e) {
            return null;
        }
    }
	
    private User getStudent(String userID, String name, String role,
                            String contact, String email, String password) throws StudentNotApprovedException {
        try {
            PreparedStatement ps = conn.prepareStatement(DBQueries.GET_STUDENT_USERID);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
	
            if (rs.next()) {
                String branch = rs.getString("branch");
                int rollNum = rs.getInt("rollNum");
                boolean approved = rs.getBoolean("approved");
                
                Student student = new Student(userID, name, contact, email, branch, rollNum, approved, password);
                if (!approved) {
                    throw new StudentNotApprovedException(userID);
                }
                return student;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
	
    private User getProfessor(String userID, String name, String role,
                              String contact, String email, String password) {
        try {
            PreparedStatement ps = conn.prepareStatement(DBQueries.GET_PROFESSOR_USERID);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
	
            if (rs.next()) {
                String department = rs.getString("department");
                String qualification = rs.getString("qualification");
                
                return new Prof(userID, name, contact, email, department, qualification, password);
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
	
    private User getAdmin(String userID, String name, String role,
                          String contact, String email, String password) {
        return new Admin(userID, name, contact, email, password);
    }

    @Override
    public String registerStudent(String username, String name, String contact, String email, String password, String branch) 
            throws UsernameAlreadyInUseException {
        /**
         * Registers a new student.
         * @param username The username for the new student.
         * @param name The name of the student.
         * @param contact The contact number of the student.
         * @param email The email address of the student.
         * @param password The password for the student's account.
         * @param branch The branch of study for the student.
         * @return A `String` indicating the result of the registration process (e.g., success or failure message).
         * @throws UsernameAlreadyInUseException If the username is already in use.
         */
        try {
            PreparedStatement ps = conn.prepareStatement(DBQueries.VERIFY_USERNAME);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                throw new UsernameAlreadyInUseException(username);
            }
        } catch (SQLException e) {
            return "SQL Exception";
        }
        
        try {
            PreparedStatement ps = conn.prepareStatement(DBQueries.FETCH_IDS);
            ResultSet rs = ps.executeQuery();
            List<String> userIds = new ArrayList<>();
            while (rs.next()) {
                userIds.add(rs.getString("userID"));
            }

            Random rand = new Random();
            String userID;
            while (true) {
                long id = 10000000 + rand.nextInt(10000000);
                userID = "STUDENT" + Long.toString(id);
                if (!userIds.contains(userID)) break;
            }

            ps = conn.prepareStatement(DBQueries.FETCH_ROLLNUMS);
            rs = ps.executeQuery();
            List<Integer> rollNums = new ArrayList<>();
            while (rs.next()) {
                rollNums.add(rs.getInt("rollNum"));
            }

            int rollNum = 0;
            while (true) {
                rollNum++;
                if (!rollNums.contains(rollNum)) break;
            }

            ps = conn.prepareStatement(DBQueries.ADD_USER);
            ps.setString(1, userID);
            ps.setString(2, name);
            ps.setString(3, "Student");
            ps.setString(4, contact);
            ps.setString(5, email);
            ps.setString(6, password);
            ps.setString(7, username);
            ps.executeUpdate();

            ps = conn.prepareStatement(DBQueries.ADD_STUDENT);
            ps.setString(1, userID);
            ps.setString(2, branch);
            ps.setInt(3, rollNum);
            ps.setBoolean(4, false);
            ps.executeUpdate();
            
            PreparedStatement ps1 = conn.prepareStatement(DBQueries.FETCH_BILLINGS);
            ResultSet rs1 = ps1.executeQuery();
            List<String> billings = new ArrayList<>();
            while (rs1.next()) {
                billings.add(rs1.getString("billingID"));
            }

            int billing = 0;
            while (true) {
                billing++;
                if (!billings.contains(String.valueOf(billing))) break;
            }

            ps1 = conn.prepareStatement(DBQueries.ADD_BILLING);
            ps1.setString(1, userID);
            ps1.setString(2, String.valueOf(billing));
            ps1.setFloat(3, 0);
            ps1.setBoolean(4, false);
            ps1.executeUpdate();
            
            return "Registration Complete! \nuserID: " + userID + "\nrollNum: " + rollNum + "\nbillingID: " + billing;
        } catch (SQLException e) {
            return "SQL Exception";
        }
    }

    @Override
    public boolean updatePassword(String username, String oldPassword, String newPassword) 
            throws UserNotFoundException {
        /**
         * Updates the password for a user.
         * @param username The username of the user whose password is to be updated.
         * @param oldPassword The current password of the user.
         * @param newPassword The new password to set.
         * @return `true` if the password was successfully updated; `false` otherwise.
         * @throws UserNotFoundException If no user with the specified username is found.
         */
        try {
            PreparedStatement ps1 = conn.prepareStatement(DBQueries.GET_USER_USERNAME);
            ps1.setString(1, username);
            ResultSet rs = ps1.executeQuery();
	
            if (rs.next()) {
                PreparedStatement ps = conn.prepareStatement(DBQueries.UPDATE_PASSWORD);
                ps.setString(1, newPassword);
                ps.setString(2, username);
                ps.setString(3, oldPassword);
                ps.executeUpdate();
                return true;
            } else {
                throw new UserNotFoundException(username);
            }
        } catch (SQLException e) {
            return false;
        }
    }
}