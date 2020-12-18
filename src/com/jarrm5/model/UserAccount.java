package com.jarrm5.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import com.jarrm5.util.BuddyListService;

public class UserAccount extends Account implements Cloneable{
	
	private static int NUMBER_OF_USER_ACCOUNTS = 0;
	
	//Add inner class for email regex validation DONE
	//12/21/19: add clone method : Need to deep copy everything; but don't increment Useraccount's class count and Account's class count DONE
	//for cloning: LocalDate does not implement cloneable; might need a wrapper class.. can create wrapper package if other wrappers are needed - Not needed
	//Convert Buddy list to an array? NO
	//Create BuddyList service with add/delete/update(block/ignore) operations
	//When we want to retrieve information about an account on the buddylist, we want a copy of the account returned; not the actual object so it can't be modified
	
	public enum Gender{
		MALE,FEMALE;
	}
	
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
//	public int getBuddyListSize() {
//		return buddyList.size();
//	}
//	public UserAccount getBuddyFromList(int index) {
//		try {
//			return (UserAccount)buddyList.get(index).clone();
//		} catch (CloneNotSupportedException e) {
//			// TODO: handle exception
//			return null;
//		}
//		
//	}
	
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
	
	public static UserAccount[] getAccounts() {
		return new UserAccount[] { 
				new UserAccount("7StringsOfWonder","password1","Jake","Bowen","JB123@gmail.com",LocalDate.of(1985, 6, 15),Gender.MALE),
				new UserAccount("Big Dick Tom","password1","Tom","Murphy","the69thpiimp@snowboard.com",LocalDate.of(1983,1, 10),Gender.MALE),
				new UserAccount("ridicPipes","password1","Spencer","Sotello","brogmail.com",LocalDate.of(1986,11, 21),Gender.MALE),
				new UserAccount("Bulbous","password1","Misha","Mansoor","abc123",LocalDate.of(1984,3,31),Gender.MALE),
				new UserAccount("ArmsOfSteel","password1","Alex","Bois",null,LocalDate.of(1985,7,7),Gender.MALE),
				new UserAccount("VneckGuy4u","password1","Matt","Halpem",null,LocalDate.of(1985,9,30),Gender.MALE)
		};
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
			UserAccount toCompare = (UserAccount) other;
			return super.equals((Account) other) && this.userAccountNumber == toCompare.userAccountNumber;
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

