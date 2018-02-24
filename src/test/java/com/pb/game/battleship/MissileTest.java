package com.pb.game.battleship;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MissileTest {

	@Test
	public void Should_SetRow_When_MissileObjectIsCreated(){
		Missile m = new Missile("A10");
		assertEquals(0, m.getRow());
	}
	
	@Test
	public void Should_SetColumn_When_MissileObjectIsCreated(){
		Missile m = new Missile("A10");
		assertEquals(9, m.getColumn());
	}
	
	@Test
	public void Should_SetTarget_When_MissileObjectIsCreated(){
		Missile m = new Missile("A10");
		assertEquals("A10", m.getTarget());
	}
}
