package com.pb.game.battleship;

import java.io.PrintStream;

import com.pb.game.battleship.exception.InvalidBattleAreaException;
import com.pb.game.battleship.exception.InvalidShipCoordinatesException;
import com.pb.game.battleship.exception.InvalidShipCountException;

public class BattleArea {

	private final static int minWidth = 1;
	private final static int maxWidth = 9;
	private final static char minHeight = 'A';
	private final static char maxHeight = 'Z';
	
	private int width;
	private char height;
	
	private int area[][];
	private Ship [] ship;
	private int nextShipPosition = 0;
	private int totalStrength = 0;
	
	public BattleArea(int width, char height){
		this.width = width;
		this.height = height;
		if (width < minWidth || width > maxWidth) {
			throw new InvalidBattleAreaException("Invalid Battle Area Size: width[" + width + "], " + " Width must be between(inclusive) " + minWidth + " and " + maxWidth);
		}
		if (height < minHeight || height > maxHeight) {
			throw new InvalidBattleAreaException("Invalid Battle Area Size: height[" + height + "]. Height must be between(inclusive) " + minHeight + " and " + maxHeight);
		}
		this.area = new int[height - 64][width];
	}
	
	public int getWidth() {
		return width;
	}

	public char getHeight() {
		return height;
	}

	public int[][] getArea() {
		return area;
	}
	
	public Ship[] addTotalShips(int minShip, int maxShip, int totalShips){
		if (totalShips < minShip || totalShips > maxShip) {
			throw new InvalidShipCountException("Invalid Ship Count: " + totalShips + "Must be between(inclusive) " + minShip + " and " + maxShip);
		}
		this.ship = new Ship[totalShips];
		return this.ship;
	}

	public void addShip(Ship ship, String location) {
		this.ship[nextShipPosition++] = ship;
		char yCoord = location.charAt(0);
		int xCoord = Integer.parseInt(location.substring(1));
		if (xCoord < ship.getMinWidth() || xCoord > ship.getMaxWidth()) {
			throw new InvalidShipCoordinatesException("Invalid Ship Corridinate : x[" + xCoord + "], " 
						+ " X Coordinate must be between(inclusive) " + ship.getMinWidth() + " and " + ship.getMaxWidth());
		}
		if (yCoord < ship.getMinHeight() || yCoord > ship.getMaxHeight()) {
			throw new InvalidShipCoordinatesException("Invalid Ship Corridinate : y[" + yCoord + "], " 
					+ " Y Coordinate must be between(inclusive) " + ship.getMinHeight() + " and " + ship.getMaxHeight());
		}
		
		for(int i=yCoord-65; i < yCoord-65+ship.getHeight() ; i++){
			for(int j=xCoord-1; j < xCoord-1+ship.getWidth(); j++){
				area[i][j] = ship.getStrength(ship.getType());
				totalStrength += area[i][j];
			}
		}
	}

	public void printBattleArea(PrintStream ps){
		for (int i=0; i<this.getArea().length;i++) {
			for(int j=0; j<this.getArea()[i].length;j++){
				ps.print(this.getArea()[i][j] + " ");
			}
			ps.println("");
		}
	}

	public int reduceTotalStrength() {
		return --totalStrength;
	}
	
	public int getTotalStrength() {
		return totalStrength;
	}
	
}
