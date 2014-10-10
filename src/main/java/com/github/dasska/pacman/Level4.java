package com.github.dasska.pacman;

import java.util.Arrays;

public class Level4 extends Game {
	private int width;
	private int height;
	private boolean[][] walls;
	private Monster[] monsters;
	private Pacman pacman;
	
	public Level4() {
		width = 23;
		height = 23;
		
		walls = new boolean[width][height];
		fillWals();
		
		monsters = new Monster[] {
					new MonsterDecart(600, new Point(10,1), this),
					
				};
		
		pacman = new Pacman(new Point(3, 19),  this);
	}

	private void fillWals() {
		cleanWalls();
		
		Arrays.fill(walls[0], true);
		Arrays.fill(walls[width-1], true);
		
		for(int i=0; i<width; i++) {
			walls[i][0] = true;
			walls[i][height-1] = true;
		}
		
		
	}
	
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
}
