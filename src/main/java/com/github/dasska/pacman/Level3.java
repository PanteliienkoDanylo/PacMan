package com.github.dasska.pacman;

import java.util.Arrays;
import java.util.HashSet;

public class Level3 extends LevelBase {
	public Level3() {
		width = 10;
		height = 10;
		
		walls = new boolean[width][height];
		fillWals();
		
		monsters = new Monster[] {

					new MonsterGraphBFS(1000, new Point(4,6), this),
					new MonsterVertical(750, new Point(8,7), this),
					new MonsterVertical(800, new Point(1,2), this),
				};

		pacman = new Pacman(new Point(1, 8),  this);
		
		coins = new HashSet<Point>();
		for(int i=0; i < width; i++){
			coins.add(new Point(i, 1));
			coins.add(new Point(i, 8));
		}
		for(int i=1; i < width-1; i++){
			coins.add(new Point(1, i));
			coins.add(new Point(8, i));
		}
		for(int i=2; i < width-2; i++){
			coins.add(new Point(i, 4));
			coins.add(new Point(i, 5));
		}
		coins.remove(new Point(1, 8));

	}

	private void fillWals() {
		cleanWalls();
		
		Arrays.fill(walls[0], true);
		Arrays.fill(walls[width-1], true);
		
		for(int i=0; i < width; i++) {
			walls[i][0] = true;
			walls[i][height-1] = true;
		}
		
		for(int i=2; i < width-2; i++ ){
			walls[i][2] = true;
			walls[i][3] = true;
			walls[i][6] = true;
			walls[i][7] = true;
		}
		walls[0][1] = false;
		walls[0][8] = false;
		walls[9][1] = false;
		walls[9][8] = false;
	}
}
