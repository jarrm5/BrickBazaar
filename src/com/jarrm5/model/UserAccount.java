package com.jarrm5.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.jarrm5.constant.Gender;
import com.jarrm5.util.BuddyListService;

public class UserAccount extends Account implements Cloneable{
	
	private static int NUMBER_OF_USER_ACCOUNTS = 0;
	
	//Add inner class for email regex validation DONE
	//12/21/19: add clone method : Need to deep copy everything; but don't increment Useraccount's class count and Account's class count DONE
	//for cloning: LocalDate does not implement cloneable; might need a wrapper class.. can create wrapper package if other wrappers are needed - Not needed
	//Convert Buddy list to an array? NO
	//Create BuddyList service with add/delete/update(block/ignore) operations
	//When we want to retrieve information about an account on the buddylist, we want a copy of the account returned; not the actual object so it can't be modified
	
	private int userAccountNumber;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate birthday;
	private boolean isBanned;
	private Gender gender;
	private ArrayList<Account> buddyList;
	
	public int getUserAccountNumber() {
		return this.userAccountNumber;
	}
	public void setAccountNumber(int userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = EmailValidator.validate(email) ? email : null;
	}
	public LocalDate getBirthday() {
		return this.birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public boolean isBanned() {
		return isBanned;
	}
	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}
	public Gender getGender() {
		return this.gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public ArrayList<Account> getBuddyList() {
		return buddyList;
	}
	public void setBuddyList(ArrayList<Account> buddyList) {
		this.buddyList = buddyList;
	}
	public int getAge() {
		return Period.between(this.birthday,LocalDate.now()).getYears();
	}
	
	public UserAccount(String username, String password,String firstName, String lastName,String email,LocalDate birthday,Gender gender) {
		super(username, password);
		this.userAccountNumber = ++NUMBER_OF_USER_ACCOUNTS;
		this.firstName = firstName;
		this.lastName = lastName;
		setEmail(email);
		this.birthday = birthday;
		this.isBanned = false;
		this.gender = gender;
		this.buddyList = new ArrayList<Account>(BuddyListService.MAX_NUMBER_OF_BUDDIES);
	}
	
	public static ArrayList<UserAccount> getAccounts() {
		ArrayList<UserAccount> users = new ArrayList<UserAccount>();
		users.add(new UserAccount("jrinella","password1","James","Rinella","ultimatemanlet66207@protonmail.com",LocalDate.of(1989,1,10),Gender.MALE));
		users.add(new UserAccount("sevans","password1","Sheldon","Evans","sevans@gmail.com",LocalDate.of(1996,11, 11),Gender.MALE));
		users.add(new UserAccount("Crypto Casey","password1","Casey","Leigh","cryptocasey@yahoo.com",LocalDate.of(1989,1,14),Gender.FEMALE));
		users.add(new UserAccount("Styxhexhammer666","password1","Tarl","Warwick","Styxhexhammer666@protonmail.com",LocalDate.of(1989,7,29),Gender.MALE));
		users.add(new UserAccount("Victor 135","password1","Victor","Ginsburg",null,LocalDate.of(1996,7,7),Gender.MALE));
		users.add(new UserAccount("Welshers","password1","Duncan","Ramsey",null,LocalDate.of(1988,10,31),Gender.MALE));
		users.add(new UserAccount("mswan","password1","Meg","Swan",null,LocalDate.of(1970,10,11),Gender.FEMALE));
		return users;
	}
	
	
	
	@Override
	public String toString() {
		String gender = null;
		switch (this.gender) {
		case MALE:
			gender = "Male";
			break;
		case FEMALE:
			gender = "Female";
			break;
		default:
			break;
		}
		return super.toString() + 
			   "\nName: " + this.firstName + " " + this.lastName + 
			   "\nEmail: " + this.email +
			   "\nBirthday: " + this.birthday.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) + " (" + this.getAge() + " yrs old)" + 
			   "\nBanned: " + this.isBanned + 
			   "\nGender: " + gender; 
	}
	
	
	@Override
	public boolean equals(Object other) {
		try {
			//UserAccount toCompare = (UserAccount) other;
			//return super.equals((Account) other) && this.userAccountNumber == toCompare.userAccountNumber;
			return super.equals((Account) other);
		}
		catch(ClassCastException err) {
			System.out.println(err.getMessage());
		}
		return false;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		UserAccount userAccount = (UserAccount)super.clone();
		userAccount.buddyList = (ArrayList<Account>)this.buddyList.clone();
		userAccount.userAccountNumber = ++NUMBER_OF_USER_ACCOUNTS;
		return userAccount;
	}
	private static class EmailValidator{
		private final static String EMAIL_PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
		
		private static boolean validate(String email) {
			return email == null ? false : email.toLowerCase().matches(EMAIL_PATTERN);
		}
	}
}

