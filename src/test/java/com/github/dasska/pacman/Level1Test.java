package com.github.dasska.pacman;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

public class Level1Test {
	private Level1 level1;
	
	@Before
	public void before() {
		level1 = new Level1();
	}
	
	@Test
	public void getWidthTest() {
		assertThat(level1.getWidth(), is(5));
	}
	
	@Test
	public void getHeightTest() {
		assertThat(level1.getHeight(), is(5));
	}	
	
	@Test
	public void getWallsTest() {
		boolean[][] walls = level1.getWalls();
		
		assertThat(walls, not(nullValue()));
		assertThat(walls[0][0], is(true));
		assertThat(walls[1][1], is(false));
		assertThat(walls[2][2], is(true));
		assertThat(walls[3][4], is(true));
	}
	
	@Test
	public void getMonstersTest() {
		Monster[] monsters = level1.getMonsters();
		
		assertThat(monsters, not(nullValue()));
		assertThat(monsters.length, is(1));		
	}
}
