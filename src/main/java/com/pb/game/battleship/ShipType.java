package com.pb.game.battleship;

public enum ShipType {

	P(1), Q(2);
	
	private final int strength;

	ShipType(int power) {
        this.strength = power;
    }

	public int getStrength() {
		return strength;
	}
	
}
