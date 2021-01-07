package com.jarrm5.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Message {
	
	public final static int MAX_MESSAGE_LENGTH = 255;
	
	private LocalDateTime time;
	private Account recipient;
	private Account sender;
	private String subject;
	private String message;
	
	public LocalDateTime getTime() {
		return time;
	}
//	public void setTime(LocalDateTime time) {
//		this.time = time;
//	}
	public Account getRecipient() {
		return recipient;
	}
//	public void setRecipient(Account recipient) {
//		this.recipient = recipient;
//	}
	public Account getSender() {
		return sender;
	}
//	public void setSender(Account sender) {
//		this.sender = sender;
//	}
	public String getSubject() {
		return subject;
	}
//	public void setSubject(String subject) {
//		this.subject = subject;
//	}
	public String getMessage() {
		return message;
	}
//	public void setMessage(String message) {
//		this.message = message;
//	}
	
	public Message(Account recipient, Account sender, String message) {
		this(recipient,sender,null,message);
	}
	public Message(Account recipient, Account sender, String subject, String message) {
		this.time = LocalDateTime.now();
		this.recipient = recipient;
		this.sender = sender;
		this.message = message;
		this.subject = subject == null ? "<No subject provided>" : subject;
	}
	public String getFormattedDate() {
		return time.format(DateTimeFormatter.ofPattern("EEE MMM dd, yyyy"));
	}
	public String getFormattedTime() {
		return time.format(DateTimeFormatter.ofPattern("h:mma"));
	}
	@Override
	public String toString() {
		return getFormattedDate() + " " + getFormattedTime() +
			   "\nTo: " + this.recipient.getUsername() + 
			   "\nFrom: " + this.sender.getUsername() +
			   "\nSubject: " + this.subject + 
			   "\n" + this.message;
	}
}
