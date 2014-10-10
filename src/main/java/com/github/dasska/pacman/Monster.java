package com.github.dasska.pacman;

import java.awt.Color;

public abstract class Monster implements Runnable {
	private int sleep;
	private Thread thread;
	
	protected Point point;
	protected Game game;
	protected Color color;
	
	private volatile boolean running = false;
	
	public Monster(int sleep, Point point, Game game, Color color) {
		this.sleep = sleep;
		thread = new Thread(this);
		this.game = game;
		this.point = point;
		this.color = color;
	}
	
	public synchronized void start() {
		running = true;
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
	}
	
	public synchronized boolean isRunning() {
		return running;
	}
	

	public Point getPoint() {
		return point;
	}
	
	public Color getColor(){
		return color;
	}
	
	public abstract void move();
	
	public void run() {
		while (isRunning()) {
			move();
			game.kill(getPoint());
				
			game.refresh();
			
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
