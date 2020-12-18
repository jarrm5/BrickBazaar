package com.jarrm5.util;

import com.jarrm5.model.Account;
import com.jarrm5.exception.AppGenericException;
import com.jarrm5.exception.MessagingException;
import com.jarrm5.exception.AppGenericException.ErrorReason;
import com.jarrm5.exception.AccountException;
import com.jarrm5.exception.UserAccountException;
import com.jarrm5.model.Message;
import com.jarrm5.model.UserAccount;

public class MessagingService  {
	
	//add reply function to maintain same subject and create a thread of messages
	//break inbox into inbox between account users; and an inbox for between account user and admin user
	public final static int MAX_NUMBER_OF_MESSAGES = 1;
	
	public static boolean sendMessageToUser(Account sender, Account recipient, String subject, String message) throws AppGenericException {
		
		Message toSend = new Message(recipient,sender,subject,message);
		
		if (sender instanceof UserAccount && ((UserAccount) sender).isBanned()) {
			throw new UserAccountException(ErrorReason.USER_BANNED,(UserAccount)sender);
		}
		else if(recipient.getInbox().size() >= MAX_NUMBER_OF_MESSAGES) {
			throw new AccountException(ErrorReason.INBOX_FULL, recipient);
		}
		else if(message.length() > Message.MAX_MESSAGE_LENGTH) {
			throw new MessagingException(ErrorReason.MESSAGE_LENGTH_EXCEEDED, toSend);
		}
		recipient.getInbox().add(toSend);
		return true;	
	}
	
	public static void printAllMessages(Account account) {
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
}
