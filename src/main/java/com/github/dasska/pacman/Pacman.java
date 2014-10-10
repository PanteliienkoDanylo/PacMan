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
			move();
		}
	}

	public void down() {
		if (game.canMoveDown(point)) {
			point.down(game.getHeight());
			move();
		}
	}
	
	public void left() {
		if (game.canMoveLeft(point)) {
			point.left(game.getWidth());
			move();
		}		
	}
	
	public void right() {
		if (game.canMoveRight(point)) {
			point.right(game.getWidth());
			move();
		}		
	}
	
	private void move() {
		game.getCoins().remove(point);
		game.win();
		game.gameOver();
		
		game.refresh();
	}
}
