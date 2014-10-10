package com.github.dasska.pacman;

import java.util.Arrays;

public class Level3 extends Game {
	private int width;
	private int height;
	private boolean[][] walls;
	private Monster[] monsters;
	private Pacman pacman;
	
	public Level3() {
		width = 23;
		height = 23;
		
		walls = new boolean[width][height];
		fillWals();
		
		monsters = new Monster[] {
					/*new MonsterHorizontal(600, new Point(10,1), this),
					new MonsterHorizontal(620, new Point(16,1), this),
					new MonsterHorizontal(640, new Point(18,2), this),
					new MonsterHorizontal(550, new Point(19,4), this),
					new MonsterHorizontal(490, new Point(13,1), this),
					new MonsterHorizontal(500, new Point(7,6), this),
					new MonsterHorizontal(525, new Point(12,10), this),
					new MonsterHorizontal(475, new Point(18,9), this),
					new MonsterHorizontal(535, new Point(4,11), this),
					new MonsterHorizontal(455, new Point(12,13), this),
					new MonsterHorizontal(566, new Point(5,15), this),
					new MonsterHorizontal(466, new Point(8,17), this),
					new MonsterHorizontal(512, new Point(10,18), this),
					new MonsterHorizontal(468, new Point(8,21), this),
					new MonsterHorizontal(433, new Point(15,21), this),
					new MonsterVertical(675, new Point(2,2), this),
					new MonsterVertical(675, new Point(12,3), this),
					new MonsterVertical(675, new Point(7,4), this),
					new MonsterVertical(675, new Point(20,2), this),
					new MonsterVertical(675, new Point(1,6), this),
					new MonsterVertical(675, new Point(21,6), this),
					new MonsterVertical(675, new Point(13,7), this),
					new MonsterVertical(675, new Point(5,10), this),
					new MonsterVertical(675, new Point(9,11), this),
					new MonsterVertical(675, new Point(11,12), this),
					new MonsterVertical(675, new Point(4,14), this),
					new MonsterVertical(675, new Point(9,21), this),*/
					new MonsterDecart(675, new Point(9,21), this),
					
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
		
		walls[0][15] = false;
		walls[22][15] = false;
		
		
		walls[2][5] = true;
		walls[2][6] = true;
		walls[2][7] = true;
		walls[2][8] = true;
		walls[2][10] = true;
		walls[2][12] = true;
		walls[2][13] = true;
		walls[2][14] = true;
		walls[2][16] = true;
		walls[2][17] = true;
		walls[2][18] = true;
		walls[2][19] = true;
		walls[2][20] = true;
		walls[2][19] = true;
		walls[3][3] = true;
		walls[3][5] = true;
		walls[3][6] = true;
		walls[3][7] = true;
		walls[3][8] = true;
		walls[3][9] = true;
		walls[3][10] = true;
		walls[3][12] = true;
		walls[3][13] = true;
		walls[3][14] = true;
		walls[3][16] = true;
		walls[3][20] = true;
		walls[4][5] = true;
		walls[4][7] = true;
		walls[4][8] = true;
		walls[4][9] = true;
		walls[4][10] = true;
		walls[4][12] = true;
		walls[4][13] = true;
		walls[4][18] = true;
		walls[4][19] = true;
		walls[4][20] = true;		
		walls[5][2] = true;
		walls[5][3] = true;
		walls[5][4] = true;
		walls[5][5] = true;
		walls[5][7] = true;
		walls[5][13] = true;
		walls[5][16] = true;
		walls[5][19] = true;
		walls[6][2] = true;
		walls[6][3] = true;
		walls[6][4] = true;
		walls[6][5] = true;
		walls[6][7] = true;
		walls[6][8] = true;
		walls[6][9] = true;
		walls[6][10] = true;
		walls[6][12] = true;
		walls[6][13] = true;
		walls[6][16] = true;
		walls[6][19] = true;
		walls[6][20] = true;
		walls[7][7] = true;
		walls[7][8] = true;
		walls[7][9] = true;
		walls[7][10] = true;
		walls[7][12] = true;
		walls[7][13] = true;
		walls[7][14] = true;
		walls[7][15] = true;
		walls[7][16] = true;
		walls[7][19] = true;
		walls[7][20] = true;
		walls[8][2] = true;
		walls[8][3] = true;
		walls[8][5] = true;
		walls[8][8] = true;
		walls[8][9] = true;
		walls[8][10] = true;
		walls[8][11] = true;
		walls[8][12] = true;
		walls[8][13] = true;
		walls[8][14] = true;
		walls[8][15] = true;
		walls[8][16] = true;
		walls[8][19] = true;
		walls[8][20] = true;
		walls[9][2] = true;
		walls[9][3] = true;
		walls[9][4] = true;
		walls[9][5] = true;
		walls[9][7] = true;
		walls[9][8] = true;
		walls[9][9] = true;
		walls[9][14] = true;
		walls[9][15] = true;
		walls[9][16] = true;
		walls[9][19] = true;
		walls[9][20] = true;
		walls[10][2] = true;
		walls[10][3] = true;
		walls[10][4] = true;
		walls[10][5] = true;
		walls[10][7] = true;
		walls[10][8] = true;
		walls[10][11] = true;
		walls[10][12] = true;
		walls[10][15] = true;
		walls[10][16] = true;
		walls[10][19] = true;
		walls[10][20] = true;
		walls[11][2] = true;
		walls[11][3] = true;
		walls[11][4] = true;
		walls[11][5] = true;
		walls[11][6] = true;
		walls[11][7] = true;
		walls[11][16] = true;
		walls[11][19] = true;
		walls[12][9] = true;
		walls[12][15] = true;
		walls[12][16] = true;
		walls[12][19] = true;
		walls[12][20] = true;
		walls[13][9] = true;
		walls[13][11] = true;
		walls[13][13] = true;
		walls[13][14] = true;
		walls[13][15] = true;
		walls[13][16] = true;
		walls[13][20] = true;
		walls[14][2] = true;
		walls[14][3] = true;
		walls[14][4] = true;
		walls[14][5] = true;
		walls[14][6] = true;
		walls[14][9] = true;
		walls[14][13] = true;
		walls[14][14] = true;
		walls[14][15] = true;
		walls[14][16] = true;
		walls[14][19] = true;
		walls[14][20] = true;
		walls[15][2] = true;
		walls[15][3] = true;
		walls[15][4] = true;
		walls[15][5] = true;
		walls[15][6] = true;
		walls[15][7] = true;
		walls[15][12] = true;
		walls[15][13] = true;
		walls[15][14] = true;
		walls[15][20] = true;
		walls[16][6] = true;
		walls[16][7] = true;
		walls[16][8] = true;
		walls[16][9] = true;
		walls[16][10] = true;
		walls[16][11] = true;
		walls[16][12] = true;
		walls[16][13] = true;
		walls[16][14] = true;
		walls[16][20] = true;
		walls[17][3] = true;
		walls[17][5] = true;
		walls[17][6] = true;
		walls[17][7] = true;
		walls[17][8] = true;
		walls[17][10] = true;
		walls[17][11] = true;
		walls[17][12] = true;
		walls[17][13] = true;
		walls[17][14] = true;
		walls[17][15] = true;
		walls[17][16] = true;
		walls[17][20] = true;
		walls[18][3] = true;
		walls[18][5] = true;
		walls[18][6] = true;
		walls[18][7] = true;
		walls[18][8] = true;
		walls[18][11] = true;
		walls[18][12] = true;
		walls[18][13] = true;
		walls[18][14] = true;
		walls[18][15] = true;
		walls[18][19] = true;
		walls[18][20] = true;
		walls[19][3] = true;
		walls[19][5] = true;
		walls[19][6] = true;
		walls[19][7] = true;
		walls[19][8] = true;
		walls[19][10] = true;
		walls[19][11] = true;
		walls[19][12] = true;
		walls[19][13] = true;
		walls[19][14] = true;
		walls[19][15] = true;
		walls[19][19] = true;
		walls[20][5] = true;
		walls[20][6] = true;
		walls[20][8] = true;
		walls[20][10] = true;
		walls[20][11] = true;
		walls[20][12] = true;
		walls[20][14] = true;
		walls[20][15] = true;
		walls[20][16] = true;
		walls[20][17] = true;
		walls[20][18] = true;
		walls[20][19] = true;
		walls[20][20] = true;
				
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
