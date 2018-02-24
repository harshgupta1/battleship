package com.pb.game.battleship;

public class Missile {

	private int row;
	private int column;
	private String target;
	
	Missile(String target){
		this.row = target.charAt(0)-65;
		this.column = new Integer(target.substring(1))-1;
		this.target = target;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public String getTarget() {
		return target;
	}

	@Override
	public String toString() {
		return target;
	}
	
}
