package com.pb.game.battleship;

/**
 * Generic class to represent any type of Ship
 * 
 * @author HA005GU
 *
 */
public abstract class Ship {

	int minWidth;
	int maxWidth;
	char minHeight;
	char maxHeight;

	int width;
	int height;
	String type;

	public abstract Ship createShip(String type, int width, int height);
	public abstract int getStrength(String type);
	
	public int getMinWidth() {
		return minWidth;
	}

	public int getMaxWidth() {
		return maxWidth;
	}

	public char getMinHeight() {
		return minHeight;
	}

	public char getMaxHeight() {
		return maxHeight;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getType() {
		return type;
	}

}
