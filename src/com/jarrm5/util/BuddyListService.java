package com.jarrm5.util;

import com.jarrm5.exception.AccountException;
import com.jarrm5.exception.UserAccountException;
import com.jarrm5.exception.AppGenericException.ErrorReason;
import com.jarrm5.model.Account;
import com.jarrm5.model.UserAccount;

public class BuddyListService {
	
	public static final int MAX_NUMBER_OF_BUDDIES = 2;
	
	//Only UserAccounts can add other users.  Other users include Admin Accounts.. so "other" can be of generic type "Account"
	public static boolean addUserToBuddyList(UserAccount account, Account other) throws AccountException{
		//Need a way to check for duplicate buddies in the account's list
		//Check ArrayList<> add documentation.. not returning false when list if full
		if (account.isBanned()) {
			throw new UserAccountException(ErrorReason.USER_BANNED,account);
		}
		else if (account.getBuddyList().size() >= MAX_NUMBER_OF_BUDDIES) {
			throw new AccountException(ErrorReason.BUDDY_LIST_FULL,account);
		}
		return account.getBuddyList().add(other);
	}
	
	public static void printAllBuddies(UserAccount account) {
		if (!account.getBuddyList().isEmpty()) {
			System.out.println("Buddies for user " + account.getUsername());
			for (Account user: account.getBuddyList()) {
				System.out.println(user.getUsername() + " ");
			}
		}
		else {
			System.out.println("buddy list empty for " + account.getUsername());
		}
		
	}
}
