package com.jarrm5.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import com.jarrm5.exception.AdminAccountException;
import com.jarrm5.exception.AppGenericException;
import com.jarrm5.model.Account;
import com.jarrm5.model.AdminAccount;
import com.jarrm5.model.ItemListing;
import com.jarrm5.model.Message;
import com.jarrm5.model.MessageString;
import com.jarrm5.model.PartItem;
import com.jarrm5.model.SetItem;
import com.jarrm5.model.UserAccount;
import com.jarrm5.constant.Gender;
import com.jarrm5.util.MessagingService;

public class App {
	//Added a comment
	public static void main(String[] args) {
		ArrayList<UserAccount> userAccounts = UserAccount.getAccounts();
		ArrayList<AdminAccount> adminAccounts = AdminAccount.getAccounts();
		//BuddyListTest(userAccounts,adminAccounts);
		//MessagingTest(userAccounts, adminAccounts);
		//SearchingServiceTest(userAccounts,adminAccounts);
		//ArrayList<SetItem> items = SetItem.getSetItems();
		//items.forEach(i -> System.out.println(i));
		//ArrayList<ItemListing> listings = ItemListing.getItemListings();
		//listings.forEach(l -> System.out.println(l));
		//ArrayList<PartItem> partItems = PartItem.getPartItems();
		//partItems.forEach(p -> System.out.println(p));
		itemTest();
	}
	public static void MessagingTest(ArrayList<UserAccount> userAccounts,ArrayList<AdminAccount> adminAccounts) {
		try {
			//MessagingService.sendMessage(userAccounts.get(0), userAccounts.get(1), null, "Testing message service");
			MessagingService.sendMessage(null,userAccounts.get(0),userAccounts.get(1),null,"Hi, how is bitcoin looking today?");
			MessagingService.sendMessage(null,userAccounts.get(0),userAccounts.get(1),"Another Question","Also, What will we be talking about today?");
			//AdminService.banUser(adminAccounts.get(0), userAccounts.get(0));
			MessagingService.sendMessage(userAccounts.get(1).getConversation().get(0),userAccounts.get(1),userAccounts.get(0),userAccounts.get(1).getConversation().get(0).getMessageString().peek().getSubject(),"Bitcoin is up big today ($37k)");
			MessagingService.sendMessage(userAccounts.get(0).getConversation().get(0),userAccounts.get(0),userAccounts.get(1),userAccounts.get(0).getConversation().get(0).getMessageString().peek().getSubject(),"Thanks for the heads up!");
			MessagingService.sendMessage(userAccounts.get(1).getConversation().get(1),userAccounts.get(1),userAccounts.get(0),userAccounts.get(1).getConversation().get(1).getMessageString().peek().getSubject(),"Ethereum is also up big");
			MessagingService.sendMessage(userAccounts.get(0).getConversation().get(1),userAccounts.get(0),userAccounts.get(1),userAccounts.get(0).getConversation().get(0).getMessageString().peek().getSubject(),"Yes almost $2k!");			
			MessagingService.sendMessage(userAccounts.get(1).getConversation().get(1),userAccounts.get(1),userAccounts.get(0),userAccounts.get(1).getConversation().get(1).getMessageString().peek().getSubject(), "I guess we better HODL!");
			
			//Lambda that sends a message to a user whose birthday is today from a friendly admin
			SearchingService.searchElementsGenericAndProcess(userAccounts,
				u -> ((UserAccount) u).getBirthday().getDayOfMonth() ==  LocalDate.now().getDayOfMonth() && 
					 ((UserAccount) u).getBirthday().getMonthValue() == LocalDate.now().getMonthValue(), 
				u -> {
					try {
						MessagingService.sendMessage(null,adminAccounts.get(0), u, "Happy " + u.getAge() + " birthday!", "Sincerely, " + adminAccounts.get(0).getUsername());
					} catch (AppGenericException e) {
						e.printStackTrace();
					}
				});
			//Lambda that searches UserAccounts inboxes for "bitcoin"
			userAccounts.forEach(u -> u.getConversation().forEach(ms -> {
				SearchingService.searchElementsGenericAndProcess(ms.getMessageString(), 
				m -> m.getMessage().toLowerCase().contains("bitcoin"), 
				m -> System.out.println(m));
			}));
			
		} catch (AppGenericException e) {
			e.printStackTrace();
		}
		
	}
	public static void BuddyListTest(ArrayList<UserAccount> userAccounts,ArrayList<AdminAccount> adminAccounts) {
		try {
			BuddyListService.addUserToBuddyList(userAccounts.get(0), adminAccounts.get(0));
			BuddyListService.addUserToBuddyList(userAccounts.get(0), userAccounts.get(1));
			BuddyListService.addUserToBuddyList(userAccounts.get(0), userAccounts.get(2));
			BuddyListService.addUserToBuddyList(userAccounts.get(0), adminAccounts.get(1));
			BuddyListService.addUserToBuddyList(userAccounts.get(0), adminAccounts.get(1));
			BuddyListService.sortBuddyListByUsername(userAccounts.get(0).getBuddyList());
			BuddyListService.printAllBuddies(userAccounts.get(0));
		} catch (AppGenericException e) {
			e.printStackTrace();
		}
	}
	public static void LoginTest(ArrayList<UserAccount> userAccounts,ArrayList<AdminAccount> adminAccounts) {
		//userAccounts.get(0).setBanned(true);
		try {
			LoginService.login(userAccounts.get(0), "asfas");
		} catch (AppGenericException e) {
			e.printStackTrace();
		}
		try {
			LoginService.login(userAccounts.get(0), "password1");
		} catch (AppGenericException e) {
			e.printStackTrace();
		}
//		try {
//			LoginService.login(userAccounts.get(0), "password1");
//		} catch (AppGenericException e) {
//			e.printStackTrace();
//		}
//		try {
//			LoginService.login(adminAccounts.get(0), "asdfas");
//		} catch (AppGenericException e) {
//			e.printStackTrace();
//		}
		
		for (UserAccount u : userAccounts) {
			System.out.println(u.getUsername() + ": " + u.getLoginAttempts());
		}
	}
	public static void SearchingServiceTest(ArrayList<UserAccount> userAccounts,ArrayList<AdminAccount> adminAccounts) {
		ArrayList<UserAccount> adminSearchResults = SearchingService.getUserAccountsWithPredicate(adminAccounts.get(0), userAccounts, 
				(UserAccount acc) -> acc.getGender() == Gender.FEMALE);
		ArrayList<UserAccount> userSearchResults = SearchingService.getUserAccountsWithPredicate(userAccounts.get(0), userAccounts, 
				(UserAccount acc) -> { 
					return acc.getEmail() != null && acc.getEmail().endsWith("protonmail.com");
				});
		//Demonstrates UserAccounts doing the searching get deep copies UserAccounts
		userSearchResults.get(0).setBanned(true);
		
		try {
			//Demonstrates AdminAccounts doing the searching get a shallow copy of UserAccounts
			AdminService.banUser(adminAccounts.get(0), adminSearchResults.get(0));
		} catch (AppGenericException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void itemTest() {
		
	}
}











