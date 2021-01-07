package com.jarrm5.exception;

import com.jarrm5.model.Account;
import com.jarrm5.model.UserAccount;
import com.jarrm5.util.LoginService;

public class AccountException extends AppGenericException{
	
	public AccountException(ErrorReason reason,Object offender) {
		super(reason,offender);
	}
	
	@Override
	public String toString() {
		Account account = (Account) offender;
		String errorReasonStr = " \nReason: ";
		
		switch(this.errorReason) {
			case BUDDY_LIST_FULL:
				errorReasonStr += account.getUsername() +  " buddy list is full.";
				break;
			case DUPLICATE_BUDDY:
				errorReasonStr += account.getUsername() +  " is already in your list.";
				break;
			case INBOX_FULL:
				errorReasonStr += account.getUsername() +  " inbox is full.";
				break;
			default:
				errorReasonStr = "";
				break;
		}
		
		return super.toString() + errorReasonStr;
	}
//	public enum AccountErrorReason{
//		USER_BANNED,BUDDY_LIST_FULL,DUPLICATE_BUDDY;
//	}
	
}
