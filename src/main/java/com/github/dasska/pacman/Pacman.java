package com.github.dasska.pacman;

public class Pacman {
	private Point point;
	private Game game;
	
	public Pacman(Point point, Game game) {
		this.point = point;
		this.game = game;
	}
	
	public Point getPoint() {
		return point;
	}
	
	public void up() {
		if (game.canMoveUp(point)) {
			point.up(game.getHeight());
			win();
		}
	}

	public void down() {
		if (game.canMoveDown(point)) {
			point.down(game.getHeight());
			win();
		}
	}
	
	public void left() {
		if (game.canMoveLeft(point)) {
			point.left(game.getWidth());
			win();
		}		
	}
	
	public void right() {
		if (game.canMoveRight(point)) {
			point.right(game.getWidth());
			win();
		}		
	}
	
	private void win() {
		// check win conditions
		game.refresh();
	}
}
