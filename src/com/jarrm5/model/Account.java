package com.jarrm5.model;

import java.util.ArrayList;
import com.jarrm5.util.MessagingService;
import com.jarrm5.model.Message;

public abstract class Account implements Cloneable{
	
	private static int NUMBER_OF_ACCOUNTS = 0;
	
	private int accountNumber;
	private int loginAttempts;
	private String username;
	private String password;
	private ArrayList<Message> inbox;
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public String getUsername() {
		return username;
	}
	public int getLoginAttempts() {
		return loginAttempts;
	}
	public String getPassword() {
		return password;
	}
	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Message> getInbox() {
		return inbox;
	}
	public static int getNumberOfAccounts(){
		return NUMBER_OF_ACCOUNTS;
	}

	public Account(String username, String password) {
		this.inbox = new ArrayList<Message>(MessagingService.MAX_NUMBER_OF_MESSAGES);
		this.accountNumber = ++NUMBER_OF_ACCOUNTS;
		this.loginAttempts = 0;
		this.username = username;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "\nUsername: " + this.username;
	}
	@Override
	public boolean equals(Object other) {
		Account toCompare = (Account)other;
		return this.accountNumber == toCompare.accountNumber;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		Account clonedAccount = (Account)super.clone();
		clonedAccount.inbox = (ArrayList<Message>)this.inbox.clone();
		clonedAccount.accountNumber = ++NUMBER_OF_ACCOUNTS;
		return clonedAccount;
	}
	
}
