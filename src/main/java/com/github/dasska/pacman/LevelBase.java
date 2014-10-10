package com.github.dasska.pacman;

import java.util.Set;

public class LevelBase extends Game {
	protected int width;
	protected int height;
	protected boolean[][] walls;
	protected Monster[] monsters;
	protected Pacman pacman;
	protected Set<Point> coins;
	
	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public int getHeight() {
		return height;
	}
	
	@Override
	public boolean[][] getWalls() {
		return walls;
	}
	
	@Override 
	public Monster[] getMonsters() {
		return monsters;
	}

	@Override
	public Pacman getPacman() {
		return pacman;
	}
	
	@Override
	public Set<Point> getCoins() {
		return coins;
	}
}
