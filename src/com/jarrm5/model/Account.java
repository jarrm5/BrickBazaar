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
	private ArrayList<MessageString> inbox;
	//private ArrayList<MessageString> sentMessages;
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
	public ArrayList<MessageString> getInbox() {
		return inbox;
	}
	/*public ArrayList<MessageString> getSentMessages() {
		return sentMessages;
	}*/
	public void setInbox(ArrayList<MessageString> inbox) {
		this.inbox = inbox;
	}
	public static int getNumberOfAccounts(){
		return NUMBER_OF_ACCOUNTS;
	}
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}
	/*public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}*/
	
	protected Account(String username, String password) {
		this.inbox = new ArrayList<MessageString>(MessagingService.MAX_NUMBER_OF_MESSAGES_STRINGS);
		//this.sentMessages = new ArrayList<MessageString>(MessagingService.MAX_NUMBER_OF_MESSAGES_STRINGS);
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
		clonedAccount.inbox = (ArrayList<MessageString>)this.inbox.clone();
		//clonedAccount.sentMessages = (ArrayList<MessageString>)this.sentMessages.clone();
		clonedAccount.accountNumber = ++NUMBER_OF_ACCOUNTS;
		clonedAccount.createdDateTime = LocalDateTime.now();
		return clonedAccount;
	}
}

