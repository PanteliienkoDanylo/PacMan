package com.github.dasska.pacman;

import java.util.Arrays;
import java.util.HashSet;

public class Level2 extends LevelBase {
	public Level2() {
		width = 10;
		height = 10;
		
		walls = new boolean[width][height];
		fillWals();
		
		coins = new HashSet<Point>();
		for(int i = 1; i < width-1; i ++){
			for(int j = 1; j < height-1; j ++){
				coins.add(new Point(j,i));
			}		
		}
		coins.remove(new Point(2,2));
		coins.remove(new Point(3,3));
		coins.remove(new Point(4,4));
		coins.remove(new Point(5,5));
		coins.remove(new Point(6,6));
		coins.remove(new Point(7,7));
		
		
		monsters = new Monster[] {
					new MonsterGraphBFS(1000, new Point(1,1), this)
				};
		
		pacman = new Pacman(new Point(8, 8),  this);
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
		walls[3][3] = true;
		walls[4][4] = true;
		walls[5][5] = true;
		walls[6][6] = true;
		walls[7][7] = true;
	}
}
