package com.github.dasska.pacman;

import java.util.Arrays;
import java.util.HashSet;

public class Level1 extends LevelBase {
	public Level1() {
		width = 5;
		height = 5;
		
		walls = new boolean[width][height];
		fillWals();
		
		coins = new HashSet<Point>();
		coins.add(new Point(1, 1));
		coins.add(new Point(1, 2));
		coins.add(new Point(1, 3));
		coins.add(new Point(2, 1));
		coins.add(new Point(2, 3));
		coins.add(new Point(3, 1));
		coins.add(new Point(3, 2));

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
}
