package com.pb.game.battleship.exception;

public class InvalidShipTypeException extends RuntimeException {

	private static final long serialVersionUID = 2304611209926694026L;

	public InvalidShipTypeException(){
		super();
	}
	
	public InvalidShipTypeException(String s){
		super(s);
	}
}
