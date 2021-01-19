 package com.jarrm5.exception;

import com.jarrm5.constant.ErrorReason;

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
}
