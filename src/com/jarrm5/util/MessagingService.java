package com.jarrm5.util;

import java.util.ArrayList;
import java.util.Comparator;
import com.jarrm5.model.Account;
import com.jarrm5.exception.AppGenericException;
import com.jarrm5.exception.MessagingException;
import com.jarrm5.exception.AppGenericException.ErrorReason;
import com.jarrm5.exception.AccountException;
import com.jarrm5.exception.UserAccountException;
import com.jarrm5.model.Message;
import com.jarrm5.model.MessageString;
import com.jarrm5.model.UserAccount;

public class MessagingService {
	
	//add reply function to maintain same subject and create a thread of messages
	//break inbox into inbox between account users; and an inbox for between account user and admin user
	public final static int MAX_NUMBER_OF_MESSAGES_STRINGS = 5;
	
	//Used to create a new MessageString (conversation) between users
	public static void sendMessage(Account sender, Account recipient, String subject, String message) throws AppGenericException {	
		Message toSend = new Message(recipient,sender,subject,message);
		try {
			validateSendMessage(toSend);
		}
		catch(AppGenericException error) {
			throw error;
		}
		MessageString newMsgString = new MessageString();
		newMsgString.getMessageString().push(toSend);
		recipient.getInbox().add(newMsgString);
	}
	
	//Used to reply to an existing message in a MessageString
	public static void sendMessage(MessageString msgString,Account sender, Account recipient, String message) throws AppGenericException{
		Message toSend = new Message(recipient,sender,msgString.getMessageString().peek().getSubject(),message);
		
		try {
			validateSendMessage(toSend);
		}
		catch(AppGenericException error) {
			throw error;
		}
		
		msgString.getMessageString().push(toSend);
		
		if(!recipient.getInbox().contains(msgString)) {
			recipient.getInbox().add(msgString);
		}
	}
	
	private static void validateSendMessage(Message message) throws AppGenericException {
		if (message.getSender() instanceof UserAccount && ((UserAccount) message.getSender()).isBanned()) {
			throw new UserAccountException(ErrorReason.USER_BANNED,(UserAccount)message.getSender());
		}
		else if(message.getRecipient().getInbox().size() >= MAX_NUMBER_OF_MESSAGES_STRINGS) {
			throw new AccountException(ErrorReason.INBOX_FULL, message.getRecipient());
		}
		else if(message.getMessage().length() > Message.MAX_MESSAGE_LENGTH) {
			throw new MessagingException(ErrorReason.MESSAGE_LENGTH_EXCEEDED, message);
		}
	}
	
	/*public static void printMessages(Account account) {
		if (!account.getInbox().isEmpty()) {
			System.out.println("Inbox messages for user " + account.getUsername());
			for (Message message : account.getInbox()) {
				System.out.println(message + "\n");
			}
		}
		else {
			System.out.println("Inbox empty for " + account.getUsername());
		}
	}
	
	public static ArrayList<Message> getMessagesByAccount(Account account, Account target){
		ArrayList<Message> result = new ArrayList<Message>();
		for (Message message : account.getInbox()) {
			if (message.getSender().getUsername().equals(target.getUsername())) result.add(message);
		}
		return result;
	}*/
	
	static class MessageSortUtil implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			Message m1 = (Message)o1;
			Message m2 = (Message)o2;
			return m1.getSender().getUsername().compareToIgnoreCase(m2.getSender().getUsername());
		}
		
	}
}
