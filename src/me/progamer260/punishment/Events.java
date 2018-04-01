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
    public ArrayList<String> muted = new ArrayList<>();
    public ArrayList<String> banned = new ArrayList<>();
    public Player player;
    private Punish punish = new Punish();

    @EventHandler
    public void onClick (InventoryClickEvent e) {

        Inventory open = e.getClickedInventory();
        ItemStack stack = e.getCurrentItem();

        player = (Player) e.getWhoClicked();
        if (open.getName().equals(ChatColor.BOLD + "" + ChatColor.BLUE + "Punishment")) {
            e.setCancelled(true);

            if (stack.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Kick")) {
                if (punish.args == null) {
                    player.sendMessage(ChatColor.RED + "Please specify a player!");
                } else {
                    player.sendMessage(ChatColor.RED + punish.args[0] + " was kicked from the game!");
                    player.kickPlayer(punish.args[0]);
                }
            }
            if (stack.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Mute")) {
                if (punish.args == null) {
                    player.sendMessage(ChatColor.RED + "Please specify a player!");
                } else {
                    player.sendMessage(ChatColor.GOLD + "Player has been muted!");
                    muted.add(punish.args[0]);
                }
                if (stack.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Un-Mute")) {
                    if (punish.args == null) {
                        player.sendMessage(ChatColor.RED + "Please specify a player!");
                    } else {
                        player.sendMessage(ChatColor.GOLD + "Player has been un-muted!");
                        muted.remove(punish.args[0]);
                    }
                    if (stack.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Ban")) {
                        if (punish.args == null) {
                            player.sendMessage(ChatColor.RED + "Please specify a player!");
                        } else {
                            banned.add(punish.args[0]);
                            if (banned.contains(punish.args[0])) {
                                player.kickPlayer(ChatColor.GOLD + "Banned by an Administrator");
                                player.isBanned();

                            }
                        }
                    }

                }
            }
        }
    }
                @EventHandler
                public void muteChat (AsyncPlayerChatEvent event){
                    player = event.getPlayer();
                    if (muted.contains(player.toString())) {
                        event.setCancelled(true);
                    } else {
                        event.setCancelled(false);
                    }
                }

                @EventHandler
                public void banJoin (PlayerLoginEvent e) {
                    player = e.getPlayer();
                    Result res = e.getResult();

                    if (res == Result.KICK_BANNED) {
                        e.disallow(Result.KICK_BANNED, ChatColor.GOLD + "Banned by an Administrator");

                    } else {
                        e.allow();
                    }
                }
        }


