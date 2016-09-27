package com.github.dasska.pacman;

import java.util.Arrays;
import java.util.HashSet;

public class Level4 extends LevelBase {
    public Level4() {
        width = 12;
        height = 12;

        walls = new boolean[width][height];
        fillWals();

        coins = new HashSet<Point>();
        for(int i=0; i < 5; i++){
            coins.add(new Point(i, 5));
            coins.add(new Point(i, 6));
        }
        for(int i=7; i < 12; i++){
            coins.add(new Point(i, 5));
            coins.add(new Point(i, 6));
        }
        for(int i=1; i < 11; i++){
            coins.add(new Point(i, 1));
            coins.add(new Point(i, 10));
        }
        for(int i=3; i < 9; i++){
            coins.add(new Point(i, 3));
            coins.add(new Point(i, 4));
            coins.add(new Point(i, 7));
            coins.add(new Point(i, 8));
        }
        coins.add(new Point(1, 2));
        coins.add(new Point(1, 3));
        coins.add(new Point(1, 4));
        coins.add(new Point(1, 7));
        coins.add(new Point(1, 8));
        coins.add(new Point(1, 9));
        coins.add(new Point(10, 2));
        coins.add(new Point(10, 3));
        coins.add(new Point(10, 4));
        coins.add(new Point(10, 7));
        coins.add(new Point(10, 8));
        coins.add(new Point(10, 9));
        coins.add(new Point(2, 5));
        coins.add(new Point(2, 6));
        coins.add(new Point(9, 5));
        coins.add(new Point(9, 6));
        coins.add(new Point(5, 0));
        coins.add(new Point(5, 1));
        coins.add(new Point(5, 2));
        coins.add(new Point(5, 3));
        coins.add(new Point(5, 4));
        coins.add(new Point(5, 7));
        coins.add(new Point(5, 8));
        coins.add(new Point(5, 9));
        coins.add(new Point(5, 10));
        coins.add(new Point(5, 11));
        coins.add(new Point(6, 0));
        coins.add(new Point(6, 1));
        coins.add(new Point(6, 2));
        coins.add(new Point(6, 3));
        coins.add(new Point(6, 4));
        coins.add(new Point(6, 7));
        coins.add(new Point(6, 8));
        coins.add(new Point(6, 9));
        coins.add(new Point(6, 10));
        coins.add(new Point(6, 11));
        coins.remove(new Point(3, 3));

        monsters = new Monster[] {
                new MonsterHorizontal(750, new Point(1,1), this),
                new MonsterHorizontal(770, new Point(8,10), this),
                new MonsterVertical(775, new Point(1,6), this),
                new MonsterVertical(680, new Point(5,8), this),
                new MonsterGraphBFS(825, new Point(10,10), this)
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
        walls[5][0] = false;
        walls[6][0] = false;
        walls[0][5] = false;
        walls[0][6] = false;
        walls[5][11] = false;
        walls[6][11] = false;
        walls[11][5] = false;
        walls[11][6] = false;

        walls[2][2] = true;
        walls[2][3] = true;
        walls[2][4] = true;
        walls[2][7] = true;
        walls[2][8] = true;
        walls[2][9] = true;

        walls[9][2] = true;
        walls[9][3] = true;
        walls[9][4] = true;
        walls[9][7] = true;
        walls[9][8] = true;
        walls[9][9] = true;

        walls[3][2] = true;
        walls[3][9] = true;
        walls[4][2] = true;
        walls[4][9] = true;
        walls[7][2] = true;
        walls[7][9] = true;
        walls[8][2] = true;
        walls[8][9] = true;
        walls[5][5] = true;
        walls[5][6] = true;
        walls[6][5] = true;
        walls[6][6] = true;
    }
}
