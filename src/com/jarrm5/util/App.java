package com.jarrm5.util;


import com.jarrm5.exception.AppGenericException;
import com.jarrm5.model.Account;
import com.jarrm5.model.AdminAccount;
import com.jarrm5.model.Message;
import com.jarrm5.model.UserAccount;

public class App {
	
	public static void main(String[] args) {
		UserAccount[] userAccounts = UserAccount.getAccounts();
		AdminAccount[] adminAccounts = AdminAccount.getAccounts();
		
		LoginTest(userAccounts, adminAccounts);
	}
	public static void MessagingTest(UserAccount[] userAccounts,AdminAccount[] adminAccounts) {
		try {
			MessagingService.sendMessageToUser(userAccounts[0], userAccounts[1], "Hannah", "She's a psychotic Bitch!");
			MessagingService.sendMessageToUser(userAccounts[0], userAccounts[1], "Bandit", "Fuck him too!! They're both insane!!");
		} catch (AppGenericException e) {
			e.printStackTrace();
		}
		
		for (Account u : userAccounts) {
			MessagingService.printAllMessages(u);
		}
	}
	public static void BuddyListTest(UserAccount[] userAccounts,AdminAccount[] adminAccounts) {
		//userAccounts[0].setBanned(true);
		try {
			BuddyListService.addUserToBuddyList(userAccounts[0], adminAccounts[0]);
			userAccounts[0].getBuddyList().get(0).setUsername("Yuge Asshole");
			BuddyListService.addUserToBuddyList(userAccounts[0], userAccounts[1]);
			BuddyListService.addUserToBuddyList(userAccounts[0], userAccounts[1]);
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
			LoginService.login(userAccounts[0], "poop");
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
//			LoginService.login(adminAccounts[0], "poop");
//		} catch (AppGenericException e) {
//			e.printStackTrace();
//		}
		
		for (UserAccount u : userAccounts) {
			System.out.println(u.getUsername() + ": " + u.getLoginAttempts());
		}
	}
}











