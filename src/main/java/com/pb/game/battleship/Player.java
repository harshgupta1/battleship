package com.pb.game.battleship;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

public class Player {

	Queue<Missile> missiles = new LinkedList<Missile>();
	private String playerName;
	BattleArea battleArea;
	
	Player(String name){
		this.playerName = name;
	}
	
	/**
	 * Read battle area dimensions as input and create battleArea.
	 * It throws InvalidBattleAreaException if the area is not within defined range.
	 * 
	 * @param battleAreaDimensions
	 * @return
	 */
	public BattleArea createBattleArea(String battleAreaDimensions){
		
		String [] dimensions = battleAreaDimensions.split(" ");
		battleArea = new BattleArea(new Integer(dimensions[0]), dimensions[1].charAt(0));
		
		return battleArea;
	}
	
	public Ship[] addTotalShipsToBattleArea(int totalShips){
		// Add totalShips to each battleArea
		return battleArea.addTotalShips(1, battleArea.getWidth() * battleArea.getHeight(), totalShips);
	}
	
	public void addShipInBattleArea(String type, int width, int height, String location){
		
		// Add different type of ships to each battleArea
		Ship ship = new BattleShip(1, battleArea.getWidth(), 'A',  battleArea.getHeight());
		ship = ship.createShip(type, width, height);
			
		// Update ship location
		battleArea.addShip(ship, location);
	}
	
	/**
	 * Read missile target location as input for each Player and add those missiles 
	 * 
	 * @param input
	 * @return
	 */
	public void addMissile(String input){
		for (String target : input.split(" ")) {
			Missile m = new Missile(target);
			missiles.add(m);
		}
	}
	
	public boolean shoot(Player player, PrintStream ps){
		boolean hit = false;
		Missile missile = missiles.remove();
		int value = player.getBattleArea().getArea()[missile.getRow()][missile.getColumn()];
		if(value == 0) 
		{
			ps.println(playerName + " fires a missile with target " + missile.getTarget() + " which got miss");
		}
		else
		{
			ps.println(playerName + " fires a missile with target " + missile.getTarget() + " which got hit");
			player.getBattleArea().getArea()[missile.getRow()][missile.getColumn()] = player.getBattleArea().getArea()[missile.getRow()][missile.getColumn()] - 1;
			player.getBattleArea().reduceTotalStrength();
			hit = true;
		}
		return hit;
	}
	
	public boolean isDown(){
		return (battleArea.getTotalStrength() == 0) ? true : false;
	}
	
	public Queue<Missile> getMissiles() {
		return missiles;
	}

	public String getPlayerName() {
		return playerName;
	}

	public BattleArea getBattleArea() {
		return battleArea;
	}
}
