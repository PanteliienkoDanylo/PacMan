package com.github.dasska.pacman;

import java.util.Arrays;
import java.util.HashSet;

public class Level5 extends LevelBase {
	public Level5() {
		width = 16;
		height = 16;
		
		walls = new boolean[width][height];
		fillWals();
		
		coins = new HashSet<Point>();
		for(int i = 1; i< width-1; i++){
			coins.add(new Point(1,i));
			coins.add(new Point(14,i));
		}
		
		coins.add(new Point(2, 6));
		coins.add(new Point(2, 8));
		coins.add(new Point(2, 9));
		coins.add(new Point(2, 10));
		coins.add(new Point(2, 14));
		coins.add(new Point(3, 1));
		coins.add(new Point(3, 2));
		coins.add(new Point(3, 3));
		coins.add(new Point(3, 4));
		coins.add(new Point(3, 5));
		coins.add(new Point(3, 6));
		coins.add(new Point(3, 8));
		coins.add(new Point(3, 9));
		coins.add(new Point(3, 10));
		coins.add(new Point(3, 11));
		coins.add(new Point(3, 12));
		coins.add(new Point(3, 13));
		coins.add(new Point(3, 14));
		coins.add(new Point(4, 1));
		coins.add(new Point(4, 4));
		coins.add(new Point(4, 8));
		coins.add(new Point(4, 9));
		coins.add(new Point(4, 12));
		coins.add(new Point(5, 1));
		coins.add(new Point(5, 4));
		coins.add(new Point(5, 5));
		coins.add(new Point(5, 6));
		coins.add(new Point(5, 7));
		coins.add(new Point(5, 8));
		coins.add(new Point(5, 9));
		coins.add(new Point(5, 11));
		coins.add(new Point(5, 12));
		coins.add(new Point(5, 13));
		coins.add(new Point(5, 14));
		coins.add(new Point(6, 1));
		coins.add(new Point(6, 4));
		coins.add(new Point(6, 8));
		coins.add(new Point(6, 9));
		coins.add(new Point(6, 13));
		coins.add(new Point(6, 14));
		coins.add(new Point(7, 1));
		coins.add(new Point(7, 2));
		coins.add(new Point(7, 3));
		coins.add(new Point(7, 4));
		coins.add(new Point(7, 6));
		coins.add(new Point(7, 7));
		coins.add(new Point(7, 8));
		coins.add(new Point(7, 9));
		coins.add(new Point(7, 10));
		coins.add(new Point(7, 11));
		coins.add(new Point(7, 12));
		coins.add(new Point(7, 13));
		coins.add(new Point(7, 14));
		coins.add(new Point(8, 4));
		coins.add(new Point(8, 5));
		coins.add(new Point(8, 6));
		coins.add(new Point(8, 9));
		coins.add(new Point(8, 11));
		coins.add(new Point(8, 13));
		coins.add(new Point(8, 14));
		coins.add(new Point(9, 1));
		coins.add(new Point(9, 2));
		coins.add(new Point(9, 4));
		coins.add(new Point(9, 5));
		coins.add(new Point(9, 6));
		coins.add(new Point(9, 8));
		coins.add(new Point(9, 9));
		coins.add(new Point(9, 10));
		coins.add(new Point(9, 12));
		coins.add(new Point(9, 13));
		coins.add(new Point(10, 1));
		coins.add(new Point(10, 2));
		coins.add(new Point(10, 4));
		coins.add(new Point(10, 5));
		coins.add(new Point(10, 6));
		coins.add(new Point(10, 8));
		coins.add(new Point(10, 9));
		coins.add(new Point(10, 11));
		coins.add(new Point(10, 13));
		coins.add(new Point(10, 14));
		coins.add(new Point(11, 2));
		coins.add(new Point(11, 3));
		coins.add(new Point(11, 4));
		coins.add(new Point(11, 5));
		coins.add(new Point(11, 6));
		coins.add(new Point(11, 8));
		coins.add(new Point(11, 9));
		coins.add(new Point(11, 11));
		coins.add(new Point(11, 12));
		coins.add(new Point(11, 14));
		coins.add(new Point(12, 1));
		coins.add(new Point(12, 2));
		coins.add(new Point(12, 3));
		coins.add(new Point(12, 5));
		coins.add(new Point(12, 6));
		coins.add(new Point(12, 7));
		coins.add(new Point(12, 8));
		coins.add(new Point(12, 9));
		coins.add(new Point(12, 10));
		coins.add(new Point(12, 12));
		coins.add(new Point(12, 13));
		coins.add(new Point(12, 14));
		coins.add(new Point(13, 1));
		coins.add(new Point(13, 5));
		coins.add(new Point(13, 6));
		coins.add(new Point(13, 7));
		coins.add(new Point(13, 8));
		coins.add(new Point(13, 9));
		coins.add(new Point(13, 10));
		coins.add(new Point(13, 11));
		coins.add(new Point(13, 12));
		coins.add(new Point(13, 14));
				
				
		monsters = new Monster[] {
					new MonsterGraphBFS(1000, new Point(7,14), this),
					new MonsterGraphBFS(1000, new Point(3,6), this),
					new MonsterHorizontal(1000, new Point(1,8), this),
					new MonsterHorizontal(1000, new Point(14,9), this),
					new MonsterVertical(1000, new Point(1,14), this),
					new MonsterVertical(1000, new Point(8,4), this),
					new MonsterVertical(1000, new Point(9,5), this),
					new MonsterVertical(1000, new Point(10,6), this),
					new MonsterVertical(1000, new Point(14,1), this),
					new MonsterVertical(1000, new Point(14,14), this),
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
		
		walls[2][1] = true;
		walls[2][2] = true;
		walls[2][3] = true;
		walls[2][4] = true;
		walls[2][5] = true;
		walls[2][7] = true;
		walls[2][11] = true;
		walls[2][12] = true;
		walls[2][13] = true;
		walls[3][7] = true;
		walls[4][2] = true;
		walls[4][3] = true;
		walls[4][5] = true;
		walls[4][6] = true;
		walls[4][7] = true;
		walls[4][10] = true;
		walls[4][11] = true;
		walls[4][13] = true;
		walls[4][14] = true;
		walls[5][2] = true;
		walls[5][3] = true;
		walls[5][10] = true;
		walls[6][2] = true;
		walls[6][3] = true;
		walls[6][5] = true;
		walls[6][6] = true;
		walls[6][7] = true;
		walls[6][10] = true;
		walls[6][11] = true;
		walls[6][12] = true;
		walls[7][5] = true;
		walls[8][1] = true;
		walls[8][2] = true;
		walls[8][3] = true;
		walls[8][7] = true;
		walls[8][10] = true;
		walls[8][12] = true;
		walls[9][3] = true;
		walls[9][7] = true;
		walls[9][11] = true;
		walls[9][14] = true;
		walls[10][3] = true;
		walls[10][7] = true;
		walls[10][10] = true;
		walls[10][12] = true;
		walls[11][1] = true;
		walls[11][7] = true;
		walls[11][10] = true;
		walls[11][13] = true;
		walls[12][4] = true;
		walls[12][11] = true;
		walls[13][2] = true;
		walls[13][3] = true;
		walls[13][4] = true;
		walls[13][13] = true;
	}
}
