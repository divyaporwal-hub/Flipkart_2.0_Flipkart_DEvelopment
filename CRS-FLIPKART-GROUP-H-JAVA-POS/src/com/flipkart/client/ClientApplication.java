package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.business.UserOperations;

/**
 * The main entry point for the CRS (Course Registration System) application.
 * Provides a menu-driven interface for users to log in, register as a student,
 * and update their passwords.
 */
public class ClientApplication {
	static UserOperations userInstance;
	static Catalog catalog;
	
	public static void main(String[] args) {
		int input = 0;
		String username = null, password = null;
		userInstance = new UserOperations();
		catalog = new Catalog();
		Scanner s = new Scanner(System.in);
		
		// Main menu loop
		while (input != 4) {
			System.out.println("\t\t\t\t\t------------------------------------------------------");
			System.out.println("\t\t\t\t\t\t Welcome to the CRS Application");
			System.out.println();
			System.out.println("\t\t\t\t\t\t\t1. Login");
			System.out.println("\t\t\t\t\t\t\t2. Registration");
			System.out.println("\t\t\t\t\t\t\t3. Update Password");
			System.out.println("\t\t\t\t\t\t\t4. Exit");
			System.out.println("\t\t\t\t\t------------------------------------------------------");
			input = s.nextInt();
			
			switch (input) {
				case 1:
					System.out.println("------------------------------------------------------");
					System.out.println("Enter the Username:");
					username = s.next();
					System.out.println("Enter the Password:");
					password = s.next();
					System.out.println("------------------------------------------------------");
					login(username, password);
					break;
				case 2:
					studentRegistraion();
					break;
				case 3:
					updatePassword();
					break;
				case 4:
					continue;
				default:
					System.out.println("Invalid command");
			}
		}
	}
	
	/**
	 * Handles user login based on username and password.
	 * @param username The username of the user.
	 * @param password The password of the user.
	 */
	public static void login(String username, String password) {
		User user = userInstance.retrieve(username, password);
		
		if (user == null) {
			System.out.println("Wrong username or password, exiting main menu...");
			return;
		}
		
		if (user.getRole().equals("Student")) {
			if (!((Student)user).isApproved()) return;
			StudentMenu studentOps = new StudentMenu();
			studentOps.studentMenu((Student)user, username);
		} else if (user.getRole().equals("Professor")) {
			ProfMenu profops = new ProfMenu();
			profops.professorMenu((Prof)user, username);
		} else if (user.getRole().equals("Admin")) {
			AdminMenu adminops = new AdminMenu();
			adminops.adminMenu((Admin)user, username);
		}
	}
	
	/**
	 * Handles student registration by taking user input and registering a new student.
	 */
	public static void studentRegistraion() {

		Scanner s = new Scanner(System.in);
		System.out.println("------------------------------------------------------");
		System.out.println("Enter Username :");
		String username = s.next();
		s.nextLine();
		System.out.println("Enter Name :");
		String name = s.nextLine();
		System.out.println("Enter Contact:");
		String contact = s.next();
		s.nextLine();
		System.out.println("Enter Email:");
		String email = s.next();
		s.nextLine();
		System.out.println("Enter Branch:");
		String branch = s.next();
		s.nextLine();
		System.out.println("Enter Password:);
		String password = s.next();
		s.nextLine();
		System.out.println("------------------------------------------------------");
		System.out.println(userInstance.registerStudent(username, name, contact, email, password, branch));		
	}
	
	/**
	 * Handles password update for a user.
	 * @param username The username of the user whose password needs to be updated.
	 * @param password The old password of the user.
	 * @param newPassword The new password to be set.
	 */
	public static void updatePassword() {
		Scanner s = new Scanner(System.in);
		String username, password, newPassword;
		System.out.println("------------------------------------------------------");
		System.out.println("Enter the Username :--");
		username = s.next();
		System.out.println("Enter old Password :--");
		password = s.next();
		System.out.println("Enter new Password :--");
		newPassword = s.next();
		System.out.println("------------------------------------------------------");
		if (userInstance.changePassword(username, password, newPassword)) {
			System.out.println("Password changed successfully");
		}
	}
}