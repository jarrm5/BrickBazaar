package com.jarrm5.model;

import java.util.Iterator;
import java.util.Stack;

public class MessageString {
	
	private Stack<Message> messageString;

	public MessageString() {
		messageString = new Stack<Message>();
	}
	
	public Stack<Message> getMessageString() {
		return messageString;
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
