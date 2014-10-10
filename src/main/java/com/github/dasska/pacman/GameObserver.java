package com.github.dasska.pacman;

public interface GameObserver {
	public void refresh();
	public void win();
	public void gameOver();
}
