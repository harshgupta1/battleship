package com.pb.game.battleship;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void Should_ReturnPlayerName_When_ConstructPlayerObject(){
		Player player = new Player("Player");
		assertEquals("Player", player.getPlayerName());
	}
	
	@Test
	public void Should_ReturnAddedMissiles_For_AddMissile(){
		Player player = new Player("Player");
		player.addMissile("A1");
		assertEquals("A1", player.getMissiles().peek().getTarget());
	}
	
	@Test
	public void Should_Hit_IfShoot(){
		Player player1 = new Player("Player1");
		Player player2 = new Player("Player2");
		player1.addMissile("A1");
		initBattleAreaData(player2);
		assertTrue(player1.shoot(player2, System.out));
	}
	
	@Test
	public void Should_Miss_IfShoot(){
		Player player1 = new Player("Player1");
		Player player2 = new Player("Player2");
		player1.addMissile("A2");
		initBattleAreaData(player2);
		assertFalse(player1.shoot(player2, System.out));
	}
	
	@Test
	public void Should_ReturnTrue_IfIsDown(){
		Player player = new Player("Player");
		player.createBattleArea("5 E");
		player.addTotalShipsToBattleArea(1);
		assertTrue(player.isDown());
	}
	
	@Test
	public void Should_ReturnFalse_IfNotDown(){
		Player player = new Player("Player");
		player.createBattleArea("5 E");
		player.addTotalShipsToBattleArea(1);
		player.addShipInBattleArea("P", 1, 1, "A1");
		assertFalse(player.isDown());
	}
	
	@Test
	public void Should_CreateBattleArea(){
		String battleAreaDimensions = "5 Z";
		Player player = new Player("Player");
		BattleArea battleArea = player.createBattleArea(battleAreaDimensions);
		assertArrayEquals(new int[]{26, 5}, new int[]{battleArea.getArea().length, battleArea.getArea()[0].length});
	}
	
	@Test
	public void Should_AddTotalShipsBattleArea(){
		Player player = new Player("Player");
		player.createBattleArea("5 E");
		Ship[] ship = player.addTotalShipsToBattleArea(5);
		assertEquals(5, ship.length);
	}
	
	@Test
	public void Should_AddShipsToBattleArea(){
		String battleAreaDimensions = "6 F";
		Player player = new Player("Player");
		BattleArea battleArea = player.createBattleArea(battleAreaDimensions);
		player.addTotalShipsToBattleArea(5);
		player.addShipInBattleArea("Q", 2 , 2, "A4");
		int playerAArea[][] = battleArea.getArea();
		assertArrayEquals(new int[]{2,2,2,2}, new int[]{playerAArea[0][3], playerAArea[0][4], playerAArea[1][3], playerAArea[1][4]});
	}

	private BattleArea initBattleAreaData(Player player){
		BattleArea battleArea = player.createBattleArea("2 B");
		battleArea.addTotalShips(1, 2, 1);
		Ship ship = new BattleShip(1, 2, 'A', 'B');
		ship.createShip("P", 1, 1);
		battleArea.addShip(ship, "A1");
		return battleArea;
	}
}
