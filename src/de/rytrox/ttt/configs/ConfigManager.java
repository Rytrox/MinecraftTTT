package de.rytrox.ttt.configs;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Bukkit;

import de.rytrox.ttt.TTT;
import de.timeout.utils.UTFConfig;

public class ConfigManager {

	private static final TTT main = TTT.plugin;
	
	private File languageFile;
	private UTFConfig language;
	
	public ConfigManager(String language) {
		loadLanguage(language);
	}
	
	public void loadLanguage(String language) {
		this.languageFile = new File(main.getDataFolder().getPath() + "/language", language + ".yml");
		this.language = (languageFile.exists()) ? new UTFConfig(languageFile) : new UTFConfig(main.getResource("assets/ttt/language/de_DE.yml"));
	}
	
	public UTFConfig getLanguageConfig() {
		return language;
	}
	
	public void saveLanguage() {
		language.options().copyHeader(true);
		File folder = new File(main.getDataFolder(), "language");
		if(!folder.exists())folder.mkdirs();
		try {
			language.save(languageFile);
		} catch (IOException e) {
			Bukkit.getLogger().log(Level.SEVERE, "Cannot save LanguageConfig", e);
		}
	}
}
