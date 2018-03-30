package net.aspecter.easygui.events.data;

import net.aspecter.easygui.events.EventData;
import net.aspecter.easygui.listeners.InventoryEventListener;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryEventData extends EventData {

	private Inventory inventory;

	public InventoryEventData(String event, Inventory inventory) {
		super(event, (eventName, player) -> player.openInventory(inventory));
		this.inventory = inventory;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

}
