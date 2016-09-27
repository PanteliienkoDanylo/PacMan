package com.github.dasska.pacman;

import java.util.Arrays;
import java.util.HashSet;

public class Level5 extends LevelBase{
    public Level5() {
        width = 14;
        height = 14;

        walls = new boolean[width][height];
        fillWals();

        coins = new HashSet<Point>();
        for(int i=0; i < height; i++){
            for(int j=0; j < width; j++){
                coins.add(new Point(i, j));
            }
        }
        coins.remove(new Point(6, 6));

        monsters = new Monster[] {
                new MonsterHorizontal(750, new Point(11, 0), this),
                new MonsterHorizontal(730, new Point(5,13), this),
                new MonsterHorizontal(700, new Point(1,7), this),
                new MonsterVertical(740, new Point(2,9), this),
                new MonsterVertical(710, new Point(10,2), this),
                new MonsterVertical(720, new Point(8,8), this),
                new MonsterGraphBFS(650, new Point(13,13), this),
                new MonsterGraphBFS(700, new Point(1,13), this),
        };

        pacman = new Pacman(new Point(6, 6),  this);
    }

    private void fillWals() {
        cleanWalls();
    }
}
