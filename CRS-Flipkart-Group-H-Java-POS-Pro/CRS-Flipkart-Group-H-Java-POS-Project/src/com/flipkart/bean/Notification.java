package com.flipkart.bean;


import com.flipkart.utils.TypeOfNotification;

public class Notification {
	private int notificationId;
	private int studentId;
	private TypeOfNotification type;
	private String referenceId;
	

	public Notification(int notificationId, int studentId, TypeOfNotification type, String referenceId)
	{
		this.notificationId = notificationId;
		this.studentId = studentId;
		this.type = type;
		this.referenceId = referenceId;
	}
	

	public int getNotificationId() {
		return notificationId;
	}
	

	public int getStudentId() {
		return studentId;
	}
	

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	

	public TypeOfNotification getType() {
		return type;
	}
	

	public void setType(TypeOfNotification type) {
		this.type = type;
	}


	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
}
