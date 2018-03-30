package net.aspecter.easygui.events;

import net.aspecter.easygui.util.GUIEvent;
import org.bukkit.inventory.Inventory;

public class EventData {

	private String event;
	private GUIEvent guiEvent;

	public EventData(String event, GUIEvent guiEvent) {
		this.event = event;
		this.guiEvent = guiEvent;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public GUIEvent getGuiEvent() {
		return guiEvent;
	}

	public void setGuiEvent(GUIEvent guiEvent) {
		this.guiEvent = guiEvent;
	}

}
