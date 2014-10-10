package com.github.dasska.pacman;

import javax.swing.JPanel;

public abstract class Game {
	public abstract int getWidth();
	public abstract int getHeight();
	public abstract boolean[][] getWalls();
	public abstract Monster[] getMonsters();
	public abstract Pacman getPacman();
	
	private JPanel panel;
	
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	public void start() {
		for(Monster monster: getMonsters())
			monster.start();
	}
	
	public boolean canMoveUp(Point point) {
		int nextY = point.getY()-1;
		if (nextY < 0) 
			nextY += getHeight();
		return !getWalls()[point.getX()][nextY];
	}
	
	public boolean canMoveDown(Point point) {
		int nextY = point.getY()+1;
		if (nextY >= getHeight()) 
			nextY -= getHeight();
		return !getWalls()[point.getX()][nextY];
	}
	
	public boolean canMoveLeft(Point point) {
		int nextX = point.getX()-1;
		if (nextX < 0) 
			nextX += getWidth();
		return !getWalls()[nextX][point.getY()];
	}
	
	public boolean canMoveRight(Point point) {
		int nextX = point.getX()+1;
		if (nextX >= getWidth()) 
			nextX -= getWidth();
		return !getWalls()[nextX][point.getY()];
	}
	
	protected void cleanWalls() {
		for(int i=0; i<getWidth(); i++)
			for(int j=0; j<getHeight(); j++)
				getWalls()[i][j] = false;
	}
	
	public boolean kill(Point point) {
		return point.equals(getPacman().getPoint());
	}
	
	public void refresh() {
		if (panel != null)
			panel.repaint();
	}
}
