package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoServices;
import com.flipkart.exception.BillingNotFoundException;
import com.flipkart.exception.CourseAlreadyOptedException;
import com.flipkart.exception.CourseNotAvailableException;
import com.flipkart.exception.CourseNotFoundException;

import java.util.List;
import java.util.Set;

/**
 * Implements the operations defined in the `StudentInterface` for managing student-related activities,
 * including course registration, viewing enrolled courses, obtaining report cards, billing information, and handling payments.
 */
public class StudentOperations implements StudentInterface {
    private StudentDaoInterface sdi = new StudentDaoServices();

    /**
     * Registers a student for a list of courses.
     * @param student The `Student` object representing the student registering for courses.
     * @param courses A `List<String>` containing the IDs of the courses the student wishes to register for.
     * @return A `String` message indicating the result of the registration operation, including the registered courses and total price.
     */
    public String register(Student student, List<String> courses) {
        StringBuilder confirmedRegistration = new StringBuilder();
        int count = 0;
        float price = 0;
        for (String courseID : courses) {
            if (count == 4) break;
            float temp = 0;
            try {
                temp = sdi.register(student, courseID);
            } catch (CourseAlreadyOptedException | CourseNotAvailableException | CourseNotFoundException e) {
                e.printStackTrace();
            }
            count++;
            confirmedRegistration.append(courseID).append("\n");
            price += temp;
        }
        return confirmedRegistration.toString().concat("price: " + price);
    }

    /**
     * Retrieves a list of courses that the student is currently enrolled in.
     * @param student The `Student` object representing the student whose enrolled courses are to be retrieved.
     * @return A `String` representation of the list of courses the student is enrolled in.
     */
    public String viewCoursesEnrolled(Student student) {
        StringBuilder courses = new StringBuilder();
        List<Course> courseList = sdi.viewCoursesEnrolled(student);
        courseList.forEach(course -> 
            courses.append(course.getCourseID()).append("\t")
                   .append(course.getCourseName()).append("\t")
                   .append(course.getCourseProf()).append("\n")
        );
        return courses.toString();
    }

    /**
     * Retrieves the report card for a student.
     * @param student The `Student` object representing the student whose report card is to be retrieved.
     * @return A `String` representation of the student's report card.
     */
    public String getReport(Student student) {
        StringBuilder report = new StringBuilder();
        ReportCard reportCard = sdi.getReport(student);
        reportCard.getGrades().forEach((key, value) -> 
            report.append(key).append(":").append(value).append("\n")
        );
        return report.toString();
    }

    /**
     * Retrieves billing information for a student.
     * @param student The `Student` object representing the student whose billing information is to be retrieved.
     * @return A `String` representation of the student's billing information.
     */
    public String getBillingInfo(Student student) {
        try {
            Billing billing = sdi.getBillingInfo(student);
            String status = billing.isStatus() ? "Completed" : "Pending";
            return billing.getBillingID() + "\t" + billing.getBillamt() + "\t" + status;
        } catch (BillingNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getValidCount(List<String> courses) {
        // Placeholder for implementation
        return 0;
    }

    @Override
    public String viewCourses() {
        StringBuilder catalog = new StringBuilder();
        Set<Course> courses = sdi.viewCourses();
        courses.forEach(course -> {
            String prof = course.getCourseProf();
            if (prof == null) prof = "Prof Awaited";
            catalog.append(course.getCourseID()).append("\t")
                   .append(course.getCourseName()).append("\t\t")
                   .append(prof).append("\t\t")
                   .append(course.getSeats()).append("\n");
        });
        return catalog.toString();
    }

    @Override
    public String makePayment(Student student, float amount, String transactionID) {
        try {
            Billing billing = sdi.getBillingInfo(student);
            if (billing.isStatus()) {
                return "Payment already completed for billing ID: " + billing.getBillingID();
            }
            billing.setTransactionID(transactionID);
            billing.setBillamt(amount);
            boolean paymentSuccess = sdi.updateBillingInfo(billing);
            return paymentSuccess ? "Payment Successful. Transaction ID: " + transactionID : "Payment failed. Please try again.";
        } catch (BillingNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public float getCoursePricing(Student student) {
        float price = 0;
        List<Course> courseList = sdi.viewCoursesEnrolled(student);
        for (Course course : courseList) {
            price += course.getPrice();
        }
        return price;
    }
}