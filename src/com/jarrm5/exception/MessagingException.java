package com.jarrm5.exception;

import com.jarrm5.model.Message;

public class MessagingException extends AppGenericException {
	
	public MessagingException(ErrorReason reason,Message message) {
		super(reason,message);
	}
	
	@Override
	public String toString() {
		Message message = (Message) offender;
		String errorReasonStr = "Messaging Error occurred: ";
		
		switch(this.errorReason) {
			case MESSAGE_LENGTH_EXCEEDED:
				errorReasonStr += "Message is " + ((message.getMessage().length() - Message.MAX_MESSAGE_LENGTH)) + " characters too long.";
				break;
			default:
				errorReasonStr = "";
				break;
		
		}
		return errorReasonStr;
	}
//	public enum ErrorReason{
//		MESSAGE_LENGTH_EXCEEDED;
//	}
}
