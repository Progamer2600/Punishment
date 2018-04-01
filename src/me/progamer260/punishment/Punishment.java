package me.progamer260.punishment;

import org.bukkit.plugin.java.JavaPlugin;

public class Punishment extends JavaPlugin {

	private Punish commands = new Punish();

	@Override
	public void onEnable() {
		getCommand(commands.cmd1).setExecutor(commands);
		getServer().getPluginManager().registerEvents(new Events(), this);

	}

}
