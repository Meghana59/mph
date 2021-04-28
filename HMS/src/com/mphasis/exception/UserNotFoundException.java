package com.mphasis.exception;

public class UserNotFoundException extends Exception{
	public UserNotFoundException() {
		
	}

	@Override
	public String toString() {
		return "UserNotFound.. plz check the credentials";
	}
	
	public void UserNotFoundException() {
		System.out.println("From User Not Found Exception");
		}
}
