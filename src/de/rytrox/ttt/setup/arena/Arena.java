package de.rytrox.ttt.setup.arena;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.ConfigurationSection;

import de.timeout.utils.UTFConfig;

public class Arena {
	
	//Constants are better for JVM than new Strings
	private static final String MINIMAL_X = "minX";
	private static final String MINIMAL_Z = "minZ";
	private static final String MAXIMAL_X = "maxX";
	private static final String MAXIMAL_Z = "maxZ";
	private static final String X = "x";
	private static final String Y = "y";
	private static final String Z = "z";
	
	private final List<Spawnpoint> spawnpoints = new ArrayList<Spawnpoint>();
	private final List<Tester> testers = new ArrayList<Tester>();
	private final List<Trap> traps = new ArrayList<Trap>();

	private String name;
	private World world;
	
	public Arena(UTFConfig config) {
		this.name = config.getString("arenaname");
		this.world = loadWorld(config.getString("worldname"));
		
		fillTesters(config.getConfigurationSection("tester"));
		fillSpawnpoints(config.getConfigurationSection("spawns"));
		fillTraps(config.getConfigurationSection("traps"));
	}
	
	private World loadWorld(String worldname) {
		World world = Bukkit.getServer().getWorld(worldname);
		if(world == null) new WorldCreator(worldname).createWorld();
		return world != null ? world : Bukkit.getServer().getWorld(worldname);
	}
	
	/**
	 * Fill TesterList
	 * @param testers the ConfigurationSection of testers
	 */
	private void fillTesters(ConfigurationSection testers) {
		testers.getKeys(false).forEach(id -> {
			ConfigurationSection tester = testers.getConfigurationSection(id);
			ConfigurationSection button = tester.getConfigurationSection("button");
			this.testers.add(new Tester(Integer.valueOf(id), new Location(world, button.getDouble(X), button.getDouble(Y), button.getDouble(Z)),
					tester.getDouble(MINIMAL_X), tester.getDouble(MINIMAL_Z), tester.getDouble(MAXIMAL_X), tester.getDouble(MAXIMAL_Z)));
		});
	}
	
	/**
	 * Fill SpawnList
	 * @param spawnpoints the ConfigurationSection of SpawnPoints
	 */
	private void fillSpawnpoints(ConfigurationSection spawnpoints) {
		spawnpoints.getKeys(false).forEach(id -> {
			ConfigurationSection spawn = spawnpoints.getConfigurationSection(id);
			this.spawnpoints.add(new Spawnpoint(this, world, Integer.valueOf(id), spawn.getDouble(X), spawn.getDouble(Y), spawn.getDouble(Z)));
		});
	}
	
	/**
	 * Fill TrapsList
	 * @param traps the ConfigurationSection of Traps
	 */
	private void fillTraps(ConfigurationSection traps) {
		traps.getKeys(false).forEach(id -> {
			ConfigurationSection trap = traps.getConfigurationSection(id);
			this.traps.add(new Trap(this, Integer.valueOf(id), new Location(world, trap.getDouble(X), trap.getDouble(Y), trap.getDouble(Z))));
		});
	}
	
	/**
	 * get name of arena
	 * @return the name of arena
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set a new name for arena
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the World of Arena
	 * @return
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * Set a new World for the Arena
	 * @param world the new world
	 */
	public void setWorld(World world) {
		this.world = world;
	}

	/**
	 * get all SpawnPoints
	 * @return all SpawnPoints
	 */
	public List<Spawnpoint> getSpawnPoints() {
		return spawnpoints;
	}

	/**
	 * get all Tester
	 * @return all Tester
	 */
	public List<Tester> getTesters() {
		return testers;
	}

	/**
	 * get all Traps
	 * @return all Traps
	 */
	public List<Trap> getTraps() {
		return traps;
	}
	
	
}
