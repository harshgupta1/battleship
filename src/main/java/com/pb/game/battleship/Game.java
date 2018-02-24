package com.pb.game.battleship;

import java.io.PrintStream;
import java.util.List;

/**
 * 
 * Assumptions :
 * 1.	Array Indexes at all places are starting from 0. 
 * 		Hence if width range is 1 to 9, then it is represented from 0 to 8;
 * 		If Height ranges from A to Z, then it is represented from 0 to 25 in array. Hence conversion from character to int is made.
 * 
 * @author HA005GU
 *
 */
public class Game {

	Player player1, player2;
	
	public static void main(String[] args){
		PrintStream console = System.out;
		if(args.length == 0)
		{
			console.println("Missing fileName: Use java -jar <jarname> <filename>");
			System.exit(1);
		}
		
		List<String> input = FileUtils.readFile(args[0]);
		for (String string : input) {
			console.println(string);
		}
		
		Game game = new Game();
		game.startGame(input, console);
		
	}
	
	public void startGame(List<String> input, PrintStream ps){
		player1 = new Player("Player-1");
		player2 = new Player("Player-2");
		
		player1.createBattleArea(input.get(0));
		player2.createBattleArea(input.get(0));
		
		addShipsToBattleArea(input);
		
		player1.addMissile(input.get(input.size()-2));
		player2.addMissile(input.get(input.size()-1));
		
		player1.getBattleArea().printBattleArea(ps);
		player2.getBattleArea().printBattleArea(ps);
		
		// PlayGame
		play(ps);
	}

	/**
	 * Read totalships and ship coordinates as input and place ships on each Player's battleArea 
	 * at the respective coordinates
	 * 
	 * @param input
	 * @return
	 */
	public void addShipsToBattleArea(List<String> input){
		// Add totalShips to each battleArea
		int totalShips = new Integer(input.get(1));
		player1.addTotalShipsToBattleArea(totalShips);
		player2.addTotalShipsToBattleArea(totalShips);
		
		// Add different type of ships to each battleArea
		for (int i = 0; i < totalShips; i++) {
			String [] battleShipDetail = input.get(i+2).split(" ");
			player1.addShipInBattleArea(battleShipDetail[0], new Integer(battleShipDetail[1]), new Integer(battleShipDetail[2]), battleShipDetail[3]);
			player2.addShipInBattleArea(battleShipDetail[0], new Integer(battleShipDetail[1]), new Integer(battleShipDetail[2]), battleShipDetail[4]);
		}
		
	}
	
	void play(PrintStream ps){
		
		boolean win = false;
		while(!win){
			
			if(shootUntil(player1, player2, ps)){
				break;
			}
			
			if(shootUntil(player2, player1, ps))
			{
				break;
			}
			
		}
	}
	
	private boolean shootUntil(Player playerA, Player playerB, PrintStream ps){
		boolean win = false;
		if(playerA.getMissiles().size() == 0){
			ps.println(playerA.getPlayerName() + " has no more missiles left to launch");
		}
		else
		{
			boolean hit = true;
			while(hit && playerA.getMissiles().size() > 0){
				hit = playerA.shoot(playerB, ps);
				if(playerB.isDown()){
					ps.println(playerA.getPlayerName() + " won the battle");
					win = true;
					break;
				}
			}
		}
		return win;
	}
	
}
