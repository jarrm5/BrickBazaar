package com.jarrm5.util;

import java.util.ArrayList;
import java.util.Comparator;
import com.jarrm5.model.Account;
import com.jarrm5.exception.AppGenericException;
import com.jarrm5.exception.MessagingException;
import com.jarrm5.constant.ErrorReason;
import com.jarrm5.exception.AccountException;
import com.jarrm5.exception.UserAccountException;
import com.jarrm5.model.Message;
import com.jarrm5.model.MessageString;
import com.jarrm5.model.UserAccount;

public class MessagingService {
	
	public final static int MAX_NUMBER_OF_MESSAGES_STRINGS = 5;
	
	public static void sendMessage(MessageString msgString, Account sender, Account recipient, String subject, String message) throws AppGenericException{
		
		Message toSend = new Message(recipient,sender,subject,message);
		
		try {
			validateSendMessage(toSend);
		}
		catch(AppGenericException error) {
			throw error;
		}
		
		//This is a new thread of messages
		if(msgString == null) {
			
			MessageString newMsgString = new MessageString();
			newMsgString.getMessageString().push(toSend);
			recipient.getConversation().add(newMsgString);
		}
		//This is an existing thread of messages (reply)
		else {
			msgString.getMessageString().push(toSend);
			if(!recipient.getConversation().contains(msgString)) {
				recipient.getConversation().add(msgString);
			}
		}
	}
	
	private static void validateSendMessage(Message message) throws AppGenericException {
		if (message.getSender() instanceof UserAccount && ((UserAccount) message.getSender()).isBanned()) {
			throw new UserAccountException(ErrorReason.USER_BANNED,(UserAccount)message.getSender());
		}
		else if(message.getRecipient().getConversation().size() >= MAX_NUMBER_OF_MESSAGES_STRINGS) {
			throw new AccountException(ErrorReason.INBOX_FULL, message.getRecipient());
		}
		else if(message.getMessage().length() > Message.MAX_MESSAGE_LENGTH) {
			throw new MessagingException(ErrorReason.MESSAGE_LENGTH_EXCEEDED, message);
		}
	}
	
	
	static class MessageSortUtil implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			Message m1 = (Message)o1;
			Message m2 = (Message)o2;
			return m1.getSender().getUsername().compareToIgnoreCase(m2.getSender().getUsername());
		}
		
	}
}
