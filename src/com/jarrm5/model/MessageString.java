package com.jarrm5.model;

import java.util.Iterator;
import java.util.Stack;

public class MessageString implements Cloneable {
	
	private Stack<Message> messageString;

	public MessageString() {
		messageString = new Stack<Message>();
	}
	
	public Stack<Message> getMessageString() {
		return messageString;
	}
	
	

	@Override
	protected Object clone() throws CloneNotSupportedException {
		MessageString msgStr = (MessageString)super.clone();
		msgStr.messageString = (Stack<Message>)this.messageString.clone();
		return msgStr;
	}
	
	public MessageString getMessageStringClone() {
		try {
			return (MessageString) this.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String toString() {
		String output = "";
		Iterator value = this.messageString.iterator();
		if(!this.messageString.empty()) {
			while(value.hasNext()) output += ("\n"+ value.next());
		}
		else output = "Message String empty";
		return output;
	}
}
