package com.github.dasska.pacman;

import java.util.List;
import java.util.LinkedList;
import java.util.Set;

import javax.swing.JPanel;

public abstract class Game {
	public abstract int getWidth();
	public abstract int getHeight();
	public abstract boolean[][] getWalls();
	public abstract Monster[] getMonsters();
	public abstract Pacman getPacman();
	public abstract Set<Point> getCoins();
	
	private List<GameObserver> observerList = new LinkedList<GameObserver>();
	
	public void addObserver(GameObserver observer) {
		observerList.add(observer);
	}
	
	public void start() {
		for(Monster monster: getMonsters())
			monster.start();
	}
	
	public void stop() {
		for(Monster monster: getMonsters())
			monster.stop();
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
		boolean result = point.equals(getPacman().getPoint());
		if (result) {
			for (GameObserver observer: observerList)
				observer.gameOver();
		}
		return result;
	}
	
	public boolean gameOver() {
		boolean result = false;
		for (Monster monster: getMonsters())
			if (getPacman().getPoint().equals(monster.getPoint())) {
				result = true;
				break;
			}
		if (result) {
			for (GameObserver observer: observerList)
				observer.gameOver();
		}
		return result;
	}	
	
	public boolean win() {
		boolean result = getCoins().size() == 0;
		if (result) {
			for (GameObserver observer: observerList)
				observer.win();
		}
		return result;
	}
	
	public void refresh() {
		for (GameObserver observer: observerList)
			observer.refresh();
	}
}
