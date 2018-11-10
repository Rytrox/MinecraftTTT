package de.rytrox.ttt.setup.arena;

import org.bukkit.Location;
import org.bukkit.material.Button;

public class Tester {

	private Button button;
	private double minX, minZ, maxX, maxZ;
	private int id;
	
	public Tester(int id, Location button, double minX, double minZ, double maxX, double maxZ) {
		this.button = (Button) button.getBlock().getState();
		this.minX = minX;
		this.minZ = minZ;
		this.maxX = maxX;
		this.maxZ = maxZ;
		this.id = id;
	}

	/**
	 * Get the Button of the Tester
	 * @return the Button
	 */
	public Button getButton() {
		return button;
	}

	/**
	 * Set a new Button for the Tester
	 * @param button
	 */
	public void setButton(Button button) {
		this.button = button;
	}

	/**
	 * Get the minimal X-Coordinate of the Tester
	 * @return the minimal X-Coordinate
	 */
	public double getMinX() {
		return minX;
	}

	/**
	 * Set the minimal X-Coordinate of the Tester
	 * @param minX the new minimal X-Coordinate
	 */
	public void setMinX(double minX) {
		this.minX = minX;
	}

	/**
	 * get the minimal Z-Coordinate of the Tester
	 * @return the minimal Z-Coordinate
	 */
	public double getMinZ() {
		return minZ;
	}

	/**
	 * Set the minimal Z-Coordinate of the Tester
	 * @param minZ the new minimal Z-Coordinate
	 */
	public void setMinZ(double minZ) {
		this.minZ = minZ;
	}

	/**
	 * get the maximal X-Coordinate of the Tester
	 * @return the maximal X-Coordinate
	 */
	public double getMaxX() {
		return maxX;
	}

	/**
	 * Set the maximal X-Coordinate of the Tester
	 * @param maxX the new maximal X-Coordinate
	 */
	public void setMaxX(double maxX) {
		this.maxX = maxX;
	}

	/**
	 * get the maximal Z-Coordinate of the Tester
	 * @return the maximal Z-Coordinate
	 */
	public double getMaxZ() {
		return maxZ;
	}

	/**
	 * Set the maximal Z-Coordinate of the Tester
	 * @param maxZ the new maximal Z-Coordinate
	 */
	public void setMaxZ(double maxZ) {
		this.maxZ = maxZ;
	}
	
	/**
	 * Get the ID of the Tester
	 * @return the ID
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * Set the Id of the Tester
	 * @param id the new ID of the Tester
	 */
	public void setID(int id) {
		this.id = id;
	}
}
