package com.github.dasska.pacman;

public class Point {
	private int x;
	private int y;
	
	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void up(int height) {
		y--;
		if (y < 0)
			y += height;
	}
	
	public void down(int height) {
		y++;
		if (y >= height)
			y -= height;
	}
	
	public void left(int width) {
		x--;
		if (x < 0)
			x += width;
	}
	
	public void right(int width) {
		x++;
		if (x >= width)
			x -= width;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
