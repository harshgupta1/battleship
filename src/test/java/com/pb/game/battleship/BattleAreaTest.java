package com.pb.game.battleship;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pb.game.battleship.exception.InvalidBattleAreaException;
import com.pb.game.battleship.exception.InvalidShipCoordinatesException;
import com.pb.game.battleship.exception.InvalidShipCountException;

public class BattleAreaTest {

	@Test(expected = InvalidBattleAreaException.class)
    public void Should_ThrowException_When_WidthLessThanMinimumBattleAreaWidth() {
		int width = 0;
		new BattleArea(width, 'Z');
    }
	
	@Test(expected = InvalidBattleAreaException.class)
    public void Should_ThrowException_When_WidthGreaterThanMaximumBattleAreaWidth() {
		int width = 10;
		new BattleArea(width, 'Z');
    }
	
	@Test(expected = InvalidBattleAreaException.class)
    public void Should_ThrowException_When_HeightLessThanMinimumBattleAreaHeight() {
		char height = '@';
		new BattleArea(5, height);
    }
	
	@Test(expected = InvalidBattleAreaException.class)
	public void Should_ThrowException_When_HeightGreaterThanMaximumBattleAreaHeight() {
		char height = '[';
		new BattleArea(5, height);
    }
	
	@Test
	public void Should_SetBattleAreaWidthAndHeight_When_CreatingBattleArea(){
		BattleArea battleArea = new BattleArea(5, 'Z');
		int size[][] = battleArea.getArea();
		int rows = size.length;
		int cols = size[0].length;
		assertArrayEquals(new int[]{26,5},new int[]{rows, cols});
		assertArrayEquals(new int[]{26,5},new int[]{battleArea.getArea().length, battleArea.getArea()[0].length});
	}
	
	@Test(expected = InvalidShipCountException.class)
	public void Should_ThrowException_When_TotalBattleShipsNotWithinDefinedRange(){
		int min=1, max = 10;
		BattleArea battleArea = new BattleArea(5, 'Z');
		battleArea.addTotalShips(min, max, 11);
	}
	
	@Test
	public void Should__AddTotalBattleShips_When_AddShip(){
		int min=1, max = 10;
		BattleArea battleArea = new BattleArea(5, 'Z');
		Ship[] ship = battleArea.addTotalShips(min, max, 5);
		assertEquals(5,ship.length);
	}
	
	@Test
	public void Should_SetShipLocationAndPower_When_AddShip(){
		BattleArea battleArea = new BattleArea(5, 'E');
		battleArea.addTotalShips(1, 9, 1);
		Ship ship = new BattleShip(1, 9, 'A', 'Z');
		ship = ship.createShip("Q", 1, 1);
		battleArea.addShip(ship, "B2");
		
		for (int i = 0; i < battleArea.getArea().length; i++) {
			for (int j = 0; j < battleArea.getArea()[i].length; j++) {
				if(i==1 && j == 1)
				{
					assertEquals(2, battleArea.getArea()[i][j]);
				}
				else
				{
					assertEquals(0, battleArea.getArea()[i][j]);
				}
			}
		}
	}
	
	@Test(expected = InvalidShipCoordinatesException.class)
	public void Should_ThrowException_When_ShipXCoordinateLessThanBattleAreaWidth(){
		BattleArea battleArea = new BattleArea(5, 'E');
		battleArea.addTotalShips(1, 9, 5);
		Ship ship = new BattleShip(1, 9, 'A', 'Z');
		battleArea.addShip(ship, "@1");
	}
	
	@Test(expected = InvalidShipCoordinatesException.class)
	public void Should_ThrowException_When_ShipXCoordinateGreaterThanBattleAreaWidth(){
		BattleArea battleArea = new BattleArea(5, 'E');
		battleArea.addTotalShips(1, 9, 5);
		Ship ship = new BattleShip(1, 9, 'A', 'Z');
		battleArea.addShip(ship, "[1");
	}
	
	@Test(expected = InvalidShipCoordinatesException.class)
	public void Should_ThrowException_When_ShipYCoordinateLessThanBattleAreaHeight(){
		BattleArea battleArea = new BattleArea(5, 'E');
		battleArea.addTotalShips(1, 9, 5);
		Ship ship = new BattleShip(1, 9, 'A', 'Z');
		battleArea.addShip(ship, "A0");
	}
	
	@Test(expected = InvalidShipCoordinatesException.class)
	public void Should_ThrowException_When_ShipYCoordinateGreaterThanBattleAreaHeight(){
		BattleArea battleArea = new BattleArea(5, 'E');
		battleArea.addTotalShips(1, 9, 5);
		Ship ship = new BattleShip(1, 9, 'A', 'Z');
		battleArea.addShip(ship, "A10");
	}
	
	@Test
	public void Should_SetWidth_When_DrawArea(){
		int width = 5;
		BattleArea battleArea = new BattleArea(width, 'E');
		assertEquals(width, battleArea.getWidth());
	}
	
	@Test
	public void Should_SetHeight_When_DrawArea(){
		char height = 'E';
		BattleArea battleArea = new BattleArea(5, height);
		assertEquals(height, battleArea.getHeight());
	}
	
}
