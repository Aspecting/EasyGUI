package net.aspecter.easygui.listeners;

import net.aspecter.easygui.handlers.EasyGUIHandler;
import net.aspecter.easygui.util.ItemInvokeData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class InventoryEventListener implements Listener {

	private EasyGUIHandler handler;
	private Plugin plugin;
	private List<ItemInvokeData> invokeList;
	private Player player;
	private Inventory inventory;

	public InventoryEventListener(EasyGUIHandler handler, Plugin plugin, List<ItemInvokeData> invokeList, Player player, Inventory inventory) {
		this.handler = handler;
		this.plugin = plugin;
		this.invokeList = invokeList;
		this.player = player;
		this.inventory = inventory;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent ice) {
		if(ice.getInventory().equals(inventory) && ice.getWhoClicked().getUniqueId() == player.getUniqueId()) {
			if(ice.getCurrentItem() == null) {
				ice.setCancelled(true);
				return;
			}
			ice.setCancelled(true);
			for(ItemInvokeData data : invokeList) {
				if (data.equalsItem(ice.getCurrentItem())) {
					ice.getWhoClicked().closeInventory();
					handler.invokeEvent(data.getInvokes(), plugin.getServer().getPlayer(ice.getWhoClicked().getUniqueId()));
				}
			}
		}
	}

	@EventHandler
	public void onInventoryClose(InventoryCloseEvent ice) {
		if(ice.getInventory().equals(inventory) && player.getUniqueId() == ice.getPlayer().getUniqueId())
			HandlerList.unregisterAll(this);
	}

}
