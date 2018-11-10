package de.rytrox.ttt.setup.arena;

import org.bukkit.Location;
import org.bukkit.material.Button;

public class Trap {

	private int id;
	private Button button;
	private Arena arena;
	
	public Trap(Arena arena, int id, Location loc) {
		this.id = id;
		this.button = (Button) loc.getBlock().getState();
		this.arena = arena;
	}

	/**
	 * Get the ID of the Trap
	 * @return the ID
	 */
	public int getID() {
		return id;
	}

	/**
	 * Set the ID of the Trap
	 * @param id the new id
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * Get the Button of the Button
	 * @return the button
	 */
	public Button getButton() {
		return button;
	}

	/**
	 * Set the Button of the new Trap
	 * @param button
	 */
	public void setButton(Button button) {
		this.button = button;
	}
	
	/**
	 * get the Arena
	 * @return the arena
	 */
	public Arena getArena() {
		return arena;
	}
	
	/**
	 * set trap to a new Arena
	 * @param arena the arena
	 */
	public void setArena(Arena arena) {
		this.arena = arena;
	}
}
