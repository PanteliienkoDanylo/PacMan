package com.github.dasska.pacman;

import java.awt.Color;

public class MonsterVertical extends Monster {
private boolean goUp = true;
	
	public MonsterVertical(int sleep, Point point, Game game) {
		super(sleep, point, game, Color.RED);
	}

	public void move() {
		if (goUp)
			upFirst();
		else
			downFirst();
	}
	
	private void upFirst() {
		if (game.canMoveUp(point))
			point.up(game.getHeight());
		else if(game.canMoveDown(point)) {
			point.down(game.getHeight());
			goUp = false;
		}
	}

	public void downFirst() {
		if(game.canMoveDown(point))
			point.down(game.getHeight());
		else if (game.canMoveUp(point)) {
			point.up(game.getHeight());	
			goUp = true;
		}
	}

}
