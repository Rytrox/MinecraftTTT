package de.rytrox.ttt;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.rytrox.ttt.configs.ConfigCreator;
import de.rytrox.ttt.configs.ConfigManager;
import de.timeout.utils.UTFConfig;

public class TTT extends JavaPlugin {
	
	public static TTT plugin;
	
	private UTFConfig config;
	private ConfigManager configManager;

	@Override
	public void onEnable() {
		plugin = this;
		new ConfigCreator("assets/ttt/").loadConfigurations();
		config = new UTFConfig(new File(getDataFolder(), "config.yml"));
		this.configManager = new ConfigManager(config.getString("language"));
	}
	
	@Override
	public void onDisable() {
		saveConfig();
	}

	@Override
	public void saveConfig() {
		try {
			config.options().copyHeader(true);
			config.save(new File(getDataFolder(), "config.yml"));
		} catch (IOException e) {
			Bukkit.getLogger().log(Level.SEVERE, "Cannot save config.yml", e);
		}
	}
	
	@Override
	public UTFConfig getConfig() {
		return config;
	}
	
	public ConfigManager getConfigManager() {
		return configManager;
	}

}
