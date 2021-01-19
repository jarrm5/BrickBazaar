package com.jarrm5.util;

import com.jarrm5.constant.ErrorReason;
import com.jarrm5.exception.LoginException;
import com.jarrm5.model.Account;

public class LoginService {
	
	public final static int MAX_LOGIN_ATTEMPTS = 2;
	
	public static boolean login(Account acc,String enteredPassword) throws LoginException{
		
		if (enteredPassword.equals(acc.getPassword())) { 
			if (acc.getLoginAttempts() < MAX_LOGIN_ATTEMPTS) {
				acc.setLoginAttempts(0);
				return true;
			}
			else {
				throw new LoginException(ErrorReason.LOGIN_FAILED_ACCOUNT_LOCKED,acc);
			}
		}
		else {
			if (acc.getLoginAttempts() < MAX_LOGIN_ATTEMPTS) {
				acc.setLoginAttempts(acc.getLoginAttempts() + 1);
			}
			else {
				throw new LoginException(ErrorReason.LOGIN_FAILED_ACCOUNT_LOCKED,acc);
			}
		}
		throw new LoginException(ErrorReason.LOGIN_FAILED_PASSWORD, acc);
	}
}
