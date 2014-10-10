package com.github.dasska.pacman;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class MonsterHorizontalTest {
	
	@Test
	public void moveNoWallsTest() {
		Monster monster = new MonsterHorizontal(1000, new Point(1, 1), new NoWallsGame());
		monster.move();
		
		assertThat(monster.getPoint(), is(new Point(2, 1)));
		
		monster.move();
		
		assertThat(monster.getPoint(), is(new Point(0, 1)));		
	}
	
	@Test
	public void moveRightWallTest() {
		Monster monster = new MonsterHorizontal(1000, new Point(1, 1), new RightWallGame());
		monster.move();
		
		assertThat(monster.getPoint(), is(new Point(0, 1)));
		
		monster.move();
		
		assertThat(monster.getPoint(), is(new Point(1, 1)));		
	}	
	
	private class NoWallsGame extends Game {
		@Override
		public int getWidth() {
			return 3;
		}

		@Override
		public int getHeight() {
			return 3;
		}

		@Override
		public boolean[][] getWalls() {
			return new boolean[3][3];
		}

		@Override
		public Monster[] getMonsters() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Pacman getPacman() {
			throw new UnsupportedOperationException();
		}
	}
	
	private class RightWallGame extends Game {
		@Override
		public int getWidth() {
			return 3;
		}

		@Override
		public int getHeight() {
			return 3;
		}

		@Override
		public boolean[][] getWalls() {
			boolean[][] walls = new boolean[3][3];
			Arrays.fill(walls[2], true);
			return walls;
		}

		@Override
		public Monster[] getMonsters() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Pacman getPacman() {
			throw new UnsupportedOperationException();
		}
	}	

}
