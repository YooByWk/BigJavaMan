package com.in28minutes.learn_spring_framework.game;

public class GameRunner {
	MarioGame game;
	
	// 생성자?
	public GameRunner(MarioGame game) {
		this.game = game;
	}

	public void run() {
		// TODO Auto-generated method stub
		
		// 좋은 구조 아님. 로깅은 추후 한다. 
		// 추후 로깅까지 System out 사용
		System.out.println("Running game: "+ game);
//		System.out.println("이거 진자 되는거");
		
		game.right();
		game.up();
		game.down();
		game.left();
		
		System.out.println("완료");
	}
}
