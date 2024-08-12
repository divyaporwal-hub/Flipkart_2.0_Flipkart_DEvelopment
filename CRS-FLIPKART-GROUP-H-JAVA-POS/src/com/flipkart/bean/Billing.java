package com.flipkart.bean;

/**
 * @author GROUP-H
 * The Billing class stores billing information for a student.
 * This includes details such as billing ID, student ID, billed amount, 
 * payment status, and transaction ID.
 * 
 */
public class Billing {

    private String billingID;
    private String studentID;
    private float billamt;
    private boolean status; // true for paid, false for unpaid
    private String transactionID;

    /**
     * Constructs a Billing object with the specified billing ID, student ID, 
     * billed amount, and payment status.
     * 
     * @param billingID  unique billing identifier
     * @param studentID  ID of the student
     * @param billamt    amount to be billed
     * @param status     payment status (true for paid, false for unpaid)
     */
    public Billing(String billingID, String studentID, float billamt, boolean status) {
        this.billingID = billingID;
        this.studentID = studentID;
        this.billamt = billamt;
        this.status = status;
        this.setTransactionID(null);
    }

    
    /**
     * Gets the billing ID.
     * 
     * @return the billing ID
     */
    
    public String getBillingID() {
        return billingID;
    }
    
    /**
     * Sets the billing ID.
     * 
     * @param billingID the unique billing identifier to set
     */
    
    public void setBillingID(String billingID) {
        this.billingID = billingID;
    }
    
    /**
     * Gets the student ID.
     * 
     * @return the student ID
     */

    public String getStudentID() {
        return studentID;
    }
    
    /**
     * Sets the student ID.
     * 
     * @param studentID the student ID to set
     */

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    
    /**
     * Gets the billed amount.
     * 
     * @return the amount to be billed
     */
    
    public float getBillamt() {
        return billamt;
    }
    
    /**
     * Sets the billed amount.
     * 
     * @param billamt the amount to be billed
     * 
     * @throws IllegalArgumentException if the bill amount is negative
     */
    
    public void setBillamt(float billamt) {
        this.billamt = billamt;
    }
    
    /**
     * Gets the payment status.
     * 
     * @return true if the bill is paid, false if unpaid
     */
    
    public boolean isStatus() {
        return status;
    }
    
    /**
     * Sets the payment status.
     * 
     * @param status true for paid, false for unpaid
     */
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    /**
     * Gets the transaction ID.
     * 
     * @return the transaction ID, or null if not set
     */
    
	public String getTransactionID() {
		return transactionID;
	}
	
	/**
     * Sets the transaction ID.
     * 
     * @param transactionID the transaction ID to set, or null if not applicable
     */
	
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
}
