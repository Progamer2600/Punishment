package me.progamer260.punishment;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_12_R1.CommandExecute;

public class Punish extends CommandExecute implements CommandExecutor {
	public String cmd1 = "Punish";
	public String cmd2 = "UnMute";
	public String cmd3 = "Unban";
	public String[] args;
	public Events e = new Events();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        this.args = args;
		if (cmd.getName().equalsIgnoreCase(cmd1)) {
			if (sender instanceof Player) {
				if (args.length == 0) {
					sender.sendMessage(ChatColor.DARK_RED + "» " + ChatColor.RED + "Please specify a player!");

				}
				if (args.length == 1) {
					sender.sendMessage(ChatColor.DARK_RED + "» " + ChatColor.RED + "Please provide a reason!");
					Player player = ((Player) sender).getPlayer();
					Gui i = new Gui();
					i.newInventory(player);

				}
				if (cmd.getName().equalsIgnoreCase(cmd2)) {
					e.muted.remove(e.player.toString());
					sender.sendMessage(ChatColor.GOLD + "Player Un-Muted!");
				}
				if (cmd.getName().equalsIgnoreCase(cmd3)) {
					e.banned.remove(e.player.toString());
					sender.sendMessage(ChatColor.GOLD + "Player has been Un-Banned!");
				}

			}

		}
		return true;
	}

}
