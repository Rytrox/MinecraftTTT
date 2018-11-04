package de.rytrox.ttt.configs;

import org.bukkit.ChatColor;

import de.rytrox.ttt.TTT;
import de.timeout.utils.UTFConfig;

public enum Language {

	PREFIX("prefix");
	
	private static final UTFConfig defaultConfig = new UTFConfig(
			TTT.plugin.getResource("assets/ttt/language/de_DE.yml"));
	
	private String path;
	private String message;
	
	private Language(String path) {
		this.path = path;
		this.message = loadMessage();
	}
	
	private String loadMessage() {
		String message = TTT.plugin.getConfigManager().getLanguageConfig().getString(path);
		return ChatColor.translateAlternateColorCodes('&', message != null ? message : defaultConfig.getString(path));
	}
	
	public String message() {
		return message;
	}
	
	public String getPath() {
		return path;
	}
}
