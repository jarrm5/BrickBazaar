package com.jarrm5.util;

import java.lang.Boolean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.jarrm5.model.Account;
import com.jarrm5.model.AdminAccount;
import com.jarrm5.model.UserAccount;
import com.jarrm5.model.Message;
import com.jarrm5.model.MessageString;

public class SearchingService {
	
	//AdminAccounts get shallow copies so they can manipulate the UserAccount; but they should get read only rights with respect to other admin accounts 
	//UserAccounts get deep copies since they have read only rights with respect to any other accounts
	public static ArrayList<UserAccount> getUserAccountsWithPredicate(Account searcher, ArrayList<UserAccount> accounts, Predicate<UserAccount> tester){
		
		ArrayList<UserAccount> result = new ArrayList<UserAccount>();
		
		for (UserAccount acc : accounts) {
			//if(searcher instanceof AdminAccount && accounts instanceof UserAccount[] && tester.test(acc)) {
			if(searcher instanceof AdminAccount && tester.test(acc)) {
				result.add(acc);
			}
			else if(tester.test(acc)) {
				try {
					result.add((UserAccount)acc.clone());
				} catch (CloneNotSupportedException e) {
					System.out.println(e.getStackTrace());
				}
			}
		}
		return result;
	}
	
	//Search the inbox of MessageString for a keyword in the subject line.  Return MessageStrings that match and print the conversation
	/*public static void getMessagesWithPredicate(Account searcher,Predicate<Message> tester, Consumer<Message> action){
		for (MessageString ms : searcher.getInbox()) {
			for(Iterator<Message> m = ms.getMessageString().iterator(); m.hasNext();) {
				Message msg = (Message) m.next();
				if(tester.test(msg)) {
					action.accept(msg);
				}
			}
		}
	}*/
	//Generic method to search a list using some test expression, then perform an action on it
	public static <T,Boolean> void searchElementsGenericAndProcess(Iterable<T> source,Function<T,Boolean> function,Consumer<T> block){
		
		for (T t : source) {
			if(function.apply(t) == java.lang.Boolean.TRUE) block.accept(t);
		}
	}
}
