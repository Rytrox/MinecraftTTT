package de.rytrox.ttt;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.rytrox.ttt.configs.ConfigCreator;
import de.rytrox.ttt.configs.ConfigManager;
import de.timeout.utils.UTFConfig;

/**
 * Main-Class
 * @author Rytrox
 *
 */
public class TTT extends JavaPlugin {
	
	public static TTT plugin;
	
	private UTFConfig config;
	private ConfigManager configManager;

	/**
	 * Will be called on enable
	 */
	@Override
	public void onEnable() {
		plugin = this;
		new ConfigCreator("assets/ttt/").loadConfigurations();
		config = new UTFConfig(new File(getDataFolder(), "config.yml"));
		this.configManager = new ConfigManager(config.getString("language"));
	}
	
	/**
	 * Will be called on Plugin-Disable
	 */
	@Override
	public void onDisable() {
		saveConfig();
	}

	/**
	 * Save the default config.yml
	 */
	@Override
	public void saveConfig() {
		try {
			config.options().copyHeader(true);
			config.save(new File(getDataFolder(), "config.yml"));
		} catch (IOException e) {
			Bukkit.getLogger().log(Level.SEVERE, "Cannot save config.yml", e);
		}
	}
	
	/**
	 * get the config.yml
	 * @return the config.yml
	 */
	@Override
	public UTFConfig getConfig() {
		return config;
	}
	
	/**
	 * Get the ConfigManager
	 * @return the ConfigManager
	 */
	public ConfigManager getConfigManager() {
		return configManager;
	}

}
