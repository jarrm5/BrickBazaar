package com.jarrm5.util;


import java.time.LocalDate;

import com.jarrm5.exception.AppGenericException;
import com.jarrm5.model.Account;
import com.jarrm5.model.AdminAccount;
import com.jarrm5.model.Message;
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
			MessagingService.sendMessageToUser(userAccounts[0], userAccounts[1], null, "Testing message service");
			//adminAccounts[0].banUser(userAccounts[0]);
			MessagingService.sendMessageToUser(userAccounts[0], userAccounts[1], "Hello again", "Still testing..");
		} catch (AppGenericException e) {
			e.printStackTrace();
		}
		
		for (Account u : userAccounts) {
			MessagingService.printAllMessages(u);
		}
	}
	public static void BuddyListTest(UserAccount[] userAccounts,AdminAccount[] adminAccounts) {
		adminAccounts[0].banUser(userAccounts[0]);
		try {
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











