package com.jarrm5.exception;

import com.jarrm5.model.UserAccount;

public class UserAccountException extends AccountException {
	
	public UserAccountException(ErrorReason reason,Object offender) {
		super(reason,offender);
	}
	
	@Override
	public String toString() {
		UserAccount account = (UserAccount) offender;
		String errorReasonStr = "Reason: ";
		
		switch(this.errorReason) {
			case USER_BANNED:
				errorReasonStr += account.getUsername() + " is temporarily banned.";
				break;
			default:
				errorReasonStr += "Unknown.";
				break;
		}
		
		return super.toString() + "\n" + errorReasonStr;
	}
}
