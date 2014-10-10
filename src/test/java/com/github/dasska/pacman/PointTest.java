package com.github.dasska.pacman;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

public class PointTest {
	@Test
	public void upTest() {
		Point point = new Point(0, 0);
		point.up(5);
		
		assertThat(point, is(new Point(0, 4)));
		
		point = new Point(0, 1);
		point.up(5);
		
		assertThat(point, is(new Point(0, 0)));		
	}
	
	@Test
	public void downTest() {
		Point point = new Point(0, 0);
		point.down(5);
		
		assertThat(point, is(new Point(0, 1)));
		
		point = new Point(0, 4);
		point.down(5);
		
		assertThat(point, is(new Point(0, 0)));		
	}
	
	@Test
	public void leftTest() {
		Point point = new Point(0, 0);
		point.left(5);
		
		assertThat(point, is(new Point(4, 0)));
		
		point = new Point(1, 0);
		point.left(5);
		
		assertThat(point, is(new Point(0, 0)));		
	}
	
	@Test
	public void rightTest() {
		Point point = new Point(0, 0);
		point.right(5);
		
		assertThat(point, is(new Point(1, 0)));
		
		point = new Point(4, 0);
		point.right(5);
		
		assertThat(point, is(new Point(0, 0)));		
	}		
}
