package com.pb.game.battleship;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pb.game.battleship.exception.InvalidShipDimensionsException;
import com.pb.game.battleship.exception.InvalidShipTypeException;

public class ShipTest {

	Ship ship = new BattleShip(1, 9, 'A', 'Z');
	
	@Test
	public void Should_SetMinWidth_When_CreateShipObject(){
		assertEquals(1, ship.getMinWidth());
	}
	
	@Test
	public void Should_SetMaxWidth_When_CreateShipObject(){
		assertEquals(9,ship.getMaxWidth());
	}
	
	@Test
	public void Should_SetMinHeight_When_CreateShipObject(){
		assertEquals('A', ship.getMinHeight());
	}
	
	@Test
	public void Should_SetMaxHeight_When_CreateShipObject(){
		assertEquals('Z', ship.getMaxHeight());
	}
	
	@Test
	public void Should_SetWidth_When_CreateShip(){
		int width = 3;
		ship.createShip("P", width, 4);
		assertEquals(width,ship.getWidth());
	}
	
	@Test
	public void Should_SetHeight_When_CreateShip(){
		int height = 4;
		ship.createShip("P", 3, height);
		assertEquals(height,ship.getHeight());
	}
	
	@Test
	public void Should_SetShipType_When_CreateShip(){
		String type = "P";
		ship.createShip(type, 3, 4);
		assertEquals(type,ship.getType());
	}
	
	@Test(expected = InvalidShipDimensionsException.class)
    public void Should_ThrowException_When_WidthLessThanDefinedRange() {
		int width = 0;
		ship.createShip("P", width, 4);
    }
	
	@Test(expected = InvalidShipDimensionsException.class)
    public void Should_ThrowException_When_WidthGreaterThanDefinedRange() {
		int width = 10;
		ship.createShip("P", width, 4);
    }
	
	@Test(expected = InvalidShipTypeException.class)
	public void Should_ThrowException_When_ShipTypeOtherThanDefineType() {
		String type = "Z";
		ship.createShip(type, 9, 4);
	}
	
	@Test(expected = InvalidShipDimensionsException.class)
    public void Should_ThrowException_When_HeightLessThanDefinedRange() {
		int height = 0;
		ship.createShip("P", 4, height);
    }
	
	@Test(expected = InvalidShipDimensionsException.class)
    public void Should_ThrowException_When_HeightGreaterThanDefinedRange() {
		int height = 27;
		ship.createShip("P", 4, height);
    }
	
	@Test
	public void Should_ReturnPower_When_GetPower(){
		assertArrayEquals(new int[]{1,2}, new int[]{ship.getStrength(ShipType.P.name()), ship.getStrength(ShipType.Q.name())});
	}
	
}
