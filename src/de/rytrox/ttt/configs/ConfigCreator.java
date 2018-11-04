package de.rytrox.ttt.configs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;

import org.bukkit.Bukkit;

import com.google.common.io.ByteStreams;

import de.rytrox.ttt.TTT;

/**
 * Class for creating required Files for the Plugin
 * @author timeout
 *
 */
public class ConfigCreator {
	
	private static final String SLASH = "/";
	private static final String CONFIG_LOADED = "§8[§aOut-Configuration§8] §a%f §f is §asucessful loaded";
	private static final String CONFIG_GENERATE = "§8[§aOut-Configuration§8] §a%f §7could not be found: §aGenerate...";
	
	private static final TTT main = TTT.plugin;
	//Must be "assets/ttt/"
	private String packagepath;
	
	public ConfigCreator(String packagepath) {
		this.packagepath = packagepath;
	}

	/**
	 * Creates Configurations if not exists
	 */
	public void loadConfigurations() {
		loadResource("config.yml");
		loadResource("language/de_DE.yml");
	}

	/**
	 * Load a File from Jar with Contents
	 * @param filepath the path of the file
	 */
	private void loadResource(String filepath) {
		try {
			File f = loadFile(filepath);
			String[] folders = filepath.contains(SLASH) ? filepath.split(SLASH) : new String[] {filepath};
			if(f != null && f.length() == 0L) {
				try(InputStream in = main.getResource(packagepath + String.join(SLASH, folders));
					OutputStream out = new FileOutputStream(f)) {
					ByteStreams.copy(in, out);
				}
			}
			Bukkit.getConsoleSender().sendMessage(CONFIG_LOADED.replace("%f", (f != null ? f.getName() : folders[folders.length -1])));
		} catch (IOException e) {
			Bukkit.getLogger().log(Level.SEVERE, "Fatal Error by creating File " + filepath, e);
		}
	}
	
	/**
	 * Creates an empty File
	 * @param filepath the path of the File
	 * @return the File
	 */
	private File loadFile(String filepath) {
		try {
			String[] folders = new String[] {filepath};
			File f = main.getDataFolder();
			if(!f.exists())f.mkdirs();
			if(filepath.contains(SLASH)) {
				folders = filepath.split(SLASH);
				for(int i = 0; i < folders.length -1; i++)if(!(f = new File(f, folders[i])).exists())f.mkdirs();			
			}
			f = new File(f, folders[folders.length -1]);
			if(!f.exists()) {
				Bukkit.getConsoleSender().sendMessage(CONFIG_GENERATE.replaceAll("%f", f.getName()));
				f.createNewFile();
			}
			return f;
		} catch (IOException e) {
			Bukkit.getLogger().log(Level.SEVERE, "Could not load " + filepath, e);
		}
		return null;
	}
}
