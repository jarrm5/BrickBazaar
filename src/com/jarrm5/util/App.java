package com.jarrm5.util;


import java.time.LocalDate;
import java.util.ArrayList;

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
		MessagingTest(userAccounts, adminAccounts);
		
	}
	public static void MessagingTest(UserAccount[] userAccounts,AdminAccount[] adminAccounts) {
		try {
			MessagingService.sendMessage(userAccounts[0], userAccounts[1], null, "Testing message service");
			MessagingService.sendMessage(userAccounts[0], userAccounts[1], "Problem?", "Stepping up to me bruh?");
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
			AdminService.banUser(adminAccounts[1],userAccounts[0]);
			//AdminService.banUser(adminAccounts[1],userAccounts[0]);
			AdminService.unbanUser(adminAccounts[1],userAccounts[0]);
			AdminService.unbanUser(adminAccounts[1],userAccounts[0]);
			BuddyListService.addUserToBuddyList(userAccounts[0], adminAccounts[0]);
			BuddyListService.addUserToBuddyList(userAccounts[0], userAccounts[1]);
			//BuddyListService.addUserToBuddyList(userAccounts[0], userAccounts[1]);
			BuddyListService.addUserToBuddyList(userAccounts[0], new UserAccount("sevans,","password1","Sheldon","Evans","sevans@gmail.com",LocalDate.of(1996,11, 11),Gender.MALE));
		} catch (AppGenericException e) {
			e.printStackTrace();
		}
		
		for (UserAccount u : userAccounts) {
			BuddyListService.printAllBuddies(u);
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
}











