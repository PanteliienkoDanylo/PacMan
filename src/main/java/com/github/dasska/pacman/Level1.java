package com.github.dasska.pacman;

import java.util.Arrays;

public class Level1 extends Game {
	private int width;
	private int height;
	private boolean[][] walls;
	private Monster[] monsters;
	private Pacman pacman;
	
	public Level1() {
		width = 5;
		height = 5;
		
		walls = new boolean[width][height];
		fillWals();
		
		monsters = new Monster[] {
					new MonsterHorizontal(1000, new Point(1,1), this)
				};
		
		pacman = new Pacman(new Point(3, 3),  this);
	}

	private void fillWals() {
		cleanWalls();
		
		Arrays.fill(walls[0], true);
		Arrays.fill(walls[width-1], true);
		
		for(int i=0; i<width; i++) {
			walls[i][0] = true;
			walls[i][height-1] = true;
		}
		
		walls[2][2] = true;
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
