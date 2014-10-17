package com.github.dasska.pacman;

import java.awt.Color;

public class MonsterHorizontal extends Monster {
	private boolean goRight = true;
	
	public MonsterHorizontal(int sleep, Point point, Game game) {
		super(sleep, point, game, Color.RED);
	}

	public void move() {
		if (goRight)
			rightFirst();
		else
			leftFirst();
	}
	
	private void rightFirst() {
		if (game.canMoveRight(point))
			point.right(game.getWidth());
		else if(game.canMoveLeft(point)) {
			point.left(game.getWidth());
			goRight = false;
		}
	}

	public void leftFirst() {
		if(game.canMoveLeft(point))
			point.left(game.getWidth());
		else if (game.canMoveRight(point)) {
			point.right(game.getWidth());	
			goRight = true;
		}
	}

}
