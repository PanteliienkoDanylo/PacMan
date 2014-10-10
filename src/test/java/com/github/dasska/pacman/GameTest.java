package com.github.dasska.pacman;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

public class GameTest {
	private Game game;
	
	@Before
	public void before() {
		game = new Level1();
	}
	
	@Test
	public void canMoveUpTest() {
		assertThat(game.canMoveUp(new Point(1, 1)), is(false));
		assertThat(game.canMoveUp(new Point(1, 2)), is(true));
		assertThat(game.canMoveUp(new Point(3, 3)), is(true));
		assertThat(game.canMoveUp(new Point(2, 3)), is(false));
	}
	
	@Test
	public void canMoveDownTest() {
		assertThat(game.canMoveDown(new Point(1, 1)), is(true));
		assertThat(game.canMoveDown(new Point(1, 2)), is(true));
		assertThat(game.canMoveDown(new Point(3, 3)), is(false));
		assertThat(game.canMoveDown(new Point(2, 3)), is(false));
		assertThat(game.canMoveDown(new Point(2, 1)), is(false));
	}
	
	@Test
	public void canMoveLeftTest() {
		assertThat(game.canMoveLeft(new Point(1, 1)), is(false));
		assertThat(game.canMoveLeft(new Point(1, 2)), is(false));
		assertThat(game.canMoveLeft(new Point(3, 3)), is(true));
		assertThat(game.canMoveLeft(new Point(2, 3)), is(true));
	}
	
	@Test
	public void canMoveRightTest() {
		assertThat(game.canMoveRight(new Point(1, 1)), is(true));
		assertThat(game.canMoveRight(new Point(1, 2)), is(false));
		assertThat(game.canMoveRight(new Point(3, 3)), is(false));
		assertThat(game.canMoveRight(new Point(2, 3)), is(true));
	}		

}
