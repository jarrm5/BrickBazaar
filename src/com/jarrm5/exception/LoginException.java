package com.jarrm5.exception;

import com.jarrm5.constant.ErrorReason;
import com.jarrm5.model.Account;
import com.jarrm5.util.LoginService;

public class LoginException extends AppGenericException {
	
	public LoginException(ErrorReason reason,Account account) {
		super(reason,account);
	}
	
	@Override
	public String toString() {
		
		Account account = (Account) offender;
		String errorReasonStr = "Login error occured for " + account.getUsername() + "\nReason: ";
		
		switch(this.errorReason) {
			case LOGIN_FAILED_PASSWORD:
				int remainingLoginAttempts = LoginService.MAX_LOGIN_ATTEMPTS - account.getLoginAttempts();
				errorReasonStr += "Incorrect Password. " + (remainingLoginAttempts > 0 ?  remainingLoginAttempts + " attempts remaining." : " Account temporarily locked.");
				break;
			case LOGIN_FAILED_ACCOUNT_LOCKED:
				errorReasonStr += "Account temporarily locked.";
				break;
			default:
				errorReasonStr = "";
				break;
		}
		
		return errorReasonStr;
	}
}
