package com.jarrm5.model;

import java.util.ArrayList;

public class AdminAccount extends Account implements Cloneable{
	
	private static int NUMBER_OF_ADMIN_ACCOUNTS = 0;
	
	private int adminAccountNumber;
	private int numberOfBans;

	public int getAdminAccountNumber() {
		return adminAccountNumber;
	}
	public int getNumberOfBans() {
		return numberOfBans;
	}
	public void setNumberOfBans(int numberOfBans) {
		this.numberOfBans = numberOfBans;
	}
	
	private AdminAccount(String username, String password,int adminAccountNumber,int numberOfBans) {
		super(username,password);
		this.adminAccountNumber = adminAccountNumber;
		this.numberOfBans = numberOfBans;
	}
	//creating new admin acc - increments account numbers and starts logins/bans = 0
	public AdminAccount(String username, String password) {
		this(username, password,++NUMBER_OF_ADMIN_ACCOUNTS,0);
	}
	
	public static ArrayList<AdminAccount> getAccounts() {
		ArrayList<AdminAccount> accounts = new ArrayList<AdminAccount>();
		accounts.add(new AdminAccount("Nicodemus","password1"));
		accounts.add(new AdminAccount("Tryclops","password1"));
		return accounts;
	}
	
	@Override
	public String toString() {
		return super.toString() + 
			   "\nNumber of bans: " + this.numberOfBans;
	}
	@Override
	public boolean equals(Object other) {
		try {
			//AdminAccount toCompare = (AdminAccount) other;
			//return super.equals((Account) other) && this.adminAccountNumber == toCompare.adminAccountNumber;
			return super.equals((Account) other);
		}
		catch(ClassCastException err) {
			System.out.println(err.getMessage());
		}
		return false;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		AdminAccount adminAccount = (AdminAccount)super.clone();
		adminAccount.adminAccountNumber = ++NUMBER_OF_ADMIN_ACCOUNTS;
		return adminAccount;
	}
}
