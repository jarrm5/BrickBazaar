package com.jarrm5.util;


import java.time.LocalDate;
import java.util.ArrayList;

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
			MessagingService.sendMessageToUser(adminAccounts[0], userAccounts[1], "Check your portfolio", "Bitcoin is up big today ($37k)");
			//adminAccounts[0].banUser(userAccounts[0]);
			MessagingService.sendMessageToUser(userAccounts[0], userAccounts[1], "Hello again", "Still testing..");
			MessagingService.sendMessageToUser(userAccounts[2], userAccounts[1], "YOU SUCK", "YOU DOO DOO HEAD!");
			MessagingService.sendMessageToUser(adminAccounts[1], userAccounts[1], "Daily reminder", "Don't forget to drink your ovaltine.");
			//ArrayList<Message> filterResult = MessagingService.getMessagesByAccount(userAccounts[1], userAccounts[0]);
			MessagingService.MessageSortUtil msu = new MessagingService.MessageSortUtil();
			userAccounts[1].getInbox().sort(msu);
		} catch (AppGenericException e) {
			e.printStackTrace();
		}
		
		for (Account u : userAccounts) {
			MessagingService.printMessages(u);
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











