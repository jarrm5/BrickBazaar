package com.jarrm5.util;

import java.util.ArrayList;

import com.jarrm5.exception.AdminAccountException;
import com.jarrm5.exception.AppGenericException;
import com.jarrm5.model.Account;
import com.jarrm5.model.AdminAccount;
import com.jarrm5.model.Message;
import com.jarrm5.model.MessageString;
import com.jarrm5.model.UserAccount;
import com.jarrm5.model.UserAccount.Gender;
import com.jarrm5.util.MessagingService;

public class App {
	//Added a comment
	public static void main(String[] args) {
		UserAccount[] userAccounts = UserAccount.getAccounts();
		AdminAccount[] adminAccounts = AdminAccount.getAccounts();
		//BuddyListTest(userAccounts,adminAccounts);
		//MessagingTest(userAccounts, adminAccounts);
		SearchingServiceTest(userAccounts,adminAccounts);
	}
	public static void MessagingTest(UserAccount[] userAccounts,AdminAccount[] adminAccounts) {
		try {
			MessagingService.sendMessage(userAccounts[0], userAccounts[1], null, "Testing message service");
			MessagingService.sendMessage(userAccounts[0], userAccounts[1], "Problem?", "Stepping up to me bruh?");
			//AdminService.banUser(adminAccounts[0], userAccounts[0]);
			MessagingService.sendMessage(userAccounts[1].getInbox().get(0),userAccounts[1],userAccounts[0], "Bitcoin is up big today ($37k)");
			MessagingService.sendMessage(userAccounts[0].getInbox().get(0),userAccounts[0],userAccounts[1], "Still testing..");
			MessagingService.sendMessage(userAccounts[1].getInbox().get(0),userAccounts[0],userAccounts[1],"YOU SUCK, YOU DOO DOO HEAD!");
			MessagingService.sendMessage(userAccounts[1].getInbox().get(1),userAccounts[1],userAccounts[0], "Ya bruh your so intimidating");
			System.out.println(userAccounts[0].getInbox().get(0));
		} catch (AppGenericException e) {
			e.printStackTrace();
		}
		
	}
	public static void BuddyListTest(UserAccount[] userAccounts,AdminAccount[] adminAccounts) {
		try {
			BuddyListService.addUserToBuddyList(userAccounts[0], adminAccounts[0]);
			BuddyListService.addUserToBuddyList(userAccounts[0], userAccounts[1]);
			BuddyListService.addUserToBuddyList(userAccounts[0], userAccounts[2]);
			BuddyListService.addUserToBuddyList(userAccounts[0], adminAccounts[1]);
			BuddyListService.addUserToBuddyList(userAccounts[0], adminAccounts[1]);
			BuddyListService.sortBuddyListByUsername(userAccounts[0].getBuddyList());
			BuddyListService.printAllBuddies(userAccounts[0]);
		} catch (AppGenericException e) {
			e.printStackTrace();
		}
	}
	public static void LoginTest(UserAccount[] userAccounts,AdminAccount[] adminAccounts) {
		//userAccounts[0].setBanned(true);
		try {
			LoginService.login(userAccounts[0], "asfas");
		} catch (AppGenericException e) {
			e.printStackTrace();
		}
		try {
			LoginService.login(userAccounts[0], "password1");
		} catch (AppGenericException e) {
			e.printStackTrace();
		}
//		try {
//			LoginService.login(userAccounts[0], "password1");
//		} catch (AppGenericException e) {
//			e.printStackTrace();
//		}
//		try {
//			LoginService.login(adminAccounts[0], "asdfas");
//		} catch (AppGenericException e) {
//			e.printStackTrace();
//		}
		
		for (UserAccount u : userAccounts) {
			System.out.println(u.getUsername() + ": " + u.getLoginAttempts());
		}
	}
	public static void SearchingServiceTest(UserAccount[] userAccounts,AdminAccount[] adminAccounts) {
		ArrayList<UserAccount> adminSearchResults = SearchingService.getAccountsWithPredicate(adminAccounts[0], userAccounts, 
				(UserAccount acc) -> acc.getGender() == UserAccount.Gender.FEMALE);
		ArrayList<UserAccount> userSearchResults = SearchingService.getAccountsWithPredicate(userAccounts[0], userAccounts, 
				(UserAccount acc) -> { 
					return acc.getEmail() != null && acc.getEmail().endsWith("protonmail.com");
				});
		//Demonstrates UserAccounts doing the searching get deep copies UserAccounts
		userSearchResults.get(0).setBanned(true);
		
		try {
			//Demonstrates AdminAccounts doing the searching get a shallow copy of UserAccounts
			AdminService.banUser(adminAccounts[0], adminSearchResults.get(0));
		} catch (AppGenericException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}











