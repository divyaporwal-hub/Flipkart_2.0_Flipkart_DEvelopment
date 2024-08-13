package com.flipkart.utils;

/**
 * This class contains SQL queries used in the application.
 * The queries are categorized based on their functionalities, such as user operations, course operations, and student operations.
 */
public class DBQueries {
    
    /** Query to get a user by their username. */
    public static final String GET_USER_USERNAME = "SELECT * FROM user WHERE username = ?";
    
    /** Query to get a user by their user ID. */
    public static final String GET_USER_ID = "SELECT * FROM user WHERE userID = ?";

    /** Query to get a student by their user ID. */
    public static final String GET_STUDENT_USERID = "SELECT * FROM student WHERE userID = ?";
    
    /** Query to get a professor by their user ID. */
    public static final String GET_PROFESSOR_USERID = "SELECT * FROM professor WHERE userID = ?";

    /** Query to verify if a username already exists. */
    public static final String VERIFY_USERNAME= "SELECT * FROM user where username = ?";
    
    /** Query to fetch all user IDs. */
    public static final String FETCH_IDS= "SELECT userID FROM user";
    
    /** Query to fetch all roll numbers of students. */
    public static final String FETCH_ROLLNUMS= "SELECT rollNum FROM student";

    /** Query to add a new user to the database. */
    public static final String ADD_USER = "INSERT INTO user(userID, name, role, contact, email, password, username) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    /** Query to add a new student to the database. */
    public static final String ADD_STUDENT = "INSERT INTO student(userID, branch, rollNum, approved) VALUES (?, ?, ?, ?)";

    /** Query to update a user's password. */
    public static final String UPDATE_PASSWORD = "UPDATE user SET password = ? WHERE username = ? AND password = ?";
    
    /** Query to fetch all courses from the catalog. */
    public static final String FETCH_COURSES = "SELECT * FROM course";
    
    /** Query to add a new course to the catalog. */
    public static final String ADD_COURSE = "INSERT INTO catalog VALUES (?, ?, NULL, ?, ?)";
    
    /** Query to remove a course from the catalog. */
    public static final String REMOVE_COURSE = "DELETE FROM catalog WHERE courseID = ?";
    
    /** Query to remove a user from the database. */
    public static final String REMOVE_USER = "DELETE FROM user WHERE userID = ?";
    
    /** Query to remove a professor from the database. */
    public static final String REMOVE_PROFESSOR = "DELETE FROM professor WHERE userID = ?";
    
    /** Query to add a new professor to the database. */
    public static final String ADD_PROFESSOR = "INSERT INTO professor VALUES (?, ?, ?)";
    
    /** Query to approve a student's registration. */
    public static final String APPROVE_REGISTRATION = "UPDATE student SET approved = 1 WHERE userID = ?";
    
    /** Query to view the professor assigned to a course. */
    public static final String VIEW_VACANT_COURSE = "SELECT courseProf FROM catalog WHERE courseID = ?";
    
    /** Query to select a professor for a course. */
    public static final String SELECT_PROF_COURSE = "UPDATE catalog SET courseProf = ? WHERE courseID = ?";
    
    /** Query to view the list of students enrolled in a course. */
    public static final String VIEW_STUDENT_LIST = "SELECT * FROM student JOIN registeredCourse ON student.userID = registeredCourse.studentID JOIN user ON student.userID = user.userID WHERE registeredCourse.courseID = ?"; 
    
    /** Query to set a grade for a student in a course. */
    public static final String SET_GRADE = "INSERT INTO reportCard(studentID, courseID, grade) VALUES (?, ?, ?)";
    
    /** Query to view the course catalog. */
    public static final String VIEW_COURSE_CATALOG = "SELECT * FROM catalog";
    
    /** Query to get grades for a specific student. */
    public static final String GET_GRADES = "SELECT * FROM reportCard WHERE studentID = ?";
    
    /** Query to get the courses enrolled by a student. */
    public static final String GET_COURSE_ENROLLED = "SELECT catalog.courseID, catalog.courseName, catalog.courseProf, catalog.seats FROM student JOIN registeredCourse ON student.userID = registeredCourse.studentID JOIN catalog ON registeredCourse.courseID = catalog.courseID WHERE student.userID = ?";
    
    /** Query to get billing information for a student. */
    public static final String GET_BILLING_INFO = "SELECT * FROM billing WHERE studentID = ?";
    
    /** Query to get a course by its ID. */
    public static final String GET_COURSE = "SELECT * FROM catalog WHERE courseID = ?";

    /** Query to decrement the number of seats available for a course. */
    public static final String DECR_SEATS = "UPDATE catalog SET seats = ? WHERE courseID = ?";
    
    /** Query to register a student for a course. */
    public static final String REGISTER_COURSE = "INSERT INTO registeredCourse(studentID, courseID, date) VALUES (?, ?, ?)";
    
    /** Query to add billing information for a student. */
    public static final String ADD_BILLING = "INSERT INTO billing(studentID, billingID, billAmount, status) VALUES (?, ?, ?, ?)";
    
    /** Query to fetch all billing IDs. */
    public static final String FETCH_BILLINGS = "SELECT billingID FROM billing";

    /** Query to get the professor assigned to a specific course. */
    public static final String GET_PROFESSOR_COURSEID = "SELECT courseProf FROM catalog WHERE courseID = ?";

    /** Query to check if a student is enrolled in a course. */
    public static final String CHECK_STUDENT_COURSE = "SELECT studentID FROM registeredCourse WHERE courseID = ? AND studentID = ?";
    
    /** Query to view courses offered by a specific professor. */
    public static final String VIEW_COURSE_ENROLLED = "SELECT * FROM catalog WHERE courseProf = ?";
    
    /** Query to update billing information. */
    public static final String UPDATE_BILLING_INFO = "UPDATE billing SET billamt = ?, status = ?, transactionID = ? WHERE billingID = ?";
    
    /** Query to view unapproved students. */
    public static final String VIEW_UNAPPROVED_STUDENTS = 
        "SELECT user.userID, user.name, user.contact, user.email, student.branch, student.rollNum, student.approved, user.password " +
        "FROM student " +
        "JOIN user ON student.userID = user.userID " +
        "WHERE student.approved = 0";

    /** Query to view the list of professors. */
    public static final String VIEW_PROF_LIST = "SELECT * FROM professor JOIN user ON professor.userID = user.userID";
}