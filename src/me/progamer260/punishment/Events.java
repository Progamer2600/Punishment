package me.progamer260.punishment;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener {
	public ArrayList<Player> muted = new ArrayList<Player>();
	public ArrayList<Player> banned = new ArrayList<Player>();
	public Player player;

	@EventHandler
	public void onClick(InventoryClickEvent e) {

		Inventory open = e.getClickedInventory();
		ItemStack stack = e.getCurrentItem();

		player = (Player) e.getWhoClicked();
		if (open.getName().equals(ChatColor.BOLD + "" + ChatColor.BLUE + "Punishment")) {
			e.setCancelled(true);

			if (stack.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Kick")) {
				player.kickPlayer(null);
			}

			if (stack.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Mute")) {
				player.sendMessage(ChatColor.GOLD + "Player has been muted!");
				muted.add(player);
			}
			if (stack.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Un-Mute")) {
				player.sendMessage(ChatColor.GOLD + "Player has been un-muted!");
				muted.remove(player);
			}
			if (stack.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Ban")) {
				banned.add(player);
				if (banned.contains(player)) {
					player.kickPlayer(ChatColor.GOLD + "Banned by an Administrator");
					player.isBanned();

				}
			}
		}

	}

	@EventHandler
	public void muteChat(AsyncPlayerChatEvent event) {
		player = event.getPlayer();
		if (muted.contains(player)) {
			event.setCancelled(true);
		} else {
			event.setCancelled(false);
		}
	}

	@EventHandler
	public void banJoin(PlayerLoginEvent e) {
		player = e.getPlayer();
		Result res = e.getResult();

		if (res == Result.KICK_BANNED) {
			e.disallow(Result.KICK_BANNED, ChatColor.GOLD + "Banned by an Administrator");

		} else {
			e.allow();
		}

	}

}
