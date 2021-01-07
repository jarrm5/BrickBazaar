 package com.jarrm5.exception;

public abstract class AppGenericException extends Exception {
	
	protected Object offender;
	protected ErrorReason errorReason;
	
	public AppGenericException(ErrorReason reason,Object offender) {
		this.errorReason = reason;
		this.offender = offender;
	}
	
	public String toString() {
		return "Application Error Occured.";
	}
	public enum ErrorReason{
		USER_BANNED,
		INBOX_FULL,
		BUDDY_LIST_FULL,
		DUPLICATE_BUDDY,
		MESSAGE_LENGTH_EXCEEDED,
		LOGIN_FAILED_PASSWORD,
		LOGIN_FAILED_ACCOUNT_LOCKED,
		USER_ACCOUNT_BANNED,
		USER_ACCOUNT_UNBANNED;
	}
}
