package me.progamer260.punishment;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class Gui {
	private static Plugin plugin = Punishment.getPlugin(Punishment.class);
	private ItemStack i1, i2, i3, i4;
	private ItemMeta meta1, meta2, meta3, meta4;

	public static Inventory inv;

	public void newInventory(Player p) {
		inv = plugin.getServer().createInventory(null, 9, ChatColor.BOLD + "" + ChatColor.BLUE + "Punishment");
		i1 = new ItemStack(Material.FEATHER);
		meta1 = i1.getItemMeta();
		meta1.setDisplayName(ChatColor.AQUA + "Kick");
		i1.setItemMeta(meta1);
		inv.setItem(0, i1);

		i2 = new ItemStack(Material.BOOK);
		meta2 = i2.getItemMeta();
		meta2.setDisplayName(ChatColor.AQUA + "Mute");
		i2.setItemMeta(meta2);
		inv.setItem(4, i2);

		i4 = new ItemStack(Material.BOOK_AND_QUILL);
		meta4 = i4.getItemMeta();
		meta4.setDisplayName(ChatColor.AQUA + "Un-Mute");
		i4.setItemMeta(meta4);
		inv.setItem(5, i4);

		i3 = new ItemStack(Material.BOOK);
		meta3 = i3.getItemMeta();
		meta3.setDisplayName(ChatColor.AQUA + "Ban");
		i3.setItemMeta(meta3);
		inv.setItem(7, i3);

		p.openInventory(inv);
	}

}
