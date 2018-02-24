package com.pb.game.battleship.exception;

public class InvalidShipCountException extends RuntimeException {

	private static final long serialVersionUID = -4737858985380728680L;

	public InvalidShipCountException(){
		super();
	}
	
	public InvalidShipCountException(String s){
		super(s);
	}
}
