package de.rytrox.ttt.setup.arena;

import org.bukkit.Location;
import org.bukkit.World;

public class Spawnpoint {

	private Location location;
	private Arena arena;
	private int id;
	
	public Spawnpoint(Arena arena, World world, int id, double x, double y, double z) {
		this.arena = arena;
		this.location = new Location(world, x, y, z);
		this.id = id;
	}

	/**
	 * Get the ID of the Spawnpoint
	 * @return the id
	 */
	public int getID() {
		return id;
	}

	/**
	 * Set a new ID to this Spawnpoint
	 * @param id the new id
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * Get the Location of the Spawns
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Set a new Spawnlocation
	 * @param location the new Location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Get the Arena of this Spawn
	 * @return the arena
	 */
	public Arena getArena() {
		return arena;
	}

	/**
	 * Set the Spawn to a new Arena
	 * @param arena
	 */
	public void setArena(Arena arena) {
		this.arena = arena;
	}
}
