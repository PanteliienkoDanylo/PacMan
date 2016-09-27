package com.github.dasska.pacman;

import java.util.Arrays;
import java.util.HashSet;

public class Level8 extends LevelBase {
	public Level8() {
		width = 23;
		height = 23;
		
		walls = new boolean[width][height];
		fillWals();
		
		monsters = new Monster[] {
					new MonsterHorizontal(600, new Point(13,1), this),
					new MonsterHorizontal(650, new Point(9,5), this),
					new MonsterHorizontal(700, new Point(5,9), this),
					new MonsterGraphBFS(550, new Point(9,13), this),
					new MonsterHorizontal(750, new Point(21,17), this),
					new MonsterHorizontal(625, new Point(17,21), this),
					new MonsterVertical(575, new Point(5,1), this),
					new MonsterVertical(590, new Point(1,5), this),
					new MonsterVertical(615, new Point(21,9), this),
					new MonsterVertical(550, new Point(17,13), this),
					new MonsterVertical(600, new Point(13,17), this),
					new MonsterVertical(675, new Point(9,21), this)
				};
		
		coins = new HashSet<Point>();
		for(int i = 1; i < 22; i++){
			coins.add(new Point(i, 1));
			coins.add(new Point(i, 5));
			coins.add(new Point(i, 9));
			coins.add(new Point(i, 13));
			coins.add(new Point(i, 17));
			coins.add(new Point(i, 21));
			coins.add(new Point(1, i));
			coins.add(new Point(5, i));
			coins.add(new Point(9, i));
			coins.add(new Point(13, i));
			coins.add(new Point(17, i));
			coins.add(new Point(21, i));
		}
		for(int i = 1; i < 11; i++){
			coins.add(new Point(2*i, 2));
			coins.add(new Point(2*i, 4));
			coins.add(new Point(2*i, 6));
			coins.add(new Point(2*i, 8));
			coins.add(new Point(2*i, 10));
			coins.add(new Point(2*i, 12));
			coins.add(new Point(2*i, 14));
			coins.add(new Point(2*i, 16));
			coins.add(new Point(2*i, 18));
			coins.add(new Point(2*i, 20));
		}
		coins.remove(new Point(1, 21));
		
		pacman = new Pacman(new Point(1, 21),  this);
	}

	private void fillWals() {
		cleanWalls();
		
		Arrays.fill(walls[0], true);
		Arrays.fill(walls[width-1], true);
		
		for(int i=0; i<width; i++) {
			walls[i][0] = true;
			walls[i][height-1] = true;
		}
		
		walls[2][3] = true;
		walls[2][7] = true;
		walls[2][11] = true;
		walls[2][15] = true;
		walls[2][19] = true;
		walls[4][3] = true;
		walls[4][7] = true;
		walls[4][11] = true;
		walls[4][15] = true;
		walls[4][19] = true;
		walls[6][3] = true;
		walls[6][7] = true;
		walls[6][11] = true;
		walls[6][15] = true;
		walls[6][19] = true;
		walls[8][3] = true;
		walls[8][7] = true;
		walls[8][11] = true;
		walls[8][15] = true;
		walls[8][19] = true;
		walls[10][3] = true;
		walls[10][7] = true;
		walls[10][11] = true;
		walls[10][15] = true;
		walls[10][19] = true;
		walls[12][3] = true;
		walls[12][7] = true;
		walls[12][11] = true;
		walls[12][15] = true;
		walls[12][19] = true;
		walls[14][3] = true;
		walls[14][7] = true;
		walls[14][11] = true;
		walls[14][15] = true;
		walls[14][19] = true;
		walls[16][3] = true;
		walls[16][7] = true;
		walls[16][11] = true;
		walls[16][15] = true;
		walls[16][19] = true;
		walls[18][3] = true;
		walls[18][7] = true;
		walls[18][11] = true;
		walls[18][15] = true;
		walls[18][19] = true;
		walls[20][3] = true;
		walls[20][7] = true;
		walls[20][11] = true;
		walls[20][15] = true;
		walls[20][19] = true;
		walls[3][2] = true;
		walls[3][3] = true;
		walls[3][4] = true;
		walls[3][6] = true;
		walls[3][7] = true;
		walls[3][8] = true;
		walls[3][10] = true;
		walls[3][11] = true;
		walls[3][12] = true;
		walls[3][14] = true;
		walls[3][15] = true;
		walls[3][16] = true;
		walls[3][18] = true;
		walls[3][19] = true;
		walls[3][20] = true;
		walls[7][2] = true;
		walls[7][3] = true;
		walls[7][4] = true;
		walls[7][6] = true;
		walls[7][7] = true;
		walls[7][8] = true;
		walls[7][10] = true;
		walls[7][11] = true;
		walls[7][12] = true;
		walls[7][14] = true;
		walls[7][15] = true;
		walls[7][16] = true;
		walls[7][18] = true;
		walls[7][19] = true;
		walls[7][20] = true;
		walls[11][2] = true;
		walls[11][3] = true;
		walls[11][4] = true;
		walls[11][6] = true;
		walls[11][7] = true;
		walls[11][8] = true;
		walls[11][10] = true;
		walls[11][11] = true;
		walls[11][12] = true;
		walls[11][14] = true;
		walls[11][15] = true;
		walls[11][16] = true;
		walls[11][18] = true;
		walls[11][19] = true;
		walls[11][20] = true;
		walls[15][2] = true;
		walls[15][3] = true;
		walls[15][4] = true;
		walls[15][6] = true;
		walls[15][7] = true;
		walls[15][8] = true;
		walls[15][10] = true;
		walls[15][11] = true;
		walls[15][12] = true;
		walls[15][14] = true;
		walls[15][15] = true;
		walls[15][16] = true;
		walls[15][18] = true;
		walls[15][19] = true;
		walls[15][20] = true;
		walls[19][2] = true;
		walls[19][3] = true;
		walls[19][4] = true;
		walls[19][6] = true;
		walls[19][7] = true;
		walls[19][8] = true;
		walls[19][10] = true;
		walls[19][11] = true;
		walls[19][12] = true;
		walls[19][14] = true;
		walls[19][15] = true;
		walls[19][16] = true;
		walls[19][18] = true;
		walls[19][19] = true;
		walls[19][20] = true;
	}
}
