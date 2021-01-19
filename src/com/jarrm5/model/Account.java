package com.jarrm5.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

import com.jarrm5.util.MessagingService;
import com.jarrm5.model.Message;

public abstract class Account implements Cloneable{
	
	private static int NUMBER_OF_ACCOUNTS = 0;
	
	private int accountNumber;
	private int loginAttempts;
	private String username;
	private String password;
	private ArrayList<MessageString> conversation;
	private LocalDateTime createdDateTime;
	
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
	public ArrayList<MessageString> getConversation() {
		return conversation;
	}
	public void setConversation(ArrayList<MessageString> inbox) {
		this.conversation = inbox;
	}
	public static int getNumberOfAccounts(){
		return NUMBER_OF_ACCOUNTS;
	}
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}
	
	protected Account(String username, String password) {
		this.conversation = new ArrayList<MessageString>(MessagingService.MAX_NUMBER_OF_MESSAGES_STRINGS);
		this.accountNumber = ++NUMBER_OF_ACCOUNTS;
		this.loginAttempts = 0;
		this.username = username;
		this.password = password;
		this.createdDateTime = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		return "Username: " + this.username + "\nCreated: " + createdDateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a"));
	}
	@Override
	public boolean equals(Object other) {
		Account toCompare = (Account)other;
		return this.accountNumber == toCompare.accountNumber;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		Account clonedAccount = (Account)super.clone();
		clonedAccount.conversation = (ArrayList<MessageString>)this.conversation.clone();
		clonedAccount.accountNumber = ++NUMBER_OF_ACCOUNTS;
		clonedAccount.createdDateTime = LocalDateTime.now();
		return clonedAccount;
	}
}

