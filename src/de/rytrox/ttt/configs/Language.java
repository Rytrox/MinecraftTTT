package de.rytrox.ttt.configs;

import org.bukkit.ChatColor;

import de.rytrox.ttt.TTT;
import de.timeout.utils.UTFConfig;

/**
 * The Language-Enum for Messages
 * @author timeout
 *
 */
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
	
	/**
	 * Loads the Message fron config
	 * Decides which config will be used
	 * @return
	 */
	private String loadMessage() {
		String message = TTT.plugin.getConfigManager().getLanguageConfig().getString(path);
		return ChatColor.translateAlternateColorCodes('&', message != null ? message : defaultConfig.getString(path));
	}
	
	/**
	 * Get the Message
	 * @return the message
	 */
	public String message() {
		return message;
	}
	
	/**
	 * Get Path of Message
	 * @return the path of message
	 */
	public String getPath() {
		return path;
	}
}
