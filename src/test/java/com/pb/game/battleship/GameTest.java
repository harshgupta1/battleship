package com.pb.game.battleship;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class GameTest {

	static Game game = new Game();
	static List<String> input_player2;
	static List<String> input_player1;
	
	@BeforeClass
	public static void setup(){
		input_player1 = FileUtils.readFile("test-input-player1.txt");
		input_player2 = FileUtils.readFile("test-input-player2.txt");
	}
	
	@Test
	public void Should_Player1Win_When_Play(){
		game.startGame(input_player1, System.out);
		assertTrue(game.player2.isDown());
	}
	
	@Test
	public void Should_Player2Win_When_Play(){
		game.startGame(input_player2, System.out);
		assertTrue(game.player1.isDown());
	}
}
