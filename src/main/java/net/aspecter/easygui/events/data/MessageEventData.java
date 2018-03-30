package net.aspecter.easygui.events.data;

import net.aspecter.easygui.events.EventData;

public class MessageEventData extends EventData {
	private String message;

	public MessageEventData(String event, String message) {
		super(event, (eventName, player) -> player.sendMessage(message));
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
