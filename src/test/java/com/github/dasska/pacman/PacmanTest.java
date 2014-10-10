package com.github.dasska.pacman;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class PacmanTest {
	
	@Test
	public void moveNoWallsTest() {
		Pacman pacman = new Pacman(new Point(1, 1), new NoWallsGame());
		pacman.right();
		
		assertThat(pacman.getPoint(), is(new Point(2, 1)));
		
		pacman.right();
		
		assertThat(pacman.getPoint(), is(new Point(0, 1)));		
	}
	
	@Test
	public void moveRightWallTest() {
		Pacman pacman = new Pacman(new Point(1, 1), new RightWallGame());
		pacman.right();
		
		assertThat(pacman.getPoint(), is(new Point(1, 1)));
		
		pacman.left();
		
		assertThat(pacman.getPoint(), is(new Point(0, 1)));		
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
			return new Monster[]{};
		}

		@Override
		public Pacman getPacman() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public Set<Point> getCoins() {
			return new HashSet<Point>();
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
			return new Monster[]{};
		}

		@Override
		public Pacman getPacman() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Set<Point> getCoins() {
			return new HashSet<Point>();
		}		
	}	

}
