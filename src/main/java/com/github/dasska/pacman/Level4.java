package com.github.dasska.pacman;

import java.util.Arrays;
import java.util.HashSet;

public class Level4 extends LevelBase {
	public Level4() {
		width = 23;
		height = 23;
		
		walls = new boolean[width][height];
		fillWals();
		
		monsters = new Monster[] {
					new MonsterDecart(500, new Point(1,1), this),
					new MonsterDecart(550, new Point(1,22), this),
					new MonsterDecart(450, new Point(22,1), this),
					new MonsterDecart(475, new Point(21,21), this),
					
					new MonsterHorizontal(425, new Point(5,1), this),
					new MonsterHorizontal(450, new Point(1,3), this),
					new MonsterHorizontal(440, new Point(10,5), this),
					new MonsterHorizontal(430, new Point(19,7), this),
					new MonsterHorizontal(420, new Point(6,9), this),
					new MonsterHorizontal(500, new Point(3,11), this),
					new MonsterHorizontal(490, new Point(16,13), this),
					new MonsterHorizontal(480, new Point(7,15), this),
					new MonsterHorizontal(475, new Point(18,17), this),
					new MonsterHorizontal(466, new Point(2,19), this),
					new MonsterHorizontal(477, new Point(11,21), this),
					
					new MonsterVertical(475, new Point(1,14), this),
					new MonsterVertical(465, new Point(3,4), this),
					new MonsterVertical(455, new Point(5,1), this),
					new MonsterVertical(466, new Point(7,7), this),
					new MonsterVertical(487, new Point(9,16), this),
					new MonsterVertical(497, new Point(11,5), this),
					new MonsterVertical(467, new Point(13,17), this),
					new MonsterVertical(488, new Point(15,10), this),
					new MonsterVertical(449, new Point(17,2), this),
					new MonsterVertical(474, new Point(19,13), this),
					new MonsterVertical(481, new Point(21,20), this),
					
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
