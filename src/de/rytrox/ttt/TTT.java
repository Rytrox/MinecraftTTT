package de.rytrox.ttt;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.timeout.utils.UTFConfig;

public class TTT extends JavaPlugin {
	
	private UTFConfig config;

	@Override
	public void onEnable() {

	}
	
	@Override
	public void onDisable() {

	}

	@Override
	public void reloadConfig() {
		config = new UTFConfig(new File(getDataFolder(), "config.yml"));
	}

	@Override
	public void saveConfig() {
		try {
			config.save(new File(getDataFolder(), "config.yml"));
		} catch (IOException e) {
			Bukkit.getLogger().log(Level.SEVERE, "Cannot save config.yml", e);
		}
	}
	
	@Override
	public UTFConfig getConfig() {
		return config;
	}

}
