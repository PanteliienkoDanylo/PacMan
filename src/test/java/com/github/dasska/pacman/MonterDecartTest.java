package com.github.dasska.pacman;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MonterDecartTest {
	@Test
	public void moveNoWallsTest() {
		assertThat(MonsterDecart.length(new Point(1,1), new Point(1,2)), is(1d));
		assertThat(MonsterDecart.length(new Point(1,1), new Point(2,1)), is(1d));
		assertThat(MonsterDecart.length(new Point(0,0), new Point(3,4)), is(5d));
	}	
}
