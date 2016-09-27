package com.github.dasska.pacman;

import java.util.Arrays;
import java.util.HashSet;

public class Level9 extends LevelBase {
	public Level9() {
		width = 23;
		height = 23;
		
		walls = new boolean[width][height];
		fillWals();
		
		monsters = new Monster[] {
					new MonsterGraphBFS(500, new Point(1,1), this),
					new MonsterGraphBFS(550, new Point(1,21), this),
					new MonsterGraphBFS(450, new Point(21,1), this),
					new MonsterGraphBFS(475, new Point(21,21), this),
					
					new MonsterHorizontal(425, new Point(5,1), this),
					new MonsterHorizontal(440, new Point(10,5), this),
					new MonsterHorizontal(420, new Point(6,9), this),
					new MonsterHorizontal(490, new Point(16,13), this),
					new MonsterHorizontal(475, new Point(18,17), this),
					new MonsterHorizontal(477, new Point(11,21), this),

					new MonsterVertical(465, new Point(3,4), this),
					new MonsterVertical(466, new Point(7,7), this),
					new MonsterVertical(497, new Point(11,5), this),
					new MonsterVertical(488, new Point(15,10), this),
					new MonsterVertical(474, new Point(19,13), this),
					
				};
		
		pacman = new Pacman(new Point(11, 11),  this);
		
		coins = new HashSet<Point>();
		for(int i = 0 ; i < 11; i++){
			for(int j = 1 ; j < 22; j++){
				coins.add(new Point(i*2+1, j));
			}
		}
		for(int i = 1 ; i < 22; i++){
			for(int j = 0 ; j < 11; j++){
				coins.add(new Point(i, j*2+1));
			}
		}		
	}

	private void fillWals() {
		cleanWalls();
		
		Arrays.fill(walls[0], true);
		Arrays.fill(walls[width-1], true);
		
		for(int i=0; i<width; i++) {
			walls[i][0] = true;
			walls[i][height-1] = true;
		}
		
		for(int i = 1; i < 11; i ++){
			for(int j = 1; j < 11; j ++){
				walls[i*2][j*2] = true;
			}
		}
		
		
	}
}
