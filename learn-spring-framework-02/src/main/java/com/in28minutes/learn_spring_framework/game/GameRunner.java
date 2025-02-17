package com.in28minutes.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	private GamingConsole game;
	
	// 생성자?
	public GameRunner(@Qualifier("SuperContraGame") GamingConsole game) {
		this.game = game;
	}

	public void run() {
		// TODO Auto-generated method stub
		
		// 좋은 구조 아님. 로깅은 추후 한다. 
		// 추후 로깅까지 System out 사용
		System.out.println("Running game: "+ game);
		
		game.right();
		game.up();
		game.down();
		game.left(); 
		
		System.out.println("완료");
	}
}
