package com.jarrm5.util;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.jarrm5.model.Account;
import com.jarrm5.model.AdminAccount;
import com.jarrm5.model.UserAccount;
import com.jarrm5.model.Message;

public class SearchingService {
	
	//AdminAccounts get shallow copies so they can manipulate the UserAccount; but they should get read only rights with respect to other admin accounts 
	//UserAccounts get deep copies since they have read only rights with respect to any other accounts
	public static ArrayList<Account> getAccountsWithPredicate(Account searcher, Account[] accounts, Predicate<Account> tester){
		
		ArrayList<Account> result = new ArrayList<Account>();
		
		for (Account acc : accounts) {
			if(searcher instanceof AdminAccount && accounts instanceof UserAccount[] && tester.test(acc)) {
				result.add(acc);
			}
			else if(tester.test(acc)) {
				try {
					result.add((Account)acc.clone());
				} catch (CloneNotSupportedException e) {
					System.out.println(e.getStackTrace());
				}
			}
		}
		return result;
	}
	/*public static ArrayList<Message> getMessagesWithPredicate(Account searcher, Predicate<Message> tester){
		ArrayList<Message> result = new ArrayList<Message>();
		for (Message m : searcher.getInbox()) {
			if(tester.test(m)) {
				result.add(m);
			}
		}
		return result;
	}*/
	public static <X, Y> ArrayList<Y> searchElements(Iterable<X> source,Consumer<Y> block,Predicate<X> tester,Function<X,Y> mapper){
		ArrayList<Y> result = new ArrayList<Y>();
		for (X x : source) {
			if (tester.test(x)) {
				Y data = mapper.apply(x);
				block.accept(data);
			}
		}
		return result;
	}
}
