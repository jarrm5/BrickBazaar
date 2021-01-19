package com.jarrm5.exception;


import com.jarrm5.constant.ErrorReason;
import com.jarrm5.model.AdminAccount;

public class AdminAccountException extends AccountException {

	public AdminAccountException(ErrorReason reason, Object offender) {
		super(reason, offender);
	}
	
	@Override
	public String toString() {
		AdminAccount account = (AdminAccount) offender;
		String errorReasonStr = "Reason: ";
		
		switch(this.errorReason) {
			case USER_ACCOUNT_BANNED:
				errorReasonStr += account.getUsername() + " cannot issue the ban - the selected user is already banned!";
				break;
			case USER_ACCOUNT_UNBANNED:
				errorReasonStr += account.getUsername() + " cannot issue the unban - the selected user is already unbanned!";
				break;
			default:
				errorReasonStr += "Unknown.";
				break;
		}
		
		return super.toString() + "\n" + errorReasonStr;
	}
}
