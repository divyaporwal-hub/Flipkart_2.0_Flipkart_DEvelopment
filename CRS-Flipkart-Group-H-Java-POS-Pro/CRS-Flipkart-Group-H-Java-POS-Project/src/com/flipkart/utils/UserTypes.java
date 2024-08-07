package com.flipkart.utils;


public enum UserTypes {
	ADMIN,PROFESSOR,STUDENT;

	public static UserTypes stringToName(String role)
	{
		UserTypes userUserTypes =null;

		if(role.equalsIgnoreCase("ADMIN"))
			userUserTypes = UserTypes.ADMIN;
		else if(role.equalsIgnoreCase("PROFESSOR"))
			userUserTypes = UserTypes.PROFESSOR;
		else if(role.equalsIgnoreCase("STUDENT"))
			userUserTypes = UserTypes.STUDENT;
		return userUserTypes;
	}
}
