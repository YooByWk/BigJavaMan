package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.MarioGame;
import com.in28minutes.learn_spring_framework.game.PacmanGame;
import com.in28minutes.learn_spring_framework.game.SuperContraGame;

public class App01gamingBasicJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var marioGame = new MarioGame();
		var superContraGame = new SuperContraGame();
		var pacmanGame = new PacmanGame();
		
		var gameRunner = new GameRunner(marioGame);
		var gameRunner2 = new GameRunner(superContraGame);
		var gameRunner3 = new GameRunner(pacmanGame);
		
		gameRunner.run();
		gameRunner2.run();
		gameRunner3.run();
	}

}
