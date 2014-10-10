package com.github.dasska.pacman;

import java.awt.Color;
import java.util.Arrays;

public class Level4 extends LevelBase {
	public Level4() {
		width = 23;
		height = 23;
		
		walls = new boolean[width][height];
		fillWals();
		
		monsters = new Monster[] {
					new MonsterDecart(600, new Point(10,1), this, Color.GREEN),
					
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
}
